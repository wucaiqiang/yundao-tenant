package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseLeads extends BaseModel implements Serializable {
    /**
	 * 客户id
	 */
    private Long customerId;

    /**
	 * 线索类型，1：预约产品；2：注册；
	 */
    private Integer type;

    /**
	 * 渠道，1：网站；2：服务号
	 */
    private Integer channel;

    /**
	 * 内容
	 */
    private String content;

    /**
	 * 备注
	 */
    private String remark;

    /**
	 * 跟进备注
	 */
    private String followRemark;

    /**
	 * 状态，0：未处理；1：已联系；2：关闭
	 */
    private Integer status;

    /**
	 * 对象id
	 */
    private Long objectId;

    /**
	 * 处理人id
	 */
    private Long processUserId;

    /**
	 * 处理时间
	 */
    private Date processDate;

    /**
	 * 线索所属客户的状态，是否曾经被设置过无效，0：否，1：是，默认0
	 */
    private Integer isOnceInvalid;

    /**
	 * 是否已被分配给客服，0：否，1：是
	 */
    private Integer isAllotedCs;

    /**
	 * 是否已被分配给理财师，0：否，1：是
	 */
    private Integer isAllotedFp;

    private static final long serialVersionUID = 1L;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFollowRemark() {
        return followRemark;
    }

    public void setFollowRemark(String followRemark) {
        this.followRemark = followRemark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Long getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(Long processUserId) {
        this.processUserId = processUserId;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public Integer getIsOnceInvalid() {
        return isOnceInvalid;
    }

    public void setIsOnceInvalid(Integer isOnceInvalid) {
        this.isOnceInvalid = isOnceInvalid;
    }

    public Integer getIsAllotedCs() {
        return isAllotedCs;
    }

    public void setIsAllotedCs(Integer isAllotedCs) {
        this.isAllotedCs = isAllotedCs;
    }

    public Integer getIsAllotedFp() {
        return isAllotedFp;
    }

    public void setIsAllotedFp(Integer isAllotedFp) {
        this.isAllotedFp = isAllotedFp;
    }
}