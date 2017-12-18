

package com.yundao.tenant.dto.sale.refund;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月16日 下午2:15:30 
 * @author   欧阳利
 * @version   
 */
public class MyRefundListResDto {

	@ApiModelProperty("退款id")
	private Long id;
	@ApiModelProperty("退款状态")
	private Integer status;
	@ApiModelProperty("退款状态名称")
	private String statusText;
	@ApiModelProperty("退款原因")
	private String reason;
	@ApiModelProperty("客户id")
	private Long customerId;
	@ApiModelProperty("客户名称")
	private String customerName;
	
	@ApiModelProperty("产品id")
	private Long productId;
	
	@ApiModelProperty("产品名称")
	private String productName;
	
	@ApiModelProperty("报单id")
	private Long declarationId;
	
	@ApiModelProperty("报单编号")
	private String declarationNumber;
	
	@ApiModelProperty("认购金额")
	private Double  dealAmount;
	
	@ApiModelProperty("打款日期")
	private Date payDate;
	
	@ApiModelProperty("报单时间")
	private Date declarationDate;
	@ApiModelProperty("审批原因")
	private String auditReason;
	public String getAuditReason() {
	
		return auditReason;
	}

	public void setAuditReason(String auditReason) {
	
		this.auditReason = auditReason;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}


	public Integer getStatus() {
	
		return status;
	}

	public void setStatus(Integer status) {
	
		this.status = status;
	}

	public String getStatusText() {
	
		return statusText;
	}

	public void setStatusText(String statusText) {
	
		this.statusText = statusText;
	}

	public String getReason() {
	
		return reason;
	}

	public void setReason(String reason) {
	
		this.reason = reason;
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

	public Long getDeclarationId() {
	
		return declarationId;
	}

	public void setDeclarationId(Long declarationId) {
	
		this.declarationId = declarationId;
	}

	public String getDeclarationNumber() {
	
		return declarationNumber;
	}

	public void setDeclarationNumber(String declarationNumber) {
	
		this.declarationNumber = declarationNumber;
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

	
}

