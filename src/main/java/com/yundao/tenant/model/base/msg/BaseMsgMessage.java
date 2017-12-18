package com.yundao.tenant.model.base.msg;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseMsgMessage extends BaseModel implements Serializable {
    /**
	 * 查看消息的用户
	 */
    private Long feedUserId;

    /**
	 * 模板id
	 */
    private Long templateId;

    /**
	 * 标题
	 */
    private String title;

    /**
	 * 唯一码
	 */
    private String seqNo;

    /**
	 * 客户id
	 */
    private Long customerId;

    /**
	 * 1未读 2已读
	 */
    private Integer readStatus;

    /**
	 * 模板code
	 */
    private String templateCode;

    /**
	 * 参数
	 */
    private String params;

    /**
	 * 一级消息 1、代办 ，2、消息
	 */
    private Integer firstType;

    /**
	 * 二级类型  1、客户 ，2、产品 ，3、待回访，4、待跟进，5、待审核，6、待确认，7、交易
	 */
    private Integer twoType;

    /**
	 * 真实发生时间
	 */
    private Date optTime;

    private static final long serialVersionUID = 1L;

    public Long getFeedUserId() {
        return feedUserId;
    }

    public void setFeedUserId(Long feedUserId) {
        this.feedUserId = feedUserId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Integer getFirstType() {
        return firstType;
    }

    public void setFirstType(Integer firstType) {
        this.firstType = firstType;
    }

    public Integer getTwoType() {
        return twoType;
    }

    public void setTwoType(Integer twoType) {
        this.twoType = twoType;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }
}