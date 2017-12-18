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
public enum DeclarationCompliancesTypeEnum {


    /**
     * 合规双录
     */
    COMPLIANCE_RECORD(1, "合规双录"),

    /**
     * 投资者基本信息表（自然人）
     */
    BASE_INFO(2, "投资者基本信息表（自然人）"),

    /**
     * 投资者风险匹配告知书及投资者确认函
     */
    RISK_NOTIFY(3, "投资者风险匹配告知书及投资者确认函"),
    /**
     * 风险承受能力调查问卷（自然人）
     */
    RISK_QUESSTIONNAIRE(4, "风险承受能力调查问卷（自然人）"),
    /**
     * 基金回访确认书
     */
    RETURN_CONFIRMATION(5, "基金回访确认书"),
    /**
     * 其他合规文件
     */
    OTHER_FILE(6, "其他合规文件");


    private Integer type;
    private String name;

    DeclarationCompliancesTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    private static Map<Integer, DeclarationCompliancesTypeEnum> enumMap = new HashMap<>();

    static {
        EnumSet<DeclarationCompliancesTypeEnum> set = EnumSet.allOf(DeclarationCompliancesTypeEnum.class);
        for (DeclarationCompliancesTypeEnum each : set) {
            enumMap.put(each.getType(), each);
        }
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Map<Integer, DeclarationCompliancesTypeEnum> getEnumMap() {
        return enumMap;
    }

    public static void setEnumMap(Map<Integer, DeclarationCompliancesTypeEnum> enumMap) {
        DeclarationCompliancesTypeEnum.enumMap = enumMap;
    }
}
