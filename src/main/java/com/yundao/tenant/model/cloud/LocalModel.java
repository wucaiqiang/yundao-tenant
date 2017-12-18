package com.yundao.tenant.model.cloud;

import com.yundao.core.base.model.BaseModel;
import com.yundao.tenant.model.base.BaseCloudFile;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 本地文件
 * 
 * @author wupengfei wupf86@126.com
 *
 */
public class LocalModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 云类型
	 */
	private Integer type;

	/**
	 * 原文件名
	 */
	private String originalName;

	/**
	 * 新文件名
	 */
	private String newName;

	/**
	 * 大小
	 */
	private Long size;

	/**
	 * 目录
	 */
	private String folder;

	/**
	 * 绝对路径
	 */
	private String path;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 本地链接
	 */
	private String url;

	/**
	 * 云链接
	 */
	private String cloudUrl;

	/**
	 * 云文件集合
	 */
	private List<BaseCloudFile> cloudList;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCloudUrl() {
		return cloudUrl;
	}

	public void setCloudUrl(String cloudUrl) {
		this.cloudUrl = cloudUrl;
	}

	public void setCloudList(List<BaseCloudFile> cloudList) {
		this.cloudList = cloudList;
	}

	public List<BaseCloudFile> getCloudList() {
		return cloudList;
	}
}
