package com.yundao.tenant.dto.permission;

import java.io.Serializable;

/**
 * 用户数据权限dto
 *
 * @author jan
 * @create 2017-08-04 PM9:16
 **/
public class UserPermissionDto implements Serializable {

    static final long serialVersionUID = -1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 数据对象编码
     */
    private String dataObjectCode;

    /**
     * 查看权限  0：无权限，10：我的，20：团队，30：部门，40：全部
     */
    private Integer readPermission;

    /**
     * 修改权限  0：无权限，10：我的，20：团队，30：部门，40：全部
     */
    private Integer editPermission;

    /**
     * 删除权限 0：无权限，10：我的，20：团队，30：部门，40：全部
     */
    private Integer deletePermission;

    public Integer getReadPermission() {
        return readPermission;
    }

    public void setReadPermission(Integer readPermission) {
        this.readPermission = readPermission;
    }

    public Integer getEditPermission() {
        return editPermission;
    }

    public void setEditPermission(Integer editPermission) {
        this.editPermission = editPermission;
    }

    public Integer getDeletePermission() {
        return deletePermission;
    }

    public void setDeletePermission(Integer deletePermission) {
        this.deletePermission = deletePermission;
    }

    public String getDataObjectCode() {
        return dataObjectCode;
    }

    public void setDataObjectCode(String dataObjectCode) {
        this.dataObjectCode = dataObjectCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
