package com.yundao.tenant.dto.customer.customer;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-09-09 PM3:16
 **/
public class CustomerIdReqDto {

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
