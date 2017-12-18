

package com.yundao.tenant.dto.customercenter.sale;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月8日 下午3:50:49 
 * @author   欧阳利
 * @version   
 */
public class DeclarationH5ResDto {

	@ApiModelProperty("报单id")
    private Long id;
	
	@ApiModelProperty("产品id")
    private Long productId;
	
	@ApiModelProperty("产品名称")
    private String productName;
	
	@ApiModelProperty("产品发现状态")
    private Integer productIssuedStatus;
	
	@ApiModelProperty("产品发现状态名称")
    private String productIssuedStatusText;

	@ApiModelProperty("认购金额")
    private Double dealAmount;
	
	@ApiModelProperty("打款日期")
	private Date payDate;
	
	@ApiModelProperty("报单日期")
	private Date declarationDate;
	
	@ApiModelProperty("理财师id")
	private Long fpId;
	
	@ApiModelProperty("理财师名称")
	private String fpRealName;

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
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

	public Integer getProductIssuedStatus() {
	
		return productIssuedStatus;
	}

	public void setProductIssuedStatus(Integer productIssuedStatus) {
	
		this.productIssuedStatus = productIssuedStatus;
	}

	public String getProductIssuedStatusText() {
	
		return productIssuedStatusText;
	}

	public void setProductIssuedStatusText(String productIssuedStatusText) {
	
		this.productIssuedStatusText = productIssuedStatusText;
	}

	public Double getDealAmount() {
	
		return dealAmount;
	}

	public void setDealAmount(Double dealAmount) {
	
		this.dealAmount = dealAmount;
	}


	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getDeclarationDate() {
	
		return declarationDate;
	}

	public void setDeclarationDate(Date declarationDate) {
	
		this.declarationDate = declarationDate;
	}

	public Long getFpId() {
	
		return fpId;
	}

	public void setFpId(Long fpId) {
	
		this.fpId = fpId;
	}

	public String getFpRealName() {
	
		return fpRealName;
	}

	public void setFpRealName(String fpRealName) {
	
		this.fpRealName = fpRealName;
	}


	
	
}

