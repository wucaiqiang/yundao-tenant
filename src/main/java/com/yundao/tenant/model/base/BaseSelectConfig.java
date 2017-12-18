package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSelectConfig extends BaseModel implements Serializable {
    /**
	 * 业务对象字段id
	 */
    private Long objectFieldId;

    /**
	 * 选项值
	 */
    private Integer value;

    /**
	 * 选项文本
	 */
    private String label;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    /**
	 * 是否系统预置
	 */
    private Integer isSystem;

    private static final long serialVersionUID = 1L;

    public Long getObjectFieldId() {
        return objectFieldId;
    }

    public void setObjectFieldId(Long objectFieldId) {
        this.objectFieldId = objectFieldId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }
}