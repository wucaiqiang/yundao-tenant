package com.yundao.tenant.enums.product;

import com.yundao.tenant.dto.field.FiledSelectDto;
import com.yundao.tenant.dto.field.SelectConfigStringValueDto;

import java.util.*;

/**
 * 产品发行状态
 *
 * @author 欧阳利
 *         2017年7月24日
 */
public enum ProductIssuedStatusEnum {

    /**
     * 上线准备中
     */
    ON_LINE_PRE(1, "上线准备中"),

    /**
     * 预售
     */
    PRE_SAISE(2, "预售"),

    /**
     * 募集中
     */
    TO_RAISE(3, "募集中"),

    /**
     * 募集结束
     */
    RAISE_END(4, "募集结束"),

    /**
     * 存续封闭中
     */
    SURVIVING(5, "存续/封闭中"),

    /**
     * 清算退出
     */
    CLEAR_OUT(6, "清算退出"),

    /**
     * 未上线
     */
    NOT_ON_LINE(0, "未上线");


    private Integer value;

    private String name;

    private static Map<Integer, ProductIssuedStatusEnum> allEnumMap = new HashMap<Integer, ProductIssuedStatusEnum>();


    static {
        EnumSet<ProductIssuedStatusEnum> set = EnumSet.allOf(ProductIssuedStatusEnum.class);
        for (ProductIssuedStatusEnum each : set) {
            allEnumMap.put(each.getValue(), each);
        }
    }

    private ProductIssuedStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static FiledSelectDto getFiledSelectDto() {
        FiledSelectDto dto = new FiledSelectDto();
        dto.setLable("发行状态");
        dto.setName("issuedStatus");
        List<SelectConfigStringValueDto> fieldConfigDtos = new ArrayList<SelectConfigStringValueDto>();
        for (Integer code : allEnumMap.keySet()) {
            ProductIssuedStatusEnum each = allEnumMap.get(code);
            SelectConfigStringValueDto configDto = new SelectConfigStringValueDto();
            configDto.setLable(each.getName());
            configDto.setValue(each.getValue().toString());
            configDto.setSequence(each.ordinal());
            fieldConfigDtos.add(configDto);
        }
        dto.setFieldConfigDtos(fieldConfigDtos);
        return dto;
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        ProductIssuedStatusEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

    /**
     * 获取枚举
     */
    public static ProductIssuedStatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return allEnumMap.get(value);
    }
    
    /**
     * 获取产品中心的产品状态集合
     * @return
     */
    public static List<Integer> getProductCenterStatus(){
    	List<Integer> all = new ArrayList<Integer>();
    	all.add(PRE_SAISE.getValue());
    	all.add(TO_RAISE.getValue());
    	all.add(RAISE_END.getValue());
    	all.add(SURVIVING.getValue());
    	all.add(CLEAR_OUT.getValue());
    	all.add(PRE_SAISE.getValue());
    	return all;
    }
    
    /**
     * 获取产品中心的产品状态集合
     * @return
     */
    public static List<Integer> getProductCenterSaleStatus(){
    	List<Integer> all = new ArrayList<Integer>();
    	all.add(PRE_SAISE.getValue());
    	all.add(TO_RAISE.getValue());
    	return all;
    }
}
