
package com.yundao.tenant.dto.finance.knotcommission;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class KnotCommissionPageReqDto{

    @ApiModelProperty(value = "范围")
    @Length(message = "{" + GJLCodeConstant.CODE_1210096 + "}")
    private String scope;

    @ApiModelProperty(value = "报单编号")
    private String number;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "客户编号")
    private String customerNumber;

    @ApiModelProperty(value = "认购开始金额")
    private String dealAmountStart;

    @ApiModelProperty(value = "认购结束金额")
    private String dealAmountEnd;

    @ApiModelProperty(value = "报单时间开始")
    private Date commitDateStart;

    @ApiModelProperty(value = "报单时间结束")
    private Date commitDateEnd;

    @ApiModelProperty(value = "理财师")
    private String userName;

    @ApiModelProperty(value = "总次数开始")
    private Integer totalCountStart;

    @ApiModelProperty(value = "总次数结束")
    private Integer totalCountEnd;

    @ApiModelProperty(value = "结佣金额开始")
    private Double totalAmountStart;

    @ApiModelProperty(value = "结佣金额结束")
    private Double totalAmountEnd;

    public Double getTotalAmountStart() {
        return totalAmountStart;
    }

    public void setTotalAmountStart(Double totalAmountStart) {
        this.totalAmountStart = totalAmountStart;
    }

    public Double getTotalAmountEnd() {
        return totalAmountEnd;
    }

    public void setTotalAmountEnd(Double totalAmountEnd) {
        this.totalAmountEnd = totalAmountEnd;
    }

    public Integer getTotalCountStart() {
        return totalCountStart;
    }

    public void setTotalCountStart(Integer totalCountStart) {
        this.totalCountStart = totalCountStart;
    }

    public Integer getTotalCountEnd() {
        return totalCountEnd;
    }

    public void setTotalCountEnd(Integer totalCountEnd) {
        this.totalCountEnd = totalCountEnd;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

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

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
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

    public Date getCommitDateStart() {
        return commitDateStart;
    }

    public void setCommitDateStart(Date commitDateStart) {
        this.commitDateStart = commitDateStart;
    }

    public Date getCommitDateEnd() {
        return commitDateEnd;
    }

    public void setCommitDateEnd(Date commitDateEnd) {
        this.commitDateEnd = commitDateEnd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
