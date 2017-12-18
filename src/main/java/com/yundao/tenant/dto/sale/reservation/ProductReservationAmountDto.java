

package com.yundao.tenant.dto.sale.reservation;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月14日 下午3:15:45 
 * @author   欧阳利
 * @version   
 */
public class ProductReservationAmountDto {
    
	@ApiModelProperty("产品id")
	private Long productId;
	
	@ApiModelProperty("预约总金额")
    private Double sumAmount;

	public Long getProductId() {
	
		return productId;
	}

	public void setProductId(Long productId) {
	
		this.productId = productId;
	}

	public Double getSumAmount() {
	
		return sumAmount;
	}

	public void setSumAmount(Double sumAmount) {
	
		this.sumAmount = sumAmount;
	}
	
}

