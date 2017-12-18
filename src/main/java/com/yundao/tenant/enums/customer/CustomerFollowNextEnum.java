package com.yundao.tenant.enums.customer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户下次跟进状态
 *
 * @author gjl
 * @create 2017-08-09 PM2:13
 **/
public enum CustomerFollowNextEnum {

    STATSU_1(1, "未发布"),
    STATSU_2(2, "已发布");

    private Integer value;
    private String name;
    private static Map<Integer, CustomerFollowNextEnum> enumMap = new HashMap<>();

    static {
        EnumSet<CustomerFollowNextEnum> set = EnumSet.allOf(CustomerFollowNextEnum.class);
        for (CustomerFollowNextEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    CustomerFollowNextEnum(Integer value, String name) {
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
    public static CustomerFollowNextEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        CustomerFollowNextEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
