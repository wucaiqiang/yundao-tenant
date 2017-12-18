package com.yundao.tenant.dto.sale.reservation.audit;

import io.swagger.annotations.ApiModelProperty;

/**
 * 预约审核分页返回dto
 *
 * @author jan
 * @create 2017-08-24 AM9:18
 **/
public class ReservationAuditPageResDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "预约编号")
    private String number;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "预约金额(募集进度使用)")
    private String reservationSumAmount;

    @ApiModelProperty(value = "报单金额(募集进度使用)")
    private String declarationSumAmount;

    @ApiModelProperty(value = "预约金额")
    private String reservationAmount;

    @ApiModelProperty(value = "预约打款日期")
    private String estimatePayDate;

    @ApiModelProperty(value = "提交时间")
    private String commitDate;

    @ApiModelProperty(value = "提交人")
    private String reservationor;

    @ApiModelProperty(value = "操作时间")
    private String operationDate;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "状态文本")
    private String statusText;

    @ApiModelProperty(value = "是否可以进行审核操作")
    private Boolean isCanAudit;

    @ApiModelProperty(value = "废弃表id")
    private Long disardId;

    @ApiModelProperty(value = "客户所属理财师id")
    private Long fpId;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReservationSumAmount() {
        return reservationSumAmount;
    }

    public void setReservationSumAmount(String reservationSumAmount) {
        this.reservationSumAmount = reservationSumAmount;
    }

    public String getDeclarationSumAmount() {
        return declarationSumAmount;
    }

    public void setDeclarationSumAmount(String declarationSumAmount) {
        this.declarationSumAmount = declarationSumAmount;
    }

    public String getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(String reservationAmount) {
        this.reservationAmount = reservationAmount;
    }

    public String getEstimatePayDate() {
        return estimatePayDate;
    }

    public void setEstimatePayDate(String estimatePayDate) {
        this.estimatePayDate = estimatePayDate;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public String getReservationor() {
        return reservationor;
    }

    public void setReservationor(String reservationor) {
        this.reservationor = reservationor;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
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

    public Boolean getCanAudit() {
        return isCanAudit;
    }

    public void setCanAudit(Boolean canAudit) {
        isCanAudit = canAudit;
    }

    public Long getDisardId() {
        return disardId;
    }

    public void setDisardId(Long disardId) {
        this.disardId = disardId;
    }

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
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

}
