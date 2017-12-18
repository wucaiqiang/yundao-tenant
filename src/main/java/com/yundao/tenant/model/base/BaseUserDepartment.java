package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseUserDepartment extends BaseModel implements Serializable {
    /**
	 * 用户账号id
	 */
    private Long userAccountId;

    /**
	 * 部门id
	 */
    private Long departmentId;

    private static final long serialVersionUID = 1L;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}