package com.yundao.tenant.dto.workflow;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class TaskActionResDto {

	@ApiModelProperty(value = "任务id")
	private String taskId;
	
    @ApiModelProperty(value = "申请人Id")
    private Long applyUserId;
    
    @ApiModelProperty(value = "申请人名称")
    private String applyUserRealName;
    
    @ApiModelProperty(value = "流程启动时间")
    private Date applyTime;
    
    @ApiModelProperty(value = "操作集合")
    private List<Integer> actions;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Long getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getApplyUserRealName() {
		return applyUserRealName;
	}

	public void setApplyUserRealName(String applyUserRealName) {
		this.applyUserRealName = applyUserRealName;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public List<Integer> getActions() {
		return actions;
	}

	public void setActions(List<Integer> actions) {
		this.actions = actions;
	}
    
    
    
}
