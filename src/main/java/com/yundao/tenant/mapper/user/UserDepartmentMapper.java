package com.yundao.tenant.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.user.UserInfoDto;
import com.yundao.tenant.dto.user.role.department.UserDepartmentDto;

public interface UserDepartmentMapper {
	 
	 /**
	  * 查询用户部门信息
	  * @param userIds
	  * @return
	  */
	 public List<UserDepartmentDto> selectUserDepartments(@Param("userIds")List<Long> userIds);

	 /**
	  * 查询部门的直接用户
	  * getDepartmentDirectUser:
	  * @author: 欧阳利
	  * @param departmentId
	  * @param range
	  * @return
	  * @description:
	  */
	 public List<UserInfoDto> getDepartmentDirectUser(@Param("departmentId")Long departmentId,@Param("range")String range);
}
