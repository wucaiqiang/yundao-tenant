package com.yundao.tenant.enums.video;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


public enum VideoStatusEnum {

	/**
	 * 压缩中
	 */
	TRANSCODING(0, "压缩中"),

	/**
	 * 正常
	 */
	NORMAL(1, "压缩完成");
	private Integer value;
	private String name;

	private static Map<Integer, VideoStatusEnum> enumMap = new HashMap<>();
	static {
		EnumSet<VideoStatusEnum> set = EnumSet.allOf(VideoStatusEnum.class);
		for (VideoStatusEnum each : set) {
			enumMap.put(each.getValue(), each);
		}
	}

	private VideoStatusEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	/**
	 * 获取枚举
	 */
	public static VideoStatusEnum getEnum(Integer value) {
		if (value == null)
			return null;
		return enumMap.get(value);
	}

}
