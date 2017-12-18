package com.yundao.tenant.enums.workflow;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 工作流动作值枚举
 */
public enum WorkflowActionEnum {

    /**
     * 通过
     */
    PASS(1, "通过"),

    /**
     * 驳回
     */
    REJECT(2, "驳回"),

    /**
     * 取消
     */
    CANCEL(3, "取消"),
    
    /**
     * 已否决
     */
    NO_PASS(5, "已否决"),

    /**
     * 重新提交
     */
    RESUBMIT(4, "重新提交");

    private Integer value;
    private String name;
    private static Map<Integer, WorkflowActionEnum> enumMap = new HashMap<>();
    static {
        EnumSet<WorkflowActionEnum> set = EnumSet.allOf(WorkflowActionEnum.class);
        for (WorkflowActionEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }
    private WorkflowActionEnum(Integer value, String name) {
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
    public static WorkflowActionEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }
    
    
    public static String getName(Integer value) {
    	WorkflowActionEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }
    

}
