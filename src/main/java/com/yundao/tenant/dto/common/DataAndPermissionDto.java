
package com.yundao.tenant.dto.common;

import java.io.Serializable;

import com.yundao.tenant.dto.common.DataDto;
import com.yundao.tenant.dto.common.PermissionDto;

/**
 * Function: Reason: Date: 2017年8月9日 上午11:37:29
 * 
 * @author wucq
 * @version
 */
public class DataAndPermissionDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private DataDto data;
	private DataPermissionDto permission;
	public DataAndPermissionDto(){}
	public DataAndPermissionDto(DataDto data){
		this.data=data;
	}
	public DataAndPermissionDto(DataDto data,DataPermissionDto permission){
		this.data=data;
		this.permission=permission;
	}
	public DataDto getData() {
	
		return data;
	}
	public void setData(DataDto data) {
	
		this.data = data;
	}
	public DataPermissionDto getPermission() {
	
		return permission;
	}
	public void setPermission(DataPermissionDto permission) {
	
		this.permission = permission;
	}

	
}
