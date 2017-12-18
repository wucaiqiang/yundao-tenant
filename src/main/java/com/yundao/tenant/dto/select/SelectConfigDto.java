package com.yundao.tenant.dto.select;

/**
 * @author jan
 * @create 2017-07-16 PM5:46
 **/
public class SelectConfigDto {

    /**
     * id
     */
    private Long id;

    /**
     * 对象字段编码
     */
    private String objectFieldCode;

    /**
     * 选项值
     */
    private Integer value;

    /**
     * 选项文本
     */
    private String label;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectFieldCode() {
        return objectFieldCode;
    }

    public void setObjectFieldCode(String objectFieldCode) {
        this.objectFieldCode = objectFieldCode;
    }

}
