

package com.yundao.tenant.mapper.sale.refund;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.yundao.tenant.dto.sale.refund.MyRefundListReqDto;
import com.yundao.tenant.dto.sale.refund.MyRefundListResDto;
import com.yundao.tenant.dto.sale.refund.RefundAuditListReqDto;
import com.yundao.tenant.dto.sale.refund.RefundAuditListResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月16日 下午4:20:55 
 * @author   欧阳利
 * @version   
 */
public interface RefundMapper {
	 /**
	  * 分页获取我的退款列表
	  * getMyRefundPage:
	  * @author: 欧阳利
	  * @param dto
	  * @return
	  * @description:
	  */
	 List<MyRefundListResDto> getMyRefundPage(@ModelAttribute MyRefundListReqDto dto) ;
	 
	 /**
	  * 我的退款总记录数
	  * getMyRefundCount:
	  * @author: 欧阳利
	  * @param dto
	  * @return
	  * @description:
	  */
	 int getMyRefundCount(@ModelAttribute MyRefundListReqDto dto) ;
	 
	 
	 /**
	  * 分页查询待审批列表
	  * getRefundAuditPage:
	  * @author: 欧阳利
	  * @param dto
	  * @return
	  * @description:
	  */
	 List<RefundAuditListResDto> getRefundAuditPage(RefundAuditListReqDto dto);
	 
	 
	 
	 /**
	  * 查询待审批列表总记录数
	  * getRefundAuditCount:
	  * @author: 欧阳利
	  * @param dto
	  * @return
	  * @description:
	  */
	 int getRefundAuditCount(RefundAuditListReqDto dto);
}

