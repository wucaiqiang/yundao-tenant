package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseDeclarationAttach extends BaseModel implements Serializable {
    /**
	 * 报单id
	 */
    private Long declarationId;

    /**
	 * 附件名称
	 */
    private String name;

    /**
	 * url
	 */
    private String url;

    /**
	 * 附件类型
	 */
    private Integer type;

    /**
	 * 排序
	 */
    private Integer sequence;

    private static final long serialVersionUID = 1L;

    public Long getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Long declarationId) {
        this.declarationId = declarationId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}