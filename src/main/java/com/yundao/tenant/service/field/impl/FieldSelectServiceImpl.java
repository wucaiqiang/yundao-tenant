package com.yundao.tenant.service.field.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.field.FieldConfigDto;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FiledSelectDetailDto;
import com.yundao.tenant.dto.field.FiledSelectDto;
import com.yundao.tenant.dto.field.NumberConfigDto;
import com.yundao.tenant.dto.field.SelectConfigDto;
import com.yundao.tenant.dto.field.SelectConfigStringValueDto;
import com.yundao.tenant.enums.bo.FieldTypeEnum;
import com.yundao.tenant.enums.bo.ProductTableFieldEnum;
import com.yundao.tenant.mapper.base.BaseBusinessObjectMapper;
import com.yundao.tenant.mapper.base.BaseFieldConfigMapper;
import com.yundao.tenant.mapper.base.BaseNumberConfigMapper;
import com.yundao.tenant.mapper.base.BaseSelectConfigMapper;
import com.yundao.tenant.mapper.field.FieldSelectMapper;
import com.yundao.tenant.mapper.field.FieldMapper;
import com.yundao.tenant.model.base.BaseFieldConfig;
import com.yundao.tenant.model.base.BaseFieldConfigExample;
import com.yundao.tenant.model.base.BaseNumberConfig;
import com.yundao.tenant.model.base.BaseNumberConfigExample;
import com.yundao.tenant.model.base.BaseSelectConfig;
import com.yundao.tenant.model.base.BaseSelectConfigExample;
import com.yundao.tenant.service.field.FieldSelectService;

@Service
public class FieldSelectServiceImpl implements FieldSelectService {

	@Autowired
	FieldMapper fieldMapper;
	@Autowired
	BaseSelectConfigMapper baseSelectConfigMapper;
	@Autowired
	BaseFieldConfigMapper baseFieldConfigMapper;
	@Autowired
	BaseNumberConfigMapper baseNumberConfigMapper;
	@Autowired
	BaseBusinessObjectMapper baseBusinessObjectMapper;
	@Autowired
	FieldSelectMapper fieldSelectMapper;
	
	
	
    /**
     * 通过产品类型id查询字段信息
     * @param fieldGroupId
     * @return
     */
	@Override
	public List<FieldDto> getProductFieldByTypeId(Long typeId) {
		// 查找字段
		List<FieldDto> list = getFieldByTypeGroupId(typeId);
		if(BooleanUtils.isEmpty(list)){
			return list;
		}
		// 重置属性名称
		ProductTableFieldEnum.resetPropertyName(list);
		return list;
	}


