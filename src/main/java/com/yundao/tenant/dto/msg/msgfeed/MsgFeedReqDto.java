
package com.yundao.tenant.dto.msg.msgfeed;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class MsgFeedReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "")
    private Long userId;

    @ApiModelProperty(value = "客户id")
    private Long templateId;

    @ApiModelProperty(value = "证件类型（1：身份证，2：护照）")
    private String seqNo;

    @ApiModelProperty(value = "证件号码")
    private Long customerId;

    @ApiModelProperty(value = "")
    private String templateCode;

    @ApiModelProperty(value = "")
    private String params;

    @ApiModelProperty(value = " 1、客户  2、交易 ")
    private Long type;

    @ApiModelProperty(value = "")
    private Date optTime;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getUserId (){
        return userId;
    }

    public void setUserId (Long userId){
        this.userId = userId;
    }

    public Long getTemplateId (){
        return templateId;
    }

    public void setTemplateId (Long templateId){
        this.templateId = templateId;
    }

    public String getSeqNo (){
        return seqNo;
    }

    public void setSeqNo (String seqNo){
        this.seqNo = seqNo;
    }

    public Long getCustomerId (){
        return customerId;
    }

    public void setCustomerId (Long customerId){
        this.customerId = customerId;
    }

    public String getTemplateCode (){
        return templateCode;
    }

    public void setTemplateCode (String templateCode){
        this.templateCode = templateCode;
    }

    public String getParams (){
        return params;
    }

    public void setParams (String params){
        this.params = params;
    }

    public Long getType (){
        return type;
    }

    public void setType (Long type){
        this.type = type;
    }

    public Date getOptTime (){
        return optTime;
    }

    public void setOptTime (Date optTime){
        this.optTime = optTime;
    }

}
