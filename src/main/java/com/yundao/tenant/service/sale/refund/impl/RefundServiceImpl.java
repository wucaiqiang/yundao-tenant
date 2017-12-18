
package com.yundao.tenant.service.sale.refund.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.Code1230000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.sale.declaration.DeclarationApplyRefundReqDto;
import com.yundao.tenant.dto.sale.refund.MyRefundListReqDto;
import com.yundao.tenant.dto.sale.refund.MyRefundListResDto;
import com.yundao.tenant.dto.sale.refund.RefundCancelReqDto;
import com.yundao.tenant.dto.sale.refund.RefundDeclarationCancelDto;
import com.yundao.tenant.dto.sale.refund.RefundResubmitReqDto;
import com.yundao.tenant.dto.workflow.task.RefundTaskDto;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.enums.sale.declaration.DeclarationStatusEnum;
import com.yundao.tenant.enums.sale.refund.RefundStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationRefundMapper;
import com.yundao.tenant.mapper.sale.refund.RefundMapper;
import com.yundao.tenant.mapper.workflow.TaskMapper;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationRefund;
import com.yundao.tenant.model.base.sale.BaseDeclarationRefundExample;
import com.yundao.tenant.service.sale.declaration.impl.DeclarationAuditServiceImpl;
import com.yundao.tenant.service.sale.refund.RefundService;
import com.yundao.tenant.service.workflow.WorkflowServie;

/**
 * Function: Reason: Date: 2017年10月16日 下午2:03:43
 * 
 * @author 欧阳利
 * @version
 */
@Service
public class RefundServiceImpl extends AbstractService implements RefundService {

	private static Log log = LogFactory.getLog(DeclarationAuditServiceImpl.class);

	@Autowired
	private BaseDeclarationMapper baseDeclarationMapper;

	@Autowired
	private BaseDeclarationRefundMapper baseDeclarationRefundMapper;

	@Autowired
	private WorkflowServie workflowServie;

	@Autowired
	private RefundMapper refundMapper;

	@Autowired
	TaskMapper taskMapper;

	@Override
	public Result<List<BaseDeclarationRefund>> getByDeclarationId(Long declarationId) throws BaseException {
		BaseDeclarationRefundExample example = new BaseDeclarationRefundExample();
		example.createCriteria().andDeclarationIdEqualTo(declarationId);
		example.setOrderByClause("create_date desc,id desc");
		List<BaseDeclarationRefund> list = baseDeclarationRefundMapper.selectByExample(example);
		return Result.newSuccessResult(list);

	}

