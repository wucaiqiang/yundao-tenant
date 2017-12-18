

package com.yundao.tenant.controller.sale.refund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.sale.refund.RefundAuditListReqDto;
import com.yundao.tenant.dto.sale.refund.RefundAuditListResDto;
import com.yundao.tenant.dto.sale.refund.RefundAuditReqDto;
import com.yundao.tenant.service.sale.refund.RefundAuditService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 退款审批
 * Reason:	  
 * Date:     2017年10月16日 下午2:01:02 
 * @author   欧阳利
 * @version   
 */

@RestController
@RequestMapping(value = "/refund/audit")
@ResponseBody
@Api("退款审批")
public class RefundAuditController {
	
	@Autowired
    private RefundAuditService refundAuditService;
	
    @RequestMapping(value = "get_audit_page", method = RequestMethod.GET)
    @ApiOperation(value = "退款列表")
    public Result<PaginationSupport<RefundAuditListResDto>> getRefundAuditPage(@ModelAttribute RefundAuditListReqDto dto) throws Exception {

        return refundAuditService.getRefundAuditPage(dto);
    }
    
    
    @RequestMapping(value = "do", method = RequestMethod.POST)
    @ApiOperation(value = "审批")
    public Result<Integer> doAudit(@ModelAttribute RefundAuditReqDto dto) throws Exception {
        
        return refundAuditService.doAudit(dto);
    }
}

