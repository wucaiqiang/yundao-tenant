package com.yundao.tenant.dto.login;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;


public class RetrievePasswordDto {
    /**
	 * 手机号码
	 */
    @ApiModelProperty("手机号码")
    @Length(min = 11, max = 11, message = "{" + CodeConstant.CODE_1200011 + "}")
    private String mobile;

    /**
	 * 验证码
	 */
    @ApiModelProperty("验证码")
    @Length(min = 6, max = 6, message = "{" + GJLCodeConstant.CODE_1210080 + "}")
    private String captcha;

    /**
	 * 密码
	 */
    @ApiModelProperty("密码")
    @Length(message = "{" + GJLCodeConstant.CODE_1210081 + "}")
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}