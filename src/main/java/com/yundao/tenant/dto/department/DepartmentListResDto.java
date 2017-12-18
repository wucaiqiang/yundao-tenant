package com.yundao.tenant.dto.department;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.annotation.FieldCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DepartmentListResDto implements Serializable {

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Long id;

    /**
     * 子部门
     */
    @ApiModelProperty(value = "子部门")
    private List<DepartmentListResDto> childs;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 编码（最小八位数，最大支持八层，从00000001开始）
     */
    @ApiModelProperty(value = "编码（最小八位数，最大支持八层，从00000001开始）")
    private String code;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;


    private static final long serialVersionUID = 1000L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public void addChild(DepartmentListResDto child) {
        childs.add(child);
    }

    public List<DepartmentListResDto> getChilds() {
        if (BooleanUtils.isEmpty(this.childs))
            this.childs = new ArrayList<>();
        return childs;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}