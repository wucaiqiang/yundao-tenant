

package com.yundao.tenant.dto.workflow.task;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月16日 下午3:49:15 
 * @author   欧阳利
 * @version   
 */
public class KnotCommissionTaskDto {
	@ApiModelProperty("佣金id")
    private Long  id;
    @ApiModelProperty("佣金类型")
    private String type;
    @ApiModelProperty("佣金类型文本")
    private String typeText;
    @ApiModelProperty("佣金费率")
    private Double rate;
    @ApiModelProperty("结佣 发放金额")
    private Double amount;
    @ApiModelProperty("打款金额")
    private Double dealAmount;
    @ApiModelProperty("产品名称")
    private String productName;
    @ApiModelProperty("订单编号")
    private String number;
    @ApiModelProperty("理财师名称")
    private String username;
    @ApiModelProperty("报单id")
    private Long declarationId;

	public String getNumber() {
	
		return number;
	}

	public void setNumber(String number) {
	
		this.number = number;
	}

	public String getUsername() {
	
		return username;
	}

	public void setUsername(String username) {
	
		this.username = username;
	}

	public Long getDeclarationId() {
	
		return declarationId;
	}

	public void setDeclarationId(Long declarationId) {
	
		this.declarationId = declarationId;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public String getType() {
	
		return type;
	}

	public void setType(String type) {
	
		this.type = type;
	}

	public String getTypeText() {
	
		return typeText;
	}

	public void setTypeText(String typeText) {
	
		this.typeText = typeText;
	}

	public Double getRate() {
	
		return rate;
	}

	public void setRate(Double rate) {
	
		this.rate = rate;
	}

	public Double getAmount() {
	
		return amount;
	}

	public void setAmount(Double amount) {
	
		this.amount = amount;
	}

	public Double getDealAmount() {
	
		return dealAmount;
	}

	public void setDealAmount(Double dealAmount) {
	
		this.dealAmount = dealAmount;
	}

	public String getProductName() {
	
		return productName;
	}

	public void setProductName(String productName) {
	
		this.productName = productName;
	}
    
    
}

