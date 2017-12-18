package com.yundao.tenant.dto.user.password;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户登录请求
 * 
 * @author 欧阳利
 * 2017年6月26日
 */
public class UserloginReqDto {
	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
    private String userName;
    
    /**
     * 用户密码
     */
	@ApiModelProperty(value = "密码")
    private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


    
}
