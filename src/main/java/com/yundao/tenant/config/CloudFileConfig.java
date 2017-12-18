package com.yundao.tenant.config;

import com.yundao.tenant.enums.cloud.CloudConfigEnum;
import com.yundao.core.config.AbstractFileConfig;

/**
 * 云文件配置
 * 
 * @author wupengfei wupf86@126.com
 * 
 */
public abstract class CloudFileConfig extends AbstractFileConfig {

	private static final String FILE = "config/properties/cloud/cloud.properties";

	static {
		load(FILE, getKeyPrefix());
	}

	/**
	 * 获取指定键的值
	 * 
	 * @param config
	 * @return
	 */
	public static String getValue(CloudConfigEnum config) {
		return AbstractFileConfig.getValue(getKeyPrefix() + config.getKey(), null);
	}

	/**
	 * 获取配置文件中指定key的值，若==null则返回默认值
	 * 
	 * @param config
	 * @param defaultValue
	 * @return
	 */
	public static String getValue(CloudConfigEnum config, String defaultValue) {
		return AbstractFileConfig.getValue(getKeyPrefix() + config.getKey(), defaultValue);
	}

	/**
	 * 获取前辍
	 * 
	 * @return
	 */
	public static String getKeyPrefix() {
		return "cloud#";
	}

	/**
	 * 获取配置文件的路径
	 * 
	 * @return
	 */
	public static String getFile() {
		return FILE;
	}
}
