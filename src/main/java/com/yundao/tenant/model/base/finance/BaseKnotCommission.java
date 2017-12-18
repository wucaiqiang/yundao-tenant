package com.yundao.tenant.model.base.finance;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseKnotCommission extends BaseModel implements Serializable {
    /**
	 * 报单ID
	 */
    private Long declarationId;

    /**
	 * 佣金类型
	 */
    private String type;

    /**
	 * 佣金费率
	 */
    private Double rate;

    /**
	 * 佣金金额
	 */
    private Double amount;

    /**
	 * 发放时间
	 */
    private Date provideDate;

    /**
	 * 备注
	 */
    private String remark;

    /**
	 * 1、待审批 2、已通过 3、已驳回
	 */
    private Integer status;

    /**
	 * 操作时间
	 */
    private Date operationDate;

    /**
	 * 流程发起人
	 */
    private Long userId;

    /**
	 * 审批时间
	 */
    private Date auditDate;

    /**
	 * 申请时间
	 */
    private Date applyDate;

    /**
	 * 审批原因
	 */
    private String auditReason;

    private static final long serialVersionUID = 1L;

    public Long getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Long declarationId) {
        this.declarationId = declarationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getProvideDate() {
        return provideDate;
    }

    public void setProvideDate(Date provideDate) {
        this.provideDate = provideDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getAuditReason() {
        return auditReason;
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason;
    }
}