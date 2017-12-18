package com.yundao.tenant.service.workflow.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.constant.HeaderConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.threadlocal.filter.RequestCommonParams;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.ThreadUtils;
import com.yundao.tenant.constant.url.WorkflowUrlConstant;
import com.yundao.tenant.dto.resource.UserResDto;
import com.yundao.tenant.dto.workflow.GroupUserReqDto;
import com.yundao.tenant.enums.ExamineGroupEnum;
import com.yundao.tenant.mapper.resource.ResourceMapper;
import com.yundao.tenant.service.user.UserRoleService;
import com.yundao.tenant.service.workflow.WorkFlowGroupUserService;
import com.yundao.tenant.util.HttpUtils;

@Service
public class WorkFlowGroupUserServiceImpl extends AbstractService implements WorkFlowGroupUserService {

	 private static Log log = LogFactory.getLog(WorkFlowGroupUserServiceImpl.class);
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	ResourceMapper resourceMapper;
	
	/**
	 * 获取审核组
	 * @return
	 * @throws BaseException
	 */
	public List<String> getAuditGroup()throws BaseException{
		 
	    // 修改后拥有的资源
	    List<String> newResourceCodes = resourceMapper.getResourceCodes(this.getHeaderUserId(), ExamineGroupEnum.getAllResourceCodeAll());

    	List<String> groupCodes = new ArrayList<String>();
    	if(!BooleanUtils.isEmpty(newResourceCodes)){
    		for(String resCode : newResourceCodes){
    			String groupCode = ExamineGroupEnum.getGroupCode(resCode);
    			if(BooleanUtils.isBlank(groupCode)){
    				continue;
    			}
    			groupCodes.add(groupCode);
    		}
    	}
    	
    	return groupCodes;
	}
	
	
	@Override
	public void updateUserRole(Long userId, List<String> oldResourceCodes, List<String> newResourceCodes)throws BaseException {
		log.info("修改用户通知工作流");
        if(BooleanUtils.isEmpty(oldResourceCodes) && BooleanUtils.isEmpty(newResourceCodes)){
        	return;
        }
        List<String> addResourceCodes = getAddResourceCodes(oldResourceCodes, newResourceCodes);
        
        List<String> deleteResourceCodes = getDeleteResourceCodes(oldResourceCodes, newResourceCodes);
        // 修改用户和组的关系
        updateGroupUserIds(userId,addResourceCodes,deleteResourceCodes);
	}

	
    
	/**
	 * 修改用户时需要通知工作流对应的用户组
	 * @param userId
	 * @param newResourceCodes
	 */
    public void addUserRole(Long userId,List<String> newResourceCodes)throws BaseException{
    	log.info("添加用户通知工作流");
    	if(BooleanUtils.isEmpty(newResourceCodes)){
    		return;
    	}
    	// 修改用户和组的关系
    	updateGroupUserIds(userId,newResourceCodes,null);
    }

    
    /**
     * 修改角色后通知工作流
     */
	public void updateRole() throws BaseException {
		log.info("修改角色通知工作流");
		List<UserResDto> newUserResDtos = resourceMapper.getUserResDtos(ExamineGroupEnum.getAllResourceCodeAll());

		final List<GroupUserReqDto> allGroupUsers = new ArrayList<GroupUserReqDto>();
		if (!BooleanUtils.isEmpty(newUserResDtos)) {
			for (UserResDto resDto : newUserResDtos) {
				GroupUserReqDto dto = new GroupUserReqDto();
				dto.setUserId(resDto.getUserId());
				dto.setGroupId(ExamineGroupEnum.getGroupCode(resDto.getResCode()));
				if (BooleanUtils.isBlank(dto.getGroupId())) {
					continue;
				}
				allGroupUsers.add(dto);
			}
		}
		// 构建请求参数对象
		Map<String, Object> methodParams = new HashMap<String, Object>();
		if (!BooleanUtils.isEmpty(allGroupUsers)) {
			methodParams.put("allGroupUsers", JsonUtils.objectToJson(allGroupUsers));
		}
		
		
//		final RequestCommonParams requestParams = RequestCommonParams.newDefault(methodParams);
//		Map<String, String> headerParams = requestParams.getHeaderParams();
//		headerParams.putAll(getHeaderParams(this.getHeaderTenantId(), this.getHeaderUserId(), this.getRealName()));
//		ThreadUtils.execute(() -> {
//			try {
//				com.yundao.core.utils.HttpUtils.post(WorkflowUrlConstant.WORK_FLOW_GROUP_USERS, requestParams);
//			}
//			catch (Exception e) {
//				// TODO 短信或者邮寄通知管理员
//				log.error("通知工作量返回结果 ", e);
//			}
//		});
		
		
		log.info("同步修改角色同步到工作流请求参数："+methodParams);
		Result<Integer> result = HttpUtils.post(WorkflowUrlConstant.WORK_FLOW_GROUP_USERS, methodParams,
                new BaseTypeReference<Result<Integer>>() {
                });
		if(!result.getSuccess()){
			log.error("同步修改角色同步到工作流返回异常结果"+result);
			throw new BaseException(result.getCode(),result.getMessage());
			
		}
		log.info("同步修改角色同步到工作流返回结果"+JsonUtils.objectToJson(result));
		

	}
    
