

package com.yundao.tenant.dto.report.declaration;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月4日 上午9:31:52 
 * @author   欧阳利
 * @version   
 */
public class DepartmentUserDeclarationDto {
	@ApiModelProperty("报单id")
    private Long id;
	@ApiModelProperty("报单状态")
    private Integer declarationStatus;
	@ApiModelProperty("报单状态")
    private String declarationStatusText;
	@ApiModelProperty("产品id")
    private Long productId;
	@ApiModelProperty("产品名称")
    private String productName;
	@ApiModelProperty("客户id")
    private Long customerId;
	@ApiModelProperty("客户名称")
    private String customerName;
	@ApiModelProperty("打款凭证")
	private Boolean hasCertificate;
	@ApiModelProperty("认购金额")
	private Double dealAmount;
	@ApiModelProperty("打款日期")
	private Date payDate;
	@ApiModelProperty("报单日期")
	private Date applyDate;
	
	public Date getApplyDate() {
	
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
	
		this.applyDate = applyDate;
	}
	public String getDeclarationStatusText() {
	
		return declarationStatusText;
	}
	public void setDeclarationStatusText(String declarationStatusText) {
	
		this.declarationStatusText = declarationStatusText;
	}
	public void setDeclarationStatus(Integer declarationStatus) {
	
		this.declarationStatus = declarationStatus;
	}
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
	
		this.id = id;
	}
	public Integer getDeclarationStatus() {
	
		return declarationStatus;
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
	public Long getCustomerId() {
	
		return customerId;
	}
	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}
	public String getCustomerName() {
	
		return customerName;
	}
	public void setCustomerName(String customerName) {
	
		this.customerName = customerName;
	}
	public Boolean getHasCertificate() {
	
		return hasCertificate;
	}
	public void setHasCertificate(Boolean hasCertificate) {
	
		this.hasCertificate = hasCertificate;
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
	
	
}

