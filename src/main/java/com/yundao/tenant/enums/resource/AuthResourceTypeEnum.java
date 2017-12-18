package com.yundao.tenant.enums.resource;

/**
 * 鉴权资源类型枚举
 */
public enum AuthResourceTypeEnum {

    /**
     * 功能菜单
     */
    MENU(1, "功能菜单"),

    /**
     * API
     */
    API(2, "API"),

    /**
     * 未知
     */
    UNKNOW(3, "未知");

    private Integer value;
    private String name;


    private AuthResourceTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
