package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseProductNotice extends BaseModel implements Serializable {
    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 标题
	 */
    private String title;

    /**
	 * 内容
	 */
    private String content;

    /**
	 * 公告类型
	 */
    private Long noticeTypeId;

    /**
	 * 审核状态 1未提交  2审核中  3已通过  4已驳回  5 已撤销
	 */
    private Integer status;

    /**
	 * 定时发送时间
	 */
    private Date sendTime;

    /**
	 * 是否发送  1发送 0未发送
	 */
    private Integer isSend;

    /**
	 * 是否定时发送（0：不是，1：是）
	 */
    private Integer isTimingSend;

    /**
	 * 审核人id
	 */
    private Long auditUserId;

    /**
	 * 审核时间
	 */
    private Date auditDate;

    /**
	 * 原因
	 */
    private String reason;

    /**
	 * 申请人id
	 */
    private Long applyUserId;

    /**
	 * 申请时间
	 */
    private Date applyDate;

    private static final long serialVersionUID = 1L;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getNoticeTypeId() {
        return noticeTypeId;
    }

    public void setNoticeTypeId(Long noticeTypeId) {
        this.noticeTypeId = noticeTypeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public Integer getIsTimingSend() {
        return isTimingSend;
    }

    public void setIsTimingSend(Integer isTimingSend) {
        this.isTimingSend = isTimingSend;
    }

    public Long getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}