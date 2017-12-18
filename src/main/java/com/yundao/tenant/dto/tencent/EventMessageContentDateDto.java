
package com.yundao.tenant.dto.tencent;

import java.io.Serializable;
import java.util.List;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:32:59
 * 
 * @author wucq
 * @version
 */
public class EventMessageContentDateDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 状态
	 */
	private Integer errCode;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 任务ID
	 */
	private String vodTaskId;
	/**
	 * 文件Id
	 */
	private String fileId;
	/**
	 * 状态
	 */
	private String status;
	
	
	public String getStatus() {
	
		return status;
	}
	public void setStatus(String status) {
	
		this.status = status;
	}
	public String getMessage() {
	
		return message;
	}
	public void setMessage(String message) {
	
		this.message = message;
	}
	public String getVodTaskId() {
	
		return vodTaskId;
	}
	public void setVodTaskId(String vodTaskId) {
	
		this.vodTaskId = vodTaskId;
	}
	public Integer getErrCode() {
	
		return errCode;
	}
	public void setErrCode(Integer errCode) {
	
		this.errCode = errCode;
	}
	public String getFileId() {
	
		return fileId;
	}
	public void setFileId(String fileId) {
	
		this.fileId = fileId;
	}
	
}
