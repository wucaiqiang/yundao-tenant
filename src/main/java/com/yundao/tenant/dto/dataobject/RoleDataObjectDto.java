package com.yundao.tenant.dto.dataobject;

/**
 * 角色对应的数据对象权限
 *
 * @author jan
 * @create 2017-07-17 PM7:48
 **/
public class RoleDataObjectDto {

    /**
     * id
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 角色id
     */
    private Long roleId;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