    /**
     * 获取头部参数
     *
     * @return 头部参数
     */
    public static Map<String, String> getHeaderParams(Long tenandId,Long userId,String realname) {
        Map<String, String> result = new HashMap<>();
        result.put(HeaderConstant.HEADER_USER_ID, userId.toString());
        result.put(HeaderConstant.HEADER_TENANT_ID, tenandId.toString());
        result.put(HeaderConstant.HEADER_REAL_NAME, realname);
        result.put(HeaderConstant.HEADER_APP_TYPE, "pc");
        return result;
    }
    
    /**
     * 用户离职
     * @param userIds
     * @throws BaseException
     */
    public void doDimission(List<Long> userIds)throws BaseException{
    	if(BooleanUtils.isEmpty(userIds)){
    		return ;
    	}
    	 // 修改用户和组的关系
        Map<String, Object> methodParams = new HashMap<String,Object>();
        methodParams.put("userIds", JsonUtils.objectToJson(userIds));
        methodParams.put("deleteGroupIds", JsonUtils.objectToJson(ExamineGroupEnum.getAllGroupCodes()));
        Result<Integer> result = HttpUtils.post(WorkflowUrlConstant.WORK_FLOW_GROUP_USERS_FOR_DIMISSION, methodParams,
                new BaseTypeReference<Result<Integer>>() {
                });
        log.info("通知工作量返回结果 ",result);
        
    }
    
    
    
    private List<String> getAddResourceCodes(List<String> oldResourceCodes, List<String> newResourceCodes){
    	if(BooleanUtils.isEmpty(oldResourceCodes)){
        	return newResourceCodes;
        }
    	List<String> list = new ArrayList<String>();
    	for(String code : newResourceCodes){
    		if(!oldResourceCodes.contains(code)){
    			list.add(code);
    		}
    	}
    	return list;
    }
    
    private List<String> getDeleteResourceCodes(List<String> oldResourceCodes, List<String> newResourceCodes){
    	if(BooleanUtils.isEmpty(newResourceCodes)){
        	return oldResourceCodes;
        }
    	
    	List<String> list = new ArrayList<String>();
    	for(String code : oldResourceCodes){
    		if(!newResourceCodes.contains(code)){
    			list.add(code);
    		}
    	}
    	return list;
    }
    
    
    /**
     * 修改组和用户的关系
     * @param userId
     * @param newResourceCodes
     * @param deleteResourceCodes
     */
    private void updateGroupUserIds(Long userId,List<String> newResourceCodes,List<String> deleteResourceCodes)throws BaseException{
    	if(BooleanUtils.isEmpty(newResourceCodes) && BooleanUtils.isEmpty(deleteResourceCodes)){
        	return;
        }
    	
    	List<String> addGroupCodes = new ArrayList<String>();
    	if(!BooleanUtils.isEmpty(newResourceCodes)){
    		for(String resCode : newResourceCodes){
    			String groupCode = ExamineGroupEnum.getGroupCode(resCode);
    			if(BooleanUtils.isBlank(groupCode)){
    				continue;
    			}
    			addGroupCodes.add(groupCode);
    		}
    	}
    	List<String> deleteGroupCodes = new ArrayList<String>();
        if(!BooleanUtils.isEmpty(deleteResourceCodes)){
        	for(String resCode : deleteResourceCodes){
    			String groupCode = ExamineGroupEnum.getGroupCode(resCode);
    			if(BooleanUtils.isBlank(groupCode)){
    				continue;
    			}
    			deleteGroupCodes.add(groupCode);
    		}
    	}
        Map<String, Object> methodParams = new HashMap<String,Object>();
        methodParams.put("userId", userId);
        methodParams.put("addGroupIds", JsonUtils.objectToJson(addGroupCodes));
        methodParams.put("deleteGroupIds", JsonUtils.objectToJson(deleteGroupCodes));
        Result<Integer> result = HttpUtils.post(WorkflowUrlConstant.WORK_FLOW_GROUP_USER, methodParams,
                new BaseTypeReference<Result<Integer>>() {
                });
    	log.info("通知工作量返回结果 ",result);
    	
    }
    
    
    
    
    private List<GroupUserReqDto> getAddUserResDto(List<UserResDto> oldUserResDtos,List<UserResDto> newUserResDtos){
    	if(BooleanUtils.isEmpty(oldUserResDtos)){
    		return getGroupUserReqDtos(newUserResDtos);
    	}
    	List<UserResDto> addUserResDtos = new ArrayList<UserResDto>();
    	if(BooleanUtils.isEmpty(newUserResDtos)){
    		return getGroupUserReqDtos(addUserResDtos);
    	}
        for(UserResDto newDto : newUserResDtos){
        	boolean isExist = false;
        	for(UserResDto oldDto : oldUserResDtos){
            	if(newDto.getUserId().equals(oldDto.getUserId()) &&
            			newDto.getResCode().equals(oldDto.getResCode())){
            		isExist = true;
            	}
            }
        	
        	if(!isExist){
        		addUserResDtos.add(newDto);
        	}
        }
    	
    	return getGroupUserReqDtos(addUserResDtos);
    }
    
