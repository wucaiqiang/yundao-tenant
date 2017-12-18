package com.yundao.tenant.enums.sms;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信扩展类型枚举
 *
 * @author jan
 * @create 2017-06-20 PM12:20
 **/
public enum SmsAssistantContentStatusEnum {

	/**
	 * 未发送
	 */
	UN_SEND(0, "未发送"),
	/**
	 * 发送成功
	 */
	SEND_SUCCESS(1, "发送成功"),
	/**
	 * 发送失败
	 */
	SEND_FAIL(2, "发送失败");

	private Integer value;
	private String name;
	private static Map<Integer, SmsAssistantContentStatusEnum> enumMap = new HashMap<Integer, SmsAssistantContentStatusEnum>();

	static {
		EnumSet<SmsAssistantContentStatusEnum> set = EnumSet.allOf(SmsAssistantContentStatusEnum.class);
		for (SmsAssistantContentStatusEnum each : set) {
			enumMap.put(each.getValue(), each);
		}
	}

	SmsAssistantContentStatusEnum(Integer value, String name) {
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
	 *
	 * @param value
	 * @return
	 */
	public static SmsAssistantContentStatusEnum getSmsAssistantContentStatusEnum(Integer value) {
		return enumMap.get(value);
	}
}
