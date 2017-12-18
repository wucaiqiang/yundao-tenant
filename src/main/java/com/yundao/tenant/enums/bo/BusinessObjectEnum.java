package com.yundao.tenant.enums.bo;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 业务对象模块枚举
 *
 * @author jan
 * @create 2017-07-04 PM2:50
 **/
public enum BusinessObjectEnum {


    /**
     * 产品
     */
    PRODUCT("product", "产品");

    private String code;
    private String name;
    private static Map<String, BusinessObjectEnum> enumMap = new HashMap<>();

    static {
        EnumSet<BusinessObjectEnum> set = EnumSet.allOf(BusinessObjectEnum.class);
        for (BusinessObjectEnum each : set) {
            enumMap.put(each.getCode(), each);
        }
    }

    BusinessObjectEnum(String value, String name) {
        this.code = value;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取枚举
     */
    public static BusinessObjectEnum getEnum(String value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(String code) {
        BusinessObjectEnum enumItem = getEnum(code);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
