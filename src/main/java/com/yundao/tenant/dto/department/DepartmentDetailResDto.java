package com.yundao.tenant.dto.department;

import com.yundao.tenant.annotation.FieldCode;
import io.swagger.annotations.ApiModelProperty;

/**
 * 部门详情
 *
 * @author jan
 * @create 2017-07-01 PM5:50
 **/
public class DepartmentDetailResDto {

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Long id;

    /**
     * 部门名称
     */
    @FieldCode("product_name")
    @ApiModelProperty(value = "部门名称")
    private String name;

    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级id")
    private long parentId;

    /**
     * 父级部门名称
     */
    @ApiModelProperty(value = "父级部门名称")
    private String parentName;

    private Long createUserId;

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

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
}
