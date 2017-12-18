

package com.yundao.tenant.dto.sale.refund;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月16日 下午5:36:39 
 * @author   欧阳利
 * @version   
 */
public class RefundAuditReqDto {
    @ApiModelProperty(value = "退款id")
    @NotNull(message = "{" + CodeConstant.CODE_1200148 + "}")
    private Long id;
    
    @ApiModelProperty(value = "动作，1：通过  2：驳回 ")
    @NotNull(message = "{" + CodeConstant.CODE_1220064 + "}")
    private Integer action;

    @ApiModelProperty(value = "驳回/取消原因")
    @Length(max = 50, message = "{" + CodeConstant.CODE_1220060 + "}", isBlank = true)
    private String reason;

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public Integer getAction() {
	
		return action;
	}

	public void setAction(Integer action) {
	
		this.action = action;
	}

	public String getReason() {
	
		return reason;
	}

	public void setReason(String reason) {
	
		this.reason = reason;
	}


    
    
}

