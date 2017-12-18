package com.yundao.tenant.enums.sale.refund;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 退款状态
 *
 * @author gjl
 * @create 2017-07-22 PM3:36
 **/
public enum RefundStatusEnum {


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
    CANCEL(4, "已取消");
	
  

    private Integer value;
    private String name;

    RefundStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static Map<Integer, RefundStatusEnum> enumMap = new HashMap<>();

    static {
        EnumSet<RefundStatusEnum> set = EnumSet.allOf(RefundStatusEnum.class);
        for (RefundStatusEnum each : set) {
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
    public static RefundStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 获取在审核者页面显示的文本
     */
    public static String getName(Integer value) {
        RefundStatusEnum enumItem = getEnum(value);
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
        return RefundStatusEnum.APPROVALING.getValue().equals(value);
    }
}
