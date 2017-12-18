package com.yundao.tenant.dto.user;

import com.yundao.tenant.dto.AbstractBasePageDto;

public class UserListReqDto extends AbstractBasePageDto{

	private static final long serialVersionUID = 1L;
	/**
	 * 用户id
	 */
	private Long id;
	
    /**
     * 真实姓名
     */
    private String username;
	
    /**
     * 真实姓名
     */
    private String realName;
    
	/**
	 * 部门id
	 */
	private Long departmentId;
	
	/**
	 * 角色id
	 */
	private Long roleId;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
    /**
	 * 手机号
	 */
    private String mobile;
    
	/**
	 * 工号
	 */
	private String jobNumber;
	
	/**
	 * 是否离职(0:在职, 1：离职)
	 */
	private Integer isDimission;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIsDimission() {
		return isDimission;
	}

	public void setIsDimission(Integer isDimission) {
		this.isDimission = isDimission;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
    
}
