

package com.yundao.tenant.service.sale.refund;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.sale.refund.RefundAuditListReqDto;
import com.yundao.tenant.dto.sale.refund.RefundAuditListResDto;
import com.yundao.tenant.dto.sale.refund.RefundAuditReqDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月16日 下午2:02:21 
 * @author   欧阳利
 * @version   
 */
public interface RefundAuditService {

	/**
	 * 审批列表
	 * getRefundAuditPage:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	 public Result<PaginationSupport<RefundAuditListResDto>> getRefundAuditPage(RefundAuditListReqDto dto) throws BaseException;
	 
	 
	 /**
	  * 审批
	  * doAudit:
	  * @author: 欧阳利
	  * @param dto
	  * @return
	  * @throws BaseException
	  * @description:
	  */
	 public Result<Integer> doAudit( RefundAuditReqDto dto) throws BaseException;
}

