package com.yundao.tenant.service.user;

import java.util.List;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.user.UserInfoDto;
import com.yundao.tenant.dto.user.role.department.UserDepartmentDto;
import com.yundao.tenant.model.base.BaseUserDepartment;

public interface UserDepartmentService {
	
	/**
	 * 添加用户部门
	 * @param userId
	 * @param departmentId
	 * @return
	 */
    public Integer insertUserDepartment(BaseUserDepartment userDepartment,Long createUserId) throws BaseException;
    
    /**
     * 修改用户部门信息
     * @param userDepartment
     * @param createUserId
     * @return
     * @throws BaseException
     */
    public Integer updateUserDeparment(BaseUserDepartment userDepartment,Long createUserId)throws BaseException;

	 /**
	  * 查询用户部门信息
	  * @param userIds
	  * @return
	  */
	 public List<UserDepartmentDto> selectUserDepartments(List<Long> userIds);
	 
	 /**
	  * 查询部门下的直接用户
	  * getDepartmentDirectUser:
	  * @author: 欧阳利
	  * @param departmentId
	  * @return
	  * @description:
	  */
	 public List<UserInfoDto> getDepartmentDirectUser(Long departmentId);
}
