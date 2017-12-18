package com.yundao.tenant.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FieldValueDto;
import com.yundao.tenant.model.base.product.BaseProductFieldValue;

public interface ProductFieldValueMapper {
	 int updateByPrimaryKey(BaseProductFieldValue record);
	 
		
		
	/**
	 * 通过产品类型查询产品的字段
	 * @param productId
	 * @return
	 */
	List<FieldValueDto> getFieldValueByProductId(@Param("fieldGroupId") Long fieldGroupId,@Param("productId") Long productId);
	List<FieldValueDto> getFieldValueByProductIdAndFieldIds(@Param("productId") Long productId,@Param("fieldIds") String fieldIds);
}
