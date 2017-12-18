package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSmsHistory extends BaseModel implements Serializable {
    /**
	 * 短信响应id
	 */
    private Long responseId;

    /**
	 * 手机号码
	 */
    private String mobile;

    private static final long serialVersionUID = 1L;

    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}