package com.yundao.tenant.enums.customer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum MapTypeEnum {
	/**
	 * 未确认
	 */
	GAODE(1, "高德"),
	/**
	 * 有效
	 */
	BAIDU(2, "百度");

	private Integer value;
	private String name;
	private static Map<Integer, MapTypeEnum> enumMap = new HashMap<>();

	static {
		EnumSet<MapTypeEnum> set = EnumSet.allOf(MapTypeEnum.class);
		for (MapTypeEnum each : set) {
			enumMap.put(each.getValue(), each);
		}
	}

	MapTypeEnum(Integer value, String name) {
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
	public static MapTypeEnum getEnum(Integer value) {
		if (value == null)
			return null;
		return enumMap.get(value);
	}

	/**
	 * 根据value 获取name
	 */
	public static String getEnumName(Integer value) {
		MapTypeEnum enumItem = getEnum(value);
		if (enumItem == null)
			return null;
		return enumItem.getName();
	}

	/**
	 * 检查状态是否有效
	 */
	public static Boolean isValid(Integer value) {
		return getEnum(value) != null;
	}
}
