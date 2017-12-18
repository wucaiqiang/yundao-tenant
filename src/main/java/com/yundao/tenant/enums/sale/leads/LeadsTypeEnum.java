package com.yundao.tenant.enums.sale.leads;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 线索类型枚举
 *
 * @author jan
 * @create 2017-09-07 PM3:01
 **/
public enum LeadsTypeEnum {

    /**
     * 预约产品
     */
    PRODUCT(1, "预约产品"),

    /**
     * 注册
     */
    REGISTER(2, "注册"),

    /**
     * 理财师
     */
    FP(3, "理财师");

    private Integer value;
    private String name;

    LeadsTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static Map<Integer, LeadsTypeEnum> enumMap = new HashMap<>();

    static {
        EnumSet<LeadsTypeEnum> set = EnumSet.allOf(LeadsTypeEnum.class);
        for (LeadsTypeEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取枚举
     */
    public static LeadsTypeEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 获取文本
     */
    public static String getName(Integer value) {
        LeadsTypeEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
