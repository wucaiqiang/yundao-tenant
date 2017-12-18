package com.yundao.tenant.dto.user.password;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户修改密码
 * 
 * @author 欧阳利
 * 2017年6月26日
 */
public class UserUpdatePasswordReqDto {

    /**
     * 旧密码
     */
	@ApiModelProperty(value = "原密码")
    private String oldPassword;
    
    /**
     * 行密码
     */
	@ApiModelProperty(value = "新密码")
    private String newPassword;



	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
    
}
