

package com.yundao.tenant.dto.customercenter.sale;

import com.yundao.tenant.dto.AbstractBasePageDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月8日 下午3:55:22 
 * @author   欧阳利
 * @version   
 */
public class DeclarationH5ReqDto extends AbstractBasePageDto{

	
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

