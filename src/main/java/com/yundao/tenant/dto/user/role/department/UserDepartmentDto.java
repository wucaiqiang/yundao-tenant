package com.yundao.tenant.dto.user.role.department;


/**
 * 用户部门信息
 * 
 * @author 欧阳利
 * 2017年6月26日
 */
public class UserDepartmentDto {
    private Long userId;
    
    private String departmentName;
    
    private Long departmentId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
    
    
}
