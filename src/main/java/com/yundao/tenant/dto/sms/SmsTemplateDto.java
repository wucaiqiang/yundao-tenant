package com.yundao.tenant.dto.sms;


import java.util.Map;

/**
 * 短信模版dto
 *
 * @author jan
 * @create 2017-06-18 PM7:29
 **/
public class SmsTemplateDto {

    /**
     * 模版编码,值参考 SmsTemplateCode 枚举文件 value
     */
    private String code;

    /**
     * 模版参数
     */
    private Map<String, String> params;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
