package com.yundao.tenant.service.field;

import java.util.List;

public interface ObjectFieldService {
	
	/**
	 * 通过字段名称获取字段信息
	 * @param fieldCodes
	 * @return
	 */
    public List<?> getObjectFields(List<String> fieldCodes);
}
