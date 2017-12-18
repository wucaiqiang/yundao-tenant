package com.yundao.tenant.dto.workflow.task;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 任务返回传输类
 *
 * @author wupengfei wupf86@126.com
 */
public class TaskInfoResDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务id(如果是开始节点，就为null)
     */
    private String id;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务指定处理人
     */
    private String assignee;

    /**
     * 通过值 例如 1：通过 2：驳回 3：取消 4：重新提交
     */
    private Integer actionValue;
    /**
     * 处理人ID
     */
    private String actionUserId;
    /**
     * 备注
     */
    private String comment;
    /**
     * 任务开启时间
     */
    private Date startTime;
    /**
     * 任务处理完成时间
     */
    private Date endTime;
    /**
     * 流程实例id
     */
    private String processInstanceId;

    /**
     * 执行实例id
     */
    private String executionId;

    /**
     * 流程定义id
     */
    private String processDefinitionId;

    /**
     * 业务值
     */
    private String businessKey;

    /**
     * 任务描述
     */
    private String description;
    ////////////////////////////////////////////////////////
    /**
     * 任务类型(开始事件：startEvent, 用户任务：userTask)
     */
    private String type;
    
    /**
     * 是否历史(false：待办， true：历史)
     */
    private Boolean history;
    /**
     * 流程启动申请人
     */
    private Long applyUserId;
    /**
     * 流程启动时间
     */
    private Date applyTime;
    

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

	public String getDescription() {
	
		return description;
	}

	public void setDescription(String description) {
	
		this.description = description;
	}

	public String getActionUserId() {
		return actionUserId;
	}

	public void setActionUserId(String actionUserId) {
		this.actionUserId = actionUserId;
	}

	public Long getApplyUserId() {
	
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
	
		this.applyUserId = applyUserId;
	}

	public Date getApplyTime() {
	
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
	
		this.applyTime = applyTime;
	}


}
