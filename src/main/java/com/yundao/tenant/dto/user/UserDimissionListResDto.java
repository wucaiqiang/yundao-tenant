package com.yundao.tenant.dto.user;

import java.util.List;

import com.yundao.tenant.dto.user.role.RoleSimpleDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户在职或者离职列表信息
 * 
 * @author 欧阳利
 * 2017年6月26日
 */
@ApiModel
public class UserDimissionListResDto {
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
    private Long id;
    /**
     * 用户姓名
     */
	@ApiModelProperty(value = "用户姓名")
    private String realName;
    
    /**
     * 用户名称
     */
	@ApiModelProperty(value = "用户名称")
    private String username;
    
    /**
     * 角色名称
     */
	@ApiModelProperty(value = "角色名称集合")
    private List<String> roleNames;
	
	/**
	 * 角色集合
	 */
	@ApiModelProperty(value = "角色集合")
	private List<RoleSimpleDto> roles;
    
    /**
     * 手机号码
     */
	@ApiModelProperty(value = "手机号码")
    private String mobile;
    
    /**
     * 工号
     */
	@ApiModelProperty(value = "工号")
    private String jobNumber;

    /**
     * 部门id
     */
	@ApiModelProperty(value = "部门id")
    private Long departmentId;
    
    /**
     * 部门名称
     */
	@ApiModelProperty(value = "部门名称")
    private String departmentName;
    
    /**
     * 是否离职
     */
	@ApiModelProperty(value = "是否离职")
    private Integer isDimission;
	
	/**
	 * 领导id
	 */
	@ApiModelProperty(value = "领导id")
	private Long leaderId;
	
	/**
	 * 领导name
	 */
	@ApiModelProperty(value = "领导名称")
	private String LeaderName;
	
	@ApiModelProperty(value = "是否系统预置用户(1：是;0:否) ")
	private Integer isSystem;
    
	public Integer getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}

	public List<RoleSimpleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleSimpleDto> roles) {
		this.roles = roles;
	}

	public Long getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}



	public String getLeaderName() {
		return LeaderName;
	}

	public void setLeaderName(String leaderName) {
		LeaderName = leaderName;
	}

	public Integer getIsDimission() {
		return isDimission;
	}

	public void setIsDimission(Integer isDimission) {
		this.isDimission = isDimission;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public List<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
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
