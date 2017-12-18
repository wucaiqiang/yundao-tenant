package com.yundao.tenant.dto.field;

import io.swagger.annotations.ApiModelProperty;

public class SelectConfigDto {
	@ApiModelProperty(value = "选项值")
	private Integer value;
	@ApiModelProperty(value = "选项显示名称")
	private String label;
	@ApiModelProperty(value = "排序，越小越靠前")
	private Integer sequence;

	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
