package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseDataObjectAccess extends BaseModel implements Serializable {
    /**
	 * 数据对象id
	 */
    private Long dataObjectId;

    /**
	 * 角色id
	 */
    private Long roleId;

    /**
	 * 读取权限，0：无权限，10：我的，20：团队，30：部门，40：全部
	 */
    private Integer readPermission;

    /**
	 * 删除权限，0：无权限，10：我的，20：团队，30：部门，40：全部
	 */
    private Integer deletePermission;

    /**
	 * 编辑权限，0：无权限，10：我的，20：团队，30：部门，40：全部
	 */
    private Integer editPermission;

    private static final long serialVersionUID = 1L;

    public Long getDataObjectId() {
        return dataObjectId;
    }

    public void setDataObjectId(Long dataObjectId) {
        this.dataObjectId = dataObjectId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getReadPermission() {
        return readPermission;
    }

    public void setReadPermission(Integer readPermission) {
        this.readPermission = readPermission;
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
}