package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseFieldRole extends BaseModel implements Serializable {
    /**
	 * 业务对象字段id
	 */
    private Long objectFieldId;

    /**
	 * 角色id（0：针对所有角色）
	 */
    private Long roleId;

    /**
	 * 是否角色只读，0：否，1：是
	 */
    private Integer isRoleReadonly;

    /**
	 * 是否角色访问，0：否，1：是
	 */
    private Integer isRoleAccess;

    private static final long serialVersionUID = 1L;

    public Long getObjectFieldId() {
        return objectFieldId;
    }

    public void setObjectFieldId(Long objectFieldId) {
        this.objectFieldId = objectFieldId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getIsRoleReadonly() {
        return isRoleReadonly;
    }

    public void setIsRoleReadonly(Integer isRoleReadonly) {
        this.isRoleReadonly = isRoleReadonly;
    }

    public Integer getIsRoleAccess() {
        return isRoleAccess;
    }

    public void setIsRoleAccess(Integer isRoleAccess) {
        this.isRoleAccess = isRoleAccess;
    }
}