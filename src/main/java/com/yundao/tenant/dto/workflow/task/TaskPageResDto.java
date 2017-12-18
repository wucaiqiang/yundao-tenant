package com.yundao.tenant.dto.workflow.task;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户池分页数据
 *
 * @author jan
 * @create 2017-08-14 AM8:56
 **/
public class TaskPageResDto {

	@ApiModelProperty(value = "标题")
	private String title;
	
	@ApiModelProperty(value = "内容列表")
	private List<ContentDto> contentList;
	
	@ApiModelProperty(value = "流程最新状态")
	private Integer auditStatus;
	@ApiModelProperty(value = "任务审核动作")
	private Integer actionValue;
	
    @ApiModelProperty(value = "任务id")
    private String taskId;

    @ApiModelProperty(value = "任务名称")
    private String taskName;
    
    @ApiModelProperty(value = "任务定义key")
    private String taskDefinitionKey;

    @ApiModelProperty(value = "任务创建时间")
    private Date createTime;
    @ApiModelProperty(value = "任务审批时间")
    private Date endTime;

    @ApiModelProperty(value = "申请人Id")
    private Long applyUserId;
    
    @ApiModelProperty(value = "申请人名称")
    private String applyUserRealName;
    
    @ApiModelProperty(value = "流程启动时间")
    private Date applyTime;
    
    @ApiModelProperty(value = "提交人名称")
    private Long submitUserId;
    
    @ApiModelProperty(value = "业务id")
    private String businesskey;
    
    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;
    
    @ApiModelProperty(value = "流程定义id")
    private String processDefinitionId;  
    
    @ApiModelProperty(value = "执行实例id")
    private String executionId;
    
    @ApiModelProperty(value = "父任务id")
    private String parentTaskId;
    
    @ApiModelProperty(value = "应许操作值")
    private List<ActionDto> actionDtos;

    @ApiModelProperty(value = "对象id")
    private Long objectId;

    @ApiModelProperty(value = "类型 预约 报单等")
    private String type;

    @ApiModelProperty(value = "是否完成")
    private Integer isComplete;

    @ApiModelProperty(value = "初始参数")
    private String initParam;


	public String getTitle() {
	
		return title;
	}

	public void setTitle(String title) {
	
		this.title = title;
	}

	public List<ContentDto> getContentList() {
	
		return contentList;
	}

	public void setContentList(List<ContentDto> contentList) {
	
		this.contentList = contentList;
	}

	public Integer getAuditStatus() {
	
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
	
		this.auditStatus = auditStatus;
	}

	public Long getObjectId() {
	
		return objectId;
	}

	public void setObjectId(Long objectId) {
	
		this.objectId = objectId;
	}

	public String getType() {
	
		return type;
	}

	public void setType(String type) {
	
		this.type = type;
	}

	public Integer getIsComplete() {
	
		return isComplete;
	}

	public void setIsComplete(Integer isComplete) {
	
		this.isComplete = isComplete;
	}

	public String getInitParam() {
	
		return initParam;
	}

	public void setInitParam(String initParam) {
	
		this.initParam = initParam;
	}



	public String getApplyUserRealName() {
	
		return applyUserRealName;
	}

	public void setApplyUserRealName(String applyUserRealName) {
	
		this.applyUserRealName = applyUserRealName;
	}

	public Long getApplyUserId() {
	
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
	
		this.applyUserId = applyUserId;
	}

	public void setSubmitUserId(Long submitUserId) {
	
		this.submitUserId = submitUserId;
	}

	public Date getApplyTime() {
	
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
	
		this.applyTime = applyTime;
	}

	public String getExecutionId() {
	
		return executionId;
	}

	public void setExecutionId(String executionId) {
	
		this.executionId = executionId;
	}

	public String getTaskDefinitionKey() {
	
		return taskDefinitionKey;
	}

	public void setTaskDefinitionKey(String taskDefinitionKey) {
	
		this.taskDefinitionKey = taskDefinitionKey;
	}



	public List<ActionDto> getActionDtos() {
	
		return actionDtos;
	}

	public void setActionDtos(List<ActionDto> actionDtos) {
	
		this.actionDtos = actionDtos;
	}

	public String getTaskId() {
	
		return taskId;
	}

	public void setTaskId(String taskId) {
	
		this.taskId = taskId;
	}

	public String getTaskName() {
	
		return taskName;
	}

	public void setTaskName(String taskName) {
	
		this.taskName = taskName;
	}

	public Date getCreateTime() {
	
		return createTime;
	}

	public void setCreateTime(Date createTime) {
	
		this.createTime = createTime;
	}

	public String getBusinesskey() {
	
		return businesskey;
	}

	public void setBusinesskey(String businesskey) {
	
		this.businesskey = businesskey;
	}

	public String getProcessInstanceId() {
	
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
	
		this.processInstanceId = processInstanceId;
	}



	public String getProcessDefinitionId() {
	
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
	
		this.processDefinitionId = processDefinitionId;
	}

	public String getParentTaskId() {
	
		return parentTaskId;
	}

	public void setParentTaskId(String parentTaskId) {
	
		this.parentTaskId = parentTaskId;
	}

	public Long getSubmitUserId() {
	
		return submitUserId;
	}

	public Date getEndTime() {
	
		return endTime;
	}

	public void setEndTime(Date endTime) {
	
		this.endTime = endTime;
	}

	public Integer getActionValue() {
	
		return actionValue;
	}

	public void setActionValue(Integer actionValue) {
	
		this.actionValue = actionValue;
	}
    
}
