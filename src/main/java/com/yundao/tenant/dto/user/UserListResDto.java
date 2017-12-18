package com.yundao.tenant.dto.user;

public class UserListResDto {
	/**
	 * 用户id
	 */
	private Integer id;
	
	/**
	 * 部门id
	 */
	private Integer departmentId;
	
	/**
	 * 部门名称
	 */
	private String departmentName;
	
    /**
	 * 登录用户名
	 */
    private String username;
    
    /**
     * 真实姓名
     */
    private String realName;

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
	
	public Integer getIsDimission() {
		return isDimission;
	}

	public void setIsDimission(Integer isDimission) {
		this.isDimission = isDimission;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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
