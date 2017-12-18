package com.yundao.tenant.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.user.role.UserRoleDto;

public interface UserRoleMapper {
	
	 /**
	  * 查询用户角色信息
	  * @param userIds
	  * @return
	  */
	 public List<UserRoleDto> selectUserRoles(@Param("userIds")List<Long> userIds);



    /**
     * 用户角色id查询在职用户id
     * @param userId
     * @return
     */
    public List<Long> selectUserIdsByRoleId(@Param("roleId") Long roleId);

}
