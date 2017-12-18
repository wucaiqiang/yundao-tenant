package com.yundao.tenant.dto.sale.reservation;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class BaseReservationDto {
	
	@ApiModelProperty("预约id")
	private Long id;
	
	@ApiModelProperty("预约编号")
    private String number;

    /**
	 * 产品id
	 */
	@ApiModelProperty("产品id")
    private Long productId;
	
	@ApiModelProperty("产品名称")
    private String productName;

    /**
	 * 客户id
	 */
	@ApiModelProperty("客户id")
    private Long customerId;
	
	@ApiModelProperty("客户名称")
    private String customerName;

    /**
	 * 预计打款日期
	 */
	@ApiModelProperty(" 预计打款日期")
    private Date estimatePayDate;

    /**
	 * 预约金额
	 */
	@ApiModelProperty("预约金额")
    private Double reservationAmount;

    /**
	 * 备注
	 */
	@ApiModelProperty("备注")
    private String remark;
	
	@ApiModelProperty("预约状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已取消")
    private Integer status;
	@ApiModelProperty("预约状态中文")
	private String statusText;

    /**
	 * 预约者id
	 */
	@ApiModelProperty(" 预约者id")
    private Long userId;

    /**
	 * 最后提交时间
	 */
	@ApiModelProperty("最后提交时间")
    private Date commitDate;

    /**
	 * 最后审核操作时间
	 */
	@ApiModelProperty("最后审核操作时间")
    private Date operationDate;

	@ApiModelProperty("预约日期")
    private Date reservationDate;

	@ApiModelProperty("取消，驳回 原因")
	private String reason;

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCommitDate() {
		return commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatusText() {
	
		return statusText;
	}

	public void setStatusText(String statusText) {
	
		this.statusText = statusText;
	}
	
}
