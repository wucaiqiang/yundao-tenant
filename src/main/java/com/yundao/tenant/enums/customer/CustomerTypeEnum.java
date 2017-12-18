package com.yundao.tenant.enums.customer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 字段类型枚举
 *
 * @author jan
 * @create 2017-07-06 PM3:55
 **/
public enum CustomerTypeEnum {

	/**
	 * 认购费
	 */
	CUSTOMER_TYPE_1(1, "普通投资人"),
	/**
	 * 发行通道
	 */
	CUSTOMER_TYPE_2(2, "专业投资人");
	private Integer type;
	private String name;
	private static Map<Integer, CustomerTypeEnum> enumMap = new HashMap<>();

	static {
		EnumSet<CustomerTypeEnum> set = EnumSet.allOf(CustomerTypeEnum.class);
		for (CustomerTypeEnum each : set) {
			enumMap.put(each.getType(), each);
		}
	}

	CustomerTypeEnum(Integer type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	  /**
     * 获取枚举
     */
    public static CustomerTypeEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
    	CustomerTypeEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }
}
