package com.yundao.tenant.enums.bo;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用性枚举
 *
 * @author jan
 * @create 2017-07-04 AM11:38
 **/
public enum ShareEnum {


    /**
     * 通用
     */
    SHARE(1, "通用"),

    /**
     * 非通用
     */
    RELEVANCE(0, "非通用");

    private Integer value;
    private String name;
    private static Map<Integer, ShareEnum> enumMap = new HashMap<>();

    static {
        EnumSet<ShareEnum> set = EnumSet.allOf(ShareEnum.class);
        for (ShareEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    ShareEnum(Integer value, String name) {
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
    public static ShareEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        ShareEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
