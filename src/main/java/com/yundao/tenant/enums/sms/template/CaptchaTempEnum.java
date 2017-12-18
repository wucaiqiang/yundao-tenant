package com.yundao.tenant.enums.sms.template;

/**
 * 验证码类短信模板枚举
 *
 * @author jan
 * @create 2017-08-17 PM7:53
 **/
public enum CaptchaTempEnum {

    TEST("SMS_82840127", "身份变更", "TEST", 0),
    RETRIEVE_2B_CAPTCHA(SmsTemplateCodeEnum.CAPTCHA_2B_RETRIEVE.getValue(), "找回密码验证码", "RETRIEVE_2B_CAPTCHA_", 300),
    RETRIEVE_2C_CAPTCHA(SmsTemplateCodeEnum.CAPTCHA_2C_RETRIEVE.getValue(), "找回密码验证码", "RETRIEVE_2C_CAPTCHA_", 300),
    REGISTER_2C_CAPTCHA(SmsTemplateCodeEnum.CAPTCHA_2C_REGISTER.getValue(), "注册验证码", "REGISTER_2C_CAPTCHA_", 300);

    private String code;
    private String name;
    private String redisKey;
    private Integer timeOut;

    CaptchaTempEnum(String code, String name, String redisKey, Integer timeOut) {
        this.code = code;
        this.name = name;
        this.redisKey = redisKey;
        this.timeOut = timeOut;
    }

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

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }
}
