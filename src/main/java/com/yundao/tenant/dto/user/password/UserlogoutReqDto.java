package com.yundao.tenant.dto.user.password;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户退出请求
 * 
 * @author 欧阳利
 * 2017年6月26日
 */
public class UserlogoutReqDto {
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
    private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
}
