package com.yundao.tenant.dto.product;

import io.swagger.annotations.ApiModelProperty;

public class ProductActionSelectDto {
	@ApiModelProperty("选项值")
    private Integer value;
	@ApiModelProperty("选项名称")
    private String lable;
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
    
}
