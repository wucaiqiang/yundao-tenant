package com.yundao.tenant.enums;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 启用和禁用
 * 
 * @author 欧阳利
 * 2017年6月22日
 */
public enum EnabledEnum {
	
	/**
	 * 关闭
	 */
	NOT_ENABLED(0, "关闭"),
	
	/**
	 * 启用
	 */
	ENABLED(1, "启用");

	private Integer value;
	private String name;
	private static Map<Integer, EnabledEnum> enumMap = new HashMap<>();

	static {
		EnumSet<EnabledEnum> set = EnumSet.allOf(EnabledEnum.class);
		for (EnabledEnum each : set) {
			enumMap.put(each.getValue(), each);
		}
	}

	EnabledEnum(Integer value, String name) {
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
	public static EnabledEnum getEnum(Integer value) {
		if (value == null)
			return null;
		return enumMap.get(value);
	}

	/**
	 * 根据value 获取name
	 */
	public static String getEnumName(Integer value) {
		EnabledEnum enumItem = getEnum(value);
		if (enumItem == null)
			return null;
		return enumItem.getName();
	}
}
