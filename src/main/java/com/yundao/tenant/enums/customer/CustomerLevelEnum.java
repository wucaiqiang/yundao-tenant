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
public enum CustomerLevelEnum {


    /**
     * A[最重要]
     */
    A(1, "A[最重要]"),

    /**
     * B[重要]
     */
    B(2, "B[重要]"),

    /**
     * C[普通]
     */
    C(3, "C[普通]"),

    /**
     * D[沉默]
     */
    D(4, "D[沉默]");

    private Integer value;
    private String name;
    private static Map<Integer, CustomerLevelEnum> enumMap = new HashMap<>();

    static {
        EnumSet<CustomerLevelEnum> set = EnumSet.allOf(CustomerLevelEnum.class);
        for (CustomerLevelEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    CustomerLevelEnum(Integer value, String name) {
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
    public static CustomerLevelEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        CustomerLevelEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
