package com.yundao.tenant.service.sale.reservation.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.MsgConstant;
import com.yundao.tenant.constant.ResourceCodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.customer.customer.CustomerSaleReservationReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerSaleReservationResDto;
import com.yundao.tenant.dto.report.AfpReportDto;
import com.yundao.tenant.dto.report.ProductReportDto;
import com.yundao.tenant.dto.resource.UserResDto;
import com.yundao.tenant.dto.sale.reservation.*;
import com.yundao.tenant.dto.workflow.ProcessStartResDTO;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.enums.product.DeclarationModelEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.enums.sale.reservation.ReservationStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.customer.BaseUserCustomerMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.mapper.base.sale.BaseReservationDiscardMapper;
import com.yundao.tenant.mapper.base.sale.BaseReservationMapper;
import com.yundao.tenant.mapper.sale.reservation.ReservationMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.model.base.customer.BaseUserCustomerExample;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.sale.*;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.resource.ResourceService;
import com.yundao.tenant.service.sale.reservation.ReservationService;
import com.yundao.tenant.service.user.customer.UserCustomerService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import com.yundao.tenant.util.DoubleUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 预约服务实现
 *
 * @author jan
 * @create 2017-08-23 PM6:39
 **/
@Service
public class ReservationServiceImpl extends AbstractService implements ReservationService {

	private static Log log = LogFactory.getLog(ReservationServiceImpl.class);

	@Autowired
	private BaseReservationMapper baseReservationMapper;

	@Autowired
	private ReservationMapper reservationMapper;

	@Autowired
	private BaseProductMapper baseProductMapper;

	@Autowired
	private WorkflowServie workflowServie;

	@Autowired
	private BaseReservationDiscardMapper baseReservationDiscardMapper;

	@Autowired
	private BaseCustomerMapper baseCustomerMapper;
	@Autowired
	private BaseUserCustomerMapper baseUserCustomerMapper;

	@Autowired
	private BaseDeclarationMapper baseDeclarationMapper;

	@Autowired
	private MsgMessageService msgMessageService;

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private UserCustomerService userCustomerService;

	/**
	 * 查询有预约的产品id集合
	 *
	 * @return
	 * @throws BaseException
	 */
	public List<Long> getHasReservationProductIds(String productIdStr) throws BaseException {
		List<Long> ids = SymbolStrUtils.toLong(productIdStr);
		if (BooleanUtils.isEmpty(ids)) {
			return null;
		}
		BaseReservationExample example = new BaseReservationExample();
		example.createCriteria().andProductIdIn(ids);
		List<BaseReservation> list = baseReservationMapper.selectByExample(example);
		List<Long> productIds = new ArrayList<Long>();
		if (!BooleanUtils.isEmpty(list)) {
			for (BaseReservation base : list) {
				if (!productIds.contains(base.getProductId())) {
					productIds.add(base.getProductId());
				}
			}
		}
		return productIds;
	}

	@Override
	public Result<List<AfpReportDto>> getReservationRank(Date beginDate, Date endDate, Integer limit)
			throws BaseException {
		return Result.newSuccessResult(reservationMapper.selectReservationRank(beginDate, endDate, limit));

	}

	@Override
	public Result<Double> getReservationTotal(Date beginDate, Date endDate) throws BaseException {
		return Result.newSuccessResult(reservationMapper.selectReservationTotal(beginDate, endDate));
	}

	@Override
	public List<ProductReportDto> getTotalByProductIds(String productIds) throws BaseException {
		return reservationMapper.selectTotalByProductIds(productIds);
	}

	@Override
	public List<ProductReportDto> getNumByProductIds(String productIds) throws BaseException {

		return reservationMapper.selectNumByProductIds(productIds,this.getHeaderUserId());

	}

	public BaseReservationDiscard getDiscard(Long id) throws BaseException {
		BaseReservationDiscardExample example = new BaseReservationDiscardExample();
		example.createCriteria().andReservationIdEqualTo(id);
		BaseReservationDiscard baseDiscard = baseReservationDiscardMapper.selectOne(example);
		return baseDiscard;
	}

