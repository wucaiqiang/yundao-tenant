package com.yundao.tenant.model.base.msg;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseMsgFeed extends BaseModel implements Serializable {
    /**
	 * 用户ID
	 */
    private Long userId;

    /**
	 * 模板ID
	 */
    private Long templateId;

    /**
	 * 唯一码
	 */
    private String seqNo;

    /**
	 * 客户id
	 */
    private Long customerId;

    /**
	 * 模板code
	 */
    private String templateCode;

    /**
	 * 参数
	 */
    private String params;

    /**
	 *  1、客户  2、交易 
	 */
    private Integer type;

    /**
	 * 真实时间
	 */
    private Date optTime;

    /**
	 * 一级类型  1客户行为  2服务轨迹
	 */
    private Integer firstType;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public Integer getFirstType() {
        return firstType;
    }

    public void setFirstType(Integer firstType) {
        this.firstType = firstType;
    }
}