package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCustomerTag extends BaseModel implements Serializable {
    /**
	 * 标签表_id
	 */
    private Long tagId;

    /**
	 * 客户ID
	 */
    private Long customerId;

    /**
	 * 排序
	 */
    private Long seqencing;

    private static final long serialVersionUID = 1L;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSeqencing() {
        return seqencing;
    }

    public void setSeqencing(Long seqencing) {
        this.seqencing = seqencing;
    }
}