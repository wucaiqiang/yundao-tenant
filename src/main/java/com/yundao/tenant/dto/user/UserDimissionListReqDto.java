package com.yundao.tenant.dto.user;

import java.util.List;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户离职或者在职查询
 * 
 * @author 欧阳利
 * 2017年6月26日
 */
public class UserDimissionListReqDto  extends AbstractBasePageDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 姓名
	 */
	 @ApiModelProperty(value = "姓名")
    private String realName;
    
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String mobile;
    
    /**
     * 是否离职
     */
    @ApiModelProperty(value = "是否离职")
    private Integer isDimission;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    private Integer isEnabled;

    /**
     * 工号
     */
    @ApiModelProperty(value = "工号")
    private String jobNumber;
    
    
    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门名称")
    private String departmentName;
    
    /**
     * 领导名称
     */
    @ApiModelProperty(value = "领导名称")
    private String leaderName;
    
    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Long departmentId;
    
    /**
     * 部门集合
     */
    private List<Long> departmentIds;
    
	public List<Long> getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(List<Long> departmentIds) {
		this.departmentIds = departmentIds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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


	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}


	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public Integer getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}
}
