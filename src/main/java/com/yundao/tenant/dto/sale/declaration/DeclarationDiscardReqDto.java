package com.yundao.tenant.dto.sale.declaration;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class DeclarationDiscardReqDto {

    @ApiModelProperty(value = "id")
    @NotNull(message = "{" + CodeConstant.CODE_1200102 + "}")
    private Long id;

    @ApiModelProperty(value = "作废原因")
    @Length(min = 1, max = 100, message = "{" + CodeConstant.CODE_1200110 + "}")
    private String reason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
