package com.yundao.tenant.model.base.msg;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseMsgTemplate extends BaseModel implements Serializable {
    /**
	 * 标题
	 */
    private String title;

    /**
	 * 动态内容
	 */
    private String feedContent;

    /**
	 * 消息的内容
	 */
    private String messageContent;

    /**
	 * app内容
	 */
    private String appContent;

    /**
	 * 1 不需要 2需要
	 */
    private Integer needPush;

    /**
	 * push内容
	 */
    private String pushContent;

    /**
	 * 首页内容
	 */
    private String indexContent;

    /**
	 * app动作
	 */
    private String appAction;

    /**
	 * pc跳转动作
	 */
    private String pcAction;

    /**
	 * 唯一编码
	 */
    private String code;

    /**
	 * 验证参数
	 */
    private String params;

    /**
	 * 备注
	 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeedContent() {
        return feedContent;
    }

    public void setFeedContent(String feedContent) {
        this.feedContent = feedContent;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getAppContent() {
        return appContent;
    }

    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }

    public Integer getNeedPush() {
        return needPush;
    }

    public void setNeedPush(Integer needPush) {
        this.needPush = needPush;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public String getIndexContent() {
        return indexContent;
    }

    public void setIndexContent(String indexContent) {
        this.indexContent = indexContent;
    }

    public String getAppAction() {
        return appAction;
    }

    public void setAppAction(String appAction) {
        this.appAction = appAction;
    }

    public String getPcAction() {
        return pcAction;
    }

    public void setPcAction(String pcAction) {
        this.pcAction = pcAction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}