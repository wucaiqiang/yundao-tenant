package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseApiResource extends BaseModel implements Serializable {
    /**
	 * 编码
	 */
    private String code;

    /**
	 * 系统编码
	 */
    private String systemCode;

    /**
	 * 名字
	 */
    private String name;

    /**
	 * 链接
	 */
    private String url;

    /**
	 * 链接类型；1：PC，2：APP
	 */
    private Integer urlType;

    /**
	 * 是否白名单
	 */
    private Integer isWhitelist;

    /**
	 * 描述
	 */
    private String description;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
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

    public Integer getUrlType() {
        return urlType;
    }

    public void setUrlType(Integer urlType) {
        this.urlType = urlType;
    }

    public Integer getIsWhitelist() {
        return isWhitelist;
    }

    public void setIsWhitelist(Integer isWhitelist) {
        this.isWhitelist = isWhitelist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}