	/**
	 * 预约作废
	 *
	 * @param dto
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Result<Long> doDiscard(ReservationDiscardReqDto dto) throws BaseException {
		BaseReservation base = baseReservationMapper.selectByPrimaryKey(dto.getId());
		if (base == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200104);
		}

		if (!ReservationStatusEnum.PASS.getValue().equals(base.getStatus())) {
			return Result.newFailureResult(CodeConstant.CODE_1200112);
		}

		// 检查是否已经作废
		BaseReservationDiscardExample example = new BaseReservationDiscardExample();
		example.createCriteria().andReservationIdEqualTo(dto.getId());
		List<BaseReservationDiscard> list = baseReservationDiscardMapper.selectByExample(example);
		if (!BooleanUtils.isEmpty(list)) {
			return Result.newFailureResult(CodeConstant.CODE_1200115);
		}

		BaseReservationDiscard record = new BaseReservationDiscard();
		record.setCreateDate(new Date());
		record.setCreateUserId(this.getHeaderUserId());
		record.setIsDelete(0);
		record.setReason(dto.getReason());
		record.setReservationId(dto.getId());
		baseReservationDiscardMapper.insert(record);

		BaseReservation baseReservation = new BaseReservation();
		baseReservation.setId(dto.getId());
		baseReservation.setReason(dto.getReason());
		baseReservation.setStatus(ReservationStatusEnum.DISCARD.getValue());
		baseReservationMapper.updateByPrimaryKeySelective(baseReservation);

		sendMessage(base, dto, MsgMessageCodeEnum.RESERVATION_DISCARD.getCode());

		return Result.newSuccessResult(1l);
	}

	private void sendMessage(BaseReservation base, ReservationDiscardReqDto dto, String code) throws BaseException {
		Map<String, Object> params = new HashMap<>();
		BaseProduct product = baseProductMapper.selectByPrimaryKey(base.getProductId());
		params.put("productName", product == null ? null : product.getName());
		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(base.getCustomerId());
		params.put("dealAmount", base.getReservationAmount());
		params.put("customerName", customer == null ? null : customer.getName());
		params.put("reason", dto.getReason());
		params.put("customerId", base.getCustomerId());
		params.put("userId", base.getUserId());
		params.put("audioName", super.getRealName());
		msgMessageService.processSendMessage(code, params);
	}

	@Override
	public Result<Long> insert(ReservationAddReqDto dto) throws BaseException {
		String logPrefix = "预约||添加||";
		log.info("%s操作开始", logPrefix);

		Long userId = super.getHeaderUserId();

		BaseUserCustomer userCustomer = userCustomerService.getByCustomerId(dto.getCustomerId());
		if (userCustomer == null || !userId.equals(userCustomer.getUserId()))
			throw new BaseException(CodeConstant.CODE_1220113);

		BaseProduct product = baseProductMapper.selectByPrimaryKey(dto.getProductId());
		if (product == null)
			throw new BaseException(CodeConstant.CODE_1200042);

		if(product.getIssuedStatus().equals(ProductIssuedStatusEnum.RAISE_END.getValue())
				|| product.getIssuedStatus().equals(ProductIssuedStatusEnum.SURVIVING.getValue())
				|| product.getIssuedStatus().equals(ProductIssuedStatusEnum.RAISE_END.getValue())){
			throw new BaseException(GJLCodeConstant.CODE_1210131);
		}
		if (DeclarationModelEnum.DECLARATION.getValue().equals(product.getDeclarationModel())) {
			throw new BaseException(CodeConstant.CODE_1200146);
		}

		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(dto.getCustomerId());
		if (customer == null)
			throw new BaseException(CodeConstant.CODE_1200084);

		BaseUserCustomerExample example = new BaseUserCustomerExample();
		example.createCriteria().andUserIdEqualTo(this.getHeaderUserId()).andCustomerIdEqualTo(customer.getId());
		BaseUserCustomer baseUserCustomer = baseUserCustomerMapper.selectOne(example);
		if (baseUserCustomer == null) {
			throw new BaseException(CodeConstant.CODE_1200142);
		}

		if (!ProductIssuedStatusEnum.PRE_SAISE.getValue().equals(product.getIssuedStatus())
				&& !ProductIssuedStatusEnum.TO_RAISE.getValue().equals(product.getIssuedStatus()))
			throw new BaseException(CodeConstant.CODE_1220071);

		this.checkStartPoint(product, dto.getReservationAmount());

		BaseReservation model = new BaseReservation();
		super.initialModel(model);
		model.setCustomerId(dto.getCustomerId());
		model.setEstimatePayDate(dto.getEstimatePayDate());
		model.setProductId(dto.getProductId());
		model.setRemark(dto.getRemark());
		model.setReservationAmount(dto.getReservationAmount());
		// 新建预约，直接提交审核
		model.setStatus(ReservationStatusEnum.APPROVALING.getValue());
		model.setAuditStatus(ReservationStatusEnum.APPROVALING.getValue());
		model.setUserId(userId);
		model.setCommitDate(new Date());
		model.setIsDelete(DeleteEnum.NOT_DELETED.getValue());

		baseReservationMapper.insertSelective(model);
		log.info("%s插入数据完成", logPrefix);
		// 设置编号
		model.setNumber(String.format("%08d", model.getId()));
		baseReservationMapper.updateByPrimaryKeySelective(model);
		log.info("%s修改预约编号完成", logPrefix);

		this.doSendMsgForNewReservation(dto.getReservationAmount(), product.getName(),
				MsgMessageCodeEnum.RESERVATION_AUDIT_TODO.getCode());

		String businessNO = this.startupWorkflow(model.getId());
		log.info("%s启动工作流完成 流水号：%s", logPrefix, businessNO);

		return Result.newSuccessResult(model.getId());
	}

	private void doSendMsgForNewReservation(Double reservationAmount, String productName, String code)
			throws BaseException {
		String logPrefix = "预约||上报消息动态||";
		log.info("%s reservationAmount %s,productName %s", logPrefix, reservationAmount, productName);
		List<UserResDto> users = resourceService.getUserByCode(ResourceCodeConstant.RESERVATION_AUDIT);
		log.info("%s users %s", logPrefix, JsonUtils.objectToJson(users));
		if (BooleanUtils.isEmpty(users)) {
			log.info("%s 需要审批的人为空");
			return;
		}
		String userIds = SymbolStrUtils.longToStr(LambdaMap.toSingleList(users, m -> m.getUserId()));
		// 上报消息动态
		Map<String, Object> msgMap = new HashMap<>();
		msgMap.put("userName", super.getRealName());
		msgMap.put("productName", productName);
		msgMap.put("reservationAmount", DoubleUtils.toWholeString(reservationAmount));
		msgMap.put(MsgConstant.USER_IDS, userIds);
		log.info("%s msgMap %s", logPrefix, JsonUtils.objectToJson(msgMap));
		msgMessageService.processSendMessage(code, msgMap);
		log.info("%s 完成");
	}

	private void checkStartPoint(BaseProduct product, Double reservationAmount) throws BaseException {
		Double buyStartPoint = product.getBuyStartPoint();
		if (buyStartPoint != null) {
			Double amount = reservationAmount;
			if (amount == null)
				throw new BaseException(CodeConstant.CODE_1200129);
			if (amount.doubleValue() < buyStartPoint.doubleValue())
				throw new BaseException(CodeConstant.CODE_1200130,
						"预约金额必须大于认购起点" + DoubleUtils.toWholeString(buyStartPoint) + "万");
		}
	}

	/**
	 * 修改预约
	 */
	@Override
	public Result<Long> update(ReservationUpdateReqDto dto) throws BaseException {
		BaseReservation reservation = baseReservationMapper.selectByPrimaryKey(dto.getId());
		if (reservation.getId() == null) {
			throw new BaseException(CodeConstant.CODE_1200104);
		}
		BaseProduct product = baseProductMapper.selectByPrimaryKey(reservation.getProductId());

		if (product == null) {
			throw new BaseException(CodeConstant.CODE_1200042);
		}

		this.checkStartPoint(product, dto.getReservationAmount());// 校验预约额度

		BaseReservation record = new BaseReservation();
		BeanUtils.copyProperties(dto, record);
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		if (BooleanUtils.isBlank(dto.getRemark())) {
			record.setRemark("");
		}
		baseReservationMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(record.getId());
	}

