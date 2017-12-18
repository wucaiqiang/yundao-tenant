
package com.yundao.tenant.dto.smsassistantcontentref;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class SmsAssistantContentRefReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "短信助手内容ID")
    private Long smsAssistantContentId;

    @ApiModelProperty(value = "客户ID")
    private Long customerId;

    @ApiModelProperty(value = "客户手机号")
    private String customerMobile;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getSmsAssistantContentId (){
        return smsAssistantContentId;
    }

    public void setSmsAssistantContentId (Long smsAssistantContentId){
        this.smsAssistantContentId = smsAssistantContentId;
    }

    public Long getCustomerId (){
        return customerId;
    }

    public void setCustomerId (Long customerId){
        this.customerId = customerId;
    }

    public String getCustomerMobile (){
        return customerMobile;
    }

    public void setCustomerMobile (String customerMobile){
        this.customerMobile = customerMobile;
    }

}
