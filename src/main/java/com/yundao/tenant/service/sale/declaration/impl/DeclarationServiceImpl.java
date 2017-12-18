
package com.yundao.tenant.service.sale.declaration.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.mysql.fabric.xmlrpc.base.Array;
import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.MsgConstant;
import com.yundao.tenant.constant.ResourceCodeConstant;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.FileDto;
import com.yundao.tenant.dto.customer.attach.CustomerAttachDto;
import com.yundao.tenant.dto.customer.credentials.CustomerCredentialsDto;
import com.yundao.tenant.dto.finance.receipt.DeclarationForReceiptResDto;
import com.yundao.tenant.dto.finance.receipt.plan.ReceiptPlanDeclarationDto;
import com.yundao.tenant.dto.report.AfpReportDto;
import com.yundao.tenant.dto.report.ProductReportDto;
import com.yundao.tenant.dto.resource.UserResDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationDiscardReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationForProDetailResDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationPageReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationPatchReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationResDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationResubmitReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationSearchReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUpdateBankDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUpdateComplianceDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUpdateCredentialsDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUpdateSubscribeDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUserDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUserReqDto;
import com.yundao.tenant.dto.sale.declaration.apply.DeclarationApplyrReqDto;
import com.yundao.tenant.dto.workflow.ProcessStartResDTO;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.enums.access.DataObjectEnum;
import com.yundao.tenant.enums.access.OperationPermissionEnum;
import com.yundao.tenant.enums.customer.CustomerAttachTypeEnum;
import com.yundao.tenant.enums.customer.CustomerCredentialsEnum;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.enums.product.DeclarationModelEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.enums.sale.declaration.DeclarationAttachTypeEnum;
import com.yundao.tenant.enums.sale.declaration.DeclarationCompliancesTypeEnum;
import com.yundao.tenant.enums.sale.declaration.DeclarationStatusEnum;
import com.yundao.tenant.enums.sale.refund.RefundStatusEnum;
import com.yundao.tenant.enums.sale.reservation.ReservationStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerAttachMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerBankMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerBankRelMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerCredentialsMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerCredentialsRelMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationAttachMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationBankRelMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationComplianceMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationCredentialsRelMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationDiscardMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationRefundMapper;
import com.yundao.tenant.mapper.base.sale.BaseReservationMapper;
import com.yundao.tenant.mapper.sale.declaration.DeclarationMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerAttach;
import com.yundao.tenant.model.base.customer.BaseCustomerAttachExample;
import com.yundao.tenant.model.base.customer.BaseCustomerBank;
import com.yundao.tenant.model.base.customer.BaseCustomerBankRel;
import com.yundao.tenant.model.base.customer.BaseCustomerBankRelExample;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentials;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentialsRel;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentialsRelExample;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationAttach;
import com.yundao.tenant.model.base.sale.BaseDeclarationAttachExample;
import com.yundao.tenant.model.base.sale.BaseDeclarationBankRel;
import com.yundao.tenant.model.base.sale.BaseDeclarationBankRelExample;
import com.yundao.tenant.model.base.sale.BaseDeclarationCompliance;
import com.yundao.tenant.model.base.sale.BaseDeclarationComplianceExample;
import com.yundao.tenant.model.base.sale.BaseDeclarationCredentialsRel;
import com.yundao.tenant.model.base.sale.BaseDeclarationCredentialsRelExample;
import com.yundao.tenant.model.base.sale.BaseDeclarationDiscard;
import com.yundao.tenant.model.base.sale.BaseDeclarationDiscardExample;
import com.yundao.tenant.model.base.sale.BaseDeclarationExample;
import com.yundao.tenant.model.base.sale.BaseDeclarationRefund;
import com.yundao.tenant.model.base.sale.BaseDeclarationRefundExample;
import com.yundao.tenant.model.base.sale.BaseReservation;
import com.yundao.tenant.model.sale.DeclarationModel;
import com.yundao.tenant.model.sale.DeclarationVideoDto;
import com.yundao.tenant.service.customer.attach.CustomerAttachService;
import com.yundao.tenant.service.customer.credentials.CustomerCredentialsService;
import com.yundao.tenant.service.dataobject.permission.DataObjectPermissionService;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.resource.ResourceService;
import com.yundao.tenant.service.sale.declaration.DeclarationCredentialsRelService;
import com.yundao.tenant.service.sale.declaration.DeclarationService;
import com.yundao.tenant.service.sale.declaration.DeclarationVideoService;
import com.yundao.tenant.service.user.customer.UserCustomerService;
import com.yundao.tenant.service.video.VideoService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import com.yundao.tenant.util.CamelUtil;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.DoubleUtils;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.ReportDateUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaMap;

@Service
public class DeclarationServiceImpl extends AbstractService implements DeclarationService {

	private static Log log = LogFactory.getLog(DeclarationServiceImpl.class);

	@Autowired
	private BaseDeclarationMapper baseDeclarationMapper;

	@Autowired
	private BaseDeclarationDiscardMapper baseDeclarationDiscardMapper;

	@Autowired
	private DeclarationMapper declarationMapper;

	@Autowired
	private BaseReservationMapper baseReservationMapper;

	@Autowired
	private WorkflowServie workflowServie;
	@Autowired
	private CustomerAttachService customerAttachService;

	@Autowired
	private BaseCustomerCredentialsMapper baseCustomerCredentialsMapper;

	@Autowired
	private BaseDeclarationCredentialsRelMapper baseDeclarationCredentialsRelMapper;

	@Autowired
	private BaseDeclarationComplianceMapper baseDeclarationComplianceMapper;

	@Autowired
	private BaseDeclarationAttachMapper baseDeclarationAttachMapper;

	@Autowired
	private BaseDeclarationBankRelMapper baseDeclarationBankRelMapper;

	@Autowired
	private BaseCustomerBankMapper baseCustomerBankMapper;

	@Autowired
	private BaseCustomerCredentialsRelMapper baseCustomerCredentialsRelMapper;

	@Autowired
	private BaseCustomerBankRelMapper baseCustomerBankRelMapper;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private DataObjectPermissionService dataObjectPermissionService;

	@Autowired
	private BaseCustomerMapper baseCustomerMapper;

	@Autowired
	private BaseCustomerAttachMapper baseCustomerAttachMapper;

	@Autowired
	private DeclarationCredentialsRelService declarationCredentialsRelService;

	@Autowired
	private CustomerCredentialsService customerCredentialsService;

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private BaseProductMapper baseProductMapper;

	@Autowired
	private MsgMessageService msgMessageService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private BaseDeclarationRefundMapper baseDeclarationRefundMapper;

	@Autowired
	private VideoService videoService;

	@Autowired
	private DeclarationVideoService declarationVideoService;

	private String defaultSortName = "create_date";
	private String defaultSort = "desc";
	private static int ATTACHS_COUNT = 4;
	private String COMPLIANCE_FILE = "compliance.file";
	private static String logPrefix = "报单||添加||";

	/**
	 * 查询有报单的产品id集合
	 */
	public List<Long> getHasDeclarationProductIds(String productIdStr) throws BaseException {
		List<Long> ids = SymbolStrUtils.toLong(productIdStr);
		if (BooleanUtils.isEmpty(ids)) {
			return null;
		}
		BaseDeclarationExample example = new BaseDeclarationExample();
		example.createCriteria().andProductIdIn(ids);
		List<BaseDeclaration> list = baseDeclarationMapper.selectByExample(example);
		List<Long> productIds = new ArrayList<Long>();
		if (!BooleanUtils.isEmpty(list)) {
			for (BaseDeclaration base : list) {
				if (!productIds.contains(base.getProductId())) {
					productIds.add(base.getProductId());
				}
			}
		}
		return productIds;
	}

	/**
	 * 判断某个预约是否有保单 hasDeclaration:
	 * 
	 * @author: 欧阳利
	 * @param reservationId
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public boolean hasDeclaration(Long reservationId) throws BaseException {
		if (reservationId == null) {
			return false;
		}
		BaseDeclarationExample example = new BaseDeclarationExample();
		example.createCriteria().andReservationIdEqualTo(reservationId);
		List<BaseDeclaration> list = baseDeclarationMapper.selectByExample(example);
		return !BooleanUtils.isEmpty(list);
	}

	/**
	 * 通过报单id查询报单作废信息
	 *
	 * @param declarationId
	 *            报单id
	 * @return
	 * @throws BaseException
	 */
	public BaseDeclarationDiscard getBaseDeclarationDiscard(Long declarationId) throws BaseException {
		BaseDeclarationDiscardExample example = new BaseDeclarationDiscardExample();
		example.createCriteria().andDeclarationIdEqualTo(declarationId);
		BaseDeclarationDiscard base = baseDeclarationDiscardMapper.selectOne(example);
		return base;
	}

	@Override
	public List<ProductReportDto> getTotalByProductIds(String productIds) throws BaseException {
		return declarationMapper.selectTotalByProductIds(productIds);

	}

	@Override
	public Result<Double> getDeclarationTotal(Date beginDate, Date endDate) throws BaseException {
		return Result.newSuccessResult(declarationMapper.selectDeclarationTotal(beginDate, endDate));
	}

	@Override
	public Result<List<AfpReportDto>> getDeclarationRank(Date beginDate, Date endDate, Integer limit)
			throws BaseException {
		List<AfpReportDto> afpReportDtos = declarationMapper.selectDeclarationRank(beginDate, endDate, limit);
		return Result.newSuccessResult(afpReportDtos);

	}

	@Override
	public Result<PaginationSupport<DeclarationForProDetailResDto>> getPageForProductDetail(Long productId)
			throws BaseException {
		String logPrefix = "报单||获取产品详情页面报单列表||";
		log.info("%s productId %s", logPrefix, productId);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("productId", productId);
		PaginationSupport<DeclarationForProDetailResDto> page = PaginationSupport.newDefault(paramMap);
		List<DeclarationForProDetailResDto> dtos = declarationMapper.selectPageForProDetail(paramMap);
		int count = declarationMapper.selectPageForProDetailCount(paramMap);
		for (DeclarationForProDetailResDto dto : dtos) {
			dto.setHasPayEvidenceText(dictionaryService.toText(DicCode.DIC_HAS_PAY_EVIDENCE, dto.getHasPayEvidence()));
		}
		page.setTotalCount(count);
		page.setDatas(dtos);
		return Result.newSuccessResult(page);
	}

	@Override
	public List<DeclarationForReceiptResDto> getCanReceiptDeclarations(Long productId) throws BaseException {
		return declarationMapper.selectCanReceiptDeclarations(productId);
	}

	@Override
	public List<ReceiptPlanDeclarationDto> getReceiptPlanDeclarations(Long receiptPlanId) throws BaseException {
		return declarationMapper.selectReceiptPlanDeclarations(receiptPlanId);
	}

