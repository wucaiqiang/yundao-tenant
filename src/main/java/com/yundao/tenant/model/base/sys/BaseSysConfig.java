package com.yundao.tenant.model.base.sys;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSysConfig extends BaseModel implements Serializable {
    /**
	 * 编码
	 */
    private String code;

    /**
	 * 配置名称
	 */
    private String name;

    /**
	 * 参数
	 */
    private String params;

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

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}