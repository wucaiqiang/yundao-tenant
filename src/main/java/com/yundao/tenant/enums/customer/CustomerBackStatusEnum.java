package com.yundao.tenant.enums.customer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户回退审核状态
 *
 * @author jan
 * @create 2017-08-10 PM3:01
 **/
public enum CustomerBackStatusEnum {

    /**
     * 审核中
     */
    APPROVALING(1, "审核中"),

    /**
     * 已通过
     */
    PASS(2, "已通过"),

    /**
     * 已驳回
     */
    REJECT(3, "已驳回");

    private Integer value;
    private String name;
    private static Map<Integer, CustomerBackStatusEnum> enumMap = new HashMap<>();

    static {
        EnumSet<CustomerBackStatusEnum> set = EnumSet.allOf(CustomerBackStatusEnum.class);
        for (CustomerBackStatusEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    CustomerBackStatusEnum(Integer value, String name) {
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
    public static CustomerBackStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        CustomerBackStatusEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
