package com.yundao.tenant.enums;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 是/否值 枚举
 *
 * @author 陈远坚
 *         2017年6月22日
 */
public enum YesOrNoEnum {

    /**
     * 否
     */
    NO(0, "否"),

    /**
     * 是
     */
    YES(1, "是");


    private Integer value;
    private String name;
    private static Map<Integer, YesOrNoEnum> enumMap = new HashMap<>();

    static {
        EnumSet<YesOrNoEnum> set = EnumSet.allOf(YesOrNoEnum.class);
        for (YesOrNoEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    YesOrNoEnum(Integer value, String name) {
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
    public static YesOrNoEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        YesOrNoEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }
}
