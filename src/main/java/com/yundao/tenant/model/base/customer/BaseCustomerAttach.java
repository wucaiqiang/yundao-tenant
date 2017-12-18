package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCustomerAttach extends BaseModel implements Serializable {
    /**
	 * 客户id
	 */
    private Long customerId;

    /**
	 * 附件名称
	 */
    private String name;

    /**
	 * url
	 */
    private String url;

    /**
	 * 附件类型（1：资产证明）
	 */
    private Integer type;

    /**
	 * 类型名称
	 */
    private String typeName;

    /**
	 * 排序
	 */
    private Integer seqencing;

    private static final long serialVersionUID = 1L;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getSeqencing() {
        return seqencing;
    }

    public void setSeqencing(Integer seqencing) {
        this.seqencing = seqencing;
    }
}