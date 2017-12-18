package com.yundao.tenant.enums.question;

public enum QuestionTypeCodeEnum {
	
	/**
	 * 跟进状态
	 */
	RISK(1,"risk");

	private Integer value;
	private String code;
	
	QuestionTypeCodeEnum(Integer value,String code) {
		this.value = value;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public Integer getValue() {
		return value;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
