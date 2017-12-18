package com.yundao.tenant.dto.tenant;

public class RoleResourceInitDataDto {
    /**
	 * 资源id
	 */
    private Long resourceId;

    /**
	 * 角色id
	 */
    private Long roleId;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;
    
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 主键
	 */
	private Long tenantId;


	/**
	 * 是否启用 0 否 1是，默认1
	 */
	private Integer isEnabled;

	/**
	 * 是否删除 0 否  1是 ，默认0
	 */
	private Integer isDelete;

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
}
