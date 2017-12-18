package com.yundao.tenant.service.field.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.field.AddressDto;
import com.yundao.tenant.dto.field.FieldDetailAndValueDto;
import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FieldValueDto;
import com.yundao.tenant.dto.field.ImageDto;
import com.yundao.tenant.dto.field.ValuesDto;
import com.yundao.tenant.enums.bo.FieldTypeEnum;
import com.yundao.tenant.mapper.base.product.BaseProductFieldValueMapper;
import com.yundao.tenant.mapper.field.FieldMapper;
import com.yundao.tenant.mapper.product.ProductFieldValueMapper;
import com.yundao.tenant.model.base.BaseCloudFile;
import com.yundao.tenant.model.base.BaseNumberConfig;
import com.yundao.tenant.model.base.BaseSelectConfig;
import com.yundao.tenant.model.base.product.BaseProductFieldValue;
import com.yundao.tenant.model.base.product.BaseProductFieldValueExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.cloudfile.CloudFileService;
import com.yundao.tenant.service.field.FieldValueService;
import com.yundao.tenant.service.field.NumberConfigService;
import com.yundao.tenant.service.select.SelectConfigService;
import com.yundao.tenant.util.field.FieldUtils;

/**
 * 对象值管理
 * 
 * @author 欧阳利 2017年7月20日
 */
@Service
public class FieldValueServiceImpl extends AbstractService implements FieldValueService {

	@Autowired
	BaseProductFieldValueMapper baseProductFieldValueMapper;
	@Autowired
	ProductFieldValueMapper productFieldValueMapper;
	@Autowired
	FieldMapper productFieldMapper;
	@Autowired
	NumberConfigService numberConfigService;
	@Autowired
	SelectConfigService selectConfigService; 
    @Autowired
    private CloudFileService cloudFileService;
	/**
	 * 转换对象数据
	 * 
	 * @param mapValues
	 * @return
	 */
	@Override
	public List<FieldValueDto> transformFieldValue(List<FieldDto> list, Map<String, String> mapValues) {
		List<FieldValueDto> fieldValues = new ArrayList<FieldValueDto>();
		for (String key : mapValues.keySet()) {
			String value = mapValues.get(key);
			if (BooleanUtils.isEmpty(value)) {
				continue;
			}
			for (FieldDto dto : list) {
				if (key.equals(dto.getName())) {
					if (FieldTypeEnum.CHECKBOX.getCode().equals(dto.getTypeCode())
							|| FieldTypeEnum.IMAGE.getCode().equals(dto.getTypeCode())) {
						String[] values = value.split(FieldUtils.SPLIT_SYMBOL);
						if (!BooleanUtils.isEmpty(values)) {
							for (int i = 0; i < values.length; i++) {
								FieldValueDto fieldValue = new FieldValueDto();
								fieldValue.setObjectFieldId(dto.getId());
								fieldValue.setValue(values[i]);
								fieldValue.setSlot(i);
								fieldValues.add(fieldValue);
							}
						}
					} else if (FieldTypeEnum.DATE_RANGE.getCode().equals(dto.getTypeCode())
							|| FieldTypeEnum.NUMBER_RANGE.getCode().equals(dto.getTypeCode())) {
						fieldValues.addAll(transformDateNumberRangeFieldValue(value, dto));
					} else if (FieldTypeEnum.ADDRESS.getCode().equals(dto.getTypeCode())) {
						fieldValues.addAll(transformAddressFieldValue(value, dto));
					} else {
						FieldValueDto fieldValue = new FieldValueDto();
						fieldValue.setObjectFieldId(dto.getId());
						fieldValue.setValue(value);
						fieldValues.add(fieldValue);
					}

				}
			}
		}
		return fieldValues;
	}

	/**
	 * 添加产品数据
	 * 
	 * @param list
	 * @return
	 */
	@Override
	public Integer saveProductFieldValue(List<FieldValueDto> list, Long productId) {
		if (BooleanUtils.isEmpty(list)) {
			return 0;
		}
		Date now = new Date();
		for (FieldValueDto dto : list) {
			BaseProductFieldValue record = new BaseProductFieldValue();
			BeanUtils.copyProperties(dto, record);
			record.setCreateDate(now);
			record.setCreateUserId(this.getHeaderUserId());
			record.setTenantId(this.getHeaderTenantId());
			record.setIsDelete(0);
			record.setReferenceTableId(productId);
			baseProductFieldValueMapper.insert(record);
		}
		return list.size();
	}

