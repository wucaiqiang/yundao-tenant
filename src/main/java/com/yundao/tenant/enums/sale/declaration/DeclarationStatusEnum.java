package com.yundao.tenant.enums.sale.declaration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 报单状态
 *
 * @author gjl
 * @create 2017-07-22 PM3:36
 **/
public enum DeclarationStatusEnum {


    /**
     * 待审批
     */
    UNCOMMITTED(0, "未提交"),

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
     * 已取消
     */
    CANCEL(4, "已取消"),
	
    /**
     * 已作废
     */
    DISCARD(5, "已作废"),
    
    /**
     * 已退款
     */
    REFUND(6, "已退款");

    private Integer value;
    private String name;

    DeclarationStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static Map<Integer, DeclarationStatusEnum> enumMap = new HashMap<>();

    static {
        EnumSet<DeclarationStatusEnum> set = EnumSet.allOf(DeclarationStatusEnum.class);
        for (DeclarationStatusEnum each : set) {
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
    public static DeclarationStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 获取在审核者页面显示的文本
     */
    public static String getName(Integer value) {
        DeclarationStatusEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }


    /**
     * 是否能进行审核
     *
     * @param value
     * @return
     */
    public static Boolean canAudit(Integer value) {
        return DeclarationStatusEnum.APPROVALING.getValue().equals(value);
    }
}
