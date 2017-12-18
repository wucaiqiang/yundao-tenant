package com.yundao.tenant.service.user;

import com.yundao.tenant.dto.user.system.UserSystemInsertAndUpdateDto;

/**
 * 用户系统管理
 * 
 * @author 欧阳利
 * 2017年6月22日
 */
public interface UserSystemService {
	
	/**
	 * 添加用户和系统的关系
	 * @param dto  
	 * @return
	 */
    public Integer insertUserSystem(UserSystemInsertAndUpdateDto dto);
}
