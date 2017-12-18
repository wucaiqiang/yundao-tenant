
package com.yundao.tenant.dto.cc.ccticket;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CcTicketReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "用户账号id")
    private Long userAccountId;

    @ApiModelProperty(value = "登录凭证码")
    private String ticket;

    @ApiModelProperty(value = "存活时间，单位秒，-1代表永不过期")
    private Integer activeTime;

    @ApiModelProperty(value = "过期时间")
    private Date expireTime;

    @ApiModelProperty(value = "类型，1：网页，2：app")
    private Integer type;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getUserAccountId (){
        return userAccountId;
    }

    public void setUserAccountId (Long userAccountId){
        this.userAccountId = userAccountId;
    }

    public String getTicket (){
        return ticket;
    }

    public void setTicket (String ticket){
        this.ticket = ticket;
    }

    public Integer getActiveTime (){
        return activeTime;
    }

    public void setActiveTime (Integer activeTime){
        this.activeTime = activeTime;
    }

    public Date getExpireTime (){
        return expireTime;
    }

    public void setExpireTime (Date expireTime){
        this.expireTime = expireTime;
    }

    public Integer getType (){
        return type;
    }

    public void setType (Integer type){
        this.type = type;
    }

}
