package com.yundao.tenant.enums.video;

/**
 * 
 * date: 2017年7月15日 下午2:10:01
 * 
 * @author:wucq
 * @description:
 */
public enum VideoHandleTypeEnum {
	/**
	 * 上传完成
	 */
	UPLOAD("upload", "上传完成"),
	/**
	 * 转码完成
	 */
	TRANSCODE("transcode", "转码完成");
	private VideoHandleTypeEnum(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	private String value;
	private String desc;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
	
		return desc;
	}

	public void setDesc(String desc) {
	
		this.desc = desc;
	}
	
}
