
package com.yundao.tenant.dto.finance.knotcommission;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class KnotCommissionAuditPageReqDto {
    @ApiModelProperty(value = "报单编号")
    private String number;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "认购开始金额")
    private String dealAmountStart;

    @ApiModelProperty(value = "认购结束金额")
    private String dealAmountEnd;

    @ApiModelProperty(value = "报单确认时间开始")
    private Date decOperationDateStart;

    @ApiModelProperty(value = "报单确认时间结束")
    private Date decOperationDateEnd;

    @ApiModelProperty(value = "理财师")
    private String userName;

    @ApiModelProperty(value = "申请日期开始")
    private Date applyDateStart;

    @ApiModelProperty(value = "申请日期结束")
    private Date applyDateEnd;

    @ApiModelProperty(value = "申请人")
    private String applyUserName;

    @ApiModelProperty(value = "佣金类型")
    private String type;

    @ApiModelProperty(value = "佣金费率开始")
    private Double rateStart;

    @ApiModelProperty(value = "佣金费率结束")
    private Double rateEnd;

    @ApiModelProperty(value = "佣金金额开始")
    private Double amountStart;

    @ApiModelProperty(value = "佣金金额结束")
    private Double amountEnd;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "操作时间结束")
    private Date operationDateStart;

    @ApiModelProperty(value = "操作时间结束")
    private Date operationDateEnd;

    @ApiModelProperty(value = "status")
    private String status;

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

    public String getDealAmountStart() {
        return dealAmountStart;
    }

    public void setDealAmountStart(String dealAmountStart) {
        this.dealAmountStart = dealAmountStart;
    }

    public String getDealAmountEnd() {
        return dealAmountEnd;
    }

    public void setDealAmountEnd(String dealAmountEnd) {
        this.dealAmountEnd = dealAmountEnd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getApplyDateStart() {
        return applyDateStart;
    }

    public void setApplyDateStart(Date applyDateStart) {
        this.applyDateStart = applyDateStart;
    }

    public Date getApplyDateEnd() {
        return applyDateEnd;
    }

    public void setApplyDateEnd(Date applyDateEnd) {
        this.applyDateEnd = applyDateEnd;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRateStart() {
        return rateStart;
    }

    public void setRateStart(Double rateStart) {
        this.rateStart = rateStart;
    }

    public Double getRateEnd() {
        return rateEnd;
    }

    public void setRateEnd(Double rateEnd) {
        this.rateEnd = rateEnd;
    }

    public Double getAmountStart() {
        return amountStart;
    }

    public void setAmountStart(Double amountStart) {
        this.amountStart = amountStart;
    }

    public Double getAmountEnd() {
        return amountEnd;
    }

    public void setAmountEnd(Double amountEnd) {
        this.amountEnd = amountEnd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getOperationDateStart() {
        return operationDateStart;
    }

    public void setOperationDateStart(Date operationDateStart) {
        this.operationDateStart = operationDateStart;
    }

    public Date getOperationDateEnd() {
        return operationDateEnd;
    }

    public void setOperationDateEnd(Date operationDateEnd) {
        this.operationDateEnd = operationDateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDecOperationDateStart() {
        return decOperationDateStart;
    }

    public void setDecOperationDateStart(Date decOperationDateStart) {
        this.decOperationDateStart = decOperationDateStart;
    }

    public Date getDecOperationDateEnd() {
        return decOperationDateEnd;
    }

    public void setDecOperationDateEnd(Date decOperationDateEnd) {
        this.decOperationDateEnd = decOperationDateEnd;
    }
}
