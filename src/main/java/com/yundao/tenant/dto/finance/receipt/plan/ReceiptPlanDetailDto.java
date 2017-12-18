package com.yundao.tenant.dto.finance.receipt.plan;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划详情dto
 *
 * @author jan
 * @create 2017-10-13 15:00
 **/
public class ReceiptPlanDetailDto {

    @ApiModelProperty(value = "回款计划id")
    private Long id;

    @ApiModelProperty(value = "回款计划名称")
    private String name;

    @ApiModelProperty(value = "回款计划金额")
    private String amount;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "回款单位")
    private String payUnit;

    @ApiModelProperty(value = "实际回款金额")
    private String actualReceiptAmount;

    @ApiModelProperty(value = "备注")
    private String remark;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public String getActualReceiptAmount() {
        return actualReceiptAmount;
    }

    public void setActualReceiptAmount(String actualReceiptAmount) {
        this.actualReceiptAmount = actualReceiptAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
