
package com.yundao.tenant.dto.tencent;

import java.io.Serializable;

/**
 * Function: Reason: Date: 2017年11月3日 下午7:48:10
 * 
 * @author wucq
 * @version
 */
public class VideoBasicInfo implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 视频名称
	 */
	private String name;
	/**
	 * 视频大小。单位：字节
	 */
	private String size;
	/**
	 * 视频时长。单位：秒
	 */
	private Integer duration;
	/**
	 * 视频描述
	 */
	private String description;
	/**
	 * 视频状态， normal：正常
	 */
	private String status;
	/**
	 * 视频创建时间（Unix时间戳）
	 */
	private long createTime;
	/**
	 * 视频信息最近更新时间（Unix时间戳）
	 */
	private long updateTime;
	/**
	 * 视频过期时间（Unix时间戳），视频过期之后，该视频及其所有附属对象（转码结果、雪碧图等）将都被删除
	 */
	private long expireTime;
	/**
	 * 视频分类Id
	 */
	private Integer classificationId;
	/**
	 * 视频分类名称
	 */
	private String classificationName;
	/**
	 * 播放器Id
	 */
	private Integer playerId;
	/**
	 * 视频封面图片地址
	 */
	private String coverUrl;
	/**
	 * 视频封装格式，例如mp4, flv等
	 */
	private String type;
	/**
	 * 视频源文件地址
	 */
	private String sourceVideoUrl;
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	
	public String getSize() {
	
		return size;
	}
	public void setSize(String size) {
	
		this.size = size;
	}
	public Integer getDuration() {
	
		return duration;
	}
	public void setDuration(Integer duration) {
	
		this.duration = duration;
	}
	public String getDescription() {
	
		return description;
	}
	public void setDescription(String description) {
	
		this.description = description;
	}
	public String getStatus() {
	
		return status;
	}
	public void setStatus(String status) {
	
		this.status = status;
	}
	
	public long getCreateTime() {
	
		return createTime;
	}
	public void setCreateTime(long createTime) {
	
		this.createTime = createTime;
	}
	public long getUpdateTime() {
	
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
	
		this.updateTime = updateTime;
	}
	public long getExpireTime() {
	
		return expireTime;
	}
	public void setExpireTime(long expireTime) {
	
		this.expireTime = expireTime;
	}
	
	public Integer getClassificationId() {
	
		return classificationId;
	}
	public void setClassificationId(Integer classificationId) {
	
		this.classificationId = classificationId;
	}
	public String getClassificationName() {
	
		return classificationName;
	}
	public void setClassificationName(String classificationName) {
	
		this.classificationName = classificationName;
	}
	public Integer getPlayerId() {
	
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
	
		this.playerId = playerId;
	}
	public String getCoverUrl() {
	
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
	
		this.coverUrl = coverUrl;
	}
	public String getType() {
	
		return type;
	}
	public void setType(String type) {
	
		this.type = type;
	}
	public String getSourceVideoUrl() {
	
		return sourceVideoUrl;
	}
	public void setSourceVideoUrl(String sourceVideoUrl) {
	
		this.sourceVideoUrl = sourceVideoUrl;
	}
	
}
