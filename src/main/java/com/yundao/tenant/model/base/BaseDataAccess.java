package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseDataAccess extends BaseModel implements Serializable {
    /**
	 * 角色id
	 */
    private Long roleId;

    /**
	 * 业务对象id
	 */
    private Long businessObjectId;

    /**
	 * 删除权限，0：无权限，1：本人，2：本人及下属，3：本级，4：本级及下属，5：全部
	 */
    private Integer deletePermission;

    /**
	 * 编辑权限，0：无权限，1：本人，2：本人及下属，3：本级，4：本级及下属，5：全部
	 */
    private Integer editPermission;

    /**
	 * 读取权限，0：无权限，1：本人，2：本人及下属，3：本级，4：本级及下属，5：全部
	 */
    private Integer readPermission;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getBusinessObjectId() {
        return businessObjectId;
    }

    public void setBusinessObjectId(Long businessObjectId) {
        this.businessObjectId = businessObjectId;
    }

    public Integer getDeletePermission() {
        return deletePermission;
    }

    public void setDeletePermission(Integer deletePermission) {
        this.deletePermission = deletePermission;
    }

    public Integer getEditPermission() {
        return editPermission;
    }

    public void setEditPermission(Integer editPermission) {
        this.editPermission = editPermission;
    }

    public Integer getReadPermission() {
        return readPermission;
    }

    public void setReadPermission(Integer readPermission) {
        this.readPermission = readPermission;
    }
}