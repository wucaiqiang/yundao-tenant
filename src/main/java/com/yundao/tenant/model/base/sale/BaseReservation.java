package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseReservation extends BaseModel implements Serializable {
    /**
	 * 预约编号
	 */
    private String number;

    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 客户id
	 */
    private Long customerId;

    /**
	 * 预计打款日期
	 */
    private Date estimatePayDate;

    /**
	 * 预约金额
	 */
    private Double reservationAmount;

    /**
	 * 备注
	 */
    private String remark;

    /**
	 * 原因；驳回、取消时填写
	 */
    private String reason;

    /**
	 * 预约状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已取消 5: 已作废
	 */
    private Integer status;

    /**
	 * 预约审批状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已取消
	 */
    private Integer auditStatus;

    /**
	 * 预约者id
	 */
    private Long userId;

    /**
	 * 最后提交时间
	 */
    private Date commitDate;

    /**
	 * 最后审核操作时间
	 */
    private Date operationDate;

    private static final long serialVersionUID = 1L;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Date getEstimatePayDate() {
        return estimatePayDate;
    }

    public void setEstimatePayDate(Date estimatePayDate) {
        this.estimatePayDate = estimatePayDate;
    }

    public Double getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(Double reservationAmount) {
        this.reservationAmount = reservationAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }
}