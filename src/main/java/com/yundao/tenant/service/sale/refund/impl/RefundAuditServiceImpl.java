
package com.yundao.tenant.service.sale.refund.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.sale.refund.RefundAuditListReqDto;
import com.yundao.tenant.dto.sale.refund.RefundAuditListResDto;
import com.yundao.tenant.dto.sale.refund.RefundAuditReqDto;
import com.yundao.tenant.enums.sale.declaration.DeclarationStatusEnum;
import com.yundao.tenant.enums.sale.refund.RefundStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationRefundMapper;
import com.yundao.tenant.mapper.sale.refund.RefundMapper;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationRefund;
import com.yundao.tenant.service.sale.refund.RefundAuditService;
import com.yundao.tenant.service.workflow.WorkflowServie;

/**
 * Function: Reason: Date: 2017年10月16日 下午2:03:28
 * 
 * @author 欧阳利
 * @version
 */
@Service
public class RefundAuditServiceImpl extends AbstractService implements RefundAuditService {

	private static Log log = LogFactory.getLog(RefundAuditServiceImpl.class);

	@Autowired
	private WorkflowServie workflowServie;

	@Autowired
	private BaseDeclarationRefundMapper baseDeclarationRefundMapper;

	@Autowired
	private BaseDeclarationMapper baseDeclarationMapper;
	
	@Autowired
	private RefundMapper refundMapper;

	/**
	 * 审批列表 getMyRefundPage:
	 * 
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<RefundAuditListResDto>> getRefundAuditPage(RefundAuditListReqDto dto)
			throws BaseException {
		log.info("我的退款||获取分页数据||开始 查询参数：%s", JsonUtils.objectToJson(dto));
		PaginationSupport<RefundAuditListResDto> page = dto.getPaginationSupport();
		// 重置参数
		resetParam(dto);
		int totalCount = refundMapper.getRefundAuditCount(dto);
		if(totalCount > 0 ){
			List<RefundAuditListResDto> datas = refundMapper.getRefundAuditPage(dto); 
			page.setDatas(datas);
			for(RefundAuditListResDto myRefund : datas){
				myRefund.setStatusText(DeclarationStatusEnum.getName(myRefund.getStatus()));
			}
		}
		page.setTotalCount(totalCount);
		return Result.newSuccessResult(page);
	}
	
	private void resetParam(RefundAuditListReqDto reqDto) {
		resetParamOrderBy(reqDto);

	}
	
	 private void resetParamOrderBy(RefundAuditListReqDto reqDto) {
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
	        } else if (reqDto.getOrderColumn().equals("auditDate")) {
	            reqDto.setOrderColumn("dr.audit_date");
	        }  else if (reqDto.getOrderColumn().equals("applyDate")) {
	            reqDto.setOrderColumn("dr.apply_date");
	        }else{
	        	reqDto.setOrderColumn("dr.apply_date");
	        }
	 }

	/**
	 * 审批 doAudit:
	 * 
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<Integer> doAudit(RefundAuditReqDto dto) throws BaseException {
		log.info("退款审批:%s", JsonUtils.objectToJson(dto));
		if (WorkflowActionEnum.PASS.getValue() != dto.getAction()
				&& dto.getAction() != WorkflowActionEnum.REJECT.getValue()) {
			throw new BaseException(CodeConstant.CODE_1200157);
		}

		BaseDeclarationRefund baseDeclarationRefund = baseDeclarationRefundMapper.selectByPrimaryKey(dto.getId());
		if (baseDeclarationRefund == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200151);
		}

		if (!RefundStatusEnum.APPROVALING.getValue().equals(baseDeclarationRefund.getStatus())) {
			return Result.newFailureResult(CodeConstant.CODE_1200156);
		}
		
		// 设置报单的状态为已退款
		if (WorkflowActionEnum.PASS.getValue().equals(dto.getAction())) {
			BaseDeclaration declarationRecord = new BaseDeclaration();
			declarationRecord.setId(baseDeclarationRefund.getDeclarationId());
			declarationRecord.setStatus(DeclarationStatusEnum.REFUND.getValue());
			declarationRecord.setUpdateDate(new Date());
			declarationRecord.setUpdateUserId(this.getHeaderUserId());
			declarationRecord.setReason(baseDeclarationRefund.getReason());
			baseDeclarationMapper.updateByPrimaryKeySelective(declarationRecord);
		}

		// 修改退款状态
		BaseDeclarationRefund record = new BaseDeclarationRefund();
		record.setId(dto.getId());
		record.setAuditDate(new Date());
		record.setUpdateDate(new Date());
		record.setAuditReason(dto.getReason());
		record.setUpdateUserId(this.getHeaderUserId());
		record.setTenantId(this.getHeaderTenantId());
		if (WorkflowActionEnum.PASS.getValue().equals(dto.getAction())) {
			record.setStatus(RefundStatusEnum.PASS.getValue());
		}else if(WorkflowActionEnum.REJECT.getValue().equals(dto.getAction())){
			record.setStatus(RefundStatusEnum.REJECT.getValue());
		}
		
		baseDeclarationRefundMapper.updateByPrimaryKeySelective(record);

		// 调用工作流
		String taskId = workflowServie.getTODOTaskId(dto.getId(), BusinessTypeCode.REFUND,false).getResult();
		workflowServie.complete(taskId, dto.getAction(), dto.getReason());
		return Result.newSuccessResult(1);
	}
}
