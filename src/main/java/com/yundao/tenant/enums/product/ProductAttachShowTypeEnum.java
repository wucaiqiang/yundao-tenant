package com.yundao.tenant.enums.product;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 字段类型枚举
 *
 * @author jan
 * @create 2017-07-06 PM3:55
 **/
public enum ProductAttachShowTypeEnum {

	/**
	 * 全部可见
	 */
	ALL(0, "全部可见"),
	/**
	 * 内部可见
	 */
	INSIDE(1, "内部可见"),
	/**
	 * 外部可见
	 */
	OUTSIDE(2, "外部可见"),
	/**
	 * 全部不可见
	 */
	NONE(3, "全部不可见");

	private Integer value;
	private String name;
	private static Map<Integer, ProductAttachShowTypeEnum> allEnumMap = new HashMap<Integer, ProductAttachShowTypeEnum>();

	static {
		EnumSet<ProductAttachShowTypeEnum> set = EnumSet.allOf(ProductAttachShowTypeEnum.class);
		for (ProductAttachShowTypeEnum each : set) {
			allEnumMap.put(each.getValue(), each);
		}
	}

	ProductAttachShowTypeEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {

		return value;
	}

	public void setValue(Integer value) {

		this.value = value;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	/**
	 * 根据value 获取name
	 */
	public static String getEnumName(Integer value) {
		ProductAttachShowTypeEnum enumItem = getEnum(value);
		if (enumItem == null)
			return null;
		return enumItem.getName();
	}

	/**
	 * 获取枚举
	 */
	public static ProductAttachShowTypeEnum getEnum(Integer value) {
		if (value == null)
			return null;
		return allEnumMap.get(value);
	}

}
