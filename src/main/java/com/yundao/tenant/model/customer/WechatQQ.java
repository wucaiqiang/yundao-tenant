

package com.yundao.tenant.model.customer;

import java.io.Serializable;

import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.GJLCodeConstant;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年8月10日 上午10:33:16 
 * @author   wucq
 * @version   
 */
public class WechatQQ implements Serializable{
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "微信")
	@Length(isBlank = true, min = 6, max = 20, message = "{" + GJLCodeConstant.CODE_1210035 + "}", groups = {
			Update.class, Insert.class })
	private String wechat;
	@ApiModelProperty(value = "qq")
	@Length(isBlank = true, max = 20, message = "{" + GJLCodeConstant.CODE_1210036 + "}", groups = { Update.class,
			Insert.class })
	private String qq;
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
	
}

