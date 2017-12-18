
package com.yundao.tenant.dto.tencent;

import java.io.Serializable;

/**
 * Function: Reason: Date: 2017年11月3日 下午7:48:10
 * 
 * @author wucq
 * @version
 */
public class VideoMetaData implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private String size;
	private String container;
	private Integer bitrate;
	private Integer height;
	private Integer width;
	private String md5;
	private Integer duration;
	
	public String getSize() {
	
		return size;
	}
	public void setSize(String size) {
	
		this.size = size;
	}
	public String getContainer() {
	
		return container;
	}
	public void setContainer(String container) {
	
		this.container = container;
	}
	public Integer getBitrate() {
	
		return bitrate;
	}
	public void setBitrate(Integer bitrate) {
	
		this.bitrate = bitrate;
	}
	public Integer getHeight() {
	
		return height;
	}
	public void setHeight(Integer height) {
	
		this.height = height;
	}
	public Integer getWidth() {
	
		return width;
	}
	public void setWidth(Integer width) {
	
		this.width = width;
	}
	public String getMd5() {
	
		return md5;
	}
	public void setMd5(String md5) {
	
		this.md5 = md5;
	}
	public Integer getDuration() {
	
		return duration;
	}
	public void setDuration(Integer duration) {
	
		this.duration = duration;
	}
	
}
