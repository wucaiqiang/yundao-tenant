package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseUserStaff extends BaseModel implements Serializable {
    /**
	 * 用户账号id
	 */
    private Long userAccountId;

    /**
	 * 是否离职，0：否；1：是
	 */
    private Integer isDimission;

    /**
	 * 工号
	 */
    private String jobNumber;

    /**
	 * 汇报上级id
	 */
    private Long leaderId;

    private static final long serialVersionUID = 1L;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Integer getIsDimission() {
        return isDimission;
    }

    public void setIsDimission(Integer isDimission) {
        this.isDimission = isDimission;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }
}