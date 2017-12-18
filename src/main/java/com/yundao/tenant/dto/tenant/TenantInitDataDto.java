package com.yundao.tenant.dto.tenant;

import java.util.List;

/**
 * 租户初始化信息
 * 
 * @author 欧阳利
 * 2017年6月28日
 */
public class TenantInitDataDto {
	
	/**
	 * 部门信息
	 */
    private List<DepartmentInitDataDto>  departmentDtos;
    
    /**
     * 资源信息
     */
    private List<ResourceInitDataDto> resourceModelList;
    
    /**
     * 角色信息
     */
    private List<RoleInitDataDto>  roleModelList;
    
    /**
     * 角色资源信息
     */
    private List<RoleResourceInitDataDto> roleResourceModelList;

	public List<DepartmentInitDataDto> getDepartmentDtos() {
		return departmentDtos;
	}

	public void setDepartmentDtos(List<DepartmentInitDataDto> departmentDtos) {
		this.departmentDtos = departmentDtos;
	}

	public List<ResourceInitDataDto> getResourceModelList() {
		return resourceModelList;
	}

	public void setResourceModelList(List<ResourceInitDataDto> resourceModelList) {
		this.resourceModelList = resourceModelList;
	}

	public List<RoleInitDataDto> getRoleModelList() {
		return roleModelList;
	}

	public void setRoleModelList(List<RoleInitDataDto> roleModelList) {
		this.roleModelList = roleModelList;
	}

	public List<RoleResourceInitDataDto> getRoleResourceModelList() {
		return roleResourceModelList;
	}

	public void setRoleResourceModelList(List<RoleResourceInitDataDto> roleResourceModelList) {
		this.roleResourceModelList = roleResourceModelList;
	}




    
}
