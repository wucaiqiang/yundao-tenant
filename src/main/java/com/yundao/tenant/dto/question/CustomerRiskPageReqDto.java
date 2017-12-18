

package com.yundao.tenant.dto.question;

import com.yundao.tenant.dto.AbstractBasePageDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月11日 上午11:17:07 
 * @author   欧阳利
 * @version   
 */
public class CustomerRiskPageReqDto extends AbstractBasePageDto{
    
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}
    
}

