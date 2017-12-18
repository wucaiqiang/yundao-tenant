

package com.yundao.tenant.dto.customer.credentials;

import com.yundao.tenant.model.base.customer.BaseCustomerCredentials;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年8月10日 上午11:35:13 
 * @author   wucq
 * @version   
 */
public class CustomerCredentialsDto extends BaseCustomerCredentials {
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	 private String typeText;
	public String getTypeText() {
	
		return typeText;
	}
	public void setTypeText(String typeText) {
	
		this.typeText = typeText;
	}
	

}

