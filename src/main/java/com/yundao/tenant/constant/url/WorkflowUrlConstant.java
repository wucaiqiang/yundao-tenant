package com.yundao.tenant.constant.url;

import com.yundao.core.utils.ConfigUtils;
import com.yundao.tenant.enums.UrlEnum;

/**
 * 调用 工作流URL地址常量
 *
 * @author jan
 * @create 2017-08-14 PM4:11
 **/
public interface WorkflowUrlConstant {

    /**
     * HOST地址
     */
    String BASE_URL = ConfigUtils.getValue(UrlEnum.WORKFLOW_URL.getKey());

    /**
     * 获取所有任何或待办任务
     */
    String WORK_FLOW_GETS = BASE_URL + "/task/single/gets";
    /**
     * 获取我的全部待办任务
     */
    String WORK_FLOW_GET_MY_TO_DO = BASE_URL + "/task/user/get_all";

    /**
     * 获取指定流程任务
     */
    //String WORK_FLOW_GET_BY_RESOURCE = BASE_URL + "/task/gets_by_processDefineKey";

    /**
     * 审核工作流
     */
    String WORK_FLOW_DO = BASE_URL + "/task/complete";

    /**
     * 启动流程
     */
    String WORK_FLOW_START = BASE_URL + "/process/start";

    /**
     * 修改工作流角色
     */
    //String WORK_FLOW_EDIT_MEMBER = BASE_URL + "/process/update_id_user";
    
    /**
     * 修改用户时通知工作流
     */
    String WORK_FLOW_GROUP_USER = BASE_URL + "/group/user";
    
    
    /**
     * 修改角色时通知用户
     */
    String WORK_FLOW_GROUP_USERS = BASE_URL + "/group/users";
    
    /**
     * 修改角色时通知用户(添加和删除)
     */
    String WORK_FLOW_GROUP_USERS_ADD_AND_DELETE = BASE_URL + "/group/users/add_and_delete";
    
    /**
     * 用户离职通知工作流
     */
    String WORK_FLOW_GROUP_USERS_FOR_DIMISSION = BASE_URL + "/group/user/dimission";
    
    /**
     * 获取单个业务的审核记录
     */
    String WORK_FLOW_GET_AUDIT_LIST =  BASE_URL + "/task/get/all/detail";
    
    
    /**
     * 分页查询待办
     */
    String WORK_FLOW_GET_AUDIT_LIST_PAGE = BASE_URL + "/task/audit/get_page";
    String WORK_FLOW_GET_DONE_PAGE = BASE_URL + "/task/user/done/get_all";
    
    /**
     * 通过taskId获取业务key
     */
    String WORK_FLOW_GET_BUSINESSKEY =  BASE_URL + "/task/get_businessKey";
    
    /**
     * 获取带审批任务的操作
     */
    String  GET_AUDIT_TASK_ATION_AND_APPLY =  BASE_URL + "/task/audit/get_action_and_apply_info";
    
    
    /**
     * 部署公共流程
     */
    String WORK_FLOW_DEPLOY_COMMON =  BASE_URL + "/deploy/common/resource";
}
