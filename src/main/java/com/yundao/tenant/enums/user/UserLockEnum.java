package com.yundao.tenant.enums.user;

/**
 * 用户锁定枚举
 * 
 * @author 欧阳利
 * 2017年6月22日
 */
public enum UserLockEnum {
	
	/**
	 * 没有锁定
	 */
	USER_NOT_LOCK(0, "没有锁定"),
	
	/**
	 * 锁定
	 */
	USER_LOCK(1, "锁定");
	private Integer value;
	private String name;
	

	private UserLockEnum(Integer value, String name) {
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
