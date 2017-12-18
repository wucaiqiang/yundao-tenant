package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseWorkflowBusinessRel extends BaseModel implements Serializable {
    /**
	 * 对象id
	 */
    private Long objectId;

    /**
	 * 业务流水号
	 */
    private String businessNo;

    /**
	 * 类型，1：预约，2：报单
	 */
    private String type;


    /**
     * 是否已完成，1：是，0：否
     */
    private Integer isComplete;
    /**
	 * 初始参数
	 */
    private String initParam;

    private static final long serialVersionUID = 1L;

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
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
}