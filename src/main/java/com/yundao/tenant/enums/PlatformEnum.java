
package com.yundao.tenant.enums;

/**
 * 平台枚举
 *
 * @author jan
 * @create 2017-10-27 20:21
 **/
public enum PlatformEnum {


    /**
     * 官方网站
     */
    OFFICIAL_WEB_SITE("website", "官方网站"),

    /**
     * 服务号
     */
    SERVIC("service_number", "服务号"),
    /**
     * 员工版app
     */
	APP_TO_B("app_to_b", "员工版APP");
    private String code;
    private String name;

    private PlatformEnum(String value, String name) {
        this.code = value;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
