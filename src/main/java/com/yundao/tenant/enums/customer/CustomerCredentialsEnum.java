package com.yundao.tenant.enums.customer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户级别枚举
 *
 * @author jan
 * @create 2017-08-09 PM2:13
 **/
public enum CustomerCredentialsEnum {


    /**
     * 自我开发
     */
    IDCARD(1, "身份证"),

    /**
     * 客户转介绍
     */
    PASSPORT(2, "护照");

    private Integer value;
    private String name;
    private static Map<Integer, CustomerCredentialsEnum> enumMap = new HashMap<>();

    static {
        EnumSet<CustomerCredentialsEnum> set = EnumSet.allOf(CustomerCredentialsEnum.class);
        for (CustomerCredentialsEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    CustomerCredentialsEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取枚举
     */
    public static CustomerCredentialsEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        CustomerCredentialsEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
