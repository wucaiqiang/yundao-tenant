package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseSmsCaptcha extends BaseModel implements Serializable {
    /**
	 * 模版CODE
	 */
    private String templateCode;

    /**
	 * 验证码
	 */
    private String code;

    /**
	 * 过期时间
	 */
    private Date expireTime;

    /**
	 * 是否有效
	 */
    private Integer isValid;

    /**
	 * 手机号码
	 */
    private byte[] mobile;

    private static final long serialVersionUID = 1L;

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public byte[] getMobile() {
        return mobile;
    }

    public void setMobile(byte[] mobile) {
        this.mobile = mobile;
    }
}