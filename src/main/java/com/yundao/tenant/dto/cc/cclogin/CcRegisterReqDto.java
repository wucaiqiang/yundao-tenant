package com.yundao.tenant.dto.cc.cclogin;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/9/11.
 */
public class CcRegisterReqDto {
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

	@ApiModelProperty("昵称")
	@Length(min = 1, max = 20, message = "{" + GJLCodeConstant.CODE_1210081 + "}")
	private String realName;

	@ApiModelProperty("理财师uuid")
	private String afpUUID;

	@ApiModelProperty("渠道")
	private Integer channel;

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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public String getAfpUUID() {
	
		return afpUUID;
	}

	public void setAfpUUID(String afpUUID) {
	
		this.afpUUID = afpUUID;
	}
	
}