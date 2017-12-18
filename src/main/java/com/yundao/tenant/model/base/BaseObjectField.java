package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseObjectField extends BaseModel implements Serializable {
    /**
	 * 字段id
	 */
    private Long fieldId;

    /**
	 * 业务对象id
	 */
    private Long businessObjectId;

    /**
	 * 描述
	 */
    private String description;

    /**
	 * 字段类型id
	 */
    private Long fieldTypeId;

    /**
	 * 是否固定显示位置，0：否，1：是
	 */
    private Integer isFix;

    /**
	 * 显示方式，0：隐藏，1：显示，2：强制显示
	 */
    private Integer displayType;

    /**
	 * 是否必选，0：否，1： 是
	 */
    private Integer isMandatory;

    /**
	 * 是否基本属性，0：否，1： 是
	 */
    private Integer isBasic;

    /**
	 * 是否共用，0：否，1：是
	 */
    private Integer isShare;

    /**
	 * 是否系统标准字段，0：否，1：是
	 */
    private Integer isSystem;

    /**
	 * 是否可搜索，0：否，1：是
	 */
    private Integer isSearch;

    /**
	 * 是否只读，0：否，1：是
	 */
    private Integer isReadonly;

    /**
	 * 是否初始化，0：否，1：是
	 */
    private Integer isInit;

    /**
	 * 是否能够修改 必填项
	 */
    private Integer canEditMandatory;

    /**
	 * 是否可修改 启用 项
	 */
    private Integer canEditEnabled;

    /**
	 * 权限，0：全部可见，1：部分可见
	 */
    private Integer access;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    private String name;

    private String code;

    private static final long serialVersionUID = 1L;

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Long getBusinessObjectId() {
        return businessObjectId;
    }

    public void setBusinessObjectId(Long businessObjectId) {
        this.businessObjectId = businessObjectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFieldTypeId() {
        return fieldTypeId;
    }

    public void setFieldTypeId(Long fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }

    public Integer getIsFix() {
        return isFix;
    }

    public void setIsFix(Integer isFix) {
        this.isFix = isFix;
    }

    public Integer getDisplayType() {
        return displayType;
    }

    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
    }

    public Integer getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Integer isMandatory) {
        this.isMandatory = isMandatory;
    }

    public Integer getIsBasic() {
        return isBasic;
    }

    public void setIsBasic(Integer isBasic) {
        this.isBasic = isBasic;
    }

    public Integer getIsShare() {
        return isShare;
    }

    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public Integer getIsSearch() {
        return isSearch;
    }

    public void setIsSearch(Integer isSearch) {
        this.isSearch = isSearch;
    }

    public Integer getIsReadonly() {
        return isReadonly;
    }

    public void setIsReadonly(Integer isReadonly) {
        this.isReadonly = isReadonly;
    }

    public Integer getIsInit() {
        return isInit;
    }

    public void setIsInit(Integer isInit) {
        this.isInit = isInit;
    }

    public Integer getCanEditMandatory() {
        return canEditMandatory;
    }

    public void setCanEditMandatory(Integer canEditMandatory) {
        this.canEditMandatory = canEditMandatory;
    }

    public Integer getCanEditEnabled() {
        return canEditEnabled;
    }

    public void setCanEditEnabled(Integer canEditEnabled) {
        this.canEditEnabled = canEditEnabled;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}