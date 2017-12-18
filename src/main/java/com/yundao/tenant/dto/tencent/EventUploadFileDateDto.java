
package com.yundao.tenant.dto.tencent;

import java.io.Serializable;
import java.util.List;

import io.swagger.models.auth.In;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:32:59
 * 
 * @author wucq
 * @version
 */
public class EventUploadFileDateDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 状态
	 */
	private Integer status;
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
	private String fileName;
	/**
	 * 文件时长
	 */
	private Integer duration;
	public Integer getStatus() {
	
		return status;
	}
	public void setStatus(Integer status) {
	
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
	public String getFileId() {
	
		return fileId;
	}
	public void setFileId(String fileId) {
	
		this.fileId = fileId;
	}
	public String getFileName() {
	
		return fileName;
	}
	public void setFileName(String fileName) {
	
		this.fileName = fileName;
	}
	public Integer getDuration() {
	
		return duration;
	}
	public void setDuration(Integer duration) {
	
		this.duration = duration;
	}
	
	
	
}
