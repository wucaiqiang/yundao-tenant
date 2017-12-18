package com.yundao.tenant.model.base.platform;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BasePosition extends BaseModel implements Serializable {
    /**
	 * 位置名称
	 */
    private String name;

    /**
	 * 编码
	 */
    private String code;

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
}