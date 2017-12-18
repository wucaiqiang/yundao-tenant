package com.yundao.tenant.dto.finance.receipt.plan;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划分页列表请求数据dto
 *
 * @author jan
 * @create 2017-10-12 17:53
 **/
public class ReceiptPlanPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "搜索范围；全部：all，本月：month，未完成：undone，默认全部")
    private String scope;

    @ApiModelProperty(value = "回款计划名称")
    private String name;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "关联交易数 区间最小值")
    private Integer declarationCountBegin;

    @ApiModelProperty(value = "关联交易数 区间最大值")
    private Integer declarationCountEnd;

    @ApiModelProperty(value = "计划金额 区间最小值")
    private Double amountBegin;

    @ApiModelProperty(value = "计划金额 区间最大值")
    private Double amountEnd;

    @ApiModelProperty(value = "回款次数 区间最小值")
    private Integer receiptCountBegin;

    @ApiModelProperty(value = "回款次数 区间最大值")
    private Integer receiptCountEnd;

    @ApiModelProperty(value = "实际回款金额 区间最小值")
    private Double actualReceiptAmountBegin;

    @ApiModelProperty(value = "实际回款金额 区间最大值")
    private Double actualReceiptAmountEnd;

    @ApiModelProperty(value = "创建日期 区间最小值")
    private String createDateBegin;

    @ApiModelProperty(value = "创建日期 区间最大值")
    private String createDateEnd;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getDeclarationCountBegin() {
        return declarationCountBegin;
    }

    public void setDeclarationCountBegin(Integer declarationCountBegin) {
        this.declarationCountBegin = declarationCountBegin;
    }

    public Integer getDeclarationCountEnd() {
        return declarationCountEnd;
    }

    public void setDeclarationCountEnd(Integer declarationCountEnd) {
        this.declarationCountEnd = declarationCountEnd;
    }

    public Double getAmountBegin() {
        return amountBegin;
    }

    public void setAmountBegin(Double amountBegin) {
        this.amountBegin = amountBegin;
    }

    public Double getAmountEnd() {
        return amountEnd;
    }

    public void setAmountEnd(Double amountEnd) {
        this.amountEnd = amountEnd;
    }

    public Integer getReceiptCountBegin() {
        return receiptCountBegin;
    }

    public void setReceiptCountBegin(Integer receiptCountBegin) {
        this.receiptCountBegin = receiptCountBegin;
    }

    public Integer getReceiptCountEnd() {
        return receiptCountEnd;
    }

    public void setReceiptCountEnd(Integer receiptCountEnd) {
        this.receiptCountEnd = receiptCountEnd;
    }

    public Double getActualReceiptAmountBegin() {
        return actualReceiptAmountBegin;
    }

    public void setActualReceiptAmountBegin(Double actualReceiptAmountBegin) {
        this.actualReceiptAmountBegin = actualReceiptAmountBegin;
    }

    public Double getActualReceiptAmountEnd() {
        return actualReceiptAmountEnd;
    }

    public void setActualReceiptAmountEnd(Double actualReceiptAmountEnd) {
        this.actualReceiptAmountEnd = actualReceiptAmountEnd;
    }

    public String getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(String createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public String getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
    }
}
