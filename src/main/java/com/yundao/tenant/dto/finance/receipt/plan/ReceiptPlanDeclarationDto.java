package com.yundao.tenant.dto.finance.receipt.plan;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划关联订单dto
 *
 * @author jan
 * @create 2017-10-14 14:06
 **/
public class ReceiptPlanDeclarationDto {

    @ApiModelProperty(value = "报单id")
    private Long id;

    @ApiModelProperty(value = "报单编号")
    private String number;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户编号")
    private String customerNumber;

    @ApiModelProperty(value = "认购金额")
    private String dealAmount;

    @ApiModelProperty(value = "报单确认日期")
    private String commitDate;

    @ApiModelProperty(value = "当前负责理财师id")
    private Long fpId;

    @ApiModelProperty(value = "成单理财师id")
    private Long dealFpId;

    @ApiModelProperty(value = "成单理财师姓名")
    private String dealFpName;

    @ApiModelProperty(value = "结佣次数")
    private Integer commissionCount;

    @ApiModelProperty(value = "结佣金额")
    private String commissionTotalAmount;

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

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public Long getDealFpId() {
        return dealFpId;
    }

    public void setDealFpId(Long dealFpId) {
        this.dealFpId = dealFpId;
    }

    public String getDealFpName() {
        return dealFpName;
    }

    public void setDealFpName(String dealFpName) {
        this.dealFpName = dealFpName;
    }

    public Integer getCommissionCount() {
        return commissionCount;
    }

    public void setCommissionCount(Integer commissionCount) {
        this.commissionCount = commissionCount;
    }

    public String getCommissionTotalAmount() {
        return commissionTotalAmount;
    }

    public void setCommissionTotalAmount(String commissionTotalAmount) {
        this.commissionTotalAmount = commissionTotalAmount;
    }

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
    }
}
