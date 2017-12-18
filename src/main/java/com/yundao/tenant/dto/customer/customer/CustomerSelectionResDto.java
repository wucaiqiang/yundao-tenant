package com.yundao.tenant.dto.customer.customer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户下拉选项dto
 *
 * @author jan
 * @create 2017-08-23 PM8:26
 **/
public class CustomerSelectionResDto {

    @ApiModelProperty(value = "客户id")
    private Long id;

    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
