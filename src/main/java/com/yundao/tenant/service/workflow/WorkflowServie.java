package com.yundao.tenant.service.workflow;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.dto.workflow.ProcessStartResDTO;
import com.yundao.tenant.dto.workflow.TaskCompleteResDTO;
import com.yundao.tenant.dto.workflow.TaskResDTO;
import com.yundao.tenant.dto.workflow.WorkFlowAuditRecordResDto;

/**
 * 工作流服务接口
 *
 * @author jan
 * @create 2017-08-27 PM1:35
 **/
public interface WorkflowServie {

	/**
	 * 初始化工作流
	 * initCommonWorkFlow:
	 * @author: 欧阳利
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	Result<Boolean> initCommonWorkFlow()throws BaseException;
	
	
    /**
     * 获取待办任务id
     * @param objectId
     * @param type
     * @return
     * @throws BaseException
     */
	Result<String> getTODOTaskId(Long objectId,String type,Boolean isCancel) throws BaseException;
	
	
    /**
     * 启动工作流
     *
     * @param objectId         对象id
     * @param processDefineKey 流程定义key，对应 ProcessDefineKeyEnum 枚举文件
     * @param businessTypeCode 业务类型CODE，引用BusinessTypeCode常量文件
     */
    ProcessStartResDTO start(Long objectId, String processDefineKey, String businessTypeCode) throws BaseException;

    /**
     * 审核
     *
     * @param taskId 任务id
     * @param action 动作值 ，例如：1：通过  2：驳回 3：取消 4：重新提交 枚举：WorkflowActionEnum
     */
    TaskCompleteResDTO complete(String taskId, Integer action) throws BaseException;

    
    /**
     * 获取待办任务id  并处理
     *
     * @param taskId 任务id
     * @param action 动作值 ，例如：1：通过  2：驳回 3：取消 4：重新提交 枚举：WorkflowActionEnum
     */
    Result<TaskCompleteResDTO> getTODOTaskIdAndcomplete(Long objectId,String type,Boolean isCancel, Integer action, String comment) throws BaseException;
    
    
    
    
    /**
     * 审核
     *
     * @param taskId  任务id
     * @param action  动作值 ，1：通过  2：驳回 3：取消 4：重新提交 枚举：WorkflowActionEnum
     * @param comment 原因，评论，备注等
     */
    TaskCompleteResDTO complete(String taskId, Integer action, String comment) throws BaseException;

    /**
     * 获取待办任务列表
     *
     * @param businessKeys 多个业务编号
     */
    List<TaskResDTO> getTodoTaskIds(String businessKeys,Boolean isCancel) throws BaseException;
    /**
     * 获取我的全部待办任务
     * getMyTodoTasks:
     * @author: wucq
     * @return
     * @throws BaseException
     * @description:
     */
    List<TaskResDTO> getMyTodoTasks() throws BaseException;
    
    /**
     * 获取单个任务的待办
     * @param businessKey
     * @return
     * @throws BaseException
     */
    public TaskResDTO getSingleTodoTaskId(String businessKey,Boolean isCancel) throws BaseException;
    
    /**
     * 查询单个业务的审核记录
     * @param objectId  业务id
     * @param type  业务类型
     * @return
     * @throws BaseException
     */
    public List<AuditDetailResDTO> getWorkflowList(Long objectId,String type) throws BaseException;
    
    /**
     * 查询单个业务的审核记录
     * @param businessNo  业务no
     * @return
     * @throws BaseException
     */
    public List<AuditDetailResDTO> getWorkflowList(String businessNo) throws BaseException;

    /**
     * 获取任务的审批历史
     * @param id
     * @param code
     * @return
     */
    Result<List<AuditDetailResDTO>> getAuditRecord(Long id, String code) throws BaseException;
    
    
	/**
	 * 多次流程审批记录
	 * getAuditDetail:
	 * @author: 欧阳利
	 * @param noticeId
	 * @return
	 * @throws BaseException
	 * @description:
	 */
    public Result<List<WorkFlowAuditRecordResDto>> getAuditDetail(Long objectId,String type)throws BaseException;
}
