package com.yundao.tenant.dto.customer.back;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class CustomerBackExamineRejectReqDto {
	
	@ApiModelProperty(value = "审核记录id集合)")
	@NotNull(message = "{" + CodeConstant.CODE_1200095 + "}")
	private Long id;
	
    @ApiModelProperty(value = "驳回原因")
    @Length(min = 1, max = 30, message = "{" + CodeConstant.CODE_1200094 + "}")
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
