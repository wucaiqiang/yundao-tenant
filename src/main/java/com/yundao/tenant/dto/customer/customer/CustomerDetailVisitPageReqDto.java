package com.yundao.tenant.dto.customer.customer;

import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 客户详情页回访分页数据
 *
 * @author jan
 * @create 2017-08-11 AM10:25
 **/
public class CustomerDetailVisitPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "客户id")
    @NotNull(message = "{" + CodeConstant.CODE_1220047 + "}")
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
