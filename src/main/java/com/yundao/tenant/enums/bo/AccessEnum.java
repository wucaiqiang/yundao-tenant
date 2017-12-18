package com.yundao.tenant.enums.bo;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 可见性 枚举
 *
 * @author jan
 * @create 2017-07-04 PM1:55
 **/
public enum AccessEnum {


    /**
     * 全部可见
     */
    ALL(0, "全部可见"),

    /**
     * 部分可见
     */
    PART(1, "部分可见");

    private Integer value;
    private String name;
    private static Map<Integer, AccessEnum> enumMap = new HashMap<>();

    static {
        EnumSet<AccessEnum> set = EnumSet.allOf(AccessEnum.class);
        for (AccessEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    AccessEnum(Integer value, String name) {
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
    public static AccessEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        AccessEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }


}
