package com.yundao.tenant.dto.department;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户对用的部门
 *
 * @author jan
 * @create 2017-11-07 08:51
 **/
public class DepartmentUserDto {

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "理财师id")
    private Long fpId;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
    }
}
