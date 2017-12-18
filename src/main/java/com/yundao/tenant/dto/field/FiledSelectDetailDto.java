package com.yundao.tenant.dto.field;

import io.swagger.annotations.ApiModelProperty;

public class FiledSelectDetailDto {
	@ApiModelProperty("字段显示名称")
    private String fieldLable;
	@ApiModelProperty("字段名称")
    private String fieldName;
	
	@ApiModelProperty("选项值")
	private Integer selectValue;
	@ApiModelProperty("选项显示名称")
	private String selectLable;
	private Integer sequence;
	public String getFieldLable() {
		return fieldLable;
	}
	public void setFieldLable(String fieldLable) {
		this.fieldLable = fieldLable;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Integer getSelectValue() {
		return selectValue;
	}
	public void setSelectValue(Integer selectValue) {
		this.selectValue = selectValue;
	}
	public String getSelectLable() {
		return selectLable;
	}
	public void setSelectLable(String selectLable) {
		this.selectLable = selectLable;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}
