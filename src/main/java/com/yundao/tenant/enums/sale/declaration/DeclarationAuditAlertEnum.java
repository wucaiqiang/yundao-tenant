package com.yundao.tenant.enums.sale.declaration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 报单审核提示枚举
 *
 * @author jan
 * @create 2017-09-12 PM2:23
 **/
public enum DeclarationAuditAlertEnum {

    /**
     * 证件类型
     */
    CREDENTIALS_TYPE(1, "证件类型"),

    /**
     * 证件号码
     */
    CREDENTIALS_NUMBER(2, "证件号码"),

    /**
     * 身份证件正反面
     */
    IDCARD(3, "身份证件正反面"),

    /**
     * 认购金额
     */
    DEAL_MONEY(4, "认购金额"),

    /**
     * 打款日期
     */
    PAY_DATE(5, "打款日期"),

    /**
     * 打款凭证
     */
    PAY_EVIDENCE(6, "打款凭证"),

    /**
     * 银行卡账号
     */
    BANK_ACCOUNT(7, "银行卡账号"),

    /**
     * 开户行
     */
    BANK_NAME(8, "开户行"),

    /**
     * 银行卡正反面
     */
    BANK_CARD(9, "银行卡正反面"),

    /**
     * 资产证明
     */
    ASSETS(10, "资产证明");

    private Integer value;
    private String name;

    DeclarationAuditAlertEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private static Map<Integer, DeclarationAuditAlertEnum> enumMap = new HashMap<>();

    static {
        EnumSet<DeclarationAuditAlertEnum> set = EnumSet.allOf(DeclarationAuditAlertEnum.class);
        for (DeclarationAuditAlertEnum each : set) {
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
    public static DeclarationAuditAlertEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 获取文本
     */
    public static String getName(Integer value) {
        DeclarationAuditAlertEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }


}
