
package com.yundao.tenant.service.field.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.mapper.base.BaseNumberConfigMapper;
import com.yundao.tenant.model.base.BaseNumberConfig;
import com.yundao.tenant.model.base.BaseNumberConfigExample;
import com.yundao.tenant.model.base.BaseNumberConfigExample.Criteria;
import com.yundao.tenant.service.field.NumberConfigService;

/**
 * Function: Reason: Date: 2017年8月3日 下午7:51:18
 * 
 * @author wucq
 * @version
 */
@Service
public class NumberConfigServiceImpl implements NumberConfigService {
	@Autowired
	BaseNumberConfigMapper baseNumberConfigMapper;

	public BaseNumberConfig selectByFieldId(Long fieldId) throws BaseException {
		BaseNumberConfigExample example = new BaseNumberConfigExample();
		Criteria criteria = example.createCriteria();
		criteria.andObjectFieldIdEqualTo(fieldId);
		return baseNumberConfigMapper.selectOne(example);
	}
}
