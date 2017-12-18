package com.yundao.tenant.dto.finance.receipt.plan;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 回款计划id
 *
 * @author jan
 * @create 2017-10-18 21:10
 **/
public class ReceiptPlanIdDto {

    @ApiModelProperty(value = "回款计划id")
    @NotNull(message = "{" + CodeConstant.CODE_1220124 + "}")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
