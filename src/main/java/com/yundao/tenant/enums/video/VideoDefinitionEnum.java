package com.yundao.tenant.enums.video;

public enum VideoDefinitionEnum {

	/**
	 * 原文件
	 */
	SOURCE(0, "原文件"),

	/**
	 * 普通
	 */
	GENERAL(10, "普通"),
	/**
	 * 标清
	 */
	STANDARD(20, "标清"),
	/**
	 * 高清
	 */
	HIGH(30, "高清"),
	/**
	 * 超高清
	 */
	SUPER_HIGH(40, "超高清");

	private Integer value;
	private String name;

	private VideoDefinitionEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

}
