package com.yundao.tenant.dto.product;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ProductSaleUpdateReqDto {
    /**
	 * 拟销售日期开始日期
	 */
    @ApiModelProperty(value=" 拟销售日期开始日期")
    private Date saleStartDate;

    /**
	 * 拟销售日期结束日期
	 */
    @ApiModelProperty(value="拟销售日期结束日期")
    private Date saleEndDate;

    /**
	 * 是否有规模
	 */
    @ApiModelProperty(value="是否有规模")
    private Integer isScale;

    /**
	 * 产品规模
	 */
    @ApiModelProperty(value="产品规模")
    private Double productScale;

    /**
	 * 投资币种
	 */
    @ApiModelProperty(value="投资币种")
    private String currencyCode;

    /**
	 * 打款账号
	 */
    @ApiModelProperty(value="打款账号")
    private String payAccount;
    


    @ApiModelProperty(value="产品id")
    private Long id;
    
    /**
	 * 开户名
	 */
    @ApiModelProperty(value="开户名")
    private String accountName;

    /**
	 * 募集银行
	 */
    @ApiModelProperty(value=" 募集银行")
    private String raiseBank;

    /**
	 * 打款备注
	 */
    @ApiModelProperty(value="打款备注")
    private String payRemark;
    
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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
