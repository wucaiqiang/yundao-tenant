package com.yundao.tenant.dto.sale.declaration;

import io.swagger.annotations.ApiModelProperty;

/**
 * 产品详情报单列表
 *
 * @author jan
 * @create 2017-09-11 PM2:33
 **/
public class DeclarationForProDetailResDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "报单编号")
    private String number;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "客户编号")
    private String customerNumber;

    @ApiModelProperty(value = "认购金额")
    private String dealAmount;

    @ApiModelProperty(value = "打款日期")
    private String payDate;

    @ApiModelProperty(value = "是否已上传打款凭证")
    private Integer hasPayEvidence;

    @ApiModelProperty(value = "是否已上传打款凭证文本")
    private String hasPayEvidenceText;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Integer getHasPayEvidence() {
        return hasPayEvidence;
    }

    public void setHasPayEvidence(Integer hasPayEvidence) {
        this.hasPayEvidence = hasPayEvidence;
    }

    public String getHasPayEvidenceText() {
        return hasPayEvidenceText;
    }

    public void setHasPayEvidenceText(String hasPayEvidenceText) {
        this.hasPayEvidenceText = hasPayEvidenceText;
    }

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
    }
}
