
package com.yundao.tenant.dto.customer.customer;

import com.yundao.tenant.model.base.customer.BaseCustomer;

/**
 * Function: Reason: Date: 2017年10月14日 下午4:12:18
 * 
 * @author wucq
 * @version
 */
public class CustomerDto extends BaseCustomer {
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 所属于理财师ID 
	 */
	private Long userId;

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}
	
}
