package com.yundao.tenant.dto.user;

import java.util.List;

import com.yundao.tenant.dto.user.role.UserRoleDto;
import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.model.base.BaseUserRole;

/**
 * 查询用户详情
 * 
 * @author 欧阳利 2017年6月22日
 */
public class UserCardResDto extends BaseUserDetail {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 租户名称
	 */
	private String tenantName;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 名片UUID
	 */
	private String avatar;
	/**
	 * 当前用户角色组
	 */
	private List<UserRoleDto> roles;
	/**
	 * 用户部分
	 */
	private String departmentName;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 邮箱
	 */
	private String email;

	public String getTenantName() {

		return tenantName;
	}

	public void setTenantName(String tenantName) {

		this.tenantName = tenantName;
	}

	public String getMobile() {

		return mobile;
	}

	public void setMobile(String mobile) {

		this.mobile = mobile;
	}

	public String getAvatar() {

		return avatar;
	}

	public void setAvatar(String avatar) {

		this.avatar = avatar;
	}

	public List<UserRoleDto> getRoles() {

		return roles;
	}

	public void setRoles(List<UserRoleDto> roles) {

		this.roles = roles;
	}

	public String getDepartmentName() {

		return departmentName;
	}

	public void setDepartmentName(String departmentName) {

		this.departmentName = departmentName;
	}

	public String getAddress() {
	
		return address;
	}

	public void setAddress(String address) {
	
		this.address = address;
	}

	public String getEmail() {
	
		return email;
	}

	public void setEmail(String email) {
	
		this.email = email;
	}

}
