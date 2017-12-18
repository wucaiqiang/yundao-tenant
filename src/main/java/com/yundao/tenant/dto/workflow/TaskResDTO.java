package com.yundao.tenant.dto.workflow;

/**
 * 任务dto
 *
 * @author jan
 * @create 2017-07-28 AM10:45
 **/
public class TaskResDTO {

    /**
     * 任务id
     */
    private String id;


    /**
     * 业务值
     */
    private String businessKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
}

