package com.yundao.tenant.dto.finance.receipt.plan;

import com.yundao.tenant.model.base.finance.BaseReceiptPlan;
import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划分页列表返回数据dto
 *
 * @author jan
 * @create 2017-10-12 17:42
 **/
public class ReceiptPlanAmountResDto extends BaseReceiptPlan{

    @ApiModelProperty(value = "计划总金额")
    private Double totalAmount;

    @ApiModelProperty(value = "实际回款金额")
    private Double realityAmount;

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getRealityAmount() {
        return realityAmount;
    }

    public void setRealityAmount(Double realityAmount) {
        this.realityAmount = realityAmount;
    }

    public ReceiptPlanAmountResDto() {
    }

    public ReceiptPlanAmountResDto(Double totalAmount, Double realityAmount) {
        this.totalAmount = totalAmount;
        this.realityAmount = realityAmount;
    }
}
