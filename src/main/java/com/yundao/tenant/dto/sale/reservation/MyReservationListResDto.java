package com.yundao.tenant.dto.sale.reservation;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class MyReservationListResDto {

    @ApiModelProperty(value = "预约id")
    private Long id;

    @ApiModelProperty(value = "预约编号")
    private String number;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "产品id")
    private String productName;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "预计打款日期")
    private Date estimatePayDate;

    @ApiModelProperty(value = "预约金额")
    private Double reservationAmount;

    @ApiModelProperty(value = "预约状态")
    private Integer status;

    @ApiModelProperty(value = "预约状态名称")
    private String statusText;

    @ApiModelProperty(value = "预约时间")
    private Date reservationDate;

    @ApiModelProperty(value = "最后提交时间")
    private Date commitDate;

    @ApiModelProperty(value = "最后审核操作时间")
    private Date operationDate;

    /**
     * 当前用户id
     */
    private Long userId;

    @ApiModelProperty(value = "原因")
    private String reason;

    @ApiModelProperty(value = "报单id")
    private Long declarationId;

    @ApiModelProperty(value = "是否已报单")
    private Boolean hasDeclaration;

    @ApiModelProperty(value = "预约是否作废")
    private Boolean discard;
    
    public Boolean getDiscard() {
		return discard;
	}

	public void setDiscard(Boolean discard) {
		this.discard = discard;
	}

	public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    public Date getEstimatePayDate() {
        return estimatePayDate;
    }

    public void setEstimatePayDate(Date estimatePayDate) {
        this.estimatePayDate = estimatePayDate;
    }

    public Double getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(Double reservationAmount) {
        this.reservationAmount = reservationAmount;
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

    public Long getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Long declarationId) {
        this.declarationId = declarationId;
    }

    public Boolean getHasDeclaration() {
        return hasDeclaration;
    }

    public void setHasDeclaration(Boolean hasDeclaration) {
        this.hasDeclaration = hasDeclaration;
    }
}
