package com.yundao.tenant.dto.bo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 业务对象字段dto
 *
 * @author jan
 * @create 2017-07-06 PM1:57
 **/
public class ObjectFieldSimpleResDto {


    /**
     * 业务对象字段id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 字段id
     */
    private Long fieldId;

    /**
     * 字段名称
     */
    @ApiModelProperty(value = "字段名称")
    private String name;

    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String code;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }
}
