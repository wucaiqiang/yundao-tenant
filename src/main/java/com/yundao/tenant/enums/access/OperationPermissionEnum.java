package com.yundao.tenant.enums.access;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据对象权限枚举
 *
 * @author jan
 * @create 2017-07-13 PM4:33
 **/
public enum OperationPermissionEnum {

    /**
     * 读
     */
    READ(0, "读"),

    /**
     * 改
     */
    EDIT(1, "改"),

    /**
     * 删
     */
    DELETE(2, "删");

    private Integer value;
    private String name;
    private static Map<Integer, OperationPermissionEnum> enumMap = new HashMap<>();

    static {
        EnumSet<OperationPermissionEnum> set = EnumSet.allOf(OperationPermissionEnum.class);
        for (OperationPermissionEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    OperationPermissionEnum(Integer value, String name) {
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
    public static OperationPermissionEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        OperationPermissionEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
