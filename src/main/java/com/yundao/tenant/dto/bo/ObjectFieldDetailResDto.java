package com.yundao.tenant.dto.bo;

import com.yundao.tenant.dto.common.IdNameDto;
import com.yundao.tenant.dto.role.RoleDetailResDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 业务对象字段详情dto
 *
 * @author jan
 * @create 2017-07-05 PM5:18
 **/
public class ObjectFieldDetailResDto {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 要素名称
     */
    @ApiModelProperty(value = "要素名称")
    private String name;

    /**
     * 业务对象字段类型编码
     */
    @ApiModelProperty(value = "类型编码")
    private String fieldTypeCode;

    /**
     * 是否必填，0：否；1：是
     */
    @ApiModelProperty(value = "是否必填，0：否；1：是")
    private Integer isMandatory;


    /**
     * 是否通用，0：否；1：是
     */
    @ApiModelProperty(value = "是否通用，0：否；1：是")
    private Integer isShare;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
    private String unit;


    /**
     * 是否启用，0：否；1：是
     */
    @ApiModelProperty(value = "是否启用，0：否；1：是")
    private Integer isEnabled;

    @ApiModelProperty(value = "是否预置，0：否；1：是")
    private Integer isSystem;

    /**
     * 是否能够修改 必填项
     */
    @ApiModelProperty(value = "是否能够修改 必填项，0：否；1：是")
    private Integer canEditMandatory;

    /**
     * 是否可修改 启用 项
     */
    @ApiModelProperty(value = "是否可修改 启用 项，0：否；1：是")
    private Integer canEditEnabled;

    /**
     * 权限限制
     */
    @ApiModelProperty(value = "权限限制，0：全部可见；1：部分可见")
    private Integer access;

    /**
     * 选中的角色
     */
    @ApiModelProperty(value = "选中的角色")
    private List<IdNameDto> selectedRoles;

    /**
     * 所有角色
     */
    @ApiModelProperty(value = "所有角色")
    private List<RoleDetailResDto> roles;

    @ApiModelProperty(value = "选项数据")
    private List<SelectionDto> selections;

    @ApiModelProperty(value = "关联的分组")
    private List<IdNameDto> fieldGroups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Integer isMandatory) {
        this.isMandatory = isMandatory;
    }

    public Integer getIsShare() {
        return isShare;
    }

    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public List<IdNameDto> getSelectedRoles() {
        return selectedRoles;
    }

    public void setSelectedRoles(List<IdNameDto> selectedRoles) {
        this.selectedRoles = selectedRoles;
    }

    public List<RoleDetailResDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDetailResDto> roles) {
        this.roles = roles;
    }

    public String getFieldTypeCode() {
        return fieldTypeCode;
    }

    public void setFieldTypeCode(String fieldTypeCode) {
        this.fieldTypeCode = fieldTypeCode;
    }

    public List<SelectionDto> getSelections() {
        return selections;
    }

    public void setSelections(List<SelectionDto> selections) {
        this.selections = selections;
    }

    public List<IdNameDto> getFieldGroups() {
        return fieldGroups;
    }

    public void setFieldGroups(List<IdNameDto> fieldGroups) {
        this.fieldGroups = fieldGroups;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
}
