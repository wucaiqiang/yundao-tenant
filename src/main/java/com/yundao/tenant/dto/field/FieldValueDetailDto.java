package com.yundao.tenant.dto.field;

import io.swagger.annotations.ApiModelProperty;

/**
 * 字段值详情
 * 
 * @author 欧阳利
 * 2017年7月27日
 */
public class FieldValueDetailDto {
	@ApiModelProperty(value = "字段英文名称")
	private String name;

    @ApiModelProperty(value = "字段显示名称")
    private String lable;

    @ApiModelProperty(value = "字段类型")
    private Integer type;
    
    @ApiModelProperty(value = "字段值")
    private String value;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
    
}
