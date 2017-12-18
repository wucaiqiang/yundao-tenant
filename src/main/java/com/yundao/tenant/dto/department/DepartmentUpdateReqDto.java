package com.yundao.tenant.dto.department;


import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.annotation.FieldCode;
import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class DepartmentUpdateReqDto implements Serializable {

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    @NotNull(message = "{" + CodeConstant.CODE_1200006 + "}")
    private Long id;

    /**
     * 名称
     */
    @FieldCode("product_name")
    @ApiModelProperty(value = "名称")
    @Length(min = 1, max = 32, message = "{" + CodeConstant.CODE_1200053 + "}")
    private String name;

    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级id")
    @NotNull(message = "{" + CodeConstant.CODE_1200026 + "}")
    private Long parentId;

    /**
     * 描述
     */
    @FieldCode("product_buy_start_point")
    @ApiModelProperty(value = "描述")
    //@Length(min = 1, max = 32, message = "{" + CodeConstant.CODE_1220011 + "}")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private static final Long serialVersionUID = 1000L;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}