	/**
	 * 修改预约forApp
	 */
	@Override
	public Result<Long> updateForApp(ReservationUpdateReqDto dto) throws BaseException {
		BaseReservation record = new BaseReservation();
		BeanUtils.copyProperties(dto, record);
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		baseReservationMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(record.getId());
	}

	/**
	 * 检查是否能编辑预约
	 */
	@Override
	public Result<Boolean> checkIsCanUpdate(Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}
		BaseReservation base = baseReservationMapper.selectByPrimaryKey(id);
		if (base == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200104);
		}
		Boolean isCanUpdate = ReservationStatusEnum.canUpdate(base.getStatus());
		return Result.newSuccessResult(isCanUpdate);
	}

	/**
	 * 检查是否能重新提交
	 */
	@Override
	public Result<Boolean> checkIsAgainCommit(Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}
		BaseReservation base = baseReservationMapper.selectByPrimaryKey(id);
		if (base == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200104);
		}
		// 当前预约是否是自己的预约
		if (!base.getUserId().equals(super.getHeaderUserId())) {
			throw new BaseException(CodeConstant.CODE_1200143);
		}

		Boolean isCanUpdate = ReservationStatusEnum.canAgainCommit(base.getStatus());
		return Result.newSuccessResult(isCanUpdate);
	}

	/**
	 * 检查是否能取消
	 */
	@Override
	public Result<Boolean> checkIsCancel(Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}
		BaseReservation base = baseReservationMapper.selectByPrimaryKey(id);
		if (base == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200104);
		}
		Boolean isCanUpdate = ReservationStatusEnum.canCancel(base.getStatus());
		return Result.newSuccessResult(isCanUpdate);
	}

	/**
	 * 取消预约
	 */
	@Override
	public Result<Long> doCancel(ReservationCancelReqDto dto) throws BaseException {
		if (dto == null || dto.getId() == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}

		Result<String> result = workflowServie.getTODOTaskId(dto.getId(), BusinessTypeCode.RESERVATION, true);
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		String taskId = result.getResult();
		workflowServie.complete(taskId, WorkflowActionEnum.CANCEL.getValue(), dto.getReason());

		BaseReservation record = new BaseReservation();
		record.setId(dto.getId());
		record.setCommitDate(new Date());
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		record.setStatus(ReservationStatusEnum.CANCEL.getValue());
		record.setAuditStatus(ReservationStatusEnum.CANCEL.getValue());
		record.setReason(dto.getReason());
		baseReservationMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(1l);
	}

	/**
	 * 重新提交预约
	 */
	@Override
	public Result<Long> doAgainCommit(Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}

		BaseReservation model = baseReservationMapper.selectByPrimaryKey(id);
		if (model == null)
			throw new BaseException(CodeConstant.CODE_1220054);

		BaseProduct product = baseProductMapper.selectByPrimaryKey(model.getProductId());
		if (product == null)
			throw new BaseException(CodeConstant.CODE_1200042);

		Result<String> result = workflowServie.getTODOTaskId(id, BusinessTypeCode.RESERVATION, false);
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		String taskId = result.getResult();
		workflowServie.complete(taskId, WorkflowActionEnum.RESUBMIT.getValue());

		BaseReservation record = new BaseReservation();
		record.setId(id);
		record.setCommitDate(new Date());
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		record.setStatus(ReservationStatusEnum.APPROVALING.getValue());
		record.setAuditStatus(ReservationStatusEnum.APPROVALING.getValue());
		// baseReservationMapper.updateByPrimaryKeySelective(record);
		reservationMapper.doAgainCommit(record);

		this.doSendMsgForNewReservation(model.getReservationAmount(), product.getName(),
				MsgMessageCodeEnum.RESERVATION_AGAIN_AUDIT_TODO.getCode());

		return Result.newSuccessResult(1l);
	}

	/**
	 * 查询单个预约详情
	 */
	@Override
	public BaseReservationDto getBaseReservationDto(Long id) throws BaseException {
		if (id == null) {
			return null;
		}
		return reservationMapper.selectByPrimaryKey(id);
	}

	@Override
	public ReservationDetailDto getBaseReservationDetailDto(Long id) throws BaseException {
		if (id == null) {
			return null;
		}
		BaseReservationDto baseReservationDto = reservationMapper.selectByPrimaryKey(id);
		ReservationDetailDto detailDto = new ReservationDetailDto();
		BeanUtils.copyProperties(baseReservationDto, detailDto);

		BaseDeclarationExample example = new BaseDeclarationExample();
		example.createCriteria().andReservationIdEqualTo(id);
		BaseDeclaration declaration = baseDeclarationMapper.selectOne(example);

		detailDto.setHasDeclaration(declaration != null);

		BaseReservationDiscardExample discardExample = new BaseReservationDiscardExample();
		discardExample.createCriteria().andReservationIdEqualTo(id);
		BaseReservationDiscard discard = baseReservationDiscardMapper.selectOne(discardExample);
		detailDto.setDiscard(discard != null);
		if (discard != null) {
			detailDto.setStatusText(ReservationStatusEnum.getName(detailDto.getStatus()) + "(已作废)");
		} else {
			detailDto.setStatusText(ReservationStatusEnum.getName(detailDto.getStatus()));
		}

		return detailDto;

	}

	/**
	 * 查询单个预约详情
	 */
	@Override
	public BaseReservation getBaseReservation(Long id) throws BaseException {
		if (id == null) {
			return null;
		}
		return baseReservationMapper.selectByPrimaryKey(id);
	}

	@Override
	public Result<List<MyReservationListResDto>> getsByProductId(Long productId, String[] statuses,
			Integer isRemoveDeclaratoin) throws BaseException {
		if (productId == null) {
			throw new BaseException(CodeConstant.CODE_1200041);
		}
		MyReservationListReqDto reqDto = new MyReservationListReqDto();
		reqDto.setProductId(String.valueOf(productId));
		reqDto.setOrderColumn("operation_date");// 按审核通过时间倒序
		reqDto.setSort("desc");
		reqDto.setUserId(this.getHeaderUserId());
		if (statuses != null && statuses.length > 0) {
			reqDto.setStatusList(statuses);
		}
		if (isRemoveDeclaratoin != null) {
			reqDto.setIsRemoveDeclaration(1);
		}
		List<MyReservationListResDto> resDtos = reservationMapper.getMyReservations(reqDto);
		return Result.newSuccessResult(resDtos);

	}

	/**
	 * 我的预约列表
	 */
	@Override
	public Result<PaginationSupport<MyReservationListResDto>> getMyReservations(MyReservationListReqDto reqDto)
			throws BaseException {
		PaginationSupport<MyReservationListResDto> result = reqDto.getPaginationSupport();
		// 重置参数
		resetParam(reqDto);
		int totalCount = reservationMapper.getMyReservationCount(reqDto);

		if (totalCount > 0) {
			List<MyReservationListResDto> datas = reservationMapper.getMyReservations(reqDto);
			result.setDatas(datas);
			List<Long> ids = new ArrayList<Long>();
			for (MyReservationListResDto dto : datas) {
				ids.add(dto.getId());
				dto.setStatusText(ReservationStatusEnum.getName(dto.getStatus()));
				dto.setHasDeclaration(dto.getDeclarationId() != null);
				dto.setDiscard(false);
			}

			// 检查是否已经作废
			if (!BooleanUtils.isEmpty(ids)) {
				BaseReservationDiscardExample example = new BaseReservationDiscardExample();
				example.createCriteria().andReservationIdIn(ids);
				List<BaseReservationDiscard> list = baseReservationDiscardMapper.selectByExample(example);

				if (!BooleanUtils.isEmpty(list)) {
					for (MyReservationListResDto dto : datas) {
						dto.setStatusText(ReservationStatusEnum.getName(dto.getStatus()));
						for (BaseReservationDiscard discardDto : list) {
							if (dto.getId().equals(discardDto.getReservationId())) {
								dto.setDiscard(true);
								dto.setReason(discardDto.getReason());
							}
						}
					}
				}
			}
		}

		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	/**
	 * 获取客户详情--> 销售信息--> 预约列表
	 */
	@Override
	public Result<PaginationSupport<CustomerSaleReservationResDto>> getCustomerReservations(
			CustomerSaleReservationReqDto reqDto) throws BaseException {
		PaginationSupport<CustomerSaleReservationResDto> result = reqDto.getPaginationSupport();

		int totalCount = reservationMapper.getCustomerReservationCount(reqDto);

		if (totalCount > 0) {
			List<CustomerSaleReservationResDto> datas = reservationMapper.getCustomerReservations(reqDto);
			result.setDatas(datas);
			for (CustomerSaleReservationResDto dto : datas) {
				dto.setStatusText(ReservationStatusEnum.getName(dto.getStatus()));
			}
		}

		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	/**
	 * 获取客户详情--> 销售信息--> 预约列表 总个数
	 */

	public Integer getCustomerReservationCount(Long customerId) throws BaseException {
		CustomerSaleReservationReqDto reqDto = new CustomerSaleReservationReqDto();
		reqDto.setCustomerId(customerId);
		return reservationMapper.getCustomerReservationCount(reqDto);
	}

	/**
	 * 重置参数
	 */
	private void resetParam(MyReservationListReqDto reqDto) {
		if (!BooleanUtils.isBlank(reqDto.getStatuss())) {
			String[] statusList = reqDto.getStatuss().split(",");
			if (!BooleanUtils.isEmpty(statusList)) {
				reqDto.setStatusList(statusList);
			}
		}

		reqDto.setUserId(this.getHeaderUserId());

		// 重置排序
		resetOrderBy(reqDto);

	}

	/**
	 * 重置排序参数
	 *
	 * @param reqDto
	 */
	private void resetOrderBy(MyReservationListReqDto reqDto) {
		if (BooleanUtils.isBlank(reqDto.getOrderColumn())) {
			reqDto.setOrderColumn("re.create_date");
			reqDto.setSort("desc");
			return;
		}

		if ("reservationAmount".equals(reqDto.getOrderColumn())) {
			reqDto.setOrderColumn("re.reservation_amount");
		} else if ("estimatePayDate".equals(reqDto.getOrderColumn())) {
			reqDto.setOrderColumn("re.estimate_pay_date");
		} else if ("reservationDate".equals(reqDto.getOrderColumn())) {
			reqDto.setOrderColumn("re.create_date");
		} else {
			reqDto.setOrderColumn(null);
			reqDto.setSort(null);
			return;
		}
		if (BooleanUtils.isBlank(reqDto.getSort())) {
			reqDto.setSort("desc");
		}
	}

	/**
	 * 启动工作流
	 *
	 * @return 返回 业务流水号
	 */
	private String startupWorkflow(Long objectId) throws BaseException {
		ProcessStartResDTO dto = workflowServie.start(objectId, ProcessDefineKeyEnum.RESERVATIN.getKey(),
				BusinessTypeCode.RESERVATION);
		return dto.getBusinessKey();
	}

}
