package com.yundao.tenant.dto.user.role;

public class UserRoleDto {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 姓名
     */
    private String roleName;
    
    /**
     * 用户id
     */
    private Long userId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    
}
