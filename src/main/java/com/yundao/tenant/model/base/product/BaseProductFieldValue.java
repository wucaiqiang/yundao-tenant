package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductFieldValue extends BaseModel implements Serializable {
    /**
	 * 业务对象字段id
	 */
    private Long objectFieldId;

    /**
	 * 引用表id
	 */
    private Long referenceTableId;

    /**
	 * 位置，一个字段有多个值时使用，按数字从小到大排列，例如日期区间
	 */
    private Integer slot;

    /**
	 * 字段值
	 */
    private String value;

    private static final long serialVersionUID = 1L;

    public Long getObjectFieldId() {
        return objectFieldId;
    }

    public void setObjectFieldId(Long objectFieldId) {
        this.objectFieldId = objectFieldId;
    }

    public Long getReferenceTableId() {
        return referenceTableId;
    }

    public void setReferenceTableId(Long referenceTableId) {
        this.referenceTableId = referenceTableId;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}