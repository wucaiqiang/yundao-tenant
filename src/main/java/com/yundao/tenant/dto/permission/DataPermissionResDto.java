package com.yundao.tenant.dto.permission;

/**
 * 数据对象权限
 *
 * @author jan
 * @create 2017-08-09 PM5:11
 **/
public class DataPermissionResDto {

    /**
     * 数据对象编码
     */
    private String dataObjectCode;

    /**
     * 是否有查询权限(1:有; 0:没有)
     */
    private Boolean isReadPermission;

    /**
     * 是否有删除权限(1:有; 0:没有)
     */
    private Boolean isDeletePermission;

    /**
     * 是否有修改权限(1:有; 0:没有)
     */
    private Boolean isEditPermission;

    public String getDataObjectCode() {
        return dataObjectCode;
    }

    public void setDataObjectCode(String dataObjectCode) {
        this.dataObjectCode = dataObjectCode;
    }

    public Boolean getReadPermission() {
        return isReadPermission;
    }

    public void setReadPermission(Boolean readPermission) {
        isReadPermission = readPermission;
    }

    public Boolean getDeletePermission() {
        return isDeletePermission;
    }

    public void setDeletePermission(Boolean deletePermission) {
        isDeletePermission = deletePermission;
    }

    public Boolean getEditPermission() {
        return isEditPermission;
    }

    public void setEditPermission(Boolean editPermission) {
        isEditPermission = editPermission;
    }
}
