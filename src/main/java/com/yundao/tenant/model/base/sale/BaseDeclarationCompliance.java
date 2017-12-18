package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseDeclarationCompliance extends BaseModel implements Serializable {
    /**
	 * 报单id
	 */
    private Long declarationId;

    /**
	 * url
	 */
    private String url;

    /**
	 * 文件名
	 */
    private String name;

    /**
	 * 类型
	 */
    private Integer type;

    /**
	 * 格式；1：图片，2：视频
	 */
    private Integer formatType;

    private Integer sequence;

    private static final long serialVersionUID = 1L;

    public Long getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Long declarationId) {
        this.declarationId = declarationId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getFormatType() {
        return formatType;
    }

    public void setFormatType(Integer formatType) {
        this.formatType = formatType;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}