package com.yundao.tenant.dto.sms;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送请求数据dto
 *
 * @author jan
 * @create 2017-09-14 PM8:51
 **/
public class SmsRequestDto {

    /**
     * 模版编码
     */
    private String code;

    /**
     * 模版参数，MAP格式
     */
    private Map<String, String> templateParmaMap;

    /**
     * 短信通道类型 值参考 SmsChannel 常量文件
     */
    private String channel;

    /**
     * 短信类型；1：验证码，2：通知，3：群发推广
     */
    private Integer smsType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Map<String, String> getTemplateParmaMap() {
        if (this.templateParmaMap == null)
            this.templateParmaMap = new HashMap<>();
        return this.templateParmaMap;
    }

    public void setTemplateParmaMap(Map<String, String> templateParmaMap) {
        this.templateParmaMap = templateParmaMap;
    }

    public Integer getSmsType() {
        return smsType;
    }

    public void setSmsType(Integer smsType) {
        this.smsType = smsType;
    }
}
