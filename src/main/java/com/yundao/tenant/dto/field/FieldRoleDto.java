package com.yundao.tenant.dto.field;

/**
 * 业务字段角色权限
 *
 * @author jan
 * @create 2017-07-19 PM1:40
 **/
public class FieldRoleDto {

    private Long id;

    /**
     * 业务对象id
     */
    private Long businessObjectId;

    /**
     * 业务对象编码
     */
    private Long businessObjectCode;

    /**
     * 业务对象字段id
     */
    private Long objectFieldId;

    /**
     * 业务对象字段编码
     */
    private Long objectFieldCode;

    /**
     * 角色id
     */
    private Long roleId;

    public Long getBusinessObjectId() {
        return businessObjectId;
    }

    public void setBusinessObjectId(Long businessObjectId) {
        this.businessObjectId = businessObjectId;
    }


    public Long getObjectFieldId() {
        return objectFieldId;
    }

    public void setObjectFieldId(Long objectFieldId) {
        this.objectFieldId = objectFieldId;
    }

    public Long getObjectFieldCode() {
        return objectFieldCode;
    }

    public void setObjectFieldCode(Long objectFieldCode) {
        this.objectFieldCode = objectFieldCode;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getBusinessObjectCode() {
        return businessObjectCode;
    }

    public void setBusinessObjectCode(Long businessObjectCode) {
        this.businessObjectCode = businessObjectCode;
    }
}