	/**
	 * 修改产品数据
	 * 
	 * @param list
	 * @return
	 */
	public Integer updateProductFieldValue(List<FieldValueDto> list, Long productId) {
		if (BooleanUtils.isEmpty(list)) {
			return 0;
		}
		// 查询所有的字段值
		BaseProductFieldValueExample example = new BaseProductFieldValueExample();
		example.createCriteria().andReferenceTableIdEqualTo(productId);
		List<BaseProductFieldValue> oldFieldValues = baseProductFieldValueMapper.selectByExample(example);
		
		List<BaseProductFieldValue> updateFieldValues = getExistFieldValues(oldFieldValues, list);
		List<BaseProductFieldValue> deleteFieldValues = getNotExistFieldValues(oldFieldValues, updateFieldValues);
		List<FieldValueDto> addFieldValues = getAddFieldValues(oldFieldValues, list);


		// 修改存在的值(先删除，在添加)
		List<FieldValueDto> existFieldValueDtos = getExistFieldValueDtos(oldFieldValues, list);
		if (!BooleanUtils.isEmpty(updateFieldValues)) {
			for (BaseProductFieldValue model : updateFieldValues) {
				baseProductFieldValueMapper.deleteByPrimaryKey(model.getId());
			}
		}
		saveProductFieldValue(existFieldValueDtos, productId);

		// 添加值
		saveProductFieldValue(addFieldValues, productId);

		// 设置值为空
		if (!BooleanUtils.isEmpty(deleteFieldValues)) {
			for (BaseProductFieldValue model : deleteFieldValues) {
				baseProductFieldValueMapper.deleteByPrimaryKey(model.getId());
			}
		}

		return list.size();
	}
	
	

	/**
	 * 获取需要添加的字段值
	 * 
	 * @param allFieldValues
	 * @param list
	 * @return
	 */
	private List<FieldValueDto> getAddFieldValues(List<BaseProductFieldValue> oldFieldValues,
			List<FieldValueDto> list) {
		if (BooleanUtils.isEmpty(list)) {
			return null;
		}
		List<FieldValueDto> addFieldValues = new ArrayList<FieldValueDto>();
		for (FieldValueDto dto : list) {
			boolean isExist = false;
			if(!BooleanUtils.isEmpty(oldFieldValues)){
				for (BaseProductFieldValue model : oldFieldValues) {
					if (model.getObjectFieldId().equals(dto.getObjectFieldId())) {
						isExist = true;
						break;
					}
				}
			}
			
			if (!isExist) {
				addFieldValues.add(dto);
			}
		}
		return addFieldValues;
	}

	/**
	 * 获取需要置空的字段值
	 * 
	 * @param allFieldValues
	 * @param existieldValues
	 * @return
	 */
	private List<BaseProductFieldValue> getNotExistFieldValues(List<BaseProductFieldValue> oldFieldValues,
			List<BaseProductFieldValue> existieldValues) {
		if (BooleanUtils.isEmpty(oldFieldValues) || BooleanUtils.isEmpty(existieldValues)) {
			return null;
		}
		List<BaseProductFieldValue> notExistFieldValues = new ArrayList<BaseProductFieldValue>();
		for (BaseProductFieldValue modelAll : oldFieldValues) {
			boolean isExist = false;
			for (BaseProductFieldValue modelexist : existieldValues) {
				if (modelAll.getId().equals(modelexist.getId())) {
					isExist = true;
				}
			}
			if (!isExist) {
				notExistFieldValues.add(modelAll);
			}
		}
		return notExistFieldValues;
	}

