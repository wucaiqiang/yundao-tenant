
package com.yundao.tenant.dto.msg.msgfeed;

import com.yundao.tenant.model.base.msg.BaseMsgFeed;

public class MsgFeedResDto extends BaseMsgFeed{
    /**
     * 标题
     */
    private String title;

    /**
     * 动态内容
     */
    private String feedContent;

    /**
     * 消息内容
     */
    private String messageContent;

    /**
     * app内容
     */
    private String appContent;
    /**
     * 首页内容
     */
    private String indexContent;

    /**
     * 备注
     */
    private String remark;

    /**
     * 类型文本
     */
    private String typeText;

    /**
     * pc跳转
     */
    private String pcAction;

    /**
     * app跳转
     */
    private String appAction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAppContent() {
        return appContent;
    }

    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }

    public String getIndexContent() {
        return indexContent;
    }

    public void setIndexContent(String indexContent) {
        this.indexContent = indexContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getPcAction() {
        return pcAction;
    }

    public void setPcAction(String pcAction) {
        this.pcAction = pcAction;
    }

    public String getAppAction() {
        return appAction;
    }

    public void setAppAction(String appAction) {
        this.appAction = appAction;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }
}
