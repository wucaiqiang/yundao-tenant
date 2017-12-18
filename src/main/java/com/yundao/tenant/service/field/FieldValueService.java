package com.yundao.tenant.service.field;

import java.util.List;
import java.util.Map;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.field.FieldDetailAndValueDto;
import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FieldValueDto;

public interface FieldValueService {
    
	/**
	 * 转换对象数据
	 * @param mapValues
	 * @return
	 */
	public List<FieldValueDto> transformFieldValue(List<FieldDto> list,Map<String, String> mapValues);
	
	/**
	 * 添加产品数据
	 * @param list
	 * @return
	 */
	public Integer saveProductFieldValue(List<FieldValueDto> list,Long productId);
	
	
	/**
	 * 修改产品数据
	 * @param list
	 * @return
	 */
	public Integer updateProductFieldValue(List<FieldValueDto> list,Long productId);
	
	/**
	 * 获取产品字段值
	 * @param productId
	 * @return
	 */
	public List<FieldValueDto> getProductFieldValues(Long typeId,Long productId);
	/**
	 * 根据产品ID获取指定非通用字段值及字段基本信息
	 * getFieldValuesByProductIdAndFields:
	 * @author: wucq
	 * @param productId
	 * @param fieldCodes
	 * @return
	 * @description:
	 */
	public List<FieldDetailAndValueDto> getFieldValuesByProductIdAndFieldCode(Long productId,List<String> fieldCodes)throws BaseException;
	
	/**
	 * 设置图片字段信息
	 * @param fieldDetailDtos
	 */
	public void setImageFieldValue(List<FieldDetailDto> fieldDetailDtos)throws Exception;
}
