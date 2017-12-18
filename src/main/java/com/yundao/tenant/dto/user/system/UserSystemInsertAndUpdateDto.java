package com.yundao.tenant.dto.user.system;

import java.util.List;

public class UserSystemInsertAndUpdateDto {
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 系统集合
	 */
	private List<String> systemCodes;
	/**
	 * 创建人id
	 */
	private Long createUserId;
	/**
	 * 租户id
	 */
	private Long tenantId;
	/**
	 * 修改用户
	 */
	private Long updateUserId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<String> getSystemCodes() {
		return systemCodes;
	}
	public void setSystemCodes(List<String> systemCodes) {
		this.systemCodes = systemCodes;
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
