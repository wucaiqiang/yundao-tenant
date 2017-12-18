package com.yundao.tenant.util.field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.dto.field.FieldConfigDto;
import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.enums.bo.FieldTypeEnum;
import com.yundao.tenant.enums.bo.ProductTableFieldEnum;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductSale;

public class ProductPropertyUtils {
	
	
    /**
     * 对象集合转换
     * @param fieldDtos
     * @return
     */
    public static List<FieldDetailDto> getALlProductFieldDtos(List<FieldDto> fieldDtos){
    	if(BooleanUtils.isEmpty(fieldDtos)){
    		return null;
    	}
    	List<FieldDetailDto> list = new ArrayList<FieldDetailDto>();
    	for(FieldDto dto : fieldDtos){
    		FieldDetailDto productFieldDto = new FieldDetailDto();
    		BeanUtils.copyProperties(dto, productFieldDto);
    		list.add(productFieldDto);
    	}
    	
    	for(FieldDetailDto fieldDto : list){
    		if(fieldDto.getFieldConfigDto() != null){
    			fieldDto.getFieldConfigDto().setInitValue(null);
    		}
    	}
    	return list;
    }
	
	
	
    /**
     * 对象集合转换
     * @param fieldDtos
     * @return
     */
    public static List<FieldDetailDto> getProductFieldDtos(List<FieldDto> fieldDtos){
    	if(BooleanUtils.isEmpty(fieldDtos)){
    		return null;
    	}
    	List<FieldDetailDto> list = new ArrayList<FieldDetailDto>();
    	Map<String, ProductTableFieldEnum> productSaleMaps = ProductTableFieldEnum.getProductSaleMap(); 
    	for(FieldDto dto : fieldDtos){
    		if(productSaleMaps.containsKey(dto.getName())){
    			continue;
    		}
    		FieldDetailDto productFieldDto = new FieldDetailDto();
    		BeanUtils.copyProperties(dto, productFieldDto);
    		list.add(productFieldDto);
    	}
    	
    	for(FieldDetailDto fieldDto : list){
    		if(fieldDto.getFieldConfigDto() != null){
    			fieldDto.getFieldConfigDto().setInitValue(null);
    		}
    	}
    	return list;
    }
    
    
    
    /**
     * 对象集合转换
     * @param fieldDtos
     * @return
     */
    public static List<FieldDetailDto> getProductSaleFieldDtos(List<FieldDto> fieldDtos){
    	if(BooleanUtils.isEmpty(fieldDtos)){
    		return null;
    	}
    	List<FieldDetailDto> list = new ArrayList<FieldDetailDto>();
    	Map<String, ProductTableFieldEnum> productSaleMaps = ProductTableFieldEnum.getProductSaleMap(); 
    	for(FieldDto dto : fieldDtos){
    		if(!productSaleMaps.containsKey(dto.getName())){
    			continue;
    		}
    		FieldDetailDto productFieldDto = new FieldDetailDto();
    		BeanUtils.copyProperties(dto, productFieldDto);
    		list.add(productFieldDto);
    	}
    	
    	for(FieldDetailDto fieldDto : list){
    		if(fieldDto.getFieldConfigDto() != null){
    			fieldDto.getFieldConfigDto().setInitValue(null);
    		}
    	}
    	return list;
    }
    
