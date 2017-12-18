package com.yundao.tenant.model.base.msg;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseMsgTemplateTypeRef extends BaseModel implements Serializable {
    /**
	 * 模板id
	 */
    private Long templateId;

    /**
	 * 类型id
	 */
    private Long typeId;

    private static final long serialVersionUID = 1L;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}