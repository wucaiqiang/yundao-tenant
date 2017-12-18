package com.yundao.tenant.dto.sale.reservation;

import java.util.Date;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class MyReservationListReqDto extends AbstractBasePageDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "预约编号")
    private String number;
    
    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品id")
    private String productId;

    @ApiModelProperty(value = "客户名称")
    private String customerName;
    
    @ApiModelProperty(value = "产品或者客户名称")
    private String productOrCustomerName;

    @ApiModelProperty(value = "预计打款日期")
    private Date estimatePayStartDate;
    
    @ApiModelProperty(value = "预计打款日期")
    private Date estimatePayEndDate;

    @ApiModelProperty(value = "预约金额")
    private Double reservationStartAmount;
    
    @ApiModelProperty(value = "预约金额")
    private Double reservationEndAmount;
    
    @ApiModelProperty(value = "预约状态")
    private String statuss;
    
    @ApiModelProperty(value = "预约开始时间")
    private Date reservationStartDate;
    
    @ApiModelProperty(value = "预约结束时间")
    private Date reservationEndDate;

    private String[] statusList;

	@ApiModelProperty(value = "传参代表排除保单的预约")
    private Integer isRemoveDeclaration;

	@ApiModelProperty(value = "传参代表排除已作废")
	private Integer isRemoveDiscard;

    /**
     * 用户id
     */
    private Long userId;
    
	public String getProductOrCustomerName() {
		return productOrCustomerName;
	}

	public void setProductOrCustomerName(String productOrCustomerName) {
		this.productOrCustomerName = productOrCustomerName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String[] getStatusList() {
		return statusList;
	}

	public void setStatusList(String[] statusList) {
		this.statusList = statusList;
	}

	public Date getReservationStartDate() {
		return reservationStartDate;
	}

	public void setReservationStartDate(Date reservationStartDate) {
		this.reservationStartDate = reservationStartDate;
	}

	public Date getReservationEndDate() {
		return reservationEndDate;
	}

	public void setReservationEndDate(Date reservationEndDate) {
		this.reservationEndDate = reservationEndDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public Date getEstimatePayStartDate() {
		return estimatePayStartDate;
	}

	public void setEstimatePayStartDate(Date estimatePayStartDate) {
		this.estimatePayStartDate = estimatePayStartDate;
	}

	public Date getEstimatePayEndDate() {
		return estimatePayEndDate;
	}

	public void setEstimatePayEndDate(Date estimatePayEndDate) {
		this.estimatePayEndDate = estimatePayEndDate;
	}

	public Double getReservationStartAmount() {
		return reservationStartAmount;
	}

	public void setReservationStartAmount(Double reservationStartAmount) {
		this.reservationStartAmount = reservationStartAmount;
	}

	public Double getReservationEndAmount() {
		return reservationEndAmount;
	}

	public void setReservationEndAmount(Double reservationEndAmount) {
		this.reservationEndAmount = reservationEndAmount;
	}

	public String getStatuss() {
		return statuss;
	}

	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getIsRemoveDeclaration() {
		return isRemoveDeclaration;
	}

	public Integer getIsRemoveDiscard() {
		return isRemoveDiscard;
	}

	public void setIsRemoveDiscard(Integer isRemoveDiscard) {
		this.isRemoveDiscard = isRemoveDiscard;
	}

	public void setIsRemoveDeclaration(Integer isRemoveDeclaration) {
		this.isRemoveDeclaration = isRemoveDeclaration;
	}
}
