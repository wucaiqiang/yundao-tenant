package com.yundao.tenant.enums.video;

public enum VideoCategoryEnum {

	/**
	 * 路演
	 */
	ROADSHOW(1, "路演"),
	/**
	 * 合规双录
	 */
	COMPLIANCE(2, "合规双录");
	private Integer value;
	private String name;


	private VideoCategoryEnum(Integer value, String name) {
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
