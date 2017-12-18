package com.yundao.tenant.enums;

/**
 * Created by gjl on 2017/10/13.
 */
public enum ScopeEnum {
    ALL("all","全部报单"),
    MONTH("month","本月报单"),
    UNPROCESS("unprocess","未结佣报单");
    private String code;
    private String name;

    ScopeEnum(String code, String name) {
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
