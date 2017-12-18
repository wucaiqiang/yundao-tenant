package com.yundao.tenant.dto.department;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.user.UserInfoDto;

import io.swagger.annotations.ApiModelProperty;

public class DepartmentUserSimpleResDto implements Serializable {

	/**
	 * 部门id
	 */
	@ApiModelProperty(value = "部门id")
	private Long departmentId;
	/**
	 * 名字
	 */
	@ApiModelProperty(value = "名字")
	private String name;

	/**
	 * 编码（最小八位数，最大支持八层，从00000001开始）
	 */
	@ApiModelProperty(value = "编码（最小八位数，最大支持八层，从00000001开始）")
	private String code;
	/**
	 * 父id
	 */
	@ApiModelProperty(value = "父id")
	private Long parentId;
	private String systemCode;
	/**
	 * 描述
	 */
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "用户ID")
	private Long userId;
	@ApiModelProperty(value = "用户手机号")
	private String mobile;
	@ApiModelProperty(value = "用户真实名字")
	private String realName;
	@ApiModelProperty(value = "用户头像")
	private String avatar;
	@ApiModelProperty(value = "用户头像")
	private Integer isEnabled;

	private static final long serialVersionUID = 1000L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDepartmentId() {

		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {

		this.departmentId = departmentId;
	}

	public Long getUserId() {

		return userId;
	}

	public void setUserId(Long userId) {

		this.userId = userId;
	}

	public String getMobile() {

		return mobile;
	}

	public void setMobile(String mobile) {

		this.mobile = mobile;
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

	public String getSystemCode() {
	
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
	
		this.systemCode = systemCode;
	}

	public Integer getIsEnabled() {
	
		return isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
	
		this.isEnabled = isEnabled;
	}

}