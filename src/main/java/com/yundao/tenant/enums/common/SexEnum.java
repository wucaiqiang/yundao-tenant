package com.yundao.tenant.enums.common;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 性别枚举
 *
 * @author jan
 * @create 2017-08-09 PM2:13
 **/
public enum SexEnum {


    /**
     * 男
     */
    MALE(1, "男"),

    /**
     * 女
     */
    FEMALE(2, "女");

    private Integer value;
    private String name;
    private static Map<Integer, SexEnum> enumMap = new HashMap<>();

    static {
        EnumSet<SexEnum> set = EnumSet.allOf(SexEnum.class);
        for (SexEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    SexEnum(Integer value, String name) {
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
    public static SexEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        SexEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
