
package com.yundao.tenant.model.customer;

import java.io.Serializable;

import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: Reason: Date: 2017年8月9日 下午1:52:42
 * 
 * @author wucq
 * @version
 */
public class BaseContact implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "手机号码")
	@Length(min = 6, max = 20, message = "{" + CodeConstant.CODE_1200011 + "}", groups = { Update.class, Insert.class })
	private String mobile;

	@ApiModelProperty(value = "邮箱")
	@Length(isBlank = true, min = 1, max = 50, message = "{" + CodeConstant.CODE_1200012 + "}", groups = { Update.class,
			Insert.class })
	private String email;
	@ApiModelProperty(value = "微信")
	@Length(isBlank = true, min = 6, max = 20, message = "{" + GJLCodeConstant.CODE_1210035 + "}", groups = {
			Update.class, Insert.class })
	private String wechat;

	@ApiModelProperty(value = "qq")
	@Length(isBlank = true, max = 20, message = "{" + GJLCodeConstant.CODE_1210036 + "}", groups = { Update.class,
			Insert.class })
	private String qq;

	public String getMobile() {

		return mobile;
	}

	public void setMobile(String mobile) {

		this.mobile = mobile;
	}

	public String getWechat() {

		return wechat;
	}

	public void setWechat(String wechat) {

		this.wechat = wechat;
	}

	public String getQq() {

		return qq;
	}

	public void setQq(String qq) {

		this.qq = qq;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

}
