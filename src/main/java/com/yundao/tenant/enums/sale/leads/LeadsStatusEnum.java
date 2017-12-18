package com.yundao.tenant.enums.sale.leads;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 线索状态枚举
 *
 * @author jan
 * @create 2017-09-07 PM3:01
 **/
public enum LeadsStatusEnum {

    /**
     * 未处理
     */
    UNPROCESS(0, "未处理"),

    /**
     * 已联系
     */
    CONNECTED(1, "已联系"),

    /**
     * 关闭
     */
    CLOSED(2, "关闭");

    private Integer value;
    private String name;

    LeadsStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static Map<Integer, LeadsStatusEnum> enumMap = new HashMap<>();

    static {
        EnumSet<LeadsStatusEnum> set = EnumSet.allOf(LeadsStatusEnum.class);
        for (LeadsStatusEnum each : set) {
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
    public static LeadsStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 获取文本
     */
    public static String getName(Integer value) {
        LeadsStatusEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
