package com.yundao.tenant.enums.product.examine;

import com.yundao.tenant.dto.field.FiledSelectDto;
import com.yundao.tenant.dto.field.SelectConfigStringValueDto;

import java.util.*;

/**
 * 产品审核状态
 *
 * @author jan
 * @create 2017-07-22 PM3:36
 **/
public enum ProductExamineStatusEnum {


    /**
     * 未提交
     */
    INITIAL(0, "未提交"),

    /**
     * 审核中
     */
    APPROVALING(1, "审批中"),

    /**
     * 已通过
     */
    PASS(2, "已通过"),

    /**
     * 已驳回
     */
    REJECT(3, "已驳回"),

    /**
     * 已撤销
     */
    CANCEL(4, "已撤销");

    private Integer value;
    private String name;
    private static Map<Integer, ProductExamineStatusEnum> enumMap = new HashMap<>();

    static {
        EnumSet<ProductExamineStatusEnum> set = EnumSet.allOf(ProductExamineStatusEnum.class);
        for (ProductExamineStatusEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    ProductExamineStatusEnum(Integer value, String name) {
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
    public static ProductExamineStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    public static Boolean canAudit(Integer value) {
        return ProductExamineStatusEnum.APPROVALING.getValue().equals(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        ProductExamineStatusEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

    public static FiledSelectDto getFiledSelectDto() {
        FiledSelectDto dto = new FiledSelectDto();
        dto.setLable("审批状态");
        dto.setName("examineStatus");
        List<SelectConfigStringValueDto> fieldConfigDtos = new ArrayList<SelectConfigStringValueDto>();
        for (Integer code : enumMap.keySet()) {
            ProductExamineStatusEnum each = enumMap.get(code);
            SelectConfigStringValueDto configDto = new SelectConfigStringValueDto();
            configDto.setLable(each.getName());
            configDto.setValue(each.getValue().toString());
            configDto.setSequence(each.ordinal());
            fieldConfigDtos.add(configDto);
        }
        dto.setFieldConfigDtos(fieldConfigDtos);
        return dto;
    }

}
