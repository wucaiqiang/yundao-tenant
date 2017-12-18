package com.yundao.tenant.dto.user;

/**
 * 用户信息
 *
 * @author jan
 * @create 2017-07-20 PM9:10
 **/
public class UserInfoDto {

	/**
	 * Id
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 是否锁定，0：否，1：是
	 */
	private Integer isLock;

	/**
	 * 是否离职，0：否；1：是
	 */
	private Integer isDimission;

	/**
	 * 工号
	 */
	private String jobNumber;

	/**
	 * 汇报上级id
	 */
	private Long leaderId;
	/**
	 * 用户名称
	 */
	private String realName;
	/**
	 * 头像
	 */
	private String avatar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public Integer getIsDimission() {
		return isDimission;
	}

	public void setIsDimission(Integer isDimission) {
		this.isDimission = isDimission;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public Long getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
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
	
}
