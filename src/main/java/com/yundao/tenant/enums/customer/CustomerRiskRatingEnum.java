package com.yundao.tenant.enums.customer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 风险特征
 *
 * @author jan
 * @create 2017-07-06 PM3:55
 **/
public enum CustomerRiskRatingEnum {

	/**
	 * 保守型
	 */
	GUARD(1, "保守型"),
	/**
	 * 适度保守型
	 */
	MODER_GUARD(2, "适度保守型"),
	/**
	 * 平衡型
	 */
	BALANCE(3, "平衡型"),
	/**
	 * 适度进取型
	 */
	MODER_ENTER(4, "适度进取型"),
	/**
	 * 进取型
	 */
	ENTER(5, "进取型");
	private Integer value;
	private String name;
	private static Map<Integer, CustomerRiskRatingEnum> enumMap = new HashMap<>();

	static {
		EnumSet<CustomerRiskRatingEnum> set = EnumSet.allOf(CustomerRiskRatingEnum.class);
		for (CustomerRiskRatingEnum each : set) {
			enumMap.put(each.getValue(), each);
		}
	}

	CustomerRiskRatingEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Integer getValue() {
	
		return value;
	}

	public void setValue(Integer value) {
	
		this.value = value;
	}
	 /**
     * 获取枚举
     */
    public static CustomerRiskRatingEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
    	CustomerRiskRatingEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

}