    /**
     * 合并字段
     * @param list
     * @param baseProduct
     * @param baseProductSale
     */
    public static void mergeProductField(List<FieldDetailDto> list,BaseProduct baseProduct){
        if(BooleanUtils.isEmpty(list)){
        	return;
        }
        for(FieldDetailDto dto:list){
        	FieldConfigDto fieldConfigDto = dto.getFieldConfigDto();
        	if(fieldConfigDto == null){
        		fieldConfigDto = new FieldConfigDto();
        		dto.setFieldConfigDto(fieldConfigDto);
        	}
        	// 设置产品字段
        	setProductProperty(dto,fieldConfigDto, baseProduct);
        }
    }
    
    
    /**
     * 合并字段
     * @param list
     * @param baseProduct
     * @param baseProductSale
     */
    public static void mergeProductSaleField(List<FieldDetailDto> list,BaseProductSale baseProductSale){
        if(BooleanUtils.isEmpty(list)){
        	return;
        }
        for(FieldDetailDto dto:list){
        	FieldConfigDto fieldConfigDto = dto.getFieldConfigDto();
        	if(fieldConfigDto == null){
        		fieldConfigDto = new FieldConfigDto();
        		dto.setFieldConfigDto(fieldConfigDto);
        	}
        	
        	// 设置产品销售信息
        	setProductSaleProperty(dto, fieldConfigDto, baseProductSale);
        }
    }
    
    
    /**
     * 设置数字类型
     * setNumberDecima:
     * @author: 欧阳利
     * @param fieldDtos
     * @description:
     */
    public static void setNumberDecima(List<FieldDetailDto> fieldDtos){
    	if(BooleanUtils.isEmpty(fieldDtos)){
    		return;
    	}
    	for(FieldDetailDto dto : fieldDtos){
    		if(FieldTypeEnum.NUMBER.getCode().equals(dto.getTypeCode())){
    			if(dto.getNumberDto() != null && dto.getNumberDto().getDecimalLength() == 0){
    				if(dto.getFieldConfigDto() != null && !BooleanUtils.isBlank(dto.getFieldConfigDto().getInitValue())){
    					if(dto.getFieldConfigDto().getInitValue().endsWith(".0") && dto.getFieldConfigDto().getInitValue().length() >=3){
    						String initValue = dto.getFieldConfigDto().getInitValue();
    						dto.getFieldConfigDto().setInitValue(initValue.substring(0, initValue.length()-2));
    					}
    				}
    			}
    		}
    	}
    }
    
    
    
    
    /**
     * 设置产品属性
     * @param dto
     * @param fieldConfigDto
     * @param baseProduct
     */
    private static void setProductProperty(FieldDetailDto dto,FieldConfigDto fieldConfigDto,BaseProduct baseProduct){
    	String initValue = null;
    	if(ProductTableFieldEnum.NAME.getPropertyName().equals(dto.getName())){
    		initValue = baseProduct.getName();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.INVEST_DOMAIN.getPropertyName().equals(dto.getName())){
    		initValue = baseProduct.getInvestDomain();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.TIME_LIMIT.getPropertyName().equals(dto.getName())){
    		if(baseProduct.getTimeLimit() != null){
    			initValue = baseProduct.getTimeLimit().toString();
    		}
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.MECHANISM.getPropertyName().equals(dto.getName())){
    		initValue = baseProduct.getMechanism();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.BUY_START_POINT.getPropertyName().equals(dto.getName())){
    		if(baseProduct.getBuyStartPoint() != null){
    			initValue = baseProduct.getBuyStartPoint().toString();
    		}
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.INVEST_DOMAIN.getPropertyName().equals(dto.getName())){
    		initValue = baseProduct.getInvestDomain();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.INCREMENTAL_AMOUNT.getPropertyName().equals(dto.getName())){
    		if(baseProduct.getIncrementalAmount() != null){
    			initValue = baseProduct.getIncrementalAmount().toString();
    		}
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.BUY_PERSON_LIMIT.getPropertyName().equals(dto.getName())){
    		if(baseProduct.getBuyPersonLimit()!= null){
    			initValue = baseProduct.getBuyPersonLimit().toString();
    		}
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.LEVEL.getPropertyName().equals(dto.getName())){
    		initValue = baseProduct.getLevel();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.RISK_LEVEL.getPropertyName().equals(dto.getName())){
    		initValue = baseProduct.getRiskLevel();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.RECEIVER_ID.getPropertyName().equals(dto.getName())){
    		if(baseProduct.getReceiverId() != null){
    			initValue = baseProduct.getReceiverId().toString();
    		}
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.ASSISTANT_ID.getPropertyName().equals(dto.getName())){
    		if(baseProduct.getAssistantId() != null){
    			initValue = baseProduct.getAssistantId().toString();
    		}
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.HIGHLIGHT.getPropertyName().equals(dto.getName())){
    		initValue = baseProduct.getHighlight();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.WX_CONTENT.getPropertyName().equals(dto.getName())){
    		initValue = baseProduct.getWxContent();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.ISSUED_CHANNEL.getPropertyName().equals(dto.getName())){
    		initValue = baseProduct.getIssuedChannel();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.MATURITY_DATE.getPropertyName().equals(dto.getName())){
    		Date maturityDate = baseProduct.getMaturityDate();
    		StringBuffer value = new StringBuffer();
    		if(maturityDate != null){
    			value.append(DateUtils.format(maturityDate, DateUtils.YYYY_MM_DD));
    		}
    		initValue = value.toString();
    		fieldConfigDto.setInitValue(initValue);
    	}
    	
    }
    
