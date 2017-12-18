

package com.yundao.tenant.dto.common;

import java.io.Serializable;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年8月9日 下午1:58:28 
 * @author   wucq
 * @version   
 */
public class PermissionDto implements Serializable{

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 读权限
	 */
	private Integer readPermission;
	/**
	 * 编辑
	 */
	private Integer editPermission;
	/**
	 * 删除
	 */
	private Integer deletePermission;
	public Integer getReadPermission() {
	
		return readPermission;
	}
	public void setReadPermission(Integer readPermission) {
	
		this.readPermission = readPermission;
	}
	public Integer getEditPermission() {
	
		return editPermission;
	}
	public void setEditPermission(Integer editPermission) {
	
		this.editPermission = editPermission;
	}
	public Integer getDeletePermission() {
	
		return deletePermission;
	}
	public void setDeletePermission(Integer deletePermission) {
	
		this.deletePermission = deletePermission;
	}
}

