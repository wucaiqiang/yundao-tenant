package com.yundao.tenant.enums.bo;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 必填性枚举
 *
 * @author jan
 * @create 2017-07-04 AM11:38
 **/
public enum MandatoryEnum {


    /**
     * 必填
     */
    REQUIRED(1, "必填"),

    /**
     * 可空
     */
    NULLABLE(0, "可空");

    private Integer value;
    private String name;
    private static Map<Integer, MandatoryEnum> enumMap = new HashMap<>();

    static {
        EnumSet<MandatoryEnum> set = EnumSet.allOf(MandatoryEnum.class);
        for (MandatoryEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    MandatoryEnum(Integer value, String name) {
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
    public static MandatoryEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        MandatoryEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