    /**
     * 设置产品销售信息
     * @param dto
     * @param fieldConfigDto
     * @param baseProductSale
     */
    private static void setProductSaleProperty(FieldDetailDto dto,FieldConfigDto fieldConfigDto,BaseProductSale baseProductSale){
    	String initValue = null;
    	if(ProductTableFieldEnum.IS_SCALE.getPropertyName().equals(dto.getName())){
    		if(baseProductSale.getIsScale() != null){
    			initValue = baseProductSale.getIsScale().toString();
    		}
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.PRODUCT_SCALE.getPropertyName().equals(dto.getName())){
    		if(baseProductSale.getProductScale() != null){
    			initValue = baseProductSale.getProductScale().toString();
    		}
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.CURRENCY_CODE.getPropertyName().equals(dto.getName())){
    		initValue = baseProductSale.getCurrencyCode();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.PAY_ACCOUNT.getPropertyName().equals(dto.getName())){
    		initValue = baseProductSale.getPayAccount();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.SALE_DATE.getPropertyName().equals(dto.getName())){
    		Date startDate = baseProductSale.getSaleStartDate();
    		Date endDate = baseProductSale.getSaleEndDate();
    		StringBuffer value = new StringBuffer();
    		if(startDate != null){
    			value.append(DateUtils.format(startDate, DateUtils.YYYY_MM_DD));
    		}
    		value.append(FieldUtils.SPLIT_SYMBOL);
    		if(endDate != null){
    			value.append(DateUtils.format(endDate, DateUtils.YYYY_MM_DD));
    		}
    		initValue = value.toString();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.RAISE_BANK.getPropertyName().equals(dto.getName())){
    		initValue = baseProductSale.getRaiseBank();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.PAY_REMARK.getPropertyName().equals(dto.getName())){
    		initValue = baseProductSale.getPayRemark();
    		fieldConfigDto.setInitValue(initValue);
    	}else if(ProductTableFieldEnum.ACCOUNT_NAME.getPropertyName().equals(dto.getName())){
    		initValue =  baseProductSale.getAccountName();
    		fieldConfigDto.setInitValue(initValue);
    	}
    	
    }
    
    
    public static List<FieldDto> getProductSaleProperty(List<FieldDto> list){
    	if(BooleanUtils.isEmpty(list)){
    		return new ArrayList<FieldDto>();
    	}
    	Map<String, ProductTableFieldEnum> map = ProductTableFieldEnum.getProductSaleMap();
    	List<FieldDto> productSaleList = new ArrayList<FieldDto>();
    	for(FieldDto fieldDto : list){
    		if(map.containsKey(fieldDto.getName())){
    			productSaleList.add(fieldDto);
    		}
    	}
    	return productSaleList;
    }
    
    
    public static List<FieldDto> getProductProperty(List<FieldDto> list){
    	if(BooleanUtils.isEmpty(list)){
    		return new ArrayList<FieldDto>();
    	}
    	Map<String, ProductTableFieldEnum> map = ProductTableFieldEnum.getProductSaleMap();
    	List<FieldDto> productSaleList = new ArrayList<FieldDto>();
    	for(FieldDto fieldDto : list){
    		if(!map.containsKey(fieldDto.getName())){
    			productSaleList.add(fieldDto);
    		}
    	}
    	return productSaleList;
    }
    
}
