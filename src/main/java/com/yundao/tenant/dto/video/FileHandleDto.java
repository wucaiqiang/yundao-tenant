

package com.yundao.tenant.dto.video;

import java.io.Serializable;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月16日 下午3:14:51 
 * @author   wucq
 * @version   
 */
public class FileHandleDto implements Serializable{
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * upload：上传完成或 transcode：转码 
	 */
    private String handleType;
    /**
     * 文件ID
     */
    private String fileId;
	public String getHandleType() {
	
		return handleType;
	}
	public void setHandleType(String handleType) {
	
		this.handleType = handleType;
	}
	public String getFileId() {
	
		return fileId;
	}
	public void setFileId(String fileId) {
	
		this.fileId = fileId;
	}
    
}

