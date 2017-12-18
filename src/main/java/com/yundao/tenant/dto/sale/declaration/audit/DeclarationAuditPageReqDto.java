package com.yundao.tenant.dto.sale.declaration.audit;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 报单审核请求数据dto
 *
 * @author jan
 * @create 2017-08-27 PM2:54
 **/
public class DeclarationAuditPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "预约编号")
    private String number;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "认购金额 - 开始")
    private Double dealAmountBegin;

    @ApiModelProperty(value = "认购金额 - 结束")
    private Double dealAmountEnd;

    @ApiModelProperty(value = "打款日期 - 开始")
    private String payDateBegin;

    @ApiModelProperty(value = "打款日期 - 结束")
    private String payDateEnd;

    @ApiModelProperty(value = "是否已上传打款凭证,多个逗号分隔")
    private String hasPayEvidences;

    @ApiModelProperty(value = "提交时间 - 开始")
    private String commitDateBegin;

    @ApiModelProperty(value = "提交时间 - 结束")
    private String commitDateEnd;

    @ApiModelProperty(value = "提交人")
    private String reservationor;

    @ApiModelProperty(value = "操作时间 - 开始")
    private String operationDateBegin;

    @ApiModelProperty(value = "操作时间 - 结束")
    private String operationDateEnd;

    @ApiModelProperty(value = "查询范围，all：所有，unprocess：未处理，默认all")
    private String scope;

    @ApiModelProperty(value = "审批状态")
    private String statuss;

    public String getStatuss() {
	
		return statuss;
	}

	public void setStatuss(String statuss) {
	
		this.statuss = statuss;
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

    public Double getDealAmountBegin() {
        return dealAmountBegin;
    }

    public void setDealAmountBegin(Double dealAmountBegin) {
        this.dealAmountBegin = dealAmountBegin;
    }

    public Double getDealAmountEnd() {
        return dealAmountEnd;
    }

    public void setDealAmountEnd(Double dealAmountEnd) {
        this.dealAmountEnd = dealAmountEnd;
    }

    public String getPayDateBegin() {
        return payDateBegin;
    }

    public void setPayDateBegin(String payDateBegin) {
        this.payDateBegin = payDateBegin;
    }

    public String getPayDateEnd() {
        return payDateEnd;
    }

    public void setPayDateEnd(String payDateEnd) {
        this.payDateEnd = payDateEnd;
    }

    public String getHasPayEvidences() {
        return hasPayEvidences;
    }

    public void setHasPayEvidences(String hasPayEvidences) {
        this.hasPayEvidences = hasPayEvidences;
    }

    public String getCommitDateBegin() {
        return commitDateBegin;
    }

    public void setCommitDateBegin(String commitDateBegin) {
        this.commitDateBegin = commitDateBegin;
    }

    public String getCommitDateEnd() {
        return commitDateEnd;
    }

    public void setCommitDateEnd(String commitDateEnd) {
        this.commitDateEnd = commitDateEnd;
    }

    public String getReservationor() {
        return reservationor;
    }

    public void setReservationor(String reservationor) {
        this.reservationor = reservationor;
    }

    public String getOperationDateBegin() {
        return operationDateBegin;
    }

    public void setOperationDateBegin(String operationDateBegin) {
        this.operationDateBegin = operationDateBegin;
    }

    public String getOperationDateEnd() {
        return operationDateEnd;
    }

    public void setOperationDateEnd(String operationDateEnd) {
        this.operationDateEnd = operationDateEnd;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
