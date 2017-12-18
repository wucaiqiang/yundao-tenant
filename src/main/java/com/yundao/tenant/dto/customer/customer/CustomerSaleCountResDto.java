package com.yundao.tenant.dto.customer.customer;

import io.swagger.annotations.ApiModelProperty;

public class CustomerSaleCountResDto {
	
   @ApiModelProperty("预约个数")
   private Integer reservationCount;
   
   @ApiModelProperty("报单个数")
   private Integer declarationCount;

public Integer getReservationCount() {
	return reservationCount;
}

public void setReservationCount(Integer reservationCount) {
	this.reservationCount = reservationCount;
}

public Integer getDeclarationCount() {
	return declarationCount;
}

public void setDeclarationCount(Integer declarationCount) {
	this.declarationCount = declarationCount;
}
   
   
}
