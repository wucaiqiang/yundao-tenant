
package com.yundao.tenant.dto.cc.cclogin;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CcLoginReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "系统编码")
    private String systemCode;

    @ApiModelProperty(value = "用户账号id")
    private Long userAccountId;

    @ApiModelProperty(value = "ip地址")
    private String ip;

    @ApiModelProperty(value = "登录状态，对应账号状态，1：正常使用；2：禁止登陆")
    private Integer status;

    @ApiModelProperty(value = "登录凭证码")
    private String ticket;

    @ApiModelProperty(value = "类型，1：网页，2：app")
    private Integer type;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getSystemCode (){
        return systemCode;
    }

    public void setSystemCode (String systemCode){
        this.systemCode = systemCode;
    }

    public Long getUserAccountId (){
        return userAccountId;
    }

    public void setUserAccountId (Long userAccountId){
        this.userAccountId = userAccountId;
    }

    public String getIp (){
        return ip;
    }

    public void setIp (String ip){
        this.ip = ip;
    }

    public Integer getStatus (){
        return status;
    }

    public void setStatus (Integer status){
        this.status = status;
    }

    public String getTicket (){
        return ticket;
    }

    public void setTicket (String ticket){
        this.ticket = ticket;
    }

    public Integer getType (){
        return type;
    }

    public void setType (Integer type){
        this.type = type;
    }

}
