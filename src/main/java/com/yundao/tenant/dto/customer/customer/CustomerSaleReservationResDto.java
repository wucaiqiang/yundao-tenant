package com.yundao.tenant.dto.customer.customer;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户详情--> 销售信息--> 预约列表
 * 
 * @author 欧阳利
 * 2017年8月31日
 */
public class CustomerSaleReservationResDto {
	
	@ApiModelProperty(value = "预约id")
    private Long id;
    
    @ApiModelProperty(value = "预约编号")
    private String number;
    
    @ApiModelProperty(value = "产品id")
    private Long productId;
    
    @ApiModelProperty(value = "产品名称")
    private String productName;
    
    @ApiModelProperty(value = "预约金额")
    private Double reservationAmount;
    
    @ApiModelProperty(value = "预计打款日期")
    private Date estimatePayDate;
    
    @ApiModelProperty(value = "预约日期")
    private Date reservationDate;
    
	@ApiModelProperty("客户id")
    private Long customerId;

    @ApiModelProperty(value = "预约状态")
    private Integer status;
    
    @ApiModelProperty(value = "预约状态名称")
    private String statusText;
    
    @ApiModelProperty(value = "创建者id")
    private Long createUserId;
    
    @ApiModelProperty(value = "创建者姓名")
    private String createRealName;
    
    @ApiModelProperty(value = "原因")
    private String reason;
    
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateRealName() {
		return createRealName;
	}

	public void setCreateRealName(String createRealName) {
		this.createRealName = createRealName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNumber() {
	
		return number;
	}

	public void setNumber(String number) {
	
		this.number = number;
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

	public Double getReservationAmount() {
		return reservationAmount;
	}

	public void setReservationAmount(Double reservationAmount) {
		this.reservationAmount = reservationAmount;
	}

	public Date getEstimatePayDate() {
		return estimatePayDate;
	}

	public void setEstimatePayDate(Date estimatePayDate) {
		this.estimatePayDate = estimatePayDate;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
    
    
}
