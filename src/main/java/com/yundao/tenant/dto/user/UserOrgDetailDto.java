package com.yundao.tenant.dto.user;

import com.yundao.tenant.dto.user.role.RoleSimpleDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 组织架构用户详情
 *
 * @author jan
 * @create 2017-11-01 17:49
 **/
public class UserOrgDetailDto {

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
     * 领导id
     */
    @ApiModelProperty(value = "领导id")
    private Long leaderId;

    /**
     * 领导名称
     */
    @ApiModelProperty(value = "领导名称")
    private String leaderName;

    @ApiModelProperty(value = "是否系统预置用户(1：是;0:否) ")
    private Integer isSystem;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    public List<RoleSimpleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleSimpleDto> roles) {
        this.roles = roles;
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

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }
}
