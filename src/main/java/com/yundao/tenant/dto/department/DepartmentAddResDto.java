package com.yundao.tenant.dto.department;

import com.yundao.core.validator.number.Number;
import com.yundao.tenant.model.base.BaseDepartment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DepartmentAddResDto implements Serializable {

    /**
     * 部门id
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 编码（最小八位数，最大支持八层，从00000001开始）
     */
    private String code;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 描述
     */
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentAddResDto(BaseDepartment department) {
        this.name = department.getName();
        this.code = department.getCode();
        this.description = department.getDescription();
        this.parentId = department.getParentId();
        this.id = department.getId();
    }

}