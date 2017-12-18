package com.yundao.tenant.model.base.cc;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCcQuestionType extends BaseModel implements Serializable {
    /**
	 * 编码
	 */
    private String code;

    /**
	 * 类型名称
	 */
    private String name;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}