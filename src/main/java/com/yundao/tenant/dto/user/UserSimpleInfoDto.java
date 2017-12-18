package com.yundao.tenant.dto.user;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author jan
 * @create 2017-07-20 PM9:10
 **/
public class UserSimpleInfoDto implements Serializable {

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Id
	 */
	private Long id;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 角色名 e.g. 理财师
	 */
	private String roleNames;
	/**
	 * 用户名称
	 */
	private String realName;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 所属部门名称
	 */
	private String departmentName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {

		return mobile;
	}

	public void setMobile(String mobile) {

		this.mobile = mobile;
	}

	public String getRoleNames() {

		return roleNames;
	}

	public void setRoleNames(String roleNames) {

		this.roleNames = roleNames;
	}

	public String getRealName() {

		return realName;
	}

	public void setRealName(String realName) {

		this.realName = realName;
	}

	public String getAvatar() {

		return avatar;
	}

	public void setAvatar(String avatar) {

		this.avatar = avatar;
	}

	public String getDepartmentName() {

		return departmentName;
	}

	public void setDepartmentName(String departmentName) {

		this.departmentName = departmentName;
	}

}
