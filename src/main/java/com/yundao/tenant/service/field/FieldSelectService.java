package com.yundao.tenant.service.field;

import java.util.List;

import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FiledSelectDto;

public interface FieldSelectService {
	
    /**
     * 通过产品类型id查询字段信息
     * @param fieldGroupId
     * @return
     */
	public List<FieldDto> getProductFieldByTypeId(Long fieldGroupId);
	
	
	/**
	 * 通过字段组id查询字段详情
	 * @param fieldGroupId
	 * @return
	 */
	public List<FieldDto> getFieldByTypeGroupId(Long fieldGroupId);
	
	
	/**
	 * 通过字段名称查询下拉选项的值
	 * @param fieldNames
	 * @return
	 */
    public List<FiledSelectDto> getFiledSelectConfigs(List<String> fieldNames);
}
