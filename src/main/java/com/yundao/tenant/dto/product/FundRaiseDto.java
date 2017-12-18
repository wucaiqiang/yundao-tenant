package com.yundao.tenant.dto.product;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 基金募集信息
 *
 * @author jan
 * @create 2017-11-25 14:30
 **/
public class FundRaiseDto extends BaseModel implements Serializable {

    /**
     * 基金ID
     */
    private Long fundId;

    /**
     * 拟销售开始日期
     */
    private Date saleStartDate;

    /**
     * 拟销售结束日期
     */
    private Date saleEndDate;

    /**
     * 是否有规模
     */
    private Integer isScale;

    /**
     * 规模
     */
    private Double productScale;

    /**
     * 投资币种
     */
    private String currencyCode;

    /**
     * 打款账号
     */
    private String payAccount;

    /**
     * 开户名
     */
    private String accountName;

    /**
     * 募集银行
     */
    private String raiseBank;

    /**
     * 打款备注
     */
    private String payRemark;

    private static final long serialVersionUID = 1L;

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public Date getSaleStartDate() {
        return saleStartDate;
    }

    public void setSaleStartDate(Date saleStartDate) {
        this.saleStartDate = saleStartDate;
    }

    public Date getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(Date saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

    public Integer getIsScale() {
        return isScale;
    }

    public void setIsScale(Integer isScale) {
        this.isScale = isScale;
    }

    public Double getProductScale() {
        return productScale;
    }

    public void setProductScale(Double productScale) {
        this.productScale = productScale;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getRaiseBank() {
        return raiseBank;
    }

    public void setRaiseBank(String raiseBank) {
        this.raiseBank = raiseBank;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

}
