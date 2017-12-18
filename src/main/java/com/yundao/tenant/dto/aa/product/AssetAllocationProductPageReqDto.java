

package com.yundao.tenant.dto.aa.product;

import com.yundao.tenant.dto.AbstractBasePageDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午4:27:57 
 * @author   欧阳利
 * @version   
 */
public class AssetAllocationProductPageReqDto extends AbstractBasePageDto {

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	
	private Long assetId;
	
	private Long userId;

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

	public Long getAssetId() {
	
		return assetId;
	}

	public void setAssetId(Long assetId) {
	
		this.assetId = assetId;
	}


	
}

