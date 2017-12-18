package com.yundao.tenant.enums.access;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据对象枚举
 *
 * @author jan
 * @create 2017-07-04 PM2:50
 **/
public enum DataObjectEnum {

    /**
     * 产品要素
     */
    PRODUCT_ELEMENT("product_element", "产品要素"),

    /**
     * 产品类别
     */
    PRODUCT_TYPE("product_type", "产品类别"),

    /**
     * 产品
     */
    PRODUCT("product", "产品"),

    /**
     * 产品供应商报价
     */
    SUPPLIER("supplier", "产品供应商报价"),

    /**
     * 产品销售佣金
     */
    COMMISSION("commission", "产品销售佣金"),

    /**
     * 产品公告
     */
    NOTICE("notice", "产品公告"),

    /**
     * 客户
     */
    CUSTOMER("customer", "客户"),

    /**
     * 客户联系信息
     */
    CONTACT("contact", "客户联系信息"),

    /**
     * 跟进
     */
    FOLLOW("follow", "跟进"),

    /**
     * 预约
     */
    RESERVATION("reservation", "预约"),

    /**
     * 报单
     */
    DECLARATION("declaration", "报单"),
    
    /**
     * 业绩报表(APP)
     */
    REPORT("report", "业绩报表(APP)"),

    /**
     * 回访
     */
    VISIT("visit", "回访");

    private String code;
    private String name;
    private static Map<String, DataObjectEnum> enumMap = new HashMap<>();

    static {
        EnumSet<DataObjectEnum> set = EnumSet.allOf(DataObjectEnum.class);
        for (DataObjectEnum each : set) {
            enumMap.put(each.getCode(), each);
        }
    }

    DataObjectEnum(String value, String name) {
        this.code = value;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取枚举
     */
    public static DataObjectEnum getEnum(String value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(String code) {
        DataObjectEnum enumItem = getEnum(code);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
