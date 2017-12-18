
package com.yundao.tenant.dto.msg.msgmessage;

import com.yundao.tenant.model.base.msg.BaseMsgMessage;

public class MsgMessagePageResDto extends BaseMsgMessage{
    private String firstTypeText;

    private String twoTypeText;

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
     * pc跳转
     */
    private String pcAction;

    /**
     * app跳转
     */
    private String appAction;

    public String getFirstTypeText() {
        return firstTypeText;
    }

    public void setFirstTypeText(String firstTypeText) {
        this.firstTypeText = firstTypeText;
    }

    public String getTwoTypeText() {
        return twoTypeText;
    }

    public void setTwoTypeText(String twoTypeText) {
        this.twoTypeText = twoTypeText;
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
}
