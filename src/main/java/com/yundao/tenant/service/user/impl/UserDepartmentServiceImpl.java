package com.yundao.tenant.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.user.UserInfoDto;
import com.yundao.tenant.dto.user.role.department.UserDepartmentDto;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.mapper.base.BaseUserDepartmentMapper;
import com.yundao.tenant.mapper.user.UserDepartmentMapper;
import com.yundao.tenant.model.base.BaseUserDepartment;
import com.yundao.tenant.model.base.BaseUserDepartmentExample;
import com.yundao.tenant.model.base.BaseUserDepartmentExample.Criteria;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.user.UserDepartmentService;


@Service
public class UserDepartmentServiceImpl extends AbstractService implements UserDepartmentService {
	
	private static Log log = LogFactory.getLog(UserDepartmentServiceImpl.class);
	
	@Autowired
	BaseUserDepartmentMapper baseUserDepartmentMapper;
	
	@Autowired
	UserDepartmentMapper userDepartmentMapper;
	

	 /**
	  * 查询部门下的直接用户
	  * getDepartmentDirectUser:
	  * @author: 欧阳利
	  * @param departmentId
	  * @return
	  * @description:
	  */
	 public List<UserInfoDto> getDepartmentDirectUser(Long departmentId){
		 String range = "all";
		 if(departmentId != null && departmentId > 0){
			 range = "department";
		 }
		 return userDepartmentMapper.getDepartmentDirectUser(departmentId, range);
	 }
	
	
	/**
	 * 添加用户部门
	 * @param createUserId
	 * @param departmentId
	 * @return
	 */
    public Integer insertUserDepartment(BaseUserDepartment userDepartment,Long createUserId) throws BaseException{
    	log.info("添加用户所属的部门：",userDepartment);
    	initAddUserAndDeparment( userDepartment,createUserId);
    	Integer count = baseUserDepartmentMapper.insert(userDepartment);
    	return count;
    }
    
    
    
    /**
     * 修改用户部门信息
     * @param userDepartment
     * @param createUserId
     * @return
     * @throws BaseException
     */
    public Integer updateUserDeparment(BaseUserDepartment userDepartment,Long updateUserId)throws BaseException{
    	log.info("修改用户所属的部门：",userDepartment);
    	// 删除已经存在的
    	BaseUserDepartmentExample example = new BaseUserDepartmentExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andUserAccountIdEqualTo(userDepartment.getUserAccountId());
    	baseUserDepartmentMapper.deleteByExample(example);
    	// 添加
    	return insertUserDepartment(userDepartment,updateUserId);
    }
    
	 /**
	  * 查询用户部门信息
	  * @param userIds
	  * @return
	  */
	 public List<UserDepartmentDto> selectUserDepartments(List<Long> userIds){
		 if(BooleanUtils.isEmpty(userIds)){
			 return null;
		 }
		 return userDepartmentMapper.selectUserDepartments(userIds);
	 }
    
    
    /**
     * 初始化部门信息
     * @param userDepartment
     * @param createUserId
     */
	private void initAddUserAndDeparment(BaseUserDepartment userDepartment,Long createUserId){
		userDepartment.setCreateDate(new Date());
		userDepartment.setCreateUserId(createUserId);
		userDepartment.setIsEnabled(EnabledEnum.ENABLED.getValue());
		userDepartment.setIsDelete(0);
	}
}
