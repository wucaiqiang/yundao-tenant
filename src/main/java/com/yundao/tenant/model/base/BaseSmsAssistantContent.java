package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseSmsAssistantContent extends BaseModel implements Serializable {
    /**
	 * 称呼
	 */
    private String callTitle;

    /**
	 * 签名
	 */
    private String sendTitle;

    /**
	 * 内容
	 */
    private String content;

    /**
	 * 发送状态 ： 0:未发送 1：发送成功 2：发送失败
	 */
    private Integer sendStatus;

    /**
	 * 发送时间
	 */
    private Date sendTime;

    /**
	 * 待执行时间
	 */
    private Date executeTime;

    private Long userId;

    private static final long serialVersionUID = 1L;

    public String getCallTitle() {
        return callTitle;
    }

    public void setCallTitle(String callTitle) {
        this.callTitle = callTitle;
    }

    public String getSendTitle() {
        return sendTitle;
    }

    public void setSendTitle(String sendTitle) {
        this.sendTitle = sendTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}