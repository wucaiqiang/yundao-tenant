

package com.yundao.tenant.enums.cms.product.recommend;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月19日 下午4:31:05 
 * @author   欧阳利
 * @version   
 */
public enum RecommendStatusEnum {
	/**
     * 停用
     */
    MALE(0, "停用"),

    /**
     * 启用
     */
    FEMALE(1, "启用");

    private Integer value;
    private String name;
    private static Map<Integer, RecommendStatusEnum> enumMap = new HashMap<>();

    static {
        EnumSet<RecommendStatusEnum> set = EnumSet.allOf(RecommendStatusEnum.class);
        for (RecommendStatusEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    RecommendStatusEnum(Integer value, String name) {
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
    public static RecommendStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
    	RecommendStatusEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }
}

