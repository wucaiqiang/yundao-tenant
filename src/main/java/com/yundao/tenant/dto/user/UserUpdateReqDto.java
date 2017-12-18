package com.yundao.tenant.dto.user;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;


/**
 * 修改用户信息
 * 
 * @author 欧阳利
 * 2017年6月22日
 */
public class UserUpdateReqDto {
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	@NotNull(message="{" + CodeConstant.CODE_1200014 + "}")
	private Long id;
	
	/**
	 * 部门id
	 */
	@ApiModelProperty(value = "部门id")
	@NotNull(message="{" + CodeConstant.CODE_1200006 + "}")
	private Long departmentId;


	/**
	 * 角色id结婚
	 */
	@ApiModelProperty(value = "角色id集合")
	@NotNull(message="{" + CodeConstant.CODE_1200007 + "}")
	private List<Long> roleIds;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    @Length(min = 1, max = 20, message = "{" + CodeConstant.CODE_1200010 + "}")
    private String realName;
	
	/**
	 * 工号
	 */
    @ApiModelProperty(value = "工号")
	@Length(min = 1, max = 20, message = "{" + CodeConstant.CODE_1200013 + "}" ,isBlank = true)
	private  String jobNumber;

    /**
     * 领导id
     */
    @ApiModelProperty(value = "领导id")
    private Long leaderId;
    
	public Long getLeaderId() {
		return leaderId;
	}


	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}


	public String getJobNumber() {
		return jobNumber;
	}


	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	public List<Long> getRoleIds() {
		return roleIds;
	}


	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}



}
