package com.yundao.tenant.dto.field;

import io.swagger.annotations.ApiModelProperty;

public class FieldValueValidateFailResultDto {
	@ApiModelProperty("字段名称")
    private String name;
	
	@ApiModelProperty("字段显示名称")
    private String lable;
    
	@ApiModelProperty("错误信息")
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
