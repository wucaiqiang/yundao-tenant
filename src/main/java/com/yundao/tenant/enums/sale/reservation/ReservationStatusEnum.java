package com.yundao.tenant.enums.sale.reservation;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 预约状态
 *
 * @author jan
 * @create 2017-07-22 PM3:36
 **/
public enum ReservationStatusEnum {

    /**
     * 待审核
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
    DISCARD(5, "已作废");

    private Integer value;
    private String name;
    private static Map<Integer, ReservationStatusEnum> enumMap = new HashMap<>();

    static {
        EnumSet<ReservationStatusEnum> set = EnumSet.allOf(ReservationStatusEnum.class);
        for (ReservationStatusEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    ReservationStatusEnum(Integer value, String name) {
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
    public static ReservationStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 获取在申请者页面显示的文本
     */
    public static String getName(Integer value) {
        ReservationStatusEnum enumItem = getEnum(value);
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
        return ReservationStatusEnum.APPROVALING.getValue().equals(value);
    }

    /**
     * 判断是否能编辑
     *
     * @param value
     * @return
     */
    public static Boolean canUpdate(Integer value) {
        if (REJECT.getValue().equals(value)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否能重新提交
     *
     * @param value
     * @return
     */
    public static Boolean canAgainCommit(Integer value) {
        if (REJECT.getValue().equals(value)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否能取消
     *
     * @param value
     * @return
     */
    public static Boolean canCancel(Integer value) {
        if (REJECT.getValue().equals(value) || APPROVALING.getValue().equals(value)) {
            return true;
        }
        return false;
    }
}
