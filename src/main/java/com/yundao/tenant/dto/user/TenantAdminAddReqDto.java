

package com.yundao.tenant.dto.user;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月13日 上午10:48:38 
 * @author   欧阳利
 * @version   
 */
public class TenantAdminAddReqDto {
	@ApiModelProperty("手机号码")
	@Length(min = 1, max = 11, message = "{" + CodeConstant.CODE_1200011 + "}")
    private String mobile;
    
	@ApiModelProperty("租户id")
    private Long userId;
    
	@ApiModelProperty("管理员姓名")
    private String realname;

	public String getMobile() {
	
		return mobile;
	}

	public void setMobile(String mobile) {
	
		this.mobile = mobile;
	}

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

	public String getRealname() {
	
		return realname;
	}

	public void setRealname(String realname) {
	
		this.realname = realname;
	}
	
}

