package com.yundao.tenant.dto.finance.receipt.plan;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划分页列表返回数据dto
 *
 * @author jan
 * @create 2017-10-12 17:42
 **/
public class ReceiptPlanPageResDto {

    @ApiModelProperty(value = "回款计划id")
    private Long id;

    @ApiModelProperty(value = "回款计划名称")
    private String name;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "关联交易数")
    private Integer declarationCount;

    @ApiModelProperty(value = "计划金额")
    private String amount;

    @ApiModelProperty(value = "回款次数")
    private Integer receiptCount;

    @ApiModelProperty(value = "实际回款金额")
    private String actualReceiptAmount;

    @ApiModelProperty(value = "创建日期")
    private String createDate;

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

    public Integer getDeclarationCount() {
        return declarationCount;
    }

    public void setDeclarationCount(Integer declarationCount) {
        this.declarationCount = declarationCount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getReceiptCount() {
        return receiptCount;
    }

    public void setReceiptCount(Integer receiptCount) {
        this.receiptCount = receiptCount;
    }

    public String getActualReceiptAmount() {
        return actualReceiptAmount;
    }

    public void setActualReceiptAmount(String actualReceiptAmount) {
        this.actualReceiptAmount = actualReceiptAmount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
