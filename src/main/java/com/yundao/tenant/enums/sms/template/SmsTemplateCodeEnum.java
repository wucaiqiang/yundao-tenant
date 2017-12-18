package com.yundao.tenant.enums.sms.template;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信模板编码枚举
 *
 * @author jan
 * @create 2017-09-14 PM9:03
 **/
public enum SmsTemplateCodeEnum {

    /**
     * 2B 找回密码发送短信验证码
     */
    CAPTCHA_2B_RETRIEVE("captcha_2b_retrieve_pwd", "SMS_96190011"),

    /**
     * 2C 找回密码发送短信验证码
     */
    CAPTCHA_2C_RETRIEVE("captcha_2c_retrieve_pwd", "SMS_96230007"),

    /**
     * 2C 注册发送短信验证码
     */
    CAPTCHA_2C_REGISTER("captcha_2c_register", "SMS_96300006"),

    /**
     * 2B通知类测试
     */
    NOTIFY_2B_TEST("notify_2b_test", "SMS_100370034");

    /**
     * 模板编码
     */
    private String value;

    /**
     * 对应默认的短信通道模板编码
     */
    private String defaultCode;

    SmsTemplateCodeEnum(String value, String defaultCode) {
        this.value = value;
        this.defaultCode = defaultCode;
    }

    private static Map<String, SmsTemplateCodeEnum> enumMap = new HashMap<>();

    static {
        EnumSet<SmsTemplateCodeEnum> set = EnumSet.allOf(SmsTemplateCodeEnum.class);
        for (SmsTemplateCodeEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDefaultCode(String defaultCode) {
        this.defaultCode = defaultCode;
    }

    public String getDfaultCode() {
        return defaultCode;
    }

    /**
     * 获取枚举
     */
    public static SmsTemplateCodeEnum getEnum(String value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 获取文本
     */
    public static String getDefaultCode(String value) {
        SmsTemplateCodeEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getDfaultCode();
    }

}
