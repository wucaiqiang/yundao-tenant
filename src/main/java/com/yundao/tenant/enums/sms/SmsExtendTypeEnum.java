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
public enum SmsExtendTypeEnum {

    /**
     * 追加
     */
    APPEND(1, "追加"),


    /**
     * 过滤
     */
    FILTER(2, "过滤");

    private Integer value;
    private String name;
    private static Map<Integer, SmsExtendTypeEnum> enumMap = new HashMap<Integer, SmsExtendTypeEnum>();

    static {
        EnumSet<SmsExtendTypeEnum> set = EnumSet.allOf(SmsExtendTypeEnum.class);
        for (SmsExtendTypeEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    SmsExtendTypeEnum(Integer value, String name) {
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
    public static SmsExtendTypeEnum getSmsExtendTypeEnum(Integer value) {
        return enumMap.get(value);
    }
}
