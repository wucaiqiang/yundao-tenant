package com.yundao.tenant.service.workflow;

import java.util.List;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.resource.UserResDto;

public interface WorkFlowGroupUserService {
	
	
	/**
	 * 获取审核组
	 * @return
	 * @throws BaseException
	 */
	public List<String> getAuditGroup()throws BaseException;
	
	
	/**
	 * 修改用户时需要通知工作流对应的用户组
	 * @param userId
	 * @param oldResourceCodes
	 * @param newResourceCodes
	 */
    public void updateUserRole(Long userId,List<String> oldResourceCodes,List<String> newResourceCodes)throws BaseException;
    
    
	/**
	 * 修改用户时需要通知工作流对应的用户组
	 * @param userId
	 * @param newResourceCodes
	 */
    public void addUserRole(Long userId,List<String> newResourceCodes)throws BaseException;
    
    
    /**
     * 修改角色后通知工作流
     * @param oldUserResDtos
     * @param newUserResDtos
     */
    public void updateRole()throws BaseException;
    
    public void updateRole( List<UserResDto> oldUserResDtos) throws BaseException;
    
    /**
     * 用户离职
     * @param userIds
     * @throws BaseException
     */
    public void doDimission(List<Long> userIds)throws BaseException;
    
}
