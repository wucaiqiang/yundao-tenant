

package com.yundao.tenant.dto.workflow.task;

import java.util.Date;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月16日 下午3:49:28 
 * @author   欧阳利
 * @version   
 */
public class RefundTaskDto {
    private Long id;
    
    private Double dealAmount;
    
    private Date payDate;
    
    private String number;
    
    private String reason;
    
    private String productName;
    
    private Long declarationId;
    
    private String customerName;
    

	public Date getPayDate() {
	
		return payDate;
	}

	public void setPayDate(Date payDate) {
	
		this.payDate = payDate;
	}

	public Long getDeclarationId() {
	
		return declarationId;
	}

	public void setDeclarationId(Long declarationId) {
	
		this.declarationId = declarationId;
	}


	public String getCustomerName() {
	
		return customerName;
	}

	public void setCustomerName(String customerName) {
	
		this.customerName = customerName;
	}

	public String getProductName() {
	
		return productName;
	}

	public void setProductName(String productName) {
	
		this.productName = productName;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public Double getDealAmount() {
	
		return dealAmount;
	}

	public void setDealAmount(Double dealAmount) {
	
		this.dealAmount = dealAmount;
	}

	public String getNumber() {
	
		return number;
	}

	public void setNumber(String number) {
	
		this.number = number;
	}

	public String getReason() {
	
		return reason;
	}

	public void setReason(String reason) {
	
		this.reason = reason;
	}
}

