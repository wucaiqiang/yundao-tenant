package com.yundao.tenant.enums.bo;

import com.yundao.core.utils.BooleanUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 字段类型枚举
 *
 * @author jan
 * @create 2017-07-06 PM3:55
 **/
public enum FieldTypeEnum {


    /**
     * 文本
     */
    TEXT("text", "文本"),

    /**
     * 文本域
     */
    TEXT_AREA("textarea", "文本域"),

    /**
     * 图片
     */
    IMAGE("image", "图片"),

    /**
     * 日期
     */
    DATE("date", "日期"),

    /**
     * 日期区间
     */
    DATE_RANGE("date_range", "日期区间"),

    /**
     * 下拉选项
     */
    SELECT("select", "下拉选项"),

    /**
     * 单选
     */
    RADIO("radio", "单选"),

    /**
     * 多选
     */
    CHECKBOX("checkbox", "多选"),

    /**
     * 数值
     */
    NUMBER("number", "数值"),

    /**
     * 数值区间
     */
    NUMBER_RANGE("number_range", "数值区间"),

    /**
     * 地址
     */
    ADDRESS("address", "地址");

    private String code;
    private String name;
    private static Map<String, FieldTypeEnum> enumMap = new HashMap<>();
    private static Map<String, FieldTypeEnum> selectionMap = new HashMap<>(3);
    private static Map<String, FieldTypeEnum> numberMap = new HashMap<>(3);


    static {
        EnumSet<FieldTypeEnum> set = EnumSet.allOf(FieldTypeEnum.class);
        for (FieldTypeEnum each : set) {
            enumMap.put(each.getCode(), each);
        }
        selectionMap.put(FieldTypeEnum.SELECT.getCode(), FieldTypeEnum.SELECT);
        selectionMap.put(FieldTypeEnum.RADIO.getCode(), FieldTypeEnum.RADIO);
        selectionMap.put(FieldTypeEnum.CHECKBOX.getCode(), FieldTypeEnum.CHECKBOX);

        numberMap.put(FieldTypeEnum.NUMBER.getCode(), FieldTypeEnum.NUMBER);
        numberMap.put(FieldTypeEnum.NUMBER_RANGE.getCode(), FieldTypeEnum.NUMBER_RANGE);

    }

    FieldTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取枚举
     */
    public static FieldTypeEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        FieldTypeEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

    public static boolean isSelection(String code) {
        if (BooleanUtils.isEmpty(code))
            return false;
        return selectionMap.get(code) != null;
    }

    public static boolean isNumber(String code) {
        if (BooleanUtils.isEmpty(code))
            return false;
        return numberMap.get(code) != null;
    }
}
