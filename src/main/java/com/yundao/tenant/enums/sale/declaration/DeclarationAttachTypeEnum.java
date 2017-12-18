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
public enum DeclarationAttachTypeEnum {


    /**
     * 合同附件
     */
    CONTRACT_FILE(1, "合同附件"),

    /**
     * 打款凭证
     */
    VOUCHER(2, "打款凭证"),

    /**
     * 资产证明
     */
    DECLARATION_ATTACHS(3, "资产证明");


    private Integer type;
    private String name;

    DeclarationAttachTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    private static Map<Integer, DeclarationAttachTypeEnum> enumMap = new HashMap<>();

    static {
        EnumSet<DeclarationAttachTypeEnum> set = EnumSet.allOf(DeclarationAttachTypeEnum.class);
        for (DeclarationAttachTypeEnum each : set) {
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

    public static Map<Integer, DeclarationAttachTypeEnum> getEnumMap() {
        return enumMap;
    }

    public static void setEnumMap(Map<Integer, DeclarationAttachTypeEnum> enumMap) {
        DeclarationAttachTypeEnum.enumMap = enumMap;
    }
}
