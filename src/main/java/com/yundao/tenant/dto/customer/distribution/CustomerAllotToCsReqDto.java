package com.yundao.tenant.dto.customer.distribution;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.CustomerMultiIdReqDto;

import io.swagger.annotations.ApiModelProperty;

public class CustomerAllotToCsReqDto extends CustomerMultiIdReqDto{
    @ApiModelProperty(value = "客服id")
    @NotNull(message = "{" + CodeConstant.CODE_1200099 + "}")
    private Long csId;
    
    @ApiModelProperty(value = "回访事由")
    @Length(min = 1, max = 100, message = "{" + CodeConstant.CODE_1200100 + "}")
    private String matter;



	public Long getCsId() {
		return csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}


}
