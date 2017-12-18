package com.yundao.tenant.enums.keypair;

/**
 * 
 * date: 2017年7月15日 下午2:10:01
 * @author:wucq
 * @description:
 */
public enum KeyPairAreaEnum {
	/**
	 * 传输
	 */
	TRAN("tran"), 
	/**
	 * db数据加密
	 */
	DB("db");
	private KeyPairAreaEnum(String value) {
		this.value = value;
	}
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
