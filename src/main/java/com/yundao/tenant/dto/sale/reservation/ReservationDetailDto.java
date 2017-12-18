package com.yundao.tenant.dto.sale.reservation;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ReservationDetailDto extends BaseReservationDto {
	@ApiModelProperty(value = "是否已报单")
	private Boolean hasDeclaration;

	@ApiModelProperty(value = "预约是否作废")
	private Boolean discard;

	public Boolean getHasDeclaration() {
	
		return hasDeclaration;
	}

	public void setHasDeclaration(Boolean hasDeclaration) {
	
		this.hasDeclaration = hasDeclaration;
	}

	public Boolean getDiscard() {
	
		return discard;
	}

	public void setDiscard(Boolean discard) {
	
		this.discard = discard;
	}
	
}
