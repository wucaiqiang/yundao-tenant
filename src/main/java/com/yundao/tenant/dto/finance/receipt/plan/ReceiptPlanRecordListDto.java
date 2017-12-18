package com.yundao.tenant.dto.finance.receipt.plan;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划详情回款记录列表dto
 *
 * @author jan
 * @create 2017-10-14 09:08
 **/
public class ReceiptPlanRecordListDto {

    @ApiModelProperty(value = "回款记录id")
    private Long id;

    @ApiModelProperty(value = "回款日期")
    private String payDate;

    @ApiModelProperty(value = "回款金额")
    private String amount;

    @ApiModelProperty(value = "回款单位")
    private String payUnit;

    @ApiModelProperty(value = "回款银行")
    private String bankName;

    @ApiModelProperty(value = "回款账号")
    private String payAccount;

    @ApiModelProperty(value = "是否开具发票")
    private Integer isInvoiced;

    @ApiModelProperty(value = "是否开具发票文本")
    private String isInvoicedText;

    @ApiModelProperty(value = "开票时间")
    private String invoicedDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public Integer getIsInvoiced() {
        return isInvoiced;
    }

    public void setIsInvoiced(Integer isInvoiced) {
        this.isInvoiced = isInvoiced;
    }

    public String getIsInvoicedText() {
        return isInvoicedText;
    }

    public void setIsInvoicedText(String isInvoicedText) {
        this.isInvoicedText = isInvoicedText;
    }

    public String getInvoicedDate() {
        return invoicedDate;
    }

    public void setInvoicedDate(String invoicedDate) {
        this.invoicedDate = invoicedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
