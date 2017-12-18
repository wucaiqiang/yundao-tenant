package com.yundao.tenant.enums;

public enum DeleteEnum {

	/**
	 * 正常
	 */
	NOT_DELETED(0, "正常"),

	/**
	 * 删除
	 */
	DELETED(1, "删除"),
	/**
	 * 腾讯云未删除成功
	 */
	REMOTE_UN_DELETE(2, "腾讯云未删除成功");
	private Integer value;
	private String name;

	private DeleteEnum(Integer value, String name) {
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
