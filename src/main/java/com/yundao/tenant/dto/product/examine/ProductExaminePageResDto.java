package com.yundao.tenant.dto.product.examine;

import io.swagger.annotations.ApiModelProperty;

/**
 * 产品审核分页dto
 *
 * @author jan
 * @create 2017-07-22 PM1:35
 **/
public class ProductExaminePageResDto {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id")
    private Long productId;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /**
     * 产品类别
     */
    @ApiModelProperty(value = "产品类别")
    private Long productType;

    /**
     * 产品类别文本
     */
    @ApiModelProperty(value = "产品类别文本")
    private String productTypeText;

    /**
     * 已售
     */
    @ApiModelProperty(value = "已售")
    private String saled;

    /**
     * 产品规模
     */
    @ApiModelProperty(value = "产品规模")
    private String productScale;

    /**
     * 产品对接人
     */
    @ApiModelProperty(value = "产品对接人")
    private String receiver;

    /**
     * 产品助理
     */
    @ApiModelProperty(value = "产品助理")
    private String assistant;

    /**
     * 发行状态
     */
    @ApiModelProperty(value = "发行状态")
    private Integer issuedStatus;

    /**
     * 发行状态文本
     */
    @ApiModelProperty(value = "发行状态文本")
    private String issuedStatusText;

    /**
     * 申请发起人
     */
    @ApiModelProperty(value = "申请发起人")
    private String proposer;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    /**
     * 请求审核的状态
     */
    @ApiModelProperty(value = "请求审核的状态")
    private Integer reqIssuedStatus;

    /**
     * 请求审核的状态
     */
    @ApiModelProperty(value = "请求审核的状态")
    private String reqIssuedStatusText;

    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态")
    private Integer status;

    /**
     * 审核状态文本
     */
    @ApiModelProperty(value = "审核状态文本")
    private String statusText;

    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    private String createDate;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private String approveDate;

    /**
     * 原因
     */
    @ApiModelProperty(value = "原因")
    private String reason;

//    /**
//     * 工作流任务id
//     */
//    @ApiModelProperty(value = "工作流任务id")
//    private String taskId;
//
//    @ApiModelProperty(value = "业务id")
//    private String businessKey;

    /**
     * 预约金额
     */
    @ApiModelProperty(value = "预约金额")
    private String reservationAmount;

    /**
     * 报单金额
     */
    @ApiModelProperty(value = "报单金额")
    private String declarationAmount;

    @ApiModelProperty(value = "是否可以进行审核操作")
    private Boolean isCanAudit;
    
    @ApiModelProperty(value = "业务类型")
    private String businessType;
    
    @ApiModelProperty(value = "业务类型名称")
    private String businessTypeText;

    public Boolean getIsCanAudit() {
	
		return isCanAudit;
	}

	public void setIsCanAudit(Boolean isCanAudit) {
	
		this.isCanAudit = isCanAudit;
	}

	public String getBusinessType() {
	
		return businessType;
	}

	public void setBusinessType(String businessType) {
	
		this.businessType = businessType;
	}

	public String getBusinessTypeText() {
	
		return businessTypeText;
	}

	public void setBusinessTypeText(String businessTypeText) {
	
		this.businessTypeText = businessTypeText;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public String getProductTypeText() {
        return productTypeText;
    }

    public void setProductTypeText(String productTypeText) {
        this.productTypeText = productTypeText;
    }

    public String getSaled() {
        return saled;
    }

    public void setSaled(String saled) {
        this.saled = saled;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public Integer getIssuedStatus() {
        return issuedStatus;
    }

    public void setIssuedStatus(Integer issuedStatus) {
        this.issuedStatus = issuedStatus;
    }

    public Integer getReqIssuedStatus() {
        return reqIssuedStatus;
    }

    public void setReqIssuedStatus(Integer reqIssuedStatus) {
        this.reqIssuedStatus = reqIssuedStatus;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(String approveDate) {
        this.approveDate = approveDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getIssuedStatusText() {
        return issuedStatusText;
    }

    public void setIssuedStatusText(String issuedStatusText) {
        this.issuedStatusText = issuedStatusText;
    }

    public String getReqIssuedStatusText() {
        return reqIssuedStatusText;
    }

    public void setReqIssuedStatusText(String reqIssuedStatusText) {
        this.reqIssuedStatusText = reqIssuedStatusText;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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

//    public String getTaskId() {
//        return taskId;
//    }
//
//    public void setTaskId(String taskId) {
//        this.taskId = taskId;
//    }

    public String getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(String reservationAmount) {
        this.reservationAmount = reservationAmount;
    }

    public String getDeclarationAmount() {
        return declarationAmount;
    }

    public void setDeclarationAmount(String declarationAmount) {
        this.declarationAmount = declarationAmount;
    }

    public Boolean getCanAudit() {
        return isCanAudit;
    }

    public void setCanAudit(Boolean canAudit) {
        isCanAudit = canAudit;
    }

//    public String getBusinessKey() {
//        return businessKey;
//    }
//
//    public void setBusinessKey(String businessKey) {
//        this.businessKey = businessKey;
//    }
}