    private List<GroupUserReqDto> getDeleteUserResDto(List<UserResDto> oldUserResDtos,List<UserResDto> newUserResDtos){
    	if(BooleanUtils.isEmpty(newUserResDtos)){
    		return getGroupUserReqDtos(oldUserResDtos);
    	}
    	if(BooleanUtils.isEmpty(oldUserResDtos)){
    		return getGroupUserReqDtos(null);
    	}
    	List<UserResDto> deleteUserResDtos = new ArrayList<UserResDto>();
    	for(UserResDto  oldDto : oldUserResDtos){
        	boolean isExist = false;
        	for(UserResDto newDto :  newUserResDtos){
            	if(newDto.getUserId().equals(oldDto.getUserId()) &&
            			newDto.getResCode().equals(oldDto.getResCode())){
            		isExist = true;
            	}
            }
        	
        	if(!isExist){
        		deleteUserResDtos.add(oldDto);
        	}
        }
    	return getGroupUserReqDtos(deleteUserResDtos);
    }
    
    private List<GroupUserReqDto> getGroupUserReqDtos(List<UserResDto> userResDtos){
    	List<GroupUserReqDto> allGroupUsers = new ArrayList<GroupUserReqDto>();
		if (!BooleanUtils.isEmpty(userResDtos)) {
			for (UserResDto resDto : userResDtos) {
				GroupUserReqDto dto = new GroupUserReqDto();
				dto.setUserId(resDto.getUserId());
				dto.setGroupId(ExamineGroupEnum.getGroupCode(resDto.getResCode()));
				if (BooleanUtils.isBlank(dto.getGroupId())) {
					continue;
				}
				allGroupUsers.add(dto);
			}
		}
		return allGroupUsers;
    }
    
    /**
     * 修改角色后通知工作流
     */
	public void updateRole( List<UserResDto> oldUserResDtos) throws BaseException {
		log.info("修改角色通知工作流");
		List<UserResDto> newUserResDtos = resourceMapper.getUserResDtos(ExamineGroupEnum.getAllResourceCodeAll());
		final List<GroupUserReqDto> addGroupUsers = getAddUserResDto(oldUserResDtos,newUserResDtos);
		final List<GroupUserReqDto> deleteGroupUsers = getDeleteUserResDto(oldUserResDtos,newUserResDtos);

		// 构建请求参数对象
		Map<String, Object> methodParams = new HashMap<String, Object>();
		if (!BooleanUtils.isEmpty(addGroupUsers)) {
			methodParams.put("addGroupUsers", JsonUtils.objectToJson(addGroupUsers));
		}
		if (!BooleanUtils.isEmpty(deleteGroupUsers)) {
			methodParams.put("deleteGroupUsers", JsonUtils.objectToJson(deleteGroupUsers));
		}
		
		if(BooleanUtils.isEmpty(addGroupUsers) && BooleanUtils.isEmpty(deleteGroupUsers)){
			return;
		}
		
//		final RequestCommonParams requestParams = RequestCommonParams.newDefault(methodParams);
//		Map<String, String> headerParams = requestParams.getHeaderParams();
//		headerParams.putAll(getHeaderParams(this.getHeaderTenantId(), this.getHeaderUserId(), this.getRealName()));
//		ThreadUtils.execute(() -> {
//			try {
//				String result = com.yundao.core.utils.HttpUtils.post(WorkflowUrlConstant.WORK_FLOW_GROUP_USERS_ADD_AND_DELETE, requestParams);
//				log.error("修改角色同步到工作流返回结果", result);
//			}
//			catch (Exception e) {
//				// TODO 短信或者邮寄通知管理员
//				log.error("通知工作流返回结果 ", e);
//			}
//		});
		
		log.info("修改角色同步到工作流请求参数："+methodParams);
		Result<Integer> result = HttpUtils.post(WorkflowUrlConstant.WORK_FLOW_GROUP_USERS_ADD_AND_DELETE, methodParams,
                new BaseTypeReference<Result<Integer>>() {
                });
		if(!result.getSuccess()){
			log.error("修改角色同步到工作流返回异常结果"+result);
			throw new BaseException(result.getCode(),result.getMessage());
			
		}
		log.info("修改角色同步到工作流返回结果"+JsonUtils.objectToJson(result));

	}
    
    
}
