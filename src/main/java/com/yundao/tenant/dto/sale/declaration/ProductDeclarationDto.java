

package com.yundao.tenant.dto.sale.declaration;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月14日 下午3:15:45 
 * @author   欧阳利
 * @version   
 */
public class ProductDeclarationDto {
    
	@ApiModelProperty("客户名称")
	private String customerName;
	
	@ApiModelProperty("客户名称")
	private Long customerId;
	
	@ApiModelProperty("产品id")
	private Long productId;
	
	@ApiModelProperty("产品名称")
	private String productName;
	
	@ApiModelProperty("报单")
	private Long declarationId;
	
	@ApiModelProperty("打款金额")
    private Double dealAmount;

	@ApiModelProperty("预约金额")
    private Integer status;

	public Long getDeclarationId() {
	
		return declarationId;
	}

	public void setDeclarationId(Long declarationId) {
	
		this.declarationId = declarationId;
	}

	public Double getDealAmount() {
	
		return dealAmount;
	}

	public void setDealAmount(Double dealAmount) {
	
		this.dealAmount = dealAmount;
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

	public String getProductName() {
	
		return productName;
	}

	public void setProductName(String productName) {
	
		this.productName = productName;
	}
	public Integer getStatus() {
	
		return status;
	}

	public void setStatus(Integer status) {
	
		this.status = status;
	}

	
}

