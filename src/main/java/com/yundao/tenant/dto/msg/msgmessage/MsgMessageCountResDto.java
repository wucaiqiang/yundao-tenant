
package com.yundao.tenant.dto.msg.msgmessage;

public class MsgMessageCountResDto {

    private Integer taskCount;

    private Integer messageCount;

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    public Integer getTaskCount() {

        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }
}
