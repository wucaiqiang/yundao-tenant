package com.yundao.tenant.enums.user;


/**
 * 用户离职枚举
 * @author Administrator
 *
 */
public enum UserDimissionEnum {
	/**
	 * 没有离职
	 */
	USER_NOT_DIMISSION(0, "正常"),
	
	/**
	 * 锁定
	 */
	USER_DIMISSION(1, "锁定");
	private Integer value;
	private String name;
	

	private UserDimissionEnum(Integer value, String name) {
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
