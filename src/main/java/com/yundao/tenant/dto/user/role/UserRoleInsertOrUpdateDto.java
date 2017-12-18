package com.yundao.tenant.dto.user.role;

import java.util.List;

/**
 * 添加用户角色
 * 
 * @author 欧阳利
 * 2017年6月27日
 */
public class UserRoleInsertOrUpdateDto {
	private Long userId;
	private List<Long> roleIds;
	private Long createUserId;
	private Long tenantId;
	private Long updateUserId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Long> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}
	public Long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Long getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	
}
