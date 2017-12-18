package com.yundao.tenant.enums.sys;

/**
 * 系统配置枚举
 *
 * @author jan
 * @create 2017-11-03 11:52
 **/
public enum SysConfEnum {

    SALE("sale", "销售管理");

    private String code;
    private String name;

    SysConfEnum(String code, String name) {
        this.code = code;
        this.name = name;
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

}