	/**
	 * 获取存在的值
	 * 
	 * @param allFieldValues
	 * @param list
	 * @return
	 */
	private List<BaseProductFieldValue> getExistFieldValues(List<BaseProductFieldValue> oldFieldValues,
			List<FieldValueDto> list) {
		if (BooleanUtils.isEmpty(oldFieldValues) || BooleanUtils.isEmpty(list)) {
			return null;
		}
		List<BaseProductFieldValue> existFieldValues = new ArrayList<BaseProductFieldValue>();
		for (BaseProductFieldValue model : oldFieldValues) {
			for (FieldValueDto dto : list) {
				if (model.getObjectFieldId().equals(dto.getObjectFieldId())) {
					existFieldValues.add(model);
					break;
				}
			}
		}
		return existFieldValues;
	}
	
	
	private List<FieldValueDto> getExistFieldValueDtos(List<BaseProductFieldValue> oldFieldValues,
			List<FieldValueDto> list) {
		if (BooleanUtils.isEmpty(oldFieldValues) || BooleanUtils.isEmpty(list)) {
			return null;
		}
		List<FieldValueDto> existFieldValueDtos = new ArrayList<FieldValueDto>();
		for (FieldValueDto dto : list) {
			for (BaseProductFieldValue model : oldFieldValues) {
				if (model.getObjectFieldId().equals(dto.getObjectFieldId())) {
					existFieldValueDtos.add(dto);
					break;
				}
			}
			
		}
		
		return existFieldValueDtos;
	}

	/**
	 * 获取产品字段值
	 * 
	 * @param productId
	 * @return
	 */
	public List<FieldValueDto> getProductFieldValues(Long typeId, Long productId) {
		if (productId == null) {
			return null;
		}
		return productFieldValueMapper.getFieldValueByProductId(typeId, productId);
	}

	@Override
	public List<FieldDetailAndValueDto> getFieldValuesByProductIdAndFieldCode(Long productId, List<String> fieldCodes)throws BaseException {
		List<FieldDto> fieldDtos = productFieldMapper.selectFieldDetailFieldCode(fieldCodes);
		Map<Long, FieldDetailAndValueDto> fieldMap = new HashMap<>();
		//所有业务对象IDs
		StringBuilder idsB = new StringBuilder();

		List<FieldDetailAndValueDto> detailAndValueDtos = new ArrayList<>();
		if (fieldDtos != null && !fieldDtos.isEmpty()) {
			for (FieldDto dto : fieldDtos) {
				FieldDetailAndValueDto field = new FieldDetailAndValueDto();
				field.setCode(dto.getName());
				field.setName(dto.getLabel());
				field.setId(dto.getId());
				field.setType(dto.getType());
				field.setTypeCode(dto.getTypeCode());
				field.setTypeName(dto.getTypeName());
				
				fieldMap.put(dto.getId(), field);
				if (idsB.length() > 0) {
					idsB.append(",");
				}
				idsB.append(dto.getId());
				
				detailAndValueDtos.add(field);
			}
			List<FieldValueDto> values = productFieldValueMapper.getFieldValueByProductIdAndFieldIds(productId,
					idsB.toString());
			if (values != null && !values.isEmpty()) {
				for (FieldValueDto dto : values) {
					if (fieldMap.containsKey(dto.getObjectFieldId())) {
						FieldDetailAndValueDto fieldDto = fieldMap.get(dto.getObjectFieldId());
						List<ValuesDto> vaList = fieldDto.getValues();
						if (vaList == null) {
							vaList = new ArrayList<>();
							fieldDto.setValues(vaList);
						}
						ValuesDto valueDto = new ValuesDto();
						valueDto.setValue(dto.getValue());
						if (FieldTypeEnum.NUMBER.getCode().equals(fieldDto.getTypeCode())
								|| FieldTypeEnum.NUMBER_RANGE.getCode().equals(fieldDto.getTypeCode())) {
							BaseNumberConfig numberConfig = numberConfigService.selectByFieldId(dto.getObjectFieldId());
							valueDto.setNumUnit(numberConfig.getUnit());//数据设置单位
						} else if (FieldTypeEnum.SELECT.getCode().equals(fieldDto.getTypeCode())
								|| FieldTypeEnum.RADIO.getCode().equals(fieldDto.getTypeCode())
								|| FieldTypeEnum.CHECKBOX.getCode().equals(fieldDto.getTypeCode())) {
							BaseSelectConfig selectConfig=selectConfigService.getByFieldIdAndValue(dto.getObjectFieldId(), Integer.parseInt(dto.getValue()));
							valueDto.setSelectLabel(selectConfig.getLabel());
						}
						vaList.add(valueDto);
					}
				}
			}
		}
		return detailAndValueDtos;

	}

