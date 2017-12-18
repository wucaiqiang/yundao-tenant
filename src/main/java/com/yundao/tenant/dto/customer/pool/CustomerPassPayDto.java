

package com.yundao.tenant.dto.customer.pool;

import java.util.Date;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月16日 下午7:31:58 
 * @author   欧阳利
 * @version   
 */
public class CustomerPassPayDto {
    private Long customerId;
    
    private String payDate;
    
    private Long declarationId;

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}

	public String getPayDate() {
	
		return payDate;
	}

	public void setPayDate(String payDate) {
	
		this.payDate = payDate;
	}

	public Long getDeclarationId() {
	
		return declarationId;
	}

	public void setDeclarationId(Long declarationId) {
	
		this.declarationId = declarationId;
	}
    
}

