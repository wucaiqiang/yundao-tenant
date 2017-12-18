package com.yundao.tenant.dto.product.attach;

import com.yundao.tenant.dto.AbstractBasePageDto;

/**
 * 附件列表查询
 * 
 * @author 欧阳利
 * 2017年7月11日
 */
public class ProductAttachListReqDto extends AbstractBasePageDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 产品id
	 */
	private Long productId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
