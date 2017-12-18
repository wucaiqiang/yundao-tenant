package com.yundao.tenant.dto.finance.receipt;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回款关联报单
 *
 * @author jan
 * @create 2017-10-15 21:24
 **/
public class DeclarationForReceiptResDto {

    @ApiModelProperty(value = "报单id")
    private Long id;

    @ApiModelProperty(value = "报单编号")
    private String number;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

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

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
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
}
