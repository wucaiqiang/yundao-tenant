package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseProductSale extends BaseModel implements Serializable {
    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 拟销售日期开始日期
	 */
    private Date saleStartDate;

    /**
	 * 拟销售日期结束日期
	 */
    private Date saleEndDate;

    /**
	 * 是否有规模
	 */
    private Integer isScale;

    /**
	 * 产品规模
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
	 * 募集银行
	 */
    private String payRemark;

    private static final long serialVersionUID = 1L;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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