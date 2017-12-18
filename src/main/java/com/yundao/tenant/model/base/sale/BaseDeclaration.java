package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseDeclaration extends BaseModel implements Serializable {
    /**
	 * 预约id
	 */
    private Long reservationId;

    /**
	 * 报单编号
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
	 * 打款日期
	 */
    private Date payDate;

    /**
	 * 认购金额
	 */
    private Double dealAmount;

    /**
	 * 备注
	 */
    private String remark;

    /**
	 * 原因；驳回、取消时填写
	 */
    private String reason;

    /**
	 * 审批状态，  1：审核中  2：审核通过  3：驳回修改  4： 已取消 
	 */
    private Integer auditStatus;

    /**
	 * 报单状态，  1：审核中  2：审核通过  3：驳回修改  4： 已取消  5: 已作废  6:已退款
	 */
    private Integer status;

    /**
	 * 报单者id
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

    /**
	 * 申请时间
	 */
    private Date applyDate;

    private static final long serialVersionUID = 1L;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}