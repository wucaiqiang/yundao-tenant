package com.yundao.tenant.dto.field;

import io.swagger.annotations.ApiModelProperty;

public class NumberConfigDto {
	
	@ApiModelProperty(value = "单位")
    private String unit;
	
	@ApiModelProperty(value = "小数点位数")
	private Integer decimalLength;
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getDecimalLength() {
		return decimalLength;
	}

	public void setDecimalLength(Integer decimalLength) {
		this.decimalLength = decimalLength;
	}

}
