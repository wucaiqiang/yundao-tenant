
package com.yundao.tenant.dto.tencent;

import java.io.Serializable;
import java.util.List;

/**
 * Function: Reason: Date: 2017年11月3日 下午7:48:10
 * 
 * @author wucq
 * @version
 */
public class TransCode implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 转码后的视频文件地址
	 */
	private String url;
	/**
	 * 转码模板Id
	 */
	private String definition;
	/**
	 * 视频流码率平均值与音频流码率平均值之和。 单位：bps
	 */
	private String bitrate;
	/**
	 * 视频流高度的最大值。单位：px
	 */
	private String height;
	/**
	 * 视频流宽度的最大值。单位：px
	 */
	private String width;
	/**
	 * 视频大小。单位：字节
	 */
	private String size;
	/**
	 * 视频时长。单位：秒
	 */
	private String duration;
	/**
	 * 容器类型，例如m4a，mp4等
	 */
	private String container;
	/**
	 * 视频的md5值
	 */
	private String md5;
	public String getUrl() {
	
		return url;
	}
	public void setUrl(String url) {
	
		this.url = url;
	}
	public String getDefinition() {
	
		return definition;
	}
	public void setDefinition(String definition) {
	
		this.definition = definition;
	}
	public String getBitrate() {
	
		return bitrate;
	}
	public void setBitrate(String bitrate) {
	
		this.bitrate = bitrate;
	}
	public String getHeight() {
	
		return height;
	}
	public void setHeight(String height) {
	
		this.height = height;
	}
	public String getWidth() {
	
		return width;
	}
	public void setWidth(String width) {
	
		this.width = width;
	}
	public String getSize() {
	
		return size;
	}
	public void setSize(String size) {
	
		this.size = size;
	}
	public String getDuration() {
	
		return duration;
	}
	public void setDuration(String duration) {
	
		this.duration = duration;
	}
	public String getContainer() {
	
		return container;
	}
	public void setContainer(String container) {
	
		this.container = container;
	}
	public String getMd5() {
	
		return md5;
	}
	public void setMd5(String md5) {
	
		this.md5 = md5;
	}
	
}
