package com.yundao.tenant.dto.workflow;

/**
 * 工作流启动返回数据dto
 *
 * @author jan
 * @create 2017-08-27 PM1:55
 **/
public class ProcessStartResDTO {

    /**
     * 业务流水号
     */
    private String businessKey;
    /**
     * 下个待办任务Id
     */
    private String taskId;


    public String getBusinessKey() {

        return businessKey;
    }

    public void setBusinessKey(String businessKey) {

        this.businessKey = businessKey;
    }

    public String getTaskId() {

        return taskId;
    }

    public void setTaskId(String taskId) {

        this.taskId = taskId;
    }

}
