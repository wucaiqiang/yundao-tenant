package com.yundao.tenant.dto.workflow;

/**
 * 工作流审核返回数据dto
 *
 * @author jan
 * @create 2017-08-27 PM2:09
 **/
public class TaskCompleteResDTO {

    /**
     * 任务id
     */
    private String taskId;
    /**
     * 流程是否已经结束
     */
    private Boolean processIsEnd;

    private String businessKey;

    public String getTaskId() {

        return taskId;
    }

    public void setTaskId(String taskId) {

        this.taskId = taskId;
    }

    public Boolean getProcessIsEnd() {

        return processIsEnd;
    }

    public void setProcessIsEnd(Boolean processIsEnd) {

        this.processIsEnd = processIsEnd;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
}
