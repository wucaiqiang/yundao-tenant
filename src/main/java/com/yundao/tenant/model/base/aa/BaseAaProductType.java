package com.yundao.tenant.model.base.aa;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseAaProductType extends BaseModel implements Serializable {
    /**
	 * 编号
	 */
    private String code;

    /**
	 * 名称
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