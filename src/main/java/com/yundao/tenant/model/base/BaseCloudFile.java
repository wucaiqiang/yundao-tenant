package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCloudFile extends BaseModel implements Serializable {
    /**
	 * 云类型，0：阿里云；1：腾讯云；2：ucloud云
	 */
    private Integer type;

    /**
	 * 链接
	 */
    private String url;

    /**
	 * 原文件名
	 */
    private String originalName;

    private static final long serialVersionUID = 1L;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }
}