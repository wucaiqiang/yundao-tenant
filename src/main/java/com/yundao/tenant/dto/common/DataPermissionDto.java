package com.yundao.tenant.dto.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * 数据权限dto
 * 
 * @author 欧阳利
 * 2017年8月9日
 */
public class DataPermissionDto {
	@ApiModelProperty("数据对象code")
	private String dataObjectCode;
	
	@ApiModelProperty("是否有查询权限(1:有; 0:没有)")
    private Integer readPermission;
	@ApiModelProperty("是否有删除权限(1:有; 0:没有)")
    private Integer deletePermission;
	@ApiModelProperty("是否有修改权限(1:有; 0:没有)")
    private Integer editPermission;
	
	public String getDataObjectCode() {
		return dataObjectCode;
	}
	public void setDataObjectCode(String dataObjectCode) {
		this.dataObjectCode = dataObjectCode;
	}
	public Integer getReadPermission() {
		return readPermission;
	}
	public void setReadPermission(Integer readPermission) {
		this.readPermission = readPermission;
	}
	public Integer getDeletePermission() {
		return deletePermission;
	}
	public void setDeletePermission(Integer deletePermission) {
		this.deletePermission = deletePermission;
	}
	public Integer getEditPermission() {
		return editPermission;
	}
	public void setEditPermission(Integer editPermission) {
		this.editPermission = editPermission;
	}
	
}
