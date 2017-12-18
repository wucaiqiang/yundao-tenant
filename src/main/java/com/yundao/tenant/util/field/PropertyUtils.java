package com.yundao.tenant.util.field;

import java.util.ArrayList;
import java.util.List;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.field.AddressDto;
import com.yundao.tenant.dto.field.FieldConfigDto;
import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.field.FieldValueDto;
import com.yundao.tenant.dto.field.ImageDto;
import com.yundao.tenant.enums.bo.FieldTypeEnum;

public class PropertyUtils {

    
    
    /**
     * 设置产品字段属性
     * @param list
     * @param fieldValueDtos
     * @param excludeFieldNames 不包含的字段
     */
    public static void setExtProperty(List<FieldDetailDto> list,List<FieldValueDto> fieldValueDtos,List<String> excludeFieldNames){
    	  if(BooleanUtils.isEmpty(list) || BooleanUtils.isEmpty(fieldValueDtos)){
    		  return;
    	  }
    	  for(FieldDetailDto dto:list){
    		  if(!BooleanUtils.isEmpty(excludeFieldNames) && excludeFieldNames.contains(dto.getName())){
    			  continue;
    		  }
    		 
    		  List<FieldValueDto> valueDtos = new ArrayList<FieldValueDto>();
    		  if(dto.getFieldConfigDto() == null){
    			  dto.setFieldConfigDto(new FieldConfigDto());
    		  }
    		  for(FieldValueDto value : fieldValueDtos){
    			  if(dto.getId().equals(value.getObjectFieldId())){
    				  valueDtos.add(value);
    			  }
    		  }
    		  if(BooleanUtils.isEmpty(valueDtos)){
    			  continue;
    		  }
    		  if(FieldTypeEnum.DATE_RANGE.getCode().equals(dto.getTypeCode())
						|| FieldTypeEnum.NUMBER_RANGE.getCode().equals(dto.getTypeCode())){
    			  StringBuffer initValue = new StringBuffer();
    			  FieldValueDto start =  getFieldValueDtoBySolt(valueDtos,0);
    			  FieldValueDto end =  getFieldValueDtoBySolt(valueDtos,1);
    			  if(start != null){
    				  initValue.append(start.getValue());
    			  }
    			  initValue.append(FieldUtils.SPLIT_SYMBOL);
    			  if(end != null){
    				  initValue.append(end.getValue());
    			  }
    			  dto.getFieldConfigDto().setInitValue(initValue.toString());
    		  }else if(FieldTypeEnum.IMAGE.getCode().equals(dto.getTypeCode())){
    			  List<ImageDto> imageDtos = new ArrayList<ImageDto>();
    			  dto.setImageDtos(imageDtos);
    			  for(FieldValueDto value : valueDtos){
    				  if(!BooleanUtils.isBlank(value.getValue())){
    					  ImageDto imageDto = new ImageDto();
        				  imageDto.setId(Long.valueOf(value.getValue()));
        				  imageDtos.add(imageDto);
    				  }
    		  	  }
    		  }else if(FieldTypeEnum.ADDRESS.getCode().equals(dto.getTypeCode())){
    			  FieldValueDto province =  getFieldValueDtoBySolt(valueDtos,0);
    			  FieldValueDto city =  getFieldValueDtoBySolt(valueDtos,1);
    			  FieldValueDto address =  getFieldValueDtoBySolt(valueDtos,2);
    			  AddressDto addressDto =  new AddressDto();
    			  if(province != null){
    				  addressDto.setProvince(province.getValue());
    			  }else{
    				  addressDto.setProvince("");
    			  }
    			 
    			  if(city != null){
    				  addressDto.setCity(city.getValue());
    			  }else{
    				  addressDto.setCity("");
    			  }
    			  if(address != null){
    				  addressDto.setAddress(address.getValue());
    			  }else{
    				  addressDto.setAddress("");
    			  }
    			  String json = JsonUtils.objectToJson(addressDto);
    			  dto.getFieldConfigDto().setInitValue(json);
    		  }else{
        		  StringBuffer initValue = new StringBuffer();
        		  for(int i=0;i<valueDtos.size();i++){
        			  FieldValueDto fieldValueDto = valueDtos.get(i);
        			  initValue.append(fieldValueDto.getValue());
        			  if(i<valueDtos.size()-1){
        				  initValue.append(FieldUtils.SPLIT_SYMBOL);
        			  }
        		  }
        		  dto.getFieldConfigDto().setInitValue(initValue.toString());
    		  }
    	  }
    } 
    
    /**
     * 获取制定位置的对象
     * @param valueDtos
     * @param solt
     * @return
     */
    private static FieldValueDto getFieldValueDtoBySolt(List<FieldValueDto> valueDtos,int solt){
	  	  for(FieldValueDto value : valueDtos){
	  		  if(value.getSlot().equals(solt)){
	  			  return value;
	  		  }
	  	  }
	  	  return null;
    }
    
}
