package com.yundao.tenant.enums.product;

import com.yundao.tenant.dto.field.FiledSelectDto;
import com.yundao.tenant.dto.field.SelectConfigStringValueDto;

import java.util.*;

/**
 * 产品发行状态
 *
 * @author 欧阳利
 *         2017年7月24日
 */
public enum ProductNoticeTypeEnum {

    /**
     * 重大事项
     */
    MAJOR_ISSUES("major_issues", "重大事项"),
    /**
     * 周报
     */
    WEEKLY("weekly", "周报"),
    /**
     * 月报
     */
    MONTHLY("monthly", "月报"),
    /**
     * 季报
     */
    QUARTERLY("quarterly", "季报"),
    /**
     * 重大事项
     */
    SEMI_ANNUAL("semi_annual", "半年报"),
    /**
     * 重大事项
     */
    ANNUAL("annual", "年报"),
    /**
     * 重大事项
     */
    PRIVATE_RECORD("private_record", "私募备案"),
    /**
     * 重大事项
     */
    NOTIFICATION_REDEMPTION("notification_redemption", "通知赎回"),
    /**
     * 重大事项
     */
    PRODUCT_FOUND("product_found", "产品成立"),
    /**
     * 重大事项
     */
    INTEREST_NOTICE("interest_notice", "付息通知"),
    /**
     * 重大事项
     */
    OTHER("other", "其他");


    private String value;

    private String name;

    private static Map<String, ProductNoticeTypeEnum> allEnumMap = new HashMap<>();


    static {
        EnumSet<ProductNoticeTypeEnum> set = EnumSet.allOf(ProductNoticeTypeEnum.class);
        for (ProductNoticeTypeEnum each : set) {
            allEnumMap.put(each.getValue(), each);
        }
    }

    private ProductNoticeTypeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        ProductNoticeTypeEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

    /**
     * 获取枚举
     */
    public static ProductNoticeTypeEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return allEnumMap.get(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
