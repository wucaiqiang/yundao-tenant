

package com.yundao.tenant.dto.tencent;

import java.io.Serializable;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月4日 上午10:49:44 
 * @author   wucq
 * @version   
 */
public class FileInfoDto implements Serializable{

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 文件ID
	 */
	private String fileId;
	/**
	 * 文件url
	 */
	private String fileUrl;
	/**
	 * 文件格式
	 */
	private String fileType;
	public String getFileId() {
	
		return fileId;
	}
	public void setFileId(String fileId) {
	
		this.fileId = fileId;
	}
	public String getFileUrl() {
	
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
	
		this.fileUrl = fileUrl;
	}
	public String getFileType() {
	
		return fileType;
	}
	public void setFileType(String fileType) {
	
		this.fileType = fileType;
	}
	

}

