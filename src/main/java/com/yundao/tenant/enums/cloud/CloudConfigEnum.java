package com.yundao.tenant.enums.cloud;

/**
 * 云文件枚举类
 *
 * @author wupengfei wupf86@126.com
 *
 */
public enum CloudConfigEnum {

	/**
	 * 云类型 0:阿里云,1:腾讯云, 2:ucloud云
	 */
	CLOUD_TYPE("cloud.type"),

	/**
	 * 默认目录
	 */
	DEFAULT_FOLDER("default.folder"),

	/**
	 * 本地根目录
	 */
	LOCAL_ROOT_FOLDER("local.root.folder"),

	/**
	 * 是否增加系统标识，0：否，1：是
	 */
	IS_ADD_SYSTEM_ID("is.add.system.id"),

	/**
	 * 访问文件的本地链接
	 */
	LOCAL_URL("local.url"),

	/**
	 * 阿里云用户名
	 */
	ALIYUN_USERNAME("aliyun.username"),

	/**
	 * 阿里云密码
	 */
	ALIYUN_PASSWORD("aliyun.password"),

	/**
	 * 阿里云桶名
	 */
	ALIYUN_BUCKET_NAME("aliyun.bucket.name"),

	/**
	 * 阿里云链接
	 */
	ALIYUN_URL("aliyun.url"),
	
	/**
	 * 腾讯云secretId
	 */
	SECRETID("tencent.secretId"),
	
	/**
	 * 腾讯云secretKey
	 */
	SECRETKEY("tencent.secretKey"),
	
	/**
	 * 阿里云存储文件的链接
	 */
	ALIYUN_ENDPOINT("aliyun.endpoint");

	private String key;

	private CloudConfigEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
