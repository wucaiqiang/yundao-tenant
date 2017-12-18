package com.yundao.tenant.dto.finance.receipt;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 回款记录添加请求dto
 *
 * @author jan
 * @create 2017-10-14 15:24
 **/
public class ReceiptRecordAddReqDto {

    @ApiModelProperty(value = "回款计划id")
    @NotNull(message = "{" + CodeConstant.CODE_1220124 + "}")
    private Long receiptPlanId;

    @ApiModelProperty(value = "回款金额")
    @NotNull(message = "{" + CodeConstant.CODE_1220131 + "}")
    private Double amount;

    @ApiModelProperty(value = "回款日期")
    @NotNull(message = "{" + CodeConstant.CODE_1220132 + "}")
    private String payDate;

    @ApiModelProperty(value = "回款单位")
    @Length(max = 50, message = "{" + CodeConstant.CODE_1220133 + "}")
    private String payUnit;

    @ApiModelProperty(value = "回款银行")
    @Length(max = 50, message = "{" + CodeConstant.CODE_1220134 + "}")
    private String bankName;

    @ApiModelProperty(value = "回款账号")
    private String payAccount;

    @ApiModelProperty(value = "是否开票，输入 1 为已开票，否则为未开票")
    private Integer isInvoiced;

    @ApiModelProperty(value = "开票时间")
    private String invoicedDate;

    @ApiModelProperty(value = "备注")
    @Length(max = 200, message = "{" + CodeConstant.CODE_1220137 + "}")
    private String remark;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
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

    public Long getReceiptPlanId() {
        return receiptPlanId;
    }

    public void setReceiptPlanId(Long receiptPlanId) {
        this.receiptPlanId = receiptPlanId;
    }
}
