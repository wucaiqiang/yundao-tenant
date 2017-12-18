

package com.yundao.tenant.dto.product;

import java.io.Serializable;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月20日 上午10:18:34 
 * @author   wucq
 * @version   
 */
public class ProductReservationDeclarationReportDto implements Serializable{

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 产品ID
	 */
	private Long productId;
	/**
	 * 预约总额
	 */
	private Double reservationTotal;
	/**
	 * 报单总额
	 */
	private Double declarationTotal;
	
	public Long getProductId() {
	
		return productId;
	}
	public void setProductId(Long productId) {
	
		this.productId = productId;
	}
	public Double getReservationTotal() {
	
		return reservationTotal;
	}
	public void setReservationTotal(Double reservationTotal) {
	
		this.reservationTotal = reservationTotal;
	}
	public Double getDeclarationTotal() {
	
		return declarationTotal;
	}
	public void setDeclarationTotal(Double declarationTotal) {
	
		this.declarationTotal = declarationTotal;
	}
	

}

