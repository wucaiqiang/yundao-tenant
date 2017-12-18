package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSmsTemplate extends BaseModel implements Serializable {
    /**
	 * 模版编码
	 */
    private String code;

    /**
	 * 对应三方平台编码
	 */
    private String thirdPartyCode;

    /**
	 * 模版名称
	 */
    private String name;

    /**
	 * 模版内容
	 */
    private String message;

    /**
	 * 描述
	 */
    private String description;

    /**
	 * 是否启用
	 */
    private Integer isEnable;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getThirdPartyCode() {
        return thirdPartyCode;
    }

    public void setThirdPartyCode(String thirdPartyCode) {
        this.thirdPartyCode = thirdPartyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }
}