package com.yundao.tenant.dto.field;

import java.util.List;

import com.yundao.core.utils.BooleanUtils;

import io.swagger.annotations.ApiModelProperty;

public class FiledSelectDto {
	@ApiModelProperty("字段显示名称")
    private String lable;
	@ApiModelProperty("字段名称")
    private String name;
	@ApiModelProperty("选项值")
    private List<SelectConfigStringValueDto> fieldConfigDtos;
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SelectConfigStringValueDto> getFieldConfigDtos() {
		return fieldConfigDtos;
	}
	public void setFieldConfigDtos(List<SelectConfigStringValueDto> fieldConfigDtos) {
		this.fieldConfigDtos = fieldConfigDtos;
	}

	public  String getSelectLableName(String selectValue){
		if(BooleanUtils.isEmpty(fieldConfigDtos) || BooleanUtils.isBlank(selectValue)){
			return null;
		}
		for(SelectConfigStringValueDto dto:fieldConfigDtos ){
			if(selectValue.equals(dto.getValue())){
				return dto.getLable();
			}
		}
		return null;
	}
	
	
	/**
	 * 获取下拉列表的值
	 * @param dtos
	 * @param name
	 * @param selectValue
	 * @return
	 */
	public static String  getSelectLableName(List<FiledSelectDto> dtos,String name,String selectValue){
		if(BooleanUtils.isEmpty(dtos) || BooleanUtils.isBlank(name) || BooleanUtils.isBlank(selectValue)){
			return null;
		}
		FiledSelectDto currentDto = null;
		for(FiledSelectDto dto:dtos){
			if(name.equals(dto.getName())){
				currentDto = dto;
			}
		}
		if(currentDto == null){
			return null;
		}
		
		return currentDto.getSelectLableName(selectValue);
	}
}