	/**
	 * 通过字段组id查询字段详情
	 * @param fieldGroupId
	 * @return
	 */
	@Override
	public List<FieldDto> getFieldByTypeGroupId(Long fieldGroupId){
		// 查找字段
		List<FieldDto> list = fieldMapper.getFieldByTypeId(fieldGroupId);
		
		if(BooleanUtils.isEmpty(list)){
			return list;
		}
		
		// 设置下拉列表，单选框，复选框的选项信息
		setSelectOptions(list);
		// 设置数字字段的选项信息
		setNumberConfig(list);
		//  设置校验信息
		setFieldConfig(list);
		return list;
	}
	
	
	
	
	/**
	 * 通过字段名称查询下拉选项的值
	 * @param fieldNames
	 * @return
	 */
    public List<FiledSelectDto> getFiledSelectConfigs(List<String> fieldNames){
    	if(BooleanUtils.isEmpty(fieldNames)){
    		return null;
    	}
    	List<FiledSelectDetailDto>  list = fieldSelectMapper.getFiledSelectDetails(fieldNames);
    	List<FiledSelectDto> datas = new ArrayList<FiledSelectDto>();
    	if(BooleanUtils.isEmpty(list)){
    		return datas;
    	}
    	for(FiledSelectDetailDto detailDto: list){
    		FiledSelectDto currentSelectDto = null;
    		for(FiledSelectDto selectDto:datas){
    			if(detailDto.getFieldName().equals(selectDto.getName())){
    				currentSelectDto = selectDto;
    				break;
    			}
    		}
    		if(currentSelectDto == null){
    			List<SelectConfigStringValueDto> dtos = new ArrayList<SelectConfigStringValueDto>();
    			currentSelectDto = new FiledSelectDto();
    			currentSelectDto.setFieldConfigDtos(dtos);
    			currentSelectDto.setLable(detailDto.getFieldLable());
    			currentSelectDto.setName(detailDto.getFieldName());
    			datas.add(currentSelectDto);
    		}
    		
    		List<SelectConfigStringValueDto> dtos = currentSelectDto.getFieldConfigDtos();
    		SelectConfigStringValueDto configDto = new SelectConfigStringValueDto();
    		configDto.setLable(detailDto.getSelectLable());
    		configDto.setValue(detailDto.getSelectValue().toString());
    		configDto.setSequence(detailDto.getSequence());
    		dtos.add(configDto);
    	}
    	return datas;
    }
	
	
	/**
	 * 设置下拉列表，单选框，复选框的选项信息
	 * 通过字段id(object_field表的id)查询下拉选择，单选框，复选框的选项信息
	 * @param list
	 */
	private void setSelectOptions(List<FieldDto> list){
		List<Long> fieldIds = new ArrayList<Long>();
		for(FieldDto dto:list){
			fieldIds.add(dto.getId());
		}
		BaseSelectConfigExample example = new BaseSelectConfigExample();
		example.createCriteria().andObjectFieldIdIn(fieldIds);
		
		example.setOrderByClause("sequence");
		List<BaseSelectConfig> selectList = baseSelectConfigMapper.selectByExample(example);
		if(BooleanUtils.isEmpty(selectList)){
			return;
		}
		for(FieldDto dto:list){
			if(FieldTypeEnum.CHECKBOX.getCode().equals(dto.getTypeCode())
					|| FieldTypeEnum.SELECT.getCode().equals(dto.getTypeCode())
					|| FieldTypeEnum.RADIO.getCode().equals(dto.getTypeCode())){
				
				List<SelectConfigDto> selectDtos = new ArrayList<SelectConfigDto>();
				for(BaseSelectConfig config:selectList){
					if(dto.getId().equals(config.getObjectFieldId())){
						SelectConfigDto configDto = new SelectConfigDto();
						BeanUtils.copyProperties(config, configDto);
						selectDtos.add(configDto);
					}
				}
				dto.setSelectDtos(selectDtos);
				
			}
		}
	}
	
	
	/**
	 * 设置数字的配置
	 * 通过字段id(object_field表的id)查询数字配置
	 * @param list
	 */
	private void setNumberConfig(List<FieldDto> list){
		List<Long> fieldIds = new ArrayList<Long>();
		for(FieldDto dto:list){
			fieldIds.add(dto.getId());
		}
		BaseNumberConfigExample example = new BaseNumberConfigExample();
		example.createCriteria().andObjectFieldIdIn(fieldIds);
		List<BaseNumberConfig> configList = baseNumberConfigMapper.selectByExample(example);
		
		if(BooleanUtils.isEmpty(configList)){
			return;
		}
		for(FieldDto dto:list){
			if(FieldTypeEnum.NUMBER.getCode().equals(dto.getTypeCode())
					|| FieldTypeEnum.NUMBER_RANGE.getCode().equals(dto.getTypeCode())){
				NumberConfigDto configDto = new NumberConfigDto();
				for(BaseNumberConfig config:configList){
					if(config.getObjectFieldId().equals(dto.getId())){
						BeanUtils.copyProperties(config, configDto);
						dto.setNumberDto(configDto);
					}
				}
				
			}
		}
	}
	
	/**
	 * 设置数据校验
	 * 通过字段id(object_field表的id)查询数字校验
	 * @param list
	 */
	private  void setFieldConfig(List<FieldDto> list){
		List<Long> fieldIds = new ArrayList<Long>();
		for(FieldDto dto:list){
			fieldIds.add(dto.getId());
		}
		
		BaseFieldConfigExample example = new BaseFieldConfigExample();
		example.createCriteria().andObjectFieldIdIn(fieldIds);
		List<BaseFieldConfig> configList = baseFieldConfigMapper.selectByExample(example);
		if(BooleanUtils.isEmpty(configList)){
			return;
		}
		for(FieldDto dto:list){
			for(BaseFieldConfig config:configList){
				if(config.getObjectFieldId().equals(dto.getId())){
					FieldConfigDto fieldConfigDto = new FieldConfigDto();
					BeanUtils.copyProperties(config, fieldConfigDto);
					fieldConfigDto.setInitValue(config.getDefaultValue());
					dto.setFieldConfigDto(fieldConfigDto);
				}
			}
		}
	}

}
