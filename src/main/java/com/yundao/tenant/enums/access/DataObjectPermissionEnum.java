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
public enum DataObjectPermissionEnum {

    /**
     * 无权限
     */
    NONE(0, "无权限"),

    /**
     * 我的，个人的
     */
    PERSONAL(10, "我的"),

    /**
     * 团队
     */
    TEAM(20, "团队"),

    /**
     * 部门
     */
    DEPARTMENT(30, "部门"),

    /**
     * 全部
     */
    PUBLIC(40, "全部");

    private Integer value;
    private String name;
    private static Map<Integer, DataObjectPermissionEnum> enumMap = new HashMap<>();

    static {
        EnumSet<DataObjectPermissionEnum> set = EnumSet.allOf(DataObjectPermissionEnum.class);
        for (DataObjectPermissionEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    DataObjectPermissionEnum(Integer value, String name) {
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
    public static DataObjectPermissionEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        DataObjectPermissionEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
