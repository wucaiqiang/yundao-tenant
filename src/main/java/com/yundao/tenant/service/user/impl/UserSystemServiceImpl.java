package com.yundao.tenant.service.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.user.system.UserSystemInsertAndUpdateDto;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.mapper.base.BaseUserSystemMapper;
import com.yundao.tenant.model.base.BaseUserSystem;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.user.UserSystemService;

/**
 * 用户和系统管理
 * 
 * @author 欧阳利
 * 2017年6月22日
 */
@Service
public class UserSystemServiceImpl extends AbstractService implements UserSystemService {
	
	@Autowired
	BaseUserSystemMapper baseUserSystemMapper;
	
	/**
	 * 添加用户和系统的关系
	 * @param userId  用户id
	 * @param systemCode  系统编码
	 * @param createUserId  创建者id
	 * @return
	 */
    public Integer insertUserSystem(UserSystemInsertAndUpdateDto dto){
    	if(BooleanUtils.isEmpty(dto.getSystemCodes())){
    		return 0;
    	}
    	for(String systemCode : dto.getSystemCodes()){
    		BaseUserSystem record = new BaseUserSystem();
    		record.setCreateDate(new Date());
    		record.setCreateUserId(dto.getCreateUserId());
    		record.setUserAccountId(dto.getUserId());
    		record.setTenantId(dto.getTenantId());
    		record.setSystemCode(systemCode);
    		record.setIsEnabled(EnabledEnum.ENABLED.getValue());
    		record.setIsDelete(0);
        	baseUserSystemMapper.insert(record);
    	}
    	return dto.getSystemCodes().size();
    }
}
