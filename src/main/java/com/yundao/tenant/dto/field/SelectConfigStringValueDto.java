package com.yundao.tenant.dto.field;

import io.swagger.annotations.ApiModelProperty;

public class SelectConfigStringValueDto {
	@ApiModelProperty(value = "选项值")
	private String value;
	@ApiModelProperty(value = "选项显示名称")
	private String lable;
	@ApiModelProperty(value = "排序，越小越靠前")
	private Integer sequence;

	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
