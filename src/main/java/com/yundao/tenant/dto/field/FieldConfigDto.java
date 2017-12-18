package com.yundao.tenant.dto.field;

import io.swagger.annotations.ApiModelProperty;

public class FieldConfigDto {
	/**
	 * 默认值
	 */
	@ApiModelProperty(value = "默认值")
    private String initValue;

	@ApiModelProperty(value = "默认值名称")
    private  String initValueText;
	@ApiModelProperty(value = "最大长度")
    private Integer maxLength;
	@ApiModelProperty(value = "最小长度")
    private Integer minLength;
	@ApiModelProperty(value = "最小值")
	private String minValue;
	@ApiModelProperty(value = "最大值")
	private String maxValue;

	public String getInitValueText() {
		return initValueText;
	}
	public void setInitValueText(String initValueText) {
		this.initValueText = initValueText;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public String getInitValue() {
		return initValue;
	}
	public void setInitValue(String initValue) {
		this.initValue = initValue;
	}
	public Integer getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	public Integer getMinLength() {
		return minLength;
	}
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
	
}
