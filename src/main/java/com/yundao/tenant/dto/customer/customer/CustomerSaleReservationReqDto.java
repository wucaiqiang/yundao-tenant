package com.yundao.tenant.dto.customer.customer;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class CustomerSaleReservationReqDto extends AbstractBasePageDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("客户id")
    private Long customerId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	
}
