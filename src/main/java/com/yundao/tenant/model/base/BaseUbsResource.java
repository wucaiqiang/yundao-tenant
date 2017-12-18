package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseUbsResource extends BaseModel implements Serializable {
    /**
	 * 系统编码
	 */
    private String systemCode;

    /**
	 * 父id，-1：表示无父类
	 */
    private Long parentId;

    /**
	 * 编码
	 */
    private String code;

    /**
	 * 名字
	 */
    private String name;

    /**
	 * 链接
	 */
    private String url;

    /**
	 * 状态，0：无效；1：有效
	 */
    private Integer status;

    /**
	 * 资源类型，1：外部资源；2：内部资源
	 */
    private String resourceType;

    /**
	 * 1：菜单 2：功能
	 */
    private Integer menue;

    /**
	 * 描述
	 */
    private String description;

    private static final long serialVersionUID = 1L;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getMenue() {
        return menue;
    }

    public void setMenue(Integer menue) {
        this.menue = menue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}