package com.yundao.tenant.model.base.platform;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BasePlatform extends BaseModel implements Serializable {
    /**
	 * 名称
	 */
    private String name;

    /**
	 * 编码
	 */
    private String code;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}