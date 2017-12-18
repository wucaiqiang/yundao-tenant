package com.yundao.tenant.dto.sale.reservation.audit;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预约审核分页请求数据dto
 *
 * @author jan
 * @create 2017-08-24 PM2:41
 **/
public class ReservationAuditPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "预约编号")
    private String number;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "预约金额 - 开始")
    private Double reservationAmountBegin;

    @ApiModelProperty(value = "预约金额 - 结束")
    private Double reservationAmountEnd;

    @ApiModelProperty(value = "预约打款日期 - 开始")
    private String estimatePayDateBegin;

    @ApiModelProperty(value = "预约打款日期 - 结束")
    private String estimatePayDateEnd;

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

    public String getEstimatePayDateBegin() {
        return estimatePayDateBegin;
    }

    public void setEstimatePayDateBegin(String estimatePayDateBegin) {
        this.estimatePayDateBegin = estimatePayDateBegin;
    }

    public String getEstimatePayDateEnd() {
        return estimatePayDateEnd;
    }

    public void setEstimatePayDateEnd(String estimatePayDateEnd) {
        this.estimatePayDateEnd = estimatePayDateEnd;
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

    public Double getReservationAmountBegin() {
        return reservationAmountBegin;
    }

    public void setReservationAmountBegin(Double reservationAmountBegin) {
        this.reservationAmountBegin = reservationAmountBegin;
    }

    public Double getReservationAmountEnd() {
        return reservationAmountEnd;
    }

    public void setReservationAmountEnd(Double reservationAmountEnd) {
        this.reservationAmountEnd = reservationAmountEnd;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
