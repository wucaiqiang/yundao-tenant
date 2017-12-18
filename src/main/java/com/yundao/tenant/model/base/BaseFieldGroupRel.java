package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseFieldGroupRel extends BaseModel implements Serializable {
    /**
	 * 业务对象字段分组id
	 */
    private Long fieldGroupId;

    /**
	 * 业务对象字段id
	 */
    private Long objectFieldId;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    private static final long serialVersionUID = 1L;

    public BaseFieldGroupRel(Long objectFieldId, Long fieldGroupId,Date createTime,Long tenantId,Integer sequence) {
        this.fieldGroupId = fieldGroupId;
        this.objectFieldId = objectFieldId;
        super.setCreateDate(createTime);
        super.setTenantId(tenantId);
        this.sequence = sequence;
    }

    public BaseFieldGroupRel() {
    }

    public Long getFieldGroupId() {
        return fieldGroupId;
    }

    public void setFieldGroupId(Long fieldGroupId) {
        this.fieldGroupId = fieldGroupId;
    }

    public Long getObjectFieldId() {
        return objectFieldId;
    }

    public void setObjectFieldId(Long objectFieldId) {
        this.objectFieldId = objectFieldId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}