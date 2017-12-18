package com.yundao.tenant.model.base.finance;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseReceiptRecord extends BaseModel implements Serializable {
    /**
	 * 回款记录ID
	 */
    private Long receiptPlanId;

    /**
	 * 回款金额
	 */
    private Double amount;

    /**
	 * 回款日期
	 */
    private Date payDate;

    /**
	 * 回款单位
	 */
    private String payUnit;

    /**
	 * 回款银行
	 */
    private String bankName;

    /**
	 * 回款账号
	 */
    private String payAccount;

    /**
	 * 是否开具发票
	 */
    private Integer isInvoiced;

    /**
	 * 开票时间
	 */
    private Date invoicedDate;

    /**
	 * 备注
	 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getReceiptPlanId() {
        return receiptPlanId;
    }

    public void setReceiptPlanId(Long receiptPlanId) {
        this.receiptPlanId = receiptPlanId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
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

    public Date getInvoicedDate() {
        return invoicedDate;
    }

    public void setInvoicedDate(Date invoicedDate) {
        this.invoicedDate = invoicedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}