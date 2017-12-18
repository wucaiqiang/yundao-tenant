package com.yundao.tenant.dto.login;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class LoginLogAddReqDto{
    @ApiModelProperty("登录用户名")
    private String loginAccount;

    @ApiModelProperty("用户账号id")
    private Long userAccountId;

    @ApiModelProperty("登录日期")
    private Date loginDate = new Date();

    @ApiModelProperty("登录IP")
    private String loginIp;

    @ApiModelProperty("登录地址")
    private String loginAddress;

    @ApiModelProperty("手机型号/浏览器型号")
    private String model;

    @ApiModelProperty("请求参数")
    private String params;

    @ApiModelProperty("结果码 1成功，其他失败")
    private Integer result;

    @ApiModelProperty("结果内容")
    private String resultMessage;

    @ApiModelProperty("系统编码")
    private String systemCode;

    @ApiModelProperty("登录类型，0：PC，1：ANDROID 2：IOS")
    private Integer loginType;

    @ApiModelProperty("版本号")
    private String version;

    private static final long serialVersionUID = 1L;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}