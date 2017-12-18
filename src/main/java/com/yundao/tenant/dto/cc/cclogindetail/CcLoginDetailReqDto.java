
package com.yundao.tenant.dto.cc.cclogindetail;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CcLoginDetailReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "登录id")
    private Long loginId;

    @ApiModelProperty(value = "操作系统名称")
    private String osName;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "分辨率")
    private String resolution;

    @ApiModelProperty(value = "终端信息")
    private String userAgent;

    @ApiModelProperty(value = "浏览器")
    private String browser;

    @ApiModelProperty(value = "备注")
    private String remark;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getLoginId (){
        return loginId;
    }

    public void setLoginId (Long loginId){
        this.loginId = loginId;
    }

    public String getOsName (){
        return osName;
    }

    public void setOsName (String osName){
        this.osName = osName;
    }

    public String getDeviceType (){
        return deviceType;
    }

    public void setDeviceType (String deviceType){
        this.deviceType = deviceType;
    }

    public String getDeviceName (){
        return deviceName;
    }

    public void setDeviceName (String deviceName){
        this.deviceName = deviceName;
    }

    public String getResolution (){
        return resolution;
    }

    public void setResolution (String resolution){
        this.resolution = resolution;
    }

    public String getUserAgent (){
        return userAgent;
    }

    public void setUserAgent (String userAgent){
        this.userAgent = userAgent;
    }

    public String getBrowser (){
        return browser;
    }

    public void setBrowser (String browser){
        this.browser = browser;
    }

    public String getRemark (){
        return remark;
    }

    public void setRemark (String remark){
        this.remark = remark;
    }

}
