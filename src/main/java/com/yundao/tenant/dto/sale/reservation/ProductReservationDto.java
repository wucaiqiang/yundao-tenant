

package com.yundao.tenant.dto.sale.reservation;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月22日 下午3:14:00 
 * @author   欧阳利
 * @version   
 */
public class ProductReservationDto {
	@ApiModelProperty("客户名称")
	private String customerName;
	
	@ApiModelProperty("客户名称")
	private Long customerId;
	
	@ApiModelProperty("产品id")
	private Long productId;
	
	@ApiModelProperty("产品名称")
	private String productName;
	
	@ApiModelProperty("预约id")
	private Long reservationId;
	
	@ApiModelProperty("预约金额")
    private Double reservationAmount;

	@ApiModelProperty("预约金额")
    private Integer status;


	public Integer getStatus() {
	
		return status;
	}

	public void setStatus(Integer status) {
	
		this.status = status;
	}

	public String getProductName() {
	
		return productName;
	}

	public void setProductName(String productName) {
	
		this.productName = productName;
	}

	public String getCustomerName() {
	
		return customerName;
	}

	public void setCustomerName(String customerName) {
	
		this.customerName = customerName;
	}

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}

	public Long getProductId() {
	
		return productId;
	}

	public void setProductId(Long productId) {
	
		this.productId = productId;
	}

	public Long getReservationId() {
	
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
	
		this.reservationId = reservationId;
	}

	public Double getReservationAmount() {
	
		return reservationAmount;
	}

	public void setReservationAmount(Double reservationAmount) {
	
		this.reservationAmount = reservationAmount;
	}
	
	
	
}

