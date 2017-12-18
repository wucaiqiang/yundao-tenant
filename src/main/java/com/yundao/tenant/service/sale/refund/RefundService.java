

package com.yundao.tenant.service.sale.refund;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.sale.declaration.DeclarationApplyRefundReqDto;
import com.yundao.tenant.dto.sale.refund.MyRefundListReqDto;
import com.yundao.tenant.dto.sale.refund.MyRefundListResDto;
import com.yundao.tenant.dto.sale.refund.RefundCancelReqDto;
import com.yundao.tenant.dto.sale.refund.RefundDeclarationCancelDto;
import com.yundao.tenant.dto.sale.refund.RefundResubmitReqDto;
import com.yundao.tenant.dto.workflow.task.RefundTaskDto;
import com.yundao.tenant.model.base.sale.BaseDeclarationRefund;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月16日 下午2:02:08 
 * @author   欧阳利
 * @version   
 */
public interface RefundService {
	
	/**
	 * 分页获取的退款列表
	 * getMyRefundPage:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<MyRefundListResDto>> getMyRefundPage(@ModelAttribute MyRefundListReqDto dto) throws BaseException;
	public Result<List<BaseDeclarationRefund>> getByDeclarationId(Long declarationId) throws BaseException;
	
	
	/**
	 * 申请退款
	 * applyRefund:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<Long> doApplyRefund(DeclarationApplyRefundReqDto dto) throws BaseException;
	
	
	/**
	 * 重新提交
	 * resubmit:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<Long> doResubmit(RefundResubmitReqDto dto)throws BaseException;
	public Result<Long> doResubmitByDeclarationId(Long declarationId)throws BaseException;
	
	
	/**
	 * 取消申请
	 * cancel:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<Long> doCancel(RefundCancelReqDto dto)throws BaseException;
	public Result<Long> doCancelByDeclarationId(RefundDeclarationCancelDto dto)throws BaseException;
	
	
	
	 public Result<RefundTaskDto> getTaskDto(Long id)throws BaseException;
	
}

