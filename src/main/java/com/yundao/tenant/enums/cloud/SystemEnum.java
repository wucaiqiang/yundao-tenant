package com.yundao.tenant.enums.cloud;

/**
 * 系统配置文件枚举
 * 
 * @author wupengfei wupf86@126.com
 *
 */
public enum SystemEnum {

	/**
	 * 异步操作的大小，单位B
	 */
	ASYNC_SIZE("async.size"),
	
	/**
	 * 是否保存本地文件0：否，1：是
	 */
	LOCAL_STORE("local.store"),
	
	/**
	 * 图片格式
	 */
	PICTURE_EXT("picture.ext");

	private String key;

	private SystemEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