	/**
	 * 分页获取的退款列表 getMyRefundPage:
	 * 
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<MyRefundListResDto>> getMyRefundPage(@ModelAttribute MyRefundListReqDto dto)
			throws BaseException {
		log.info("我的退款||获取分页数据||开始 查询参数：%s", JsonUtils.objectToJson(dto));
		PaginationSupport<MyRefundListResDto> page = dto.getPaginationSupport();
		// 重置参数
		resetParam(dto);
		int totalCount = refundMapper.getMyRefundCount(dto);
		if (totalCount > 0) {
			List<MyRefundListResDto> datas = refundMapper.getMyRefundPage(dto);
			page.setDatas(datas);
			for (MyRefundListResDto myRefund : datas) {
				myRefund.setStatusText(DeclarationStatusEnum.getName(myRefund.getStatus()));
			}
		}
		page.setTotalCount(totalCount);
		return Result.newSuccessResult(page);
	}

	private void resetParam(MyRefundListReqDto reqDto) {
		resetParamOrderBy(reqDto);

	}

	private void resetParamOrderBy(MyRefundListReqDto reqDto) {
		if (BooleanUtils.isBlank(reqDto.getOrderColumn())) {
			reqDto.setOrderColumn(" dr.apply_date");
			reqDto.setSort("desc");
			return;
		}

		if (BooleanUtils.isBlank(reqDto.getSort())) {
			reqDto.setSort("asc");
		} else if (reqDto.getSort().trim().equals("asc")) {
			reqDto.setSort("asc");
		} else if (reqDto.getSort().trim().equals("desc")) {
			reqDto.setSort("desc");
		} else {
			reqDto.setSort("asc");
		}

		if (reqDto.getOrderColumn().equals("dealAmount")) {
			reqDto.setOrderColumn("d.deal_amount");
		} else if (reqDto.getOrderColumn().equals("payDate")) {
			reqDto.setOrderColumn("d.pay_date");
		} else if (reqDto.getOrderColumn().equals("declarationDate")) {
			reqDto.setOrderColumn("d.create_date");
		}
	}

	/**
	 * 申请退款 applyRefund:
	 * 
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<Long> doApplyRefund(DeclarationApplyRefundReqDto dto) throws BaseException {
		// 查询报单是否存在
		BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(dto.getId());
		if (declaration == null) {
			return Result.newFailureResult(CodeConstant.CODE_1220062);
		}

		// 该报单已退款
		if (DeclarationStatusEnum.REFUND.getValue().equals(declaration.getStatus())) {
			return Result.newFailureResult(CodeConstant.CODE_1200149);
		}

		// 该报单退款审批中
		List<Integer> status = new ArrayList<Integer>();
		status.add(RefundStatusEnum.APPROVALING.getValue());
		status.add(RefundStatusEnum.REJECT.getValue());
		BaseDeclarationRefundExample example = new BaseDeclarationRefundExample();
		example.createCriteria().andStatusIn(status).andDeclarationIdEqualTo(dto.getId());
		List<BaseDeclarationRefund> list = baseDeclarationRefundMapper.selectByExample(example);
		if (!BooleanUtils.isEmpty(list)) {
			return Result.newFailureResult(CodeConstant.CODE_1200150);
		}

		BaseDeclarationRefund refund = new BaseDeclarationRefund();
		refund.setApplyDate(new Date());
		refund.setReason(dto.getReason());
		refund.setUserId(this.getHeaderUserId());
		refund.setDeclarationId(dto.getId());
		refund.setTenantId(this.getHeaderTenantId());
		refund.setApplyDate(new Date());
		refund.setStatus(DeclarationStatusEnum.APPROVALING.getValue()); // 1、待审批
																		// 2、已通过
																		// 3、已驳回
		refund.setCreateDate(new Date());
		refund.setCreateUserId(this.getHeaderUserId());
		refund.setIsDelete(0);
		baseDeclarationRefundMapper.insert(refund);

		// 启动工作流
		workflowServie.start(refund.getId(), ProcessDefineKeyEnum.REFUND.getKey(), BusinessTypeCode.REFUND);
		return Result.newSuccessResult(refund.getId());
	}

	@Override
	public Result<Long> doResubmitByDeclarationId(Long declarationId) throws BaseException {
		BaseDeclarationRefundExample example = new BaseDeclarationRefundExample();
		example.createCriteria().andDeclarationIdEqualTo(declarationId)
				.andStatusEqualTo(RefundStatusEnum.REJECT.getValue());
		BaseDeclarationRefund refund = baseDeclarationRefundMapper.selectOne(example);
		// 退款数据不存在
		if (refund == null) {
			return Result.newFailureResult(Code1230000.CODE_1230011);
		}

		// 发起人才能重新提交
		if (!refund.getUserId().equals(this.getHeaderUserId())) {
			return Result.newFailureResult(CodeConstant.CODE_1200153);
		}

		String taskId = workflowServie.getTODOTaskId(refund.getId(), BusinessTypeCode.REFUND, false).getResult();

		workflowServie.complete(taskId, WorkflowActionEnum.RESUBMIT.getValue());

		BaseDeclarationRefund record = new BaseDeclarationRefund();
		record.setId(refund.getId());
		record.setStatus(RefundStatusEnum.APPROVALING.getValue());
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		record.setAuditReason("");
		record.setAuditDate(null);
		baseDeclarationRefundMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(1l);

	}

	/**
	 * 重新提交 resubmit:
	 * 
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<Long> doResubmit(RefundResubmitReqDto dto) throws BaseException {
		BaseDeclarationRefund refund = baseDeclarationRefundMapper.selectByPrimaryKey(dto.getId());
		// 退款数据不存在
		if (refund == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200151);
		}

		// 驳回中的退款才能重新提交
		if (!RefundStatusEnum.REJECT.getValue().equals(refund.getStatus())) {
			return Result.newFailureResult(CodeConstant.CODE_1200152);
		}

		// 发起人才能重新提交
		if (!refund.getUserId().equals(this.getHeaderUserId())) {
			return Result.newFailureResult(CodeConstant.CODE_1200153);
		}

		String taskId = workflowServie.getTODOTaskId(dto.getId(), BusinessTypeCode.REFUND, false).getResult();

		workflowServie.complete(taskId, WorkflowActionEnum.RESUBMIT.getValue());

		BaseDeclarationRefund record = new BaseDeclarationRefund();
		record.setId(dto.getId());
		record.setStatus(RefundStatusEnum.APPROVALING.getValue());
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		record.setAuditReason("");
		record.setAuditDate(null);
		baseDeclarationRefundMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(1l);
	}

	@Override
	public Result<Long> doCancelByDeclarationId(RefundDeclarationCancelDto dto) throws BaseException {
		BaseDeclarationRefundExample example = new BaseDeclarationRefundExample();
		example.setOrderByClause("create_date desc,id desc");
		example.createCriteria().andDeclarationIdEqualTo(dto.getDeclarationId());
		BaseDeclarationRefund refund = baseDeclarationRefundMapper.selectOne(example);
		// 退款数据不存在
		if (refund == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200151);
		}

		// 驳回或者审批中的退款才能取消
		if (!(RefundStatusEnum.REJECT.getValue().equals(refund.getStatus())
				|| RefundStatusEnum.APPROVALING.getValue().equals(refund.getStatus()))) {
			return Result.newFailureResult(CodeConstant.CODE_1200155);
		}

		// 发起人才能取消申请
		if (!refund.getUserId().equals(this.getHeaderUserId())) {
			return Result.newFailureResult(CodeConstant.CODE_1200154);
		}

		String taskId = workflowServie.getTODOTaskId(refund.getId(), BusinessTypeCode.REFUND, true).getResult();

		workflowServie.complete(taskId, WorkflowActionEnum.CANCEL.getValue(), dto.getReason());
		BaseDeclarationRefund record = new BaseDeclarationRefund();
		record.setId(refund.getId());
		record.setStatus(RefundStatusEnum.CANCEL.getValue());
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		record.setAuditReason(dto.getReason());
		baseDeclarationRefundMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(1l);
		
	}

	/**
	 * 取消申请 cancel:
	 * 
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 * 
	 */
	public Result<Long> doCancel(RefundCancelReqDto dto) throws BaseException {
		BaseDeclarationRefund refund = baseDeclarationRefundMapper.selectByPrimaryKey(dto.getId());
		// 退款数据不存在
		if (refund == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200151);
		}

		// 驳回或者审批中的退款才能取消
		if (!(RefundStatusEnum.REJECT.getValue().equals(refund.getStatus())
				|| RefundStatusEnum.APPROVALING.getValue().equals(refund.getStatus()))) {
			return Result.newFailureResult(CodeConstant.CODE_1200155);
		}

		// 发起人才能取消申请
		if (!refund.getUserId().equals(this.getHeaderUserId())) {
			return Result.newFailureResult(CodeConstant.CODE_1200154);
		}

		String taskId = workflowServie.getTODOTaskId(dto.getId(), BusinessTypeCode.REFUND, true).getResult();

		workflowServie.complete(taskId, WorkflowActionEnum.CANCEL.getValue(), dto.getReason());
		BaseDeclarationRefund record = new BaseDeclarationRefund();
		record.setId(dto.getId());
		record.setStatus(RefundStatusEnum.CANCEL.getValue());
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		record.setAuditReason(dto.getReason());
		baseDeclarationRefundMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(1l);
	}

	public Result<RefundTaskDto> getTaskDto(Long id) throws BaseException {
		RefundTaskDto dto = taskMapper.getRefundTaskDto(id);
		return Result.newSuccessResult(dto);
	}
}
