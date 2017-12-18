
package com.yundao.tenant.dto.smsassistantcontent;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class SmsAssistantContentReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "称呼")
    private String callTitle;

    @ApiModelProperty(value = "签名")
    private String sendTitle;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发送状态 ： 0:未发送 1：发送成功 2：发送失败")
    private Integer sendStatus;

    @ApiModelProperty(value = "发送时间")
    private Date sendTime;

    @ApiModelProperty(value = "待执行时间")
    private Date executeTime;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getCallTitle (){
        return callTitle;
    }

    public void setCallTitle (String callTitle){
        this.callTitle = callTitle;
    }

    public String getSendTitle (){
        return sendTitle;
    }

    public void setSendTitle (String sendTitle){
        this.sendTitle = sendTitle;
    }

    public String getContent (){
        return content;
    }

    public void setContent (String content){
        this.content = content;
    }

    public Integer getSendStatus (){
        return sendStatus;
    }

    public void setSendStatus (Integer sendStatus){
        this.sendStatus = sendStatus;
    }

    public Date getSendTime (){
        return sendTime;
    }

    public void setSendTime (Date sendTime){
        this.sendTime = sendTime;
    }

    public Date getExecuteTime (){
        return executeTime;
    }

    public void setExecuteTime (Date executeTime){
        this.executeTime = executeTime;
    }

}