	@Override
	public Result<Long> processSubmit(Long id) throws BaseException {
		BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(id);
		if (!DeclarationStatusEnum.UNCOMMITTED.getValue().equals(declaration.getStatus())) {
			throw new BaseException(GJLCodeConstant.CODE_1210124);
		}
		if (!super.getHeaderUserId().equals(declaration.getUserId())) {
			throw new BaseException(GJLCodeConstant.CODE_1210125);
		}
		validateSubmit(declaration);
		log.info("进入报单申请流程报单ID:" + id);
		// 发起申请
		Date now = new Date();
		declaration.setApplyDate(now);
		declaration.setUpdateUserId(super.getHeaderUserId());
		declaration.setUpdateDate(now);
		declaration.setCommitDate(now);
		declaration.setStatus(DeclarationStatusEnum.APPROVALING.getValue());
		declaration.setAuditStatus(DeclarationStatusEnum.APPROVALING.getValue());
		baseDeclarationMapper.updateByPrimaryKeySelective(declaration);
		// 发送消息
		BaseProduct product = baseProductMapper.selectByPrimaryKey(declaration.getProductId());
		String productName = product == null ? null : product.getName();
		this.doSendMsgForNewDeclaration(declaration.getDealAmount(), declaration.getPayDate(), productName,
				MsgMessageCodeEnum.DECLARATION_AUDIT_TODO.getCode());

		// 发起流程
		ProcessStartResDTO dto = workflowServie.start(declaration.getId(), ProcessDefineKeyEnum.DECLARATION.getKey(),
				BusinessTypeCode.DECLARATION);
		log.info("%s启动工作流完成 流水号：%s", logPrefix, dto.getBusinessKey());
		return Result.newSuccessResult(declaration.getId());
	}

	@Override
	public Result<Long> processValidate(Long id) throws BaseException {
		BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(id);
		validateSubmit(declaration);
		return Result.newSuccessResult(id);
	}

	private void validateSubmit(BaseDeclaration declaration) throws BaseException {
		if (declaration == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}
		StringBuilder errMsg = new StringBuilder();
		// 验证证件
		BaseDeclarationCredentialsRelExample credentialsRelExample = new BaseDeclarationCredentialsRelExample();
		credentialsRelExample.createCriteria().andDeclarationIdEqualTo(declaration.getId());
		BaseDeclarationCredentialsRel credentialsRel = baseDeclarationCredentialsRelMapper
				.selectOne(credentialsRelExample);
		if (credentialsRel == null) {
			addErrMsg(errMsg, "证件类型、证件号码、身份证件正反面");
			// throw new BaseException(GJLCodeConstant.CODE_1210126);
		} else {
			BaseCustomerCredentials customerCredentials = baseCustomerCredentialsMapper
					.selectByPrimaryKey(credentialsRel.getCredentialsId());
			if (customerCredentials == null) {
				addErrMsg(errMsg, "证件类型、证件号码、身份证件正反面");
				// throw new BaseException(GJLCodeConstant.CODE_1210127);
			} else {
				if (customerCredentials.getType() == null) {
					addErrMsg(errMsg, "证件类型");
				}
				if (BooleanUtils.isEmpty(customerCredentials.getNumber())) {
					addErrMsg(errMsg, "证件号码");
				}
				if (BooleanUtils.isEmpty(customerCredentials.getFront())) {
					addErrMsg(errMsg, "身份证件正反面");
				}
				// if(BooleanUtils.isEmpty(customerCredentials.getBack())){
				// addErrMsg(errMsg,"身份证件反面");
				// }
			}
		}

		// 验证打款凭证
		BaseDeclarationAttachExample attachExample = new BaseDeclarationAttachExample();
		attachExample.createCriteria().andDeclarationIdEqualTo(declaration.getId())
				.andTypeEqualTo(DeclarationAttachTypeEnum.VOUCHER.getType());
		List<BaseDeclarationAttach> attaches = baseDeclarationAttachMapper.selectByExample(attachExample);
		if (attaches == null || attaches.isEmpty()) {
			addErrMsg(errMsg, "打款凭证");
		}

		// 银行卡信息
		BaseDeclarationBankRelExample declarationBankRelExample = new BaseDeclarationBankRelExample();
		declarationBankRelExample.createCriteria().andDeclarationIdEqualTo(declaration.getId());
		BaseDeclarationBankRel declarationBankRel = baseDeclarationBankRelMapper.selectOne(declarationBankRelExample);
		if (declarationBankRel == null) {
			addErrMsg(errMsg, "银行卡账号、开户行、银行卡正反面");
		} else {
			BaseCustomerBank customerBank = baseCustomerBankMapper.selectByPrimaryKey(declarationBankRel.getBankId());
			if (customerBank == null) {
				addErrMsg(errMsg, "银行卡账号、开户行、银行卡正反面");
			} else {
				if (BooleanUtils.isEmpty(customerBank.getBankName())) {
					addErrMsg(errMsg, "开户行");
				}
				if (BooleanUtils.isEmpty(customerBank.getAccount())) {
					addErrMsg(errMsg, "银行卡账号");
				}
				// if(BooleanUtils.isEmpty(customerBank.getBack())){
				// addErrMsg(errMsg,"银行卡反面");
				// }
				if (BooleanUtils.isEmpty(customerBank.getFront())) {
					addErrMsg(errMsg, "银行卡正反面");
				}
			}
		}

		// 资产证明验证
		BaseDeclarationAttachExample attachExample1 = new BaseDeclarationAttachExample();
		attachExample1.createCriteria().andDeclarationIdEqualTo(declaration.getId())
				.andTypeEqualTo(DeclarationAttachTypeEnum.DECLARATION_ATTACHS.getType());
		List<BaseDeclarationAttach> declarationAttaches = baseDeclarationAttachMapper.selectByExample(attachExample1);
		if (declarationAttaches == null || declarationAttaches.isEmpty()) {
			addErrMsg(errMsg, "资产证明");
		}
		if (errMsg.length() > 0) {
			throw new BaseException(GJLCodeConstant.CODE_1210126, errMsg.toString());
		}
	}

	private void addErrMsg(StringBuilder errMsg, String s) {
		if (errMsg.length() < 1) {
			errMsg.append(s);
		} else {
			errMsg.append("、").append(s);
		}
	}

	/**
	 * 查询报单基本信息
	 */
	public BaseDeclaration getBaseDeclaration(Long id) throws BaseException {
		BaseDeclaration model = baseDeclarationMapper.selectByPrimaryKey(id);
		return model;
	}

	/**
	 * 预约作废
	 *
	 * @param dto
	 * @return
	 * @throws BaseException
	 */
	public Result<Long> doDiscard(DeclarationDiscardReqDto dto) throws BaseException {
		BaseDeclaration base = baseDeclarationMapper.selectByPrimaryKey(dto.getId());
		if (base == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200114);
		}

		if (!DeclarationStatusEnum.PASS.getValue().equals(base.getAuditStatus())) {
			return Result.newFailureResult(CodeConstant.CODE_1200113);
		}

		// 检查是否已经作废
		BaseDeclarationDiscardExample example = new BaseDeclarationDiscardExample();
		example.createCriteria().andDeclarationIdEqualTo(dto.getId());
		List<BaseDeclarationDiscard> list = baseDeclarationDiscardMapper.selectByExample(example);
		if (!BooleanUtils.isEmpty(list)) {
			return Result.newFailureResult(CodeConstant.CODE_1200116);
		}

		BaseDeclarationDiscard record = new BaseDeclarationDiscard();
		record.setCreateDate(new Date());
		record.setCreateUserId(this.getHeaderUserId());
		record.setIsDelete(0);
		record.setReason(dto.getReason());
		record.setDeclarationId(dto.getId());
		baseDeclarationDiscardMapper.insert(record);

		BaseDeclaration baseDeclaration = new BaseDeclaration();
		baseDeclaration.setId(dto.getId());
		baseDeclaration.setReason(dto.getReason());
		baseDeclaration.setStatus(DeclarationStatusEnum.DISCARD.getValue());
		baseDeclarationMapper.updateByPrimaryKeySelective(baseDeclaration);

