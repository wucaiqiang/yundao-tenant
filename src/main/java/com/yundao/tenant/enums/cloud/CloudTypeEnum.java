package com.yundao.tenant.enums.cloud;

import com.yundao.core.listener.SystemListener;
import com.yundao.tenant.service.cloudfile.CloudService;
import com.yundao.tenant.util.SpringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 云类型枚举
 * 
 * @author wupengfei wupf86@126.com
 *
 */
public enum CloudTypeEnum {

	/**
	 * 阿里云
	 */
	ALIYUN(0) {
		@Override
		public CloudService getCloudService() {
			return SpringUtils.getBean("aliyunServiceImpl", CloudService.class);
		}
	},

	/**
	 * 腾讯云
	 */
	TXYUN(1) {
		@Override
		public CloudService getCloudService() {
			return null;
		}
	},

	/**
	 * ucloud云
	 */
	UCLOUD(2) {
		@Override
		public CloudService getCloudService() {
			return null;
		}
	};

	private Integer value;
	private static Map<Integer, CloudTypeEnum> enumMap = new HashMap<Integer, CloudTypeEnum>();

	static {
		EnumSet<CloudTypeEnum> set = EnumSet.allOf(CloudTypeEnum.class);
		for (CloudTypeEnum each : set) {
			enumMap.put(each.getValue(), each);
		}
	}

	private CloudTypeEnum(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	/**
	 * 获取云服务
	 * 
	 * @return
	 */
	public abstract CloudService getCloudService();

	/**
	 * 获取云类型枚举
	 * 
	 * @param value
	 * @return
	 */
	public static CloudTypeEnum getCloudTypeEnum(Integer value) {
		return enumMap.get(value);
	}
}
