

package com.yundao.tenant.dto.aa.asset;

import com.yundao.tenant.dto.AbstractBasePageDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午4:29:04 
 * @author   欧阳利
 * @version   
 */
public class AssetAllocationPageReqDto extends AbstractBasePageDto {
    
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
    
    private Long customerId;

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}
    
}