		sendMessage(base, dto, MsgMessageCodeEnum.DECLARATION_DISCARD.getCode());
		return Result.newSuccessResult(1l);
	}

	private void sendMessage(BaseDeclaration base, DeclarationDiscardReqDto dto, String code) throws BaseException {
		Map<String, Object> params = new HashMap<>();
		BaseProduct product = baseProductMapper.selectByPrimaryKey(base.getProductId());
		params.put("productName", product == null ? null : product.getName());
		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(base.getCustomerId());
		params.put("dealAmount", base.getDealAmount());
		params.put("customerName", customer == null ? null : customer.getName());
		params.put("reason", dto.getReason());
		params.put("customerId", base.getCustomerId());
		params.put("userId", base.getUserId());
		params.put("audioName", super.getRealName());
		params.put("id", dto.getId());
		msgMessageService.processSendMessage(code, params);
	}

	@Override
	public Result<Integer> getCustomerCount(Long customerId) throws SQLException {
		Map<String, Object> params = new HashMap<>();
		params.put("customerId", customerId);
		int totalCount = declarationMapper.queryPageCount(params);
		return Result.newSuccessResult(totalCount);
	}

	/**
	 * 提交报单 submitDeclaration:
	 *
	 * @param reqDto
	 * @return
	 * @throws Exception
	 * @author: 欧阳利
	 * @description:
	 */
	public Result<Long> doSubmitDeclaration(DeclarationReqDto reqDto) throws Exception {
		// 打款日期不能大于当前日期
		if (reqDto.getPayDate().getTime() > new Date().getTime()) {
			return Result.newFailureResult(CodeConstant.CODE_1200140);
		}
		if (reqDto.getReservationId() == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}

		BaseDeclaration model = new BaseDeclaration();
		BeanUtils.copyProperties(reqDto, model);
		validateDate(reqDto, model);

		if (model.getCustomerId() == null) {
			throw new BaseException(CodeConstant.CODE_1220047);
		}
		// 产品不存在
		BaseProduct product = baseProductMapper.selectByPrimaryKey(model.getProductId());
		if (product == null) {
			throw new BaseException(CodeConstant.CODE_1200042);
		}
		model.setProductId(product.getId());
		return insert(model, product, false, true);
	}

	/**
	 * 补入报单 patch:
	 * 
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws Exception
	 * @description:
	 */
	public Result<Long> doPatch(DeclarationPatchReqDto reqDto) throws Exception {
		// 打款日期不能大于当前日期
		if (reqDto.getPayDate().getTime() > new Date().getTime()) {
			return Result.newFailureResult(CodeConstant.CODE_1200140);
		}
		// 产品不存在
		BaseProduct product = baseProductMapper.selectByPrimaryKey(reqDto.getProductId());
		if (product == null) {
			throw new BaseException(CodeConstant.CODE_1200042);
		}

		BaseDeclaration model = new BaseDeclaration();
		BeanUtils.copyProperties(reqDto, model);
		model.setUserId(this.getHeaderUserId());

		if (ProductIssuedStatusEnum.ON_LINE_PRE.getValue().equals(product.getIssuedStatus())
				|| ProductIssuedStatusEnum.NOT_ON_LINE.getValue().equals(product.getIssuedStatus())) {
			throw new BaseException(CodeConstant.CODE_1200158);
		}

		return insert(model, product, true, false);
	}

	/**
	 * 新增报单 add:
	 *
	 * @param reqDto
	 * @return
	 * @throws Exception
	 * @author: 欧阳利
	 * @description:
	 */
	public Result<Long> add(DeclarationReqDto reqDto) throws Exception {
		// 打款日期不能大于当前日期
		if (reqDto.getPayDate().getTime() > new Date().getTime()) {
			return Result.newFailureResult(CodeConstant.CODE_1200140);
		}
		// 报单请选择产品
		if (reqDto.getProductId() == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200041);
		}
		// 产品不存在
		BaseProduct product = baseProductMapper.selectByPrimaryKey(reqDto.getProductId());
		if (product == null) {
			throw new BaseException(CodeConstant.CODE_1200042);
		}

		if (DeclarationModelEnum.DECLARATION.getValue().equals(product.getDeclarationModel())) {
			// 直接报单的产品，需要传客户ID，不需要传预约ID
			if (reqDto.getReservationId() != null) {
				throw new BaseException(CodeConstant.CODE_1200146);
			} else if (reqDto.getCustomerId() == null) {
				throw new BaseException(CodeConstant.CODE_1200147);
			}

		} else if (DeclarationModelEnum.RESERVATION_AND_DECLARATION.getValue().equals(product.getDeclarationModel())) {
			if (reqDto.getReservationId() == null) {
				throw new BaseException(CodeConstant.CODE_1200102);
			}
		}

		// 检查客户是否是当前客户
		BaseDeclaration model = new BaseDeclaration();
		BeanUtils.copyProperties(reqDto, model);
		if (reqDto.getReservationId() != null) {
			validateDate(reqDto, model);
		} else {
			model.setUserId(this.getHeaderUserId());
		}
		return insert(model, product, false, false);
	}

	/**
	 * 产品报单的基本校验 insert:
	 *
	 * @param model
	 * @param product
	 * @return
	 * @throws Exception
	 * @author: 欧阳利
	 * @description:
	 */
	private Result<Long> insert(BaseDeclaration model, BaseProduct product, boolean isPatch,
			boolean isSubmitDeclaration) throws Exception {
		// 只有募集中的产品才能添加报单
		if (!isSubmitDeclaration) {
			if (!isPatch) {
				if (!ProductIssuedStatusEnum.TO_RAISE.getValue().equals(product.getIssuedStatus())) {
					throw new BaseException(CodeConstant.CODE_1200145);
				}
			}
		}
		if (model.getCustomerId() != null) {
			Long userId = super.getHeaderUserId();
			BaseUserCustomer userCustomer = userCustomerService.getByCustomerId(model.getCustomerId());
			if (userCustomer == null || !userId.equals(userCustomer.getUserId())) {
				throw new BaseException(Code1200000.CODE_1200201);
			}
		}

		model.setAuditStatus(DeclarationStatusEnum.UNCOMMITTED.getValue());
		model.setStatus(DeclarationStatusEnum.UNCOMMITTED.getValue());
		model.setIsDelete(CommonConstant.ZERO);
		// model.setCommitDate(new Date());
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setTenantId(super.getHeaderTenantId());
		model.setId(null);

		baseDeclarationMapper.insertSelective(model);
		// 生产保单编号
		model.setNumber(String.format("%08d", model.getId()));
		baseDeclarationMapper.updateByPrimaryKey(model);

		// 正补客户银行卡和身份证到报单中
		replenishData(model);

		// this.doSendMsgForNewDeclaration(model.getDealAmount(),
		// model.getPayDate(), product.getName(),
		// MsgMessageCodeEnum.DECLARATION_AUDIT_TODO.getCode());

		// 发起流程
		// ProcessStartResDTO dto = workflowServie.start(model.getId(),
		// ProcessDefineKeyEnum.DECLARATION.getKey(),
		// BusinessTypeCode.DECLARATION);
		// log.info("%s启动工作流完成 流水号：%s", logPrefix, dto.getBusinessKey());

		return Result.newSuccessResult(model.getId());

	}

	private void doSendMsgForNewDeclaration(Double dealAmount, Date payDate, String productName, String code)
			throws BaseException {
		String logPrefix = "报单||上报消息动态||";
		log.info("%s,dealAmount %s, payDate %s,productName %s", logPrefix, dealAmount, payDate, productName);
		List<UserResDto> users = resourceService.getUserByCode(ResourceCodeConstant.DECLARATION_AUDIT);
		log.info("%s users %s", logPrefix, JsonUtils.objectToJson(users));
		if (BooleanUtils.isEmpty(users)) {
			log.info("%s 需要审批的人为空");
		}
		String userIds = SymbolStrUtils.longToStr(LambdaMap.toSingleList(users, m -> m.getUserId()));
		// 上报消息动态
		Map<String, Object> msgMap = new HashMap<>();
		msgMap.put("userName", super.getRealName());
		msgMap.put("productName", productName);
		msgMap.put("dealAmount", DoubleUtils.toWholeString(dealAmount));
		msgMap.put("payDate", DateUtil.formatExactDay(payDate));
		msgMap.put(MsgConstant.USER_IDS, userIds);
		log.info("%s msgMap %s", logPrefix, JsonUtils.objectToJson(msgMap));
		msgMessageService.processSendMessage(code, msgMap);
		log.info("%s 完成");
	}

	private void replenishData(BaseDeclaration model) {
		Long customerId = model.getCustomerId();
		// 补充身份证信息
		BaseCustomerCredentialsRelExample relExample = new BaseCustomerCredentialsRelExample();
		relExample.createCriteria().andCustomerIdEqualTo(customerId);
		List<BaseCustomerCredentialsRel> credentialsRels = baseCustomerCredentialsRelMapper.selectByExample(relExample);
		if (credentialsRels != null && !credentialsRels.isEmpty()) {
			BaseCustomerCredentials customerCredentials = baseCustomerCredentialsMapper
					.selectByPrimaryKey(credentialsRels.get(0).getCredentialsId());
			customerCredentials.setId(null);
			baseCustomerCredentialsMapper.insertSelective(customerCredentials);
			BaseDeclarationCredentialsRel credentialsRel = new BaseDeclarationCredentialsRel();
			credentialsRel.setCredentialsId(customerCredentials.getId());
			credentialsRel.setDeclarationId(model.getId());
			credentialsRel.setCreateDate(new Date());
			credentialsRel.setCreateUserId(super.getHeaderUserId());
			baseDeclarationCredentialsRelMapper.insertSelective(credentialsRel);
		}
		// 补充银行卡
		BaseCustomerBankRelExample bankRelExample = new BaseCustomerBankRelExample();
		bankRelExample.createCriteria().andCustomerIdEqualTo(customerId);
		List<BaseCustomerBankRel> bankRels = baseCustomerBankRelMapper.selectByExample(bankRelExample);
		if (bankRels != null && !bankRels.isEmpty()) {
			BaseCustomerBank bank = baseCustomerBankMapper.selectByPrimaryKey(bankRels.get(0).getBankId());
			bank.setId(null);
			baseCustomerBankMapper.insertSelective(bank);
			BaseDeclarationBankRel bankRel = new BaseDeclarationBankRel();
			bankRel.setBankId(bank.getId());
			bankRel.setDeclarationId(model.getId());
			bankRel.setCreateDate(new Date());
			bankRel.setCreateUserId(super.getHeaderUserId());
			baseDeclarationBankRelMapper.insertSelective(bankRel);
		}

	}

	private void validateDate(DeclarationReqDto reqDto, BaseDeclaration model) throws BaseException {
		BaseReservation reservation = baseReservationMapper.selectByPrimaryKey(reqDto.getReservationId());
		if (reservation == null || CommonConstant.ONE == reservation.getIsDelete()) {
			throw new BaseException(GJLCodeConstant.CODE_1210062);
		} else {
			model.setProductId(reservation.getProductId());
			model.setCustomerId(reservation.getCustomerId());
			model.setUserId(reservation.getUserId());
		}

		if (!reservation.getStatus().equals(ReservationStatusEnum.PASS.getValue())) {
			throw new BaseException(GJLCodeConstant.CODE_1210078);
		}
		// 当前预约是否是自己的预约
		if (!reservation.getUserId().equals(super.getHeaderUserId())) {
			throw new BaseException(GJLCodeConstant.CODE_1210064);
		}
		// 当前预约是否已经报单过了
		BaseDeclarationExample example = new BaseDeclarationExample();
		example.createCriteria().andReservationIdEqualTo(reqDto.getReservationId());
		List<BaseDeclaration> list = baseDeclarationMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			throw new BaseException(GJLCodeConstant.CODE_1210063);
		}
	}

	@Override
	public Result<Boolean> updateForApp(Map<String, String> params) throws Exception {
		if (StringUtils.isBlank(params.get("orderId"))) {
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}
		Long orderId = NumberUtils.toLong(params.get("orderId"));

		BaseDeclaration model = baseDeclarationMapper.selectByPrimaryKey(orderId);
		if (model == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}
		if (model.getAuditStatus().equals(DeclarationStatusEnum.CANCEL.getValue())) {
			throw new BaseException(GJLCodeConstant.CODE_1210068);
		}

		boolean doUpdate = false;
		boolean doInsert = false;
		// 认购资料
		if (params.containsKey("renGouAmount")) {// 认购金额
			doUpdate = true;
			model.setDealAmount(NumberUtils.toDouble(params.get("renGouAmount")));
		}
		if (params.containsKey("giveAmountDate")) {// 打款日期
			doUpdate = true;
			Date payDate = new Date(Long.parseLong(params.get("giveAmountDate")));
			model.setPayDate(payDate);
		}
		if (doUpdate) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.APPROVALING.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200126);
			} else if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			baseDeclarationMapper.updateByPrimaryKey(model);
		}
		doUpdate = false;
		// 修改证件
		BaseCustomerCredentials customerCredentials = declarationCredentialsRelService
				.getCustomerCredentialsByDeclarationId(orderId);

		if (customerCredentials == null) {
			customerCredentials = new BaseCustomerCredentials();
			doInsert = true;
		}
		if (params.containsKey("certificateType")) {
			customerCredentials.setType(Long.parseLong(params.get("certificateType")));
			doUpdate = true;
		}
		if (params.containsKey("certificateNumber")) {
			doUpdate = true;
			if ((customerCredentials == null || customerCredentials.getType() == null)
					&& StringUtils.isBlank(params.get("certificateType"))) {
				throw new BaseException(CodeConstant.CODE_1200091);
			}
			customerCredentials.setNumber(params.get("certificateNumber"));
		}
		if (params.containsKey("identityFrontCardUrl")) {
			doUpdate = true;
			if ((customerCredentials == null || customerCredentials.getType() == null)
					&& StringUtils.isBlank(params.get("certificateType"))) {
				throw new BaseException(CodeConstant.CODE_1200091);
			}
			customerCredentials.setFront(params.get("identityFrontCardUrl"));
		}
		if (params.containsKey("identityBackCardUrl")) {
			doUpdate = true;
			if ((customerCredentials == null || customerCredentials.getType() == null)
					&& StringUtils.isBlank(params.get("certificateType"))) {
				throw new BaseException(CodeConstant.CODE_1200091);
			}
			customerCredentials.setBack(params.get("identityBackCardUrl"));
		}
		if (doInsert && doUpdate) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			declarationCredentialsRelService.add(customerCredentials, orderId);
		} else if (doUpdate) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			customerCredentialsService.update(customerCredentials);
		}
		// 资产证明
		if (params.containsKey("assetsCertificateUrlList")) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			String assets = params.get("assetsCertificateUrlList");
			List<String> assetUrls = JsonUtils.jsonToObject(assets, new BaseTypeReference<List<String>>() {
			});
			// 清空资产证明
			BaseDeclarationAttachExample attachExample = new BaseDeclarationAttachExample();
			attachExample.createCriteria().andDeclarationIdEqualTo(model.getId())
					.andTypeEqualTo(DeclarationAttachTypeEnum.DECLARATION_ATTACHS.getType());
			baseDeclarationAttachMapper.deleteByExample(attachExample);
			if (BooleanUtils.isNotEmpty(assetUrls)) {
				// 新增资产证明
				for (int i = 0; i < assetUrls.size(); i++) {
					BaseDeclarationAttach declarationAttach = new BaseDeclarationAttach();

					String url = assetUrls.get(i);
					int indix_ = url.lastIndexOf(".");
					int beginIndix_ = url.lastIndexOf("/");

					declarationAttach.setId(null);
					declarationAttach.setType(DeclarationAttachTypeEnum.DECLARATION_ATTACHS.getType());
					declarationAttach.setDeclarationId(model.getId());
					declarationAttach.setName(url.substring(beginIndix_ + 1, indix_));
					declarationAttach.setUrl(url);
					declarationAttach.setSequence(i);
					declarationAttach.setTenantId(super.getHeaderTenantId());
					declarationAttach.setCreateDate(new Date());
					declarationAttach.setCreateUserId(super.getHeaderUserId());
					baseDeclarationAttachMapper.insertSelective(declarationAttach);
				}
			}
		}
		// 打款凭证
		if (params.containsKey("giveAmountCertificateUrlList")) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			String vouches = params.get("giveAmountCertificateUrlList");
			List<String> vouchUrls = JsonUtils.jsonToObject(vouches, new BaseTypeReference<List<String>>() {
			});
			// 清空资产证明
			BaseDeclarationAttachExample attachExample = new BaseDeclarationAttachExample();
			attachExample.createCriteria().andDeclarationIdEqualTo(model.getId())
					.andTypeEqualTo(DeclarationAttachTypeEnum.VOUCHER.getType());
			baseDeclarationAttachMapper.deleteByExample(attachExample);
			if (BooleanUtils.isNotEmpty(vouchUrls)) {
				// 新增资产证明
				for (int i = 0; i < vouchUrls.size(); i++) {
					BaseDeclarationAttach declarationAttach = new BaseDeclarationAttach();

					String url = vouchUrls.get(i);
					int indix_ = url.lastIndexOf(".");
					int beginIndix_ = url.lastIndexOf("/");

					declarationAttach.setId(null);
					declarationAttach.setType(DeclarationAttachTypeEnum.VOUCHER.getType());
					declarationAttach.setDeclarationId(model.getId());
					declarationAttach.setName(url.substring(beginIndix_ + 1, indix_));
					declarationAttach.setUrl(url);
					declarationAttach.setSequence(i);
					declarationAttach.setTenantId(super.getHeaderTenantId());
					declarationAttach.setCreateDate(new Date());
					declarationAttach.setCreateUserId(super.getHeaderUserId());
					baseDeclarationAttachMapper.insertSelective(declarationAttach);
				}
			}
		}
		// 合同附件
		if (params.containsKey("contractAttachUrlList")) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			String contracts = params.get("contractAttachUrlList");
			List<String> contractUrls = JsonUtils.jsonToObject(contracts, new BaseTypeReference<List<String>>() {
			});
			// 清空资产证明
			BaseDeclarationAttachExample attachExample = new BaseDeclarationAttachExample();
			attachExample.createCriteria().andDeclarationIdEqualTo(model.getId())
					.andTypeEqualTo(DeclarationAttachTypeEnum.CONTRACT_FILE.getType());
			baseDeclarationAttachMapper.deleteByExample(attachExample);
			if (BooleanUtils.isNotEmpty(contractUrls)) {
				// 新增资产证明
				for (int i = 0; i < contractUrls.size(); i++) {
					BaseDeclarationAttach declarationAttach = new BaseDeclarationAttach();

					String url = contractUrls.get(i);
					int indix_ = url.lastIndexOf(".");
					int beginIndix_ = url.lastIndexOf("/");

					declarationAttach.setId(null);
					declarationAttach.setType(DeclarationAttachTypeEnum.CONTRACT_FILE.getType());
					declarationAttach.setDeclarationId(model.getId());
					declarationAttach.setName(url.substring(beginIndix_ + 1, indix_));
					declarationAttach.setUrl(url);
					declarationAttach.setSequence(i);
					declarationAttach.setTenantId(super.getHeaderTenantId());
					declarationAttach.setCreateDate(new Date());
					declarationAttach.setCreateUserId(super.getHeaderUserId());
					baseDeclarationAttachMapper.insertSelective(declarationAttach);
				}
			}
		}
		// 合规双录的视频的信息
		if (params.containsKey("orderComplianceMultimediaFile")) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}

			List<DeclarationVideoDto> list = new ArrayList<>();

			String urlStr = params.get("orderComplianceMultimediaFile");
			if (StringUtils.isNotBlank(urlStr)) {
				JavaType javaType = JsonUtils.getCollectionType(List.class, DeclarationVideoDto.class);
				list = JsonUtils.jsonToObject(urlStr, javaType);
			}

			declarationVideoService.updateComplianceRecord(JsonUtils.objectToJson(list), model);

		}
		// 投资者基本信息表(自然人)
		if (params.containsKey("investorBaseInfoFormUrlList")) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			String urlStr = params.get("investorBaseInfoFormUrlList");
			List<String> urls = JsonUtils.jsonToObject(urlStr, new BaseTypeReference<List<String>>() {
			});
			BaseDeclarationComplianceExample complianceExample = new BaseDeclarationComplianceExample();
			complianceExample.createCriteria().andDeclarationIdEqualTo(model.getId())
					.andTypeEqualTo(DeclarationCompliancesTypeEnum.BASE_INFO.getType());
			baseDeclarationComplianceMapper.deleteByExample(complianceExample);
			if (BooleanUtils.isNotEmpty(urls)) {
				// 新增资产证明
				for (int i = 0; i < urls.size(); i++) {
					BaseDeclarationCompliance declarationCompliance = new BaseDeclarationCompliance();

					String url = urls.get(i);
					int indix_ = url.lastIndexOf(".");
					int beginIndix_ = url.lastIndexOf("/");

					declarationCompliance.setType(DeclarationCompliancesTypeEnum.BASE_INFO.getType());
					declarationCompliance.setUrl(url);
					declarationCompliance.setName(url.substring(beginIndix_ + 1, indix_));
					declarationCompliance.setDeclarationId(model.getId());
					declarationCompliance.setFormatType(1);
					declarationCompliance.setSequence(i);
					declarationCompliance.setCreateUserId(super.getHeaderUserId());
					declarationCompliance.setCreateDate(new Date());
					declarationCompliance.setTenantId(this.getHeaderTenantId());
					baseDeclarationComplianceMapper.insertSelective(declarationCompliance);
				}
			}
		}
		// 投资者风险匹配告知书及投资者确认函
		if (params.containsKey("investorRiskConfirmationUrlList")) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			String urlStr = params.get("investorRiskConfirmationUrlList");
			List<String> urls = JsonUtils.jsonToObject(urlStr, new BaseTypeReference<List<String>>() {
			});
			BaseDeclarationComplianceExample complianceExample = new BaseDeclarationComplianceExample();
			complianceExample.createCriteria().andDeclarationIdEqualTo(model.getId())
					.andTypeEqualTo(DeclarationCompliancesTypeEnum.RISK_NOTIFY.getType());
			baseDeclarationComplianceMapper.deleteByExample(complianceExample);
			if (BooleanUtils.isNotEmpty(urls)) {
				// 新增资产证明
				for (int i = 0; i < urls.size(); i++) {
					BaseDeclarationCompliance declarationCompliance = new BaseDeclarationCompliance();

					String url = urls.get(i);
					int indix_ = url.lastIndexOf(".");
					int beginIndix_ = url.lastIndexOf("/");

					declarationCompliance.setType(DeclarationCompliancesTypeEnum.RISK_NOTIFY.getType());
					declarationCompliance.setUrl(url);
					declarationCompliance.setName(url.substring(beginIndix_ + 1, indix_));
					declarationCompliance.setDeclarationId(model.getId());
					declarationCompliance.setFormatType(1);
					declarationCompliance.setSequence(i);
					declarationCompliance.setCreateUserId(super.getHeaderUserId());
					declarationCompliance.setCreateDate(new Date());
					declarationCompliance.setTenantId(this.getHeaderTenantId());
					baseDeclarationComplianceMapper.insertSelective(declarationCompliance);
				}
			}
		}
		// 风险承受能力调查问卷(自然人)
		if (params.containsKey("riskToleranceQuestionnaireUrlList")) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			String urlStr = params.get("riskToleranceQuestionnaireUrlList");
			List<String> urls = JsonUtils.jsonToObject(urlStr, new BaseTypeReference<List<String>>() {
			});
			BaseDeclarationComplianceExample complianceExample = new BaseDeclarationComplianceExample();
			complianceExample.createCriteria().andDeclarationIdEqualTo(model.getId())
					.andTypeEqualTo(DeclarationCompliancesTypeEnum.RISK_QUESSTIONNAIRE.getType());
			baseDeclarationComplianceMapper.deleteByExample(complianceExample);
			if (BooleanUtils.isNotEmpty(urls)) {
				for (int i = 0; i < urls.size(); i++) {
					BaseDeclarationCompliance declarationCompliance = new BaseDeclarationCompliance();

					String url = urls.get(i);
					int indix_ = url.lastIndexOf(".");
					int beginIndix_ = url.lastIndexOf("/");

					declarationCompliance.setType(DeclarationCompliancesTypeEnum.RISK_QUESSTIONNAIRE.getType());
					declarationCompliance.setUrl(url);
					declarationCompliance.setName(url.substring(beginIndix_ + 1, indix_));
					declarationCompliance.setDeclarationId(model.getId());
					declarationCompliance.setFormatType(1);
					declarationCompliance.setSequence(i);
					declarationCompliance.setCreateUserId(super.getHeaderUserId());
					declarationCompliance.setCreateDate(new Date());
					declarationCompliance.setTenantId(this.getHeaderTenantId());
					baseDeclarationComplianceMapper.insertSelective(declarationCompliance);
				}
			}
		}
		// 基金回访确认书
		if (params.containsKey("fundCallbackUrlList")) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			String urlStr = params.get("fundCallbackUrlList");
			List<String> urls = JsonUtils.jsonToObject(urlStr, new BaseTypeReference<List<String>>() {
			});
			BaseDeclarationComplianceExample complianceExample = new BaseDeclarationComplianceExample();
			complianceExample.createCriteria().andDeclarationIdEqualTo(model.getId())
					.andTypeEqualTo(DeclarationCompliancesTypeEnum.RETURN_CONFIRMATION.getType());
			baseDeclarationComplianceMapper.deleteByExample(complianceExample);
			if (BooleanUtils.isNotEmpty(urls)) {
				// 新增资产证明
				for (int i = 0; i < urls.size(); i++) {
					BaseDeclarationCompliance declarationCompliance = new BaseDeclarationCompliance();

					String url = urls.get(i);
					int indix_ = url.lastIndexOf(".");
					int beginIndix_ = url.lastIndexOf("/");

					declarationCompliance.setType(DeclarationCompliancesTypeEnum.RETURN_CONFIRMATION.getType());
					declarationCompliance.setUrl(url);
					declarationCompliance.setName(url.substring(beginIndix_ + 1, indix_));
					declarationCompliance.setDeclarationId(model.getId());
					declarationCompliance.setFormatType(1);
					declarationCompliance.setSequence(i);
					declarationCompliance.setCreateUserId(super.getHeaderUserId());
					declarationCompliance.setCreateDate(new Date());
					declarationCompliance.setTenantId(this.getHeaderTenantId());
					baseDeclarationComplianceMapper.insertSelective(declarationCompliance);
				}
			}
		}
		// 其他合规文件
		if (params.containsKey("otherContractUrlList")) {
			if (model.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
				throw new BaseException(CodeConstant.CODE_1200127);
			}
			String urlStr = params.get("otherContractUrlList");
			List<String> urls = JsonUtils.jsonToObject(urlStr, new BaseTypeReference<List<String>>() {
			});
			BaseDeclarationComplianceExample complianceExample = new BaseDeclarationComplianceExample();
			complianceExample.createCriteria().andDeclarationIdEqualTo(model.getId())
					.andTypeEqualTo(DeclarationCompliancesTypeEnum.OTHER_FILE.getType());
			baseDeclarationComplianceMapper.deleteByExample(complianceExample);
			if (BooleanUtils.isNotEmpty(urls)) {
				// 新增资产证明
				for (int i = 0; i < urls.size(); i++) {
					BaseDeclarationCompliance declarationCompliance = new BaseDeclarationCompliance();

					String url = urls.get(i);
					int indix_ = url.lastIndexOf(".");
					int beginIndix_ = url.lastIndexOf("/");

					declarationCompliance.setType(DeclarationCompliancesTypeEnum.OTHER_FILE.getType());
					declarationCompliance.setUrl(url);
					declarationCompliance.setName(url.substring(beginIndix_ + 1, indix_));
					declarationCompliance.setDeclarationId(model.getId());
					declarationCompliance.setFormatType(1);
					declarationCompliance.setSequence(i);
					declarationCompliance.setCreateUserId(super.getHeaderUserId());
					declarationCompliance.setCreateDate(new Date());
					declarationCompliance.setTenantId(this.getHeaderTenantId());
					baseDeclarationComplianceMapper.insertSelective(declarationCompliance);
				}
			}
		}

		return Result.newSuccessResult(true);

	}

	public Result<Integer> update(DeclarationReqDto reqDto) throws Exception {
		BaseDeclaration model = new BaseDeclaration();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseDeclarationMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseDeclaration declaration = new BaseDeclaration();
		declaration.setId(id);
		declaration.setUpdateDate(new Date());
		declaration.setUpdateUserId(super.getHeaderUserId());
		int count = baseDeclarationMapper.updateByPrimaryKeySelective(declaration);
		return Result.newSuccessResult(count);
	}

	public Result<DeclarationResDto> get(Long id) throws Exception {
		DeclarationResDto model = declarationMapper.selectByPrimaryKey(id);
		// if (!super.getHeaderUserId().equals(model.getUserId())) {
		// throw new BaseException(GJLCodeConstant.CODE_1210065);
		// }
		if (model != null) {
			setData(model);
		}
		return Result.newSuccessResult(model);
	}

	@Override
	public Result<PaginationSupport<DeclarationModel>> getPage(DeclarationPageReqDto declarationDto,
			AbstractBasePageDto pageDto) throws Exception {
		Map<String, Object> params = LocalBeanUtils.toMap(declarationDto);
		if (BooleanUtils.isEmpty(pageDto.getOrderColumn())) {
			pageDto.setOrderColumn(defaultSortName);
			pageDto.setSort(defaultSort);
		} else {
			pageDto.setOrderColumn(CamelUtil.toline(pageDto.getOrderColumn()));
			if (BooleanUtils.isNotEmpty(pageDto.getSort())) {
				pageDto.setSort(pageDto.getSort());
			} else {
				pageDto.setSort(defaultSort);
			}
		}

		if (BooleanUtils.isNotEmpty(declarationDto.getStatuss())) {
			String statuss = declarationDto.getStatuss();
			params.put("statuss", statuss.replace(",", "','"));
		}
		// params.put("userId", super.getHeaderUserId());
		params.putAll(LocalBeanUtils.toMap(pageDto));
		PaginationSupport<DeclarationModel> pager = PaginationSupport.newDefault(params);
		int totalCount = declarationMapper.queryPageCount(params);
		if (totalCount > 0) {
			List<DeclarationModel> list = declarationMapper.queryPageInfo(params);
			for (DeclarationModel dto : list) {
				dto.setStatusName(DeclarationStatusEnum.getName(dto.getStatus()));
			}
			pager.setDatas(list);

			// 设置是否能申请退款
			setCanApplyRefund(list);
		}

		pager.setTotalCount(totalCount);
		return Result.newSuccessResult(pager);
	}

	/**
	 * 设置是否能申请退款 setCanApplyRefund:
	 * 
	 * @author: 欧阳利
	 * @param list
	 * @description:
	 */
	private void setCanApplyRefund(List<DeclarationModel> list) {
		List<Long> declarationIds = new ArrayList<Long>();
		for (DeclarationModel dto : list) {
			declarationIds.add(dto.getId());
		}
		// 查询报单的退款申请
		BaseDeclarationRefundExample example = new BaseDeclarationRefundExample();
		example.createCriteria().andDeclarationIdIn(declarationIds);
		List<BaseDeclarationRefund> refundList = baseDeclarationRefundMapper.selectByExample(example);
		for (DeclarationModel dto : list) {
			if (!DeclarationStatusEnum.DISCARD.getValue().equals(dto.getStatus())
					&& !DeclarationStatusEnum.PASS.getValue().equals(dto.getStatus())) {
				dto.setCanApplyRefund(false);
				dto.setNotCanApplyRefundTitle("已作废和已通过的报单才能申请退款");
				continue;
			}
			if (DeclarationStatusEnum.REFUND.getValue().equals(dto.getStatus())) {
				dto.setCanApplyRefund(false);
				dto.setNotCanApplyRefundTitle("已退款，不能再次申请退款");
				continue;
			}

			for (BaseDeclarationRefund refund : refundList) {
				if (dto.getId().equals(refund.getDeclarationId())) {
					if (RefundStatusEnum.REJECT.getValue().equals(refund.getStatus())) {
						dto.setNotCanApplyRefundTitle("退款申请已驳回，请到我的退款中处理");
						dto.setCanApplyRefund(false);
					} else if (RefundStatusEnum.APPROVALING.getValue().equals(refund.getStatus())) {
						dto.setNotCanApplyRefundTitle("退款申请中，可到我的退款中查看进展");
						dto.setCanApplyRefund(false);
					}
				}
			}

			if (dto.getCanApplyRefund() == null) {
				dto.setCanApplyRefund(true);
			}

		}
	}

	@Override
	public Result<PaginationSupport<DeclarationModel>> searchForApp(DeclarationSearchReqDto declarationDto,
			AbstractBasePageDto pageDto) throws Exception {
		Map<String, Object> params = LocalBeanUtils.toMap(declarationDto);
		if (BooleanUtils.isEmpty(pageDto.getOrderColumn())) {
			pageDto.setOrderColumn(defaultSortName);
			pageDto.setSort(defaultSort);
		} else {
			pageDto.setOrderColumn(CamelUtil.toline(pageDto.getOrderColumn()));
		}
		if (BooleanUtils.isEmpty(pageDto.getSort())) {
			pageDto.setSort(defaultSort);
		}
		params.putAll(LocalBeanUtils.toMap(pageDto));

		PaginationSupport<DeclarationModel> pager = PaginationSupport.newDefault(params);
		int totalCount = declarationMapper.selectSearchPageCount(params);
		List<DeclarationModel> list = declarationMapper.selectSearchPage(params);
		for (DeclarationModel dto : list) {
			dto.setStatusName(DeclarationStatusEnum.getName(dto.getStatus()));
		}
		pager.setDatas(list);
		pager.setTotalCount(totalCount);
		return Result.newSuccessResult(pager);

	}

	@Override
	public Result<Long> doResubmitForApp(DeclarationResubmitReqDto reqDto) throws BaseException {
		if (reqDto.getPayDate().getTime() > new Date().getTime()) {
			throw new BaseException(CodeConstant.CODE_1200140);
		}
		BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(reqDto.getId());
		if (declaration.getUserId() != this.getHeaderUserId()) {
			throw new BaseException(CodeConstant.CODE_1200141);
		}

		DeclarationApplyrReqDto applyrReqDto = new DeclarationApplyrReqDto();
		applyrReqDto.setAction(WorkflowActionEnum.RESUBMIT.getValue());
		applyrReqDto.setId(reqDto.getId());
		this.doApply(applyrReqDto);

		declaration.setDealAmount(reqDto.getDealAmount());
		declaration.setPayDate(reqDto.getPayDate());
		declaration.setRemark(reqDto.getRemark());
		super.updateModel(declaration);
		baseDeclarationMapper.updateByPrimaryKey(declaration);

		return Result.newSuccessResult(declaration.getId());

	}

	@Override
	public Result<Long> doResubmit(DeclarationApplyrReqDto dto) throws BaseException {
		log.info("我的报单||重新提交开始");
		dto.setAction(WorkflowActionEnum.RESUBMIT.getValue());
		return this.doApply(dto);
	}

	@Override
	public Result<Long> doCancel(DeclarationApplyrReqDto dto) throws BaseException {
		log.info("我的报单||取消开始");
		dto.setAction(WorkflowActionEnum.CANCEL.getValue());
		return this.doApply(dto);
	}

	@Override
	public Result<Long> updateCredentials(DeclarationUpdateCredentialsDto dto) throws BaseException {
		validataCredentialsDto(dto);
		// 获取对应的报单
		BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(dto.getId());
		validataUpdateDeclaration(declaration);

		if (!declaration.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
			// 处理身份信息
			headleCredentials(dto, declaration);
		}
		// 处理资产证明
		headlerAttach(dto.getDeclarationAttachs(), declaration,
				DeclarationAttachTypeEnum.DECLARATION_ATTACHS.getType());
		// 处理客户的资产证明
		backToCustomerAttach(dto.getDeclarationAttachs(), declaration);
		return Result.newSuccessResult(declaration.getId());
	}

	private void validataUpdateDeclaration(BaseDeclaration declaration) throws BaseException {
		if (declaration == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}
		if (declaration.getAuditStatus().equals(DeclarationStatusEnum.CANCEL.getValue())) {
			throw new BaseException(GJLCodeConstant.CODE_1210068);
		}
	}

	@Override
	public Result<Long> updateCompliance(DeclarationUpdateComplianceDto dto) throws BaseException {

		validataCompliance(dto);
		// 获取对应的报单
		BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(dto.getId());
		validataUpdateDeclaration(declaration);
		declarationVideoService.updateComplianceRecord(dto.getComplianceRecord(), declaration);
		headlerCompliance(dto.getBaseInfo(), declaration, DeclarationCompliancesTypeEnum.BASE_INFO.getType());
		headlerCompliance(dto.getRiskNotify(), declaration, DeclarationCompliancesTypeEnum.RISK_NOTIFY.getType());
		headlerCompliance(dto.getRiskQuesstionnaire(), declaration,
				DeclarationCompliancesTypeEnum.RISK_QUESSTIONNAIRE.getType());
		headlerCompliance(dto.getReturnConfirmation(), declaration,
				DeclarationCompliancesTypeEnum.RETURN_CONFIRMATION.getType());
		headlerCompliance(dto.getOtherFile(), declaration, DeclarationCompliancesTypeEnum.OTHER_FILE.getType());
		return Result.newSuccessResult(declaration.getId());
	}

	@Override
	public Result<Long> updateBank(DeclarationUpdateBankDto dto) throws BaseException {
		validataBank(dto);
		// 获取对应的报单
		BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(dto.getId());
		validataUpdateDeclaration(declaration);
		if (declaration.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
			Map<String, String> params = new HashMap<>();
			params.put("name", "银行卡信息");
			throw new BaseException(GJLCodeConstant.CODE_1210076, params);
		}
		headlerBank(dto, declaration);
		return Result.newSuccessResult(dto.getBankId());
	}

	@Override
	public Result<Long> updateSubscribe(DeclarationUpdateSubscribeDto dto) throws BaseException {
		validataSubscribe(dto);
		// 获取对应的报单
		BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(dto.getId());
		validataUpdateDeclaration(declaration);
		// 只有驳回才能修改认购金额和打款日期和备注
		if (declaration.getAuditStatus().equals(DeclarationStatusEnum.REJECT.getValue())) {
			declaration.setDealAmount(dto.getDealAmount());
			declaration.setPayDate(dto.getPayDate());
			declaration.setRemark(dto.getRemark());
			declaration.setUpdateDate(new Date());
			declaration.setUpdateUserId(super.getHeaderUserId());
			baseDeclarationMapper.updateByPrimaryKey(declaration);
		}
		// 打款凭证不通过才能修改
		if (!declaration.getAuditStatus().equals(DeclarationStatusEnum.PASS.getValue())) {
			headlerAttach(dto.getVoucher(), declaration, DeclarationAttachTypeEnum.VOUCHER.getType());
		}
		headlerAttach(dto.getContractFile(), declaration, DeclarationAttachTypeEnum.CONTRACT_FILE.getType());
		return Result.newSuccessResult(dto.getId());
	}

	private void validataSubscribe(DeclarationUpdateSubscribeDto dto) {
	}

	/**
	 * 银行卡
	 *
	 * @param dto
	 */
	private void headlerBank(DeclarationUpdateBankDto dto, BaseDeclaration declaration) throws BaseException {
		// 获取当前关联的银行信息
		BaseDeclarationBankRelExample bankRelExample = new BaseDeclarationBankRelExample();
		bankRelExample.createCriteria().andDeclarationIdEqualTo(dto.getId());
		List<BaseDeclarationBankRel> declarationBankRels = baseDeclarationBankRelMapper.selectByExample(bankRelExample);
		if (declarationBankRels == null || declarationBankRels.isEmpty()) {
			addDeclarationBank(dto, declaration);
		} else {
			updateDeclarationBank(dto, declarationBankRels);
		}

		// 判断是否有操作用户权限
		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(declaration.getCustomerId());
		Boolean isAuth = dataObjectPermissionService.check(DataObjectEnum.CUSTOMER.getCode(),
				OperationPermissionEnum.EDIT.getValue(), customer.getCreateUserId());
		if (isAuth) {
			// 判断客户是否已经有银行卡
			BaseCustomerBankRelExample customerBankRelExample = new BaseCustomerBankRelExample();
			customerBankRelExample.createCriteria().andCustomerIdEqualTo(declaration.getCustomerId());
			List<BaseCustomerBankRel> customerBankRels = baseCustomerBankRelMapper
					.selectByExample(customerBankRelExample);
			if (customerBankRels == null || customerBankRels.isEmpty()) {
				backToCustomerBank(dto, declaration);
			}
		}
	}

	/**
	 * 反补到客户银行卡并建立关联关系
	 *
	 * @param dto
	 */
	private void backToCustomerBank(DeclarationUpdateBankDto dto, BaseDeclaration declaration) {
		BaseCustomerBank customerBank = new BaseCustomerBank();
		customerBank.setBack(dto.getBack());
		customerBank.setAccount(dto.getAccount());
		customerBank.setBankName(dto.getBankName());
		customerBank.setFront(dto.getFront());
		customerBank.setBack(dto.getBack());
		customerBank.setCreateDate(new Date());
		customerBank.setCreateUserId(super.getHeaderUserId());
		customerBank.setTenantId(super.getHeaderTenantId());
		baseCustomerBankMapper.insertSelective(customerBank);
		BaseCustomerBankRel customerBankRel = new BaseCustomerBankRel();
		customerBankRel.setBankId(customerBank.getId());
		customerBankRel.setCustomerId(declaration.getCustomerId());
		customerBankRel.setCreateUserId(super.getHeaderUserId());
		customerBankRel.setCreateDate(new Date());
		customerBankRel.setTenantId(super.getHeaderTenantId());
		baseCustomerBankRelMapper.insertSelective(customerBankRel);
	}

	/**
	 * k 更新报单银行卡信息
	 *
	 * @param dto
	 * @iparam declaration
	 */
	private void updateDeclarationBank(DeclarationUpdateBankDto dto, List<BaseDeclarationBankRel> declarationBankRels) {
		BaseDeclarationBankRel declarationBankRel = declarationBankRels.get(0);
		BaseCustomerBank customerBank = baseCustomerBankMapper.selectByPrimaryKey(declarationBankRel.getBankId());
		customerBank.setBack(dto.getBack());
		customerBank.setAccount(dto.getAccount());
		customerBank.setBankName(dto.getBankName());
		customerBank.setFront(dto.getFront());
		customerBank.setBack(dto.getBack());
		customerBank.setUpdateUserId(super.getHeaderUserId());
		customerBank.setUpdateDate(new Date());
		baseCustomerBankMapper.updateByPrimaryKey(customerBank);

		dto.setBankId(customerBank.getId());
	}

	/**
	 * 新增报单银行卡信息
	 *
	 * @param dto
	 * @param declaration
	 */
	private void addDeclarationBank(DeclarationUpdateBankDto dto, BaseDeclaration declaration) {
		BaseCustomerBank customerBank = new BaseCustomerBank();
		customerBank.setBack(dto.getBack());
		customerBank.setAccount(dto.getAccount());
		customerBank.setBankName(dto.getBankName());
		customerBank.setFront(dto.getFront());
		customerBank.setBack(dto.getBack());
		customerBank.setCreateDate(new Date());
		customerBank.setCreateUserId(super.getHeaderUserId());
		customerBank.setTenantId(super.getHeaderTenantId());
		baseCustomerBankMapper.insertSelective(customerBank);
		BaseDeclarationBankRel declarationBankRel = new BaseDeclarationBankRel();
		declarationBankRel.setDeclarationId(declaration.getId());
		declarationBankRel.setBankId(customerBank.getId());
		declarationBankRel.setCreateUserId(super.getHeaderUserId());
		declarationBankRel.setCreateDate(new Date());
		declarationBankRel.setTenantId(super.getHeaderTenantId());
		baseDeclarationBankRelMapper.insertSelective(declarationBankRel);

		dto.setBankId(customerBank.getId());
	}

	/**
	 * 验证参数
	 *
	 * @param dto
	 */
	private void validataBank(DeclarationUpdateBankDto dto) throws BaseException {
		if (dto.getId() == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}
		if (BooleanUtils.isBlank(dto.getFront()) && BooleanUtils.isBlank(dto.getBack()))
			throw new BaseException(CodeConstant.CODE_1220110);
	}

	/**
	 * 验证合规双件的文件
	 *
	 * @param dto
	 */
	private void validataCompliance(DeclarationUpdateComplianceDto dto) throws BaseException {
		if (dto.getId() == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}
		// if (BooleanUtils.isNotEmpty(dto.getComplianceRecord())) {
		// List<DeclarationVideoDto> complianceList =
		// JsonUtils.jsonToObject(dto.getComplianceRecord(),
		// new BaseTypeReference<List<DeclarationVideoDto>>() {
		// });
		// if (complianceList.size() > 1) {
		// throw new BaseException(GJLCodeConstant.CODE_1210069);
		// }
		// }
		if (BooleanUtils.isNotEmpty(dto.getBaseInfo())) {
			List<BaseDeclarationCompliance> complianceList = JsonUtils.jsonToObject(dto.getBaseInfo(),
					new BaseTypeReference<List<BaseDeclarationCompliance>>() {
					});
			if (BooleanUtils.isNotEmpty(complianceList) && complianceList.size() > 1) {
				throw new BaseException(GJLCodeConstant.CODE_1210070);
			}
		}
		if (BooleanUtils.isNotEmpty(dto.getRiskNotify())) {
			List<BaseDeclarationCompliance> complianceList = JsonUtils.jsonToObject(dto.getRiskNotify(),
					new BaseTypeReference<List<BaseDeclarationCompliance>>() {
					});
			if (BooleanUtils.isNotEmpty(complianceList) && complianceList.size() > 1) {
				throw new BaseException(GJLCodeConstant.CODE_1210071);
			}
		}
		if (BooleanUtils.isNotEmpty(dto.getRiskQuesstionnaire())) {
			List<BaseDeclarationCompliance> complianceList = JsonUtils.jsonToObject(dto.getRiskQuesstionnaire(),
					new BaseTypeReference<List<BaseDeclarationCompliance>>() {
					});
			if (BooleanUtils.isNotEmpty(complianceList) && complianceList.size() > 4) {
				throw new BaseException(GJLCodeConstant.CODE_1210072);
			}
		}
		if (BooleanUtils.isNotEmpty(dto.getReturnConfirmation())) {
			List<BaseDeclarationCompliance> complianceList = JsonUtils.jsonToObject(dto.getReturnConfirmation(),
					new BaseTypeReference<List<BaseDeclarationCompliance>>() {
					});
			if (BooleanUtils.isNotEmpty(complianceList) && complianceList.size() > 1) {
				throw new BaseException(GJLCodeConstant.CODE_1210073);
			}
		}
		if (BooleanUtils.isNotEmpty(dto.getOtherFile())) {
			List<BaseDeclarationCompliance> complianceList = JsonUtils.jsonToObject(dto.getOtherFile(),
					new BaseTypeReference<List<BaseDeclarationCompliance>>() {
					});
			if (BooleanUtils.isNotEmpty(complianceList) && complianceList.size() > 8) {
				throw new BaseException(GJLCodeConstant.CODE_1210074);
			}
		}
	}

	/**
	 * 回补客户资产证明
	 *
	 * @param declarationAttachs
	 * @param declaration
	 */
	private void backToCustomerAttach(String declarationAttachs, BaseDeclaration declaration) throws BaseException {
		if (BooleanUtils.isEmpty(declarationAttachs)) {
			return;
		}

		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(declaration.getCustomerId());
		Boolean isAuth = dataObjectPermissionService.check(DataObjectEnum.CUSTOMER.getCode(),
				OperationPermissionEnum.EDIT.getValue(), customer.getCreateUserId());
		if (!isAuth) {
			return;
		}
		// 获取客户现有的数据，如果没有就新增
		BaseCustomerAttachExample customerAttachExample = new BaseCustomerAttachExample();
		customerAttachExample.createCriteria().andCustomerIdEqualTo(customer.getId())
				.andTypeEqualTo(CustomerAttachTypeEnum.ASSET.getType());
		List<BaseCustomerAttach> attaches = baseCustomerAttachMapper.selectByExample(customerAttachExample);
		if (attaches == null || attaches.isEmpty()) {
			List<FileDto> attachList = JsonUtils.jsonToObject(declarationAttachs,
					new BaseTypeReference<List<FileDto>>() {
					});
			BaseCustomerAttach customerAttach = new BaseCustomerAttach();
			for (int i = 0; i < attachList.size(); i++) {
				FileDto fileDto = attachList.get(i);
				customerAttach.setId(null);
				customerAttach.setSeqencing(i + 1);
				customerAttach.setUrl(fileDto.getFileUrl());
				customerAttach.setName(fileDto.getFileName());
				customerAttach.setCustomerId(declaration.getCustomerId());
				customerAttach.setType(CustomerAttachTypeEnum.ASSET.getType());
				customerAttach.setTypeName(CustomerAttachTypeEnum.ASSET.getName());
				customerAttach.setCreateUserId(super.getHeaderUserId());
				customerAttach.setCreateDate(new Date());
				customerAttach.setTenantId(super.getHeaderTenantId());
				baseCustomerAttachMapper.insertSelective(customerAttach);
			}
		}
	}

	/**
	 * 处理合规双件
	 *
	 * @param compliance
	 * @param declaration
	 * @param type
	 */
	private void headlerCompliance(String compliance, BaseDeclaration declaration, Integer type) {
		BaseDeclarationComplianceExample complianceExample = new BaseDeclarationComplianceExample();
		complianceExample.createCriteria().andDeclarationIdEqualTo(declaration.getId()).andTypeEqualTo(type);
		baseDeclarationComplianceMapper.deleteByExample(complianceExample);
		if (BooleanUtils.isNotEmpty(compliance)) {
			List<BaseDeclarationCompliance> complianceList = JsonUtils.jsonToObject(compliance,
					new BaseTypeReference<List<BaseDeclarationCompliance>>() {
					});
			for (int i = 1; i <= complianceList.size(); i++) {
				BaseDeclarationCompliance declarationCompliance = complianceList.get(i - 1);
				declarationCompliance.setSequence(i);
				declarationCompliance.setCreateUserId(super.getHeaderUserId());
				declarationCompliance.setCreateDate(new Date());
				declarationCompliance.setDeclarationId(declaration.getId());
				declarationCompliance.setType(type);
				baseDeclarationComplianceMapper.insertSelective(declarationCompliance);
			}
		}
	}

	/**
	 * 处理资产证明
	 *
	 * @param attachs
	 * @param declaration
	 */
	private void headlerAttach(String attachs, BaseDeclaration declaration, Integer type) {
		// 清空资产证明
		BaseDeclarationAttachExample attachExample = new BaseDeclarationAttachExample();
		attachExample.createCriteria().andDeclarationIdEqualTo(declaration.getId()).andTypeEqualTo(type);
		baseDeclarationAttachMapper.deleteByExample(attachExample);
		if (BooleanUtils.isNotEmpty(attachs)) {
			List<FileDto> attachList = JsonUtils.jsonToObject(attachs, new BaseTypeReference<List<FileDto>>() {
			});
			BaseDeclarationAttach declarationAttach = new BaseDeclarationAttach();
			// 新增资产证明
			for (int i = 1; i <= attachList.size(); i++) {
				FileDto fileDto = attachList.get(i - 1);
				declarationAttach.setId(null);
				declarationAttach.setType(type);
				declarationAttach.setDeclarationId(declaration.getId());
				declarationAttach.setName(fileDto.getFileName());
				declarationAttach.setUrl(fileDto.getFileUrl());
				declarationAttach.setSequence(i);
				declarationAttach.setTenantId(super.getHeaderTenantId());
				declarationAttach.setCreateDate(new Date());
				declarationAttach.setCreateUserId(super.getHeaderUserId());
				baseDeclarationAttachMapper.insertSelective(declarationAttach);
			}
		}
	}

	/**
	 * 处理身份信息
	 *
	 * @param dto
	 * @param declaration
	 * @throws BaseException
	 */
	private void headleCredentials(DeclarationUpdateCredentialsDto dto, BaseDeclaration declaration)
			throws BaseException {
		BaseDeclarationCredentialsRelExample credentialsRelExample = new BaseDeclarationCredentialsRelExample();
		credentialsRelExample.createCriteria().andDeclarationIdEqualTo(declaration.getId());
		List<BaseDeclarationCredentialsRel> credentialsRels = baseDeclarationCredentialsRelMapper
				.selectByExample(credentialsRelExample);
		BaseCustomerCredentials customerCredentials = null;
		if (credentialsRels == null || credentialsRels.isEmpty()) {
			// 新增身份信息
			customerCredentials = addDeclarationCredentials(dto);
		} else {
			// 修改现有的身份信息
			customerCredentials = updateDeclarationCredentials(dto, credentialsRels);
		}

		// 是否有修改用户的权限
		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(declaration.getCustomerId());
		Boolean isAuth = dataObjectPermissionService.check(DataObjectEnum.CUSTOMER.getCode(),
				OperationPermissionEnum.EDIT.getValue(), customer.getCreateUserId());
		if (isAuth) {
			// 是否需要回补客户
			BaseCustomerCredentialsRelExample relExample = new BaseCustomerCredentialsRelExample();
			relExample.createCriteria().andCustomerIdEqualTo(declaration.getCustomerId());
			List<BaseCustomerCredentialsRel> customerRels = baseCustomerCredentialsRelMapper
					.selectByExample(relExample);
			if (customerRels == null || customerRels.isEmpty()) {
				// 回补客户
				backToCustomer(declaration, customerCredentials);
			}
		}
	}

	private void backToCustomer(BaseDeclaration declaration, BaseCustomerCredentials customerCredentials) {
		customerCredentials.setId(null);
		baseCustomerCredentialsMapper.insertSelective(customerCredentials);
		BaseCustomerCredentialsRel customerCredentialsRel = new BaseCustomerCredentialsRel();
		customerCredentialsRel.setCredentialsId(customerCredentials.getId());
		customerCredentialsRel.setCustomerId(declaration.getCustomerId());
		customerCredentialsRel.setCreateDate(new Date());
		customerCredentialsRel.setCreateUserId(super.getHeaderUserId());
		customerCredentialsRel.setTenantId(super.getHeaderTenantId());
		baseCustomerCredentialsRelMapper.insertSelective(customerCredentialsRel);
	}

	private BaseCustomerCredentials updateDeclarationCredentials(DeclarationUpdateCredentialsDto dto,
			List<BaseDeclarationCredentialsRel> credentialsRels) {
		BaseCustomerCredentials customerCredentials;
		BaseDeclarationCredentialsRel customerCredentialsRel = credentialsRels.get(0);
		customerCredentials = baseCustomerCredentialsMapper
				.selectByPrimaryKey(customerCredentialsRel.getCredentialsId());
		customerCredentials.setType(dto.getType());
		customerCredentials.setBack(dto.getBack());
		customerCredentials.setFront(dto.getFront());
		customerCredentials.setNumber(dto.getNumber());
		customerCredentials.setUpdateDate(new Date());
		customerCredentials.setUpdateUserId(super.getHeaderUserId());
		baseCustomerCredentialsMapper.updateByPrimaryKey(customerCredentials);
		return customerCredentials;
	}

	private BaseCustomerCredentials addDeclarationCredentials(DeclarationUpdateCredentialsDto dto) {
		BaseCustomerCredentials customerCredentials;
		customerCredentials = new BaseCustomerCredentials();
		BeanUtils.copyProperties(dto, customerCredentials);
		customerCredentials.setCreateUserId(super.getHeaderUserId());
		customerCredentials.setCreateDate(new Date());
		customerCredentials.setId(null);
		baseCustomerCredentialsMapper.insertSelective(customerCredentials);
		// 关联关系
		BaseDeclarationCredentialsRel credentialsRel = new BaseDeclarationCredentialsRel();
		credentialsRel.setCredentialsId(customerCredentials.getId());
		credentialsRel.setDeclarationId(dto.getId());
		credentialsRel.setCreateUserId(super.getHeaderUserId());
		credentialsRel.setCreateDate(new Date());
		credentialsRel.setTenantId(super.getHeaderTenantId());
		baseDeclarationCredentialsRelMapper.insertSelective(credentialsRel);
		return customerCredentials;
	}

	private void validataCredentialsDto(DeclarationUpdateCredentialsDto dto) throws BaseException {
		if (dto.getId() == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}
		String attachs = dto.getDeclarationAttachs();
		if (BooleanUtils.isNotEmpty(attachs)) {
			List<FileDto> attachList = JsonUtils.jsonToObject(attachs, new BaseTypeReference<List<FileDto>>() {
			});
			if (attachList.size() > ATTACHS_COUNT) {
				throw new BaseException(GJLCodeConstant.CODE_1210067);
			}
		}
	}

	public Result<PaginationSupport<BaseDeclaration>> getPageOld(DeclarationReqDto declarationReqDto,
			AbstractBasePageDto pageDto) throws Exception {
		BaseDeclarationExample baseDeclarationExample = new BaseDeclarationExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseDeclarationExample.Criteria criteria = baseDeclarationExample.createCriteria();
		String orderByClause = "create_date desc";
		if (StringUtils.isNotBlank(pageDto.getOrderColumn())) {
			StringBuilder orderBuider = new StringBuilder();
			orderBuider.append(pageDto.getOrderColumn()).append(" ");
			if (StringUtils.isNotBlank(pageDto.getSort())) {
				orderBuider.append(pageDto.getSort());
			} else {
				orderBuider.append("desc");
			}
			orderByClause = orderBuider.toString();
		}
		baseDeclarationExample.setOrderByClause(orderByClause);
		List<BaseDeclaration> list = baseDeclarationMapper.selectByExample(baseDeclarationExample);
		int totalCount = baseDeclarationMapper.countByExample(baseDeclarationExample);
		PaginationSupport<BaseDeclaration> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	private Result<Long> doApply(DeclarationApplyrReqDto dto) throws BaseException {
		String logPrefix = "我的报单||提交申请操作||";
		log.info(logPrefix + "参数 %s", JsonUtils.objectToJson(dto));
		BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(dto.getId());
		log.info(logPrefix + "报单数据 %s", JsonUtils.objectToJson(declaration));
		if (declaration == null)
			throw new BaseException(CodeConstant.CODE_1220062);

		if (DeclarationStatusEnum.PASS.getValue().equals(declaration.getAuditStatus())
				|| DeclarationStatusEnum.CANCEL.getValue().equals(declaration.getAuditStatus())) {
			log.info(logPrefix + "状态值有误，不能提交申请");
			throw new BaseException(CodeConstant.CODE_1220063);
		}

		// 校验报单相关资料
		validateSubmit(declaration);

		Boolean isCancel = WorkflowActionEnum.CANCEL.getValue().equals(dto.getAction());
		String taskId = workflowServie.getTODOTaskId(dto.getId(), BusinessTypeCode.DECLARATION, isCancel).getResult();
		// 调用工作流
		workflowServie.complete(taskId, dto.getAction(), dto.getReason());

		if (WorkflowActionEnum.CANCEL.getValue().equals(dto.getAction())) {
			// 取消
			declaration.setAuditStatus(DeclarationStatusEnum.CANCEL.getValue());
			declaration.setStatus(DeclarationStatusEnum.CANCEL.getValue());
			if (BooleanUtils.isEmpty(dto.getReason()))
				throw new BaseException(CodeConstant.CODE_1220058);
			declaration.setReason(dto.getReason());
		} else if (WorkflowActionEnum.RESUBMIT.getValue().equals(dto.getAction())) {
			// 重新提交
			declaration.setAuditStatus(DeclarationStatusEnum.APPROVALING.getValue());
			declaration.setStatus(DeclarationStatusEnum.APPROVALING.getValue());
			declaration.setCommitDate(new Date());
			declaration.setOperationDate(null);
			BaseProduct product = baseProductMapper.selectByPrimaryKey(declaration.getProductId());
			if (product == null)
				throw new BaseException(CodeConstant.CODE_1200042);
			// 上报消息动态
			this.doSendMsgForNewDeclaration(declaration.getDealAmount(), declaration.getPayDate(), product.getName(),
					MsgMessageCodeEnum.DECLARATION_AGAIN_AUDIT_TODO.getCode());
		} else {
			// 其他状态，不允许提交申请
			log.info(logPrefix + "状态值有误，不能提交申请");
			throw new BaseException(CodeConstant.CODE_1220063);
		}
		declaration.setReason(dto.getReason());
		super.updateModel(declaration);
		baseDeclarationMapper.updateByPrimaryKey(declaration);
		log.info(logPrefix + "完成");
		return Result.newSuccessResult(declaration.getId());
	}

	public void setData(DeclarationResDto data) throws BaseException {

		// 预约信息
		if (data.getReservationId() != null) {
			BaseReservation reservation = baseReservationMapper.selectByPrimaryKey(data.getReservationId());
			data.setReservation(reservation);
		}
		// 客户资产证明
		if (data.getCustomerId() != null) {
			List<CustomerAttachDto> attachDtos = customerAttachService.selectByCustomerIdAndType(data.getCustomerId(),
					CustomerAttachTypeEnum.ASSET.getType());
			data.setCustomerAttachDtos(attachDtos);

		}
		// 身份证
		BaseDeclarationCredentialsRelExample declarationCredentialsRelExample = new BaseDeclarationCredentialsRelExample();
		declarationCredentialsRelExample.createCriteria().andDeclarationIdEqualTo(data.getId());
		List<BaseDeclarationCredentialsRel> credentialsRels = baseDeclarationCredentialsRelMapper
				.selectByExample(declarationCredentialsRelExample);
		if (credentialsRels != null && !credentialsRels.isEmpty()) {
			BaseCustomerCredentials baseCustomerCredentials = baseCustomerCredentialsMapper
					.selectByPrimaryKey(credentialsRels.get(0).getCredentialsId());
			CustomerCredentialsDto customerCredentialsDto = new CustomerCredentialsDto();
			BeanUtils.copyProperties(baseCustomerCredentials, customerCredentialsDto);
			if (baseCustomerCredentials.getType() != null) {
				customerCredentialsDto
						.setTypeText(CustomerCredentialsEnum.getEnumName(baseCustomerCredentials.getType().intValue()));
			}
			data.setCustomerCredentials(customerCredentialsDto);
		}

		// 银行卡
		BaseDeclarationBankRelExample bankRelExample = new BaseDeclarationBankRelExample();
		bankRelExample.createCriteria().andDeclarationIdEqualTo(data.getId());
		List<BaseDeclarationBankRel> bankRels = baseDeclarationBankRelMapper.selectByExample(bankRelExample);
		if (bankRels != null && !bankRels.isEmpty()) {
			data.setCustomerBank(baseCustomerBankMapper.selectByPrimaryKey(bankRels.get(0).getBankId()));
		}

		// 合规文k件
		BaseDeclarationComplianceExample complianceExample = new BaseDeclarationComplianceExample();
		complianceExample.createCriteria().andDeclarationIdEqualTo(data.getId());
		List<BaseDeclarationCompliance> compliances = baseDeclarationComplianceMapper
				.selectByExample(complianceExample);
		setCompliances(compliances, data);

		// 附件
		BaseDeclarationAttachExample attachExample = new BaseDeclarationAttachExample();
		attachExample.createCriteria().andDeclarationIdEqualTo(data.getId());
		List<BaseDeclarationAttach> declarationAttaches = baseDeclarationAttachMapper.selectByExample(attachExample);
		setAttach(declarationAttaches, data);
		setAttach(declarationAttaches, data);

		// 状态
		data.setStatusText(dictionaryService.toText(DicCode.DIC_DECLARATION_STATUS, data.getStatus() + ""));

		// 设置合规文件配置
		data.setComplianceFile(ConfigUtils.getValue(COMPLIANCE_FILE));
	}

	private void setAttach(List<BaseDeclarationAttach> declarationAttaches, DeclarationResDto data) {
		if (declarationAttaches != null && !declarationAttaches.isEmpty()) {
			List<FileDto> declarationAttachs = new ArrayList<>();
			List<FileDto> voucher = new ArrayList<>();
			List<FileDto> contractFile = new ArrayList<>();
			for (BaseDeclarationAttach attach : declarationAttaches) {
				if (attach.getType().equals(DeclarationAttachTypeEnum.CONTRACT_FILE.getType())) {
					contractFile.add(new FileDto(attach.getUrl(), attach.getName()));
				} else if (attach.getType().equals(DeclarationAttachTypeEnum.VOUCHER.getType())) {
					voucher.add(new FileDto(attach.getUrl(), attach.getName()));
				} else if (attach.getType().equals(DeclarationAttachTypeEnum.DECLARATION_ATTACHS.getType())) {
					declarationAttachs.add(new FileDto(attach.getUrl(), attach.getName()));
				}
			}
			data.setDeclarationAttachs(declarationAttachs);
			data.setVoucher(voucher);
			data.setContractFile(contractFile);
		}
	}

	private void setCompliances(List<BaseDeclarationCompliance> compliances, DeclarationResDto data)
			throws BaseException {
		if (compliances != null && !compliances.isEmpty()) {
			List<BaseDeclarationCompliance> baseInfo = new ArrayList<>();
			List<BaseDeclarationCompliance> riskNotify = new ArrayList<>();
			List<BaseDeclarationCompliance> riskQuesstionnaire = new ArrayList<>();
			List<BaseDeclarationCompliance> returnConfirmation = new ArrayList<>();
			List<BaseDeclarationCompliance> otherFile = new ArrayList<>();

			for (BaseDeclarationCompliance compliance : compliances) {
				if (compliance.getType().equals(DeclarationCompliancesTypeEnum.BASE_INFO.getType())) {
					baseInfo.add(compliance);
				} else if (compliance.getType().equals(DeclarationCompliancesTypeEnum.RISK_NOTIFY.getType())) {
					riskNotify.add(compliance);
				} else if (compliance.getType().equals(DeclarationCompliancesTypeEnum.RISK_QUESSTIONNAIRE.getType())) {
					riskQuesstionnaire.add(compliance);
				} else if (compliance.getType().equals(DeclarationCompliancesTypeEnum.RETURN_CONFIRMATION.getType())) {
					returnConfirmation.add(compliance);
				} else if (compliance.getType().equals(DeclarationCompliancesTypeEnum.OTHER_FILE.getType())) {
					otherFile.add(compliance);
				}
			}
			data.setBaseInfo(baseInfo);
			data.setRiskNotify(riskNotify);
			data.setRiskQuesstionnaire(riskQuesstionnaire);
			data.setReturnConfirmation(returnConfirmation);
			data.setOtherFile(otherFile);
		}
		// 设置合规双录
		List<Long> videoIds = declarationVideoService.getComplianceRecordVideoId(data.getId());
		data.setComplianceRecord(videoService.getVideoList(videoIds));
	}

	/**
	 * 获取成单理财师信息 getDeclarationUserDto:
	 * 
	 * @author: 欧阳利
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<List<DeclarationUserDto>> getDeclarationUserDtos(DeclarationUserReqDto reqDto) throws BaseException {
		if (reqDto.getFilterType() != 1) {
			reqDto.setCustomStart(ReportDateUtils.getStartDay(new Date(), reqDto.getFilterType(), false));
			reqDto.setCustomEnd(ReportDateUtils.getLastDay(new Date(), reqDto.getFilterType(), false));
		}
		return Result.newSuccessResult(declarationMapper.selectDeclarationUserDots(reqDto));
	}
}