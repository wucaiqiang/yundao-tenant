package com.yundao.tenant.dto.sms.captcha;

import com.yundao.core.base.model.BaseModel;

import java.util.Date;

/**
 * 短信验证码数据dto
 *
 * @author jan
 * @create 2017-09-05 AM9:30
 **/
public class SmsCaptchaDto extends BaseModel {

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
    private String mobile;

    /**
     * 密钥
     */
    private String dbCodeKey;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDbCodeKey() {
        return dbCodeKey;
    }

    public void setDbCodeKey(String dbCodeKey) {
        this.dbCodeKey = dbCodeKey;
    }
}
