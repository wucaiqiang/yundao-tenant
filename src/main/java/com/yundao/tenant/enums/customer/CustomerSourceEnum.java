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
public enum CustomerSourceEnum {


    /**
     * 自我开发
     */
    SELF(1, "自我开发"),

    /**
     * 客户转介绍
     */
    INTRODUCE(2, "客户转介绍"),

    /**
     * 市场活动
     */
    ACTIVITY(3, "市场活动"),

    /**
     * 其他
     */
    OTHER(4, "其他");

    private Integer value;
    private String name;
    private static Map<Integer, CustomerSourceEnum> enumMap = new HashMap<>();

    static {
        EnumSet<CustomerSourceEnum> set = EnumSet.allOf(CustomerSourceEnum.class);
        for (CustomerSourceEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    CustomerSourceEnum(Integer value, String name) {
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
    public static CustomerSourceEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        CustomerSourceEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
