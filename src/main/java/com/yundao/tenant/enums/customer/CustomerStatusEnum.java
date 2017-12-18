package com.yundao.tenant.enums.customer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CustomerStatusEnum {
    /**
     * 未确认
     */
    UNCONFIRMED(0, "未确认"),
    /**
     * 有效
     */
    VALID(1, "有效"),
    /**
     * 无效
     */
    INVALID(2, "无效");

    private Integer value;
    private String name;
    private static Map<Integer, CustomerStatusEnum> enumMap = new HashMap<>();

    static {
        EnumSet<CustomerStatusEnum> set = EnumSet.allOf(CustomerStatusEnum.class);
        for (CustomerStatusEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    CustomerStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 获取枚举
     */
    public static CustomerStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        CustomerStatusEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

    /**
     * 检查状态是否有效
     */
    public static Boolean isValid(Integer value) {
        return getEnum(value) != null;
    }
}
