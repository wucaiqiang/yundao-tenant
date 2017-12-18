package com.yundao.tenant.dto.customer.back;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户回退审核列表请求结果列表
 * 
 * @author 欧阳利
 * 2017年8月14日
 */
public class CustomerBackExamineListResDto {
	@ApiModelProperty("Id")
	private Long id;
	
	@ApiModelProperty("客户Id")
	private String customerId;
	@ApiModelProperty("客户名称")
	private String customerName;
	
	@ApiModelProperty("客户编号")
    private String customerNumber;
	
	@ApiModelProperty("客户手机号码")
    private String customerMobile;
	
	@ApiModelProperty("拥有者id")
	private Long ownerId;
	
	@ApiModelProperty("申请发起人Id")
    private Long applyUserId;
	
	@ApiModelProperty("申请发起人name")
    private String applyUserName;
	
	@ApiModelProperty("回退原因")
    private String reason;
	
	@ApiModelProperty("申请时间")
    private Date applyDate;
	
	@ApiModelProperty("审核时间")
    private Date examineDate;
	
	@ApiModelProperty("客户性别")
    private Integer customerSex;
	
	@ApiModelProperty("客户性别")
	private String customerSexText;
	
	@ApiModelProperty("客户等级")
    private String customerLevel;
	
	
	@ApiModelProperty("客户等级名称")
    private String customerLevelText;
	
	@ApiModelProperty("省集合")
    private String provinceCode;
	
	@ApiModelProperty("省集合")
    private String provinceCodeText;
	
	@ApiModelProperty("市集合")
    private String cityCode;
	
	@ApiModelProperty("市集合")
    private String cityCodeText;
	
	@ApiModelProperty("驳回原因")
	private String rejectReason;
	
	/**
	 * 审核状态
	 */
	@ApiModelProperty("审核状态")
	private Integer status;
	
	/**
	 * 审核状态名称
	 */
	@ApiModelProperty("审核状态名称")
	private String statusText;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
		this.applyUserId = applyUserId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}


	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}


	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getExamineDate() {
		return examineDate;
	}

	public void setExamineDate(Date examineDate) {
		this.examineDate = examineDate;
	}


	public Integer getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(Integer customerSex) {
		this.customerSex = customerSex;
	}

	public String getCustomerSexText() {
		return customerSexText;
	}

	public void setCustomerSexText(String customerSexText) {
		this.customerSexText = customerSexText;
	}

	public String getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
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

	public String getCustomerLevelText() {
		return customerLevelText;
	}

	public void setCustomerLevelText(String customerLevelText) {
		this.customerLevelText = customerLevelText;
	}

	public String getProvinceCodeText() {
		return provinceCodeText;
	}

	public void setProvinceCodeText(String provinceCodeText) {
		this.provinceCodeText = provinceCodeText;
	}

	public String getCityCodeText() {
		return cityCodeText;
	}

	public void setCityCodeText(String cityCodeText) {
		this.cityCodeText = cityCodeText;
	}
	
}
