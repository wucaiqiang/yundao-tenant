
package com.yundao.tenant.dto.sale.declaration;


import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class DeclarationUpdateSubscribeDto{
    @ApiModelProperty(value = "报单ID")
    private Long id;
    /**
     * 打款日期
     */
    @ApiModelProperty(value = "打款日期")
    private Date payDate;

    /**
     * 认购金额
     */
    @ApiModelProperty(value = "认购金额")
    private Double dealAmount;
    //保单备注
    @ApiModelProperty(value = "保单备注")
    private String remark;
    //打款凭证
    @ApiModelProperty(value = "打款凭证")
    private String voucher;
    //合同附件
    @ApiModelProperty(value = "合同附件")
    private String contractFile;

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(Double dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getContractFile() {
        return contractFile;
    }

    public void setContractFile(String contractFile) {
        this.contractFile = contractFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