	/**
	 * 转换日期，数据区间字段值(,)
	 * 
	 * @param value
	 * @param dto
	 * @return
	 */
	private List<FieldValueDto> transformDateNumberRangeFieldValue(String value, FieldDto dto) {
		List<FieldValueDto> fieldValues = new ArrayList<FieldValueDto>();
		Integer count = 0;
		count = FieldUtils.containsCharCount(value, FieldUtils.SPLIT_SYMBOL, count);
		String[] values = value.split(FieldUtils.SPLIT_SYMBOL);
		if (!BooleanUtils.isEmpty(values) && values.length == 2) {
			for (int i = 0; i < values.length; i++) {
				FieldValueDto fieldValue = new FieldValueDto();
				fieldValue.setObjectFieldId(dto.getId());
				fieldValue.setValue(values[i]);
				fieldValue.setSlot(i);
				fieldValues.add(fieldValue);
			}
		} else {
			for (int i = 0; i < 2; i++) {
				if (i < values.length) {
					FieldValueDto fieldValue = new FieldValueDto();
					fieldValue.setObjectFieldId(dto.getId());
					fieldValue.setValue(values[i]);
					fieldValue.setSlot(i);
					fieldValues.add(fieldValue);
				} else {
					FieldValueDto fieldValue = new FieldValueDto();
					fieldValue.setObjectFieldId(dto.getId());
					fieldValue.setValue("");
					fieldValue.setSlot(i);
					fieldValues.add(fieldValue);
				}
			}
		}
		return fieldValues;
	}

	/**
	 * 转换地址字段值(省,市,地址)
	 * 
	 * @param value
	 * @param dto
	 * @return
	 */
	public List<FieldValueDto> transformAddressFieldValue(String value, FieldDto dto) {
		List<FieldValueDto> fieldValues = new ArrayList<FieldValueDto>();
		AddressDto addressDto = getAddressDto(value);
		if(addressDto == null){
			return fieldValues;
		}
		
		FieldValueDto province = new FieldValueDto();
		province.setObjectFieldId(dto.getId());
		province.setValue(BooleanUtils.isBlank(addressDto.getProvince())?"":addressDto.getProvince());
		province.setSlot(0);
		fieldValues.add(province);
		
		
		FieldValueDto city = new FieldValueDto();
		city.setObjectFieldId(dto.getId());
		city.setValue(BooleanUtils.isBlank(addressDto.getCity())?"":addressDto.getCity());
		city.setSlot(1);
		fieldValues.add(city);
		
		FieldValueDto address = new FieldValueDto();
		address.setObjectFieldId(dto.getId());
		address.setValue(BooleanUtils.isBlank(addressDto.getAddress())?"":addressDto.getAddress());
		address.setSlot(2);
		fieldValues.add(address);
		return fieldValues;
	}
	
	/**
	 * 对象转换
	 * @param value
	 * @return
	 */
	private  AddressDto getAddressDto(String value){
		AddressDto addressDto =  null;
		try{
			addressDto = JsonUtils.jsonToObject(value, AddressDto.class);
		}catch(Exception e){
			return null;
		}
		return addressDto;
	}
	
	
	/**
	 * 设置图片字段信息
	 * @param fieldDetailDtos
	 */
	public void setImageFieldValue(List<FieldDetailDto> fieldDetailDtos)throws Exception{
		if(BooleanUtils.isEmpty(fieldDetailDtos)){
			return ;
		}
		for(FieldDetailDto fieldDetailDto : fieldDetailDtos){
			if(FieldTypeEnum.IMAGE.getCode().equals(fieldDetailDto.getTypeCode())){
				List<ImageDto> imageDtos = fieldDetailDto.getImageDtos();
				if(BooleanUtils.isEmpty(imageDtos)){
					return;
				}
				for(ImageDto dto : imageDtos){
					Result<BaseCloudFile> result = cloudFileService.get(dto.getId());
					if(result.getSuccess()){
						BaseCloudFile file = result.getResult();
						if(file != null){
							dto.setName(file.getOriginalName());
							dto.setUrl(file.getUrl());
						}
					}
					
				}
			}
		}
	}
}
