package com.yundao.tenant.enums.finance;

import com.yundao.tenant.enums.sale.declaration.DeclarationStatusEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gjl on 2017/10/12.
 */
public enum KnotCommissionStatusEnum {
    /**
     * 待审批
     */
    APPROVALING(1, "待审批"),

    /**
     * 已通过
     */
    PASS(2, "已通过"),

    /**
     * 已驳回
     */
    REJECT(3, "已驳回"),

    /**
     * 已否决
     */
    NO_PASS(5, "已否决");

    private Integer value;
    private String name;

    KnotCommissionStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static Map<Integer, KnotCommissionStatusEnum> enumMap = new HashMap<>();

    static {
        EnumSet<KnotCommissionStatusEnum> set = EnumSet.allOf(KnotCommissionStatusEnum.class);
        for (KnotCommissionStatusEnum each : set) {
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
    public static KnotCommissionStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 获取在审核者页面显示的文本
     */
    public static String getName(Integer value) {
        KnotCommissionStatusEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }
}
