package com.yundao.tenant.mapper.field;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.field.FieldDto;

public interface FieldMapper {
	
	/**
	 * 通过产品类型查询产品的字段
	 * @param productType
	 * @return
	 */
	List<FieldDto> getFieldByTypeId(@Param("fieldGroupId") Long fieldGroupId);
	/**
	 * 根据产品字段code获取字段
	 * selectFieldDetailFieldCode:
	 * @author: wucq
	 * @param fieldCodes
	 * @return
	 * @description:
	 */
	List<FieldDto> selectFieldDetailFieldCode(@Param("fieldCodes") List<String> fieldCodes);

}
