package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseUserVisit extends BaseModel implements Serializable {
    /**
	 * 客户id
	 */
    private Long customerId;

    /**
	 * 回访人id
	 */
    private Long userId;

    /**
	 * 提交回访时间
	 */
    private Date subDate;

    /**
	 * 回访事由
	 */
    private String matter;

    /**
	 * 回访时间
	 */
    private Date visitDate;

    /**
	 * 回访方式(1：电话，2：短信，3：微信/QQ，4：上门拜访，5：其他)
	 */
    private Integer type;

    /**
	 * 回访状态（1：成功，0：失败）
	 */
    private Integer status;

    /**
	 * 回访内容
	 */
    private String content;

    /**
	 * 下次回访时间
	 */
    private Date nextTime;

    /**
	 * 下次回访id
	 */
    private Long nextVisitId;

    /**
	 *  发送消息的状态（0：没有发送，1：已经发送，2 ：不需要发送）
	 */
    private Integer sendStatus;

    private static final long serialVersionUID = 1L;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

    public Long getNextVisitId() {
        return nextVisitId;
    }

    public void setNextVisitId(Long nextVisitId) {
        this.nextVisitId = nextVisitId;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
}