package com.yundao.tenant.dto.customer.customer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户下拉选项请求dto
 *
 * @author jan
 * @create 2017-08-23 PM8:42
 **/
public class CustomerSelectionReqDto {

    @ApiModelProperty(value = "客户姓名")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
