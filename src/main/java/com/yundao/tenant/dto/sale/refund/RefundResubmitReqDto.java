package com.yundao.tenant.dto.sale.refund;

import javax.validation.constraints.NotNull;

import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

/**
 * 我的报单申请审核请求数据dto
 *
 * @author jan
 * @create 2017-08-25 AM11:39
 **/
public class RefundResubmitReqDto {

    @ApiModelProperty(value = "退款id")
    @NotNull(message = "{" + CodeConstant.CODE_1200148 + "}")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
