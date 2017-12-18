package com.yundao.tenant.enums.access;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据对象权限操作返回方式枚举
 *
 * @author jan
 * @create 2017-07-15 PM3:56
 **/
public enum DataAccessReturnTypeEnum {

    /**
     * 直接返回，通过 throw new BaseException方式
     */
    TERMINAL(0, "直接返回"),

    /**
     * 返回不可操作的结果
     */
    RETURN_RESULT(1, "返回不可操作的结果");

    private Integer value;
    private String name;
    private static Map<Integer, DataAccessReturnTypeEnum> enumMap = new HashMap<>();

    static {
        EnumSet<DataAccessReturnTypeEnum> set = EnumSet.allOf(DataAccessReturnTypeEnum.class);
        for (DataAccessReturnTypeEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    DataAccessReturnTypeEnum(Integer value, String name) {
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
    public static DataAccessReturnTypeEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        DataAccessReturnTypeEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
