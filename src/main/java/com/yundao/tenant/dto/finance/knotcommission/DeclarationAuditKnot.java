package com.yundao.tenant.dto.finance.knotcommission;


import com.yundao.tenant.model.sale.DeclarationModel;

import java.util.Date;

/**
 * Created by gjl on 2017/10/13.
 */
public class DeclarationAuditKnot extends DeclarationModel {
    /**
     * 理财师
     */
    private String userName;

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

    private Date decOperationDate;

    private String applyUserName;

    private Long declarationId;

    public Long getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Long declarationId) {
        this.declarationId = declarationId;
    }

    public Date getDecOperationDate() {
        return decOperationDate;
    }

    public void setDecOperationDate(Date decOperationDate) {
        this.decOperationDate = decOperationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Date getOperationDate() {
        return operationDate;
    }

    @Override
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
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

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }
}
