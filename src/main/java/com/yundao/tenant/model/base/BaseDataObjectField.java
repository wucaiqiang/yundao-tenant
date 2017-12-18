package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseDataObjectField extends BaseModel implements Serializable {
    /**
	 * 字段id
	 */
    private Long fieldId;

    /**
	 * 数据对象id
	 */
    private Long dataObjectId;

    private static final long serialVersionUID = 1L;

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Long getDataObjectId() {
        return dataObjectId;
    }

    public void setDataObjectId(Long dataObjectId) {
        this.dataObjectId = dataObjectId;
    }
}