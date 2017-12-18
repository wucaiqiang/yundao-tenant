package com.yundao.tenant.dto.bo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 业务对象字段分页列表dto
 *
 * @author jan
 * @create 2017-07-04 AM9:14
 **/
public class ObjectFieldPageResDto {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer type;

    /**
     * 类型文本
     */
    @ApiModelProperty(value = "类型文本")
    private String typeText;

    /**
     * 是否必填，0：否；1：是
     */
    @ApiModelProperty(value = "是否必填，0：否；1：是")
    private Integer isMandatory;

    /**
     * 是否必填文本
     */
    @ApiModelProperty(value = "是否必填文本")
    private String isMandatoryText;

    /**
     * 是否通用，0：否；1：是
     */
    @ApiModelProperty(value = "是否通用，0：否；1：是")
    private Integer isShare;

    /**
     * 是否通用文本
     */
    @ApiModelProperty(value = "是否通用文本")
    private String isShareText;

    /**
     * 是否启用，0：否；1：是
     */
    @ApiModelProperty(value = "是否启用，0：否；1：是")
    private Integer isEnabled;

    /**
     * 是否启用文本
     */
    @ApiModelProperty(value = "是否启用文本")
    private String isEnabledText;

    /**
     * 权限限制
     */
    @ApiModelProperty(value = "权限限制,0：全部可见；1：部分可见")
    private Integer access;

    /**
     * 权限限制文本
     */
    @ApiModelProperty(value = "权限限制文本")
    private String accessText;

    /**
     * 是否系统预置
     */
    @ApiModelProperty(value = "是否系统预置")
    private Integer isSystem;

    /**
     * 是否系统预置文本
     */
    @ApiModelProperty(value = "是否系统预置文本")
    private String isSystemText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public Integer getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Integer isMandatory) {
        this.isMandatory = isMandatory;
    }

    public String getIsMandatoryText() {
        return isMandatoryText;
    }

    public void setIsMandatoryText(String isMandatoryText) {
        this.isMandatoryText = isMandatoryText;
    }

    public Integer getIsShare() {
        return isShare;
    }

    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    public String getIsShareText() {
        return isShareText;
    }

    public void setIsShareText(String isShareText) {
        this.isShareText = isShareText;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getIsEnabledText() {
        return isEnabledText;
    }

    public void setIsEnabledText(String isEnabledText) {
        this.isEnabledText = isEnabledText;
    }

    public String getAccessText() {
        return accessText;
    }

    public void setAccessText(String accessText) {
        this.accessText = accessText;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public String getIsSystemText() {
        return isSystemText;
    }

    public void setIsSystemText(String isSystemText) {
        this.isSystemText = isSystemText;
    }
}
