package com.yundao.tenant.dto.workflow;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 审核任务详细信息
 * 
 * @author 欧阳利
 * 2017年9月2日
 */
public class AuditDetailResDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务id(如果是开始节点，就为null)")
    private String id;

    /**
     * 任务名称
     */
    @ApiModelProperty("任务名称")
    private String name;

    /**
     * 任务指定处理人
     */
    @ApiModelProperty("任务指定处理人")
    private String assignee;

    /**
     * 操作值 例如 1：通过 2：驳回 3：取消 4：重新提交
     */
    @ApiModelProperty("操作值 例如 1：通过 2：驳回 3：取消 4：重新提交")
    private Integer actionValue;
    
    /**
     * 操作名称 例如 1：通过 2：驳回 3：取消 4：重新提交
     */
    @ApiModelProperty("操作名称 例如 1：通过 2：驳回 3：取消 4：重新提交")
    private String actionText;
    
    /**
     * 操作人人ID
     */
    @ApiModelProperty("操作人人ID")
    private Long actionUserId;
    
    /**
     * 操作人名称
     */
    @ApiModelProperty("操作人名称")
    private String actionUserName;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String comment;
    /**
     * 任务开启时间
     */
    @ApiModelProperty("任务开启时间")
    private Date startTime;
    /**
     * 任务处理完成时间
     */
    @ApiModelProperty("任务处理完成时间")
    private Date endTime;
    /**
     * 流程实例id
     */
    @ApiModelProperty("流程实例id")
    private String processInstanceId;

    /**
     * 执行实例id
     */
    @ApiModelProperty("执行实例id")
    private String executionId;

    /**
     * 流程定义id
     */
    @ApiModelProperty(" 流程定义id")
    private String processDefinitionId;

    /**
     * 业务值
     */
    @ApiModelProperty("业务值")
    private String businessKey;

    /**
     * 任务类型(开始事件：startEvent, 用户任务：userTask)
     */
    @ApiModelProperty("任务类型(开始事件：startEvent, 用户任务：userTask)")
    private String type;
    
    /**
     * 是否历史(false：待办， true：历史)
     */
    @ApiModelProperty("是否历史(false：待办， true：历史)")
    private Boolean history;


	public String getActionText() {
		return actionText;
	}

	public void setActionText(String actionText) {
		this.actionText = actionText;
	}

	public String getActionUserName() {
		return actionUserName;
	}

	public void setActionUserName(String actionUserName) {
		this.actionUserName = actionUserName;
	}

	public Boolean getHistory() {
		return history;
	}

	public void setHistory(Boolean history) {
		this.history = history;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public Integer getActionValue() {
		return actionValue;
	}

	public void setActionValue(Integer actionValue) {
		this.actionValue = actionValue;
	}

	public String getComment() {
	
		return comment;
	}

	public void setComment(String comment) {
	
		this.comment = comment;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }


    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

	public Date getStartTime() {
	
		return startTime;
	}

	public void setStartTime(Date startTime) {
	
		this.startTime = startTime;
	}

	public Date getEndTime() {
	
		return endTime;
	}

	public void setEndTime(Date endTime) {
	
		this.endTime = endTime;
	}

	public Long getActionUserId() {
		return actionUserId;
	}

	public void setActionUserId(Long actionUserId) {
		this.actionUserId = actionUserId;
	}




}
