package com.yundao.tenant.model.base.cc;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCcQuestion extends BaseModel implements Serializable {
    /**
	 * 类型id
	 */
    private Long typeId;

    /**
	 * 标题
	 */
    private String title;

    /**
	 * 类型，0：单选，1：多选，2：文本
	 */
    private Integer type;

    /**
	 * 排序
	 */
    private Integer sequence;

    private static final long serialVersionUID = 1L;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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