package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseDeclarationRefund extends BaseModel implements Serializable {
    /**
	 * 报单ID
	 */
    private Long declarationId;

    /**
	 * 退款原因
	 */
    private String reason;

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