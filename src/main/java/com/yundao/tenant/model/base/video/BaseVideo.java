package com.yundao.tenant.model.base.video;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseVideo extends BaseModel implements Serializable {
    /**
	 * 视频分类 1:路演 2：合规双录
	 */
    private Integer category;

    /**
	 * 视频名称
	 */
    private String name;

    /**
	 * 文件名
	 */
    private String fileName;

    /**
	 * 时长
	 */
    private Integer duration;

    /**
	 * 格式
	 */
    private String type;

    /**
	 * 状态 0:压缩中 1：压缩完成
	 */
    private Integer status;

    /**
	 * 大小
	 */
    private Long size;

    /**
	 * 封面
	 */
    private String coverUrl;

    /**
	 * 腾讯云文件ID
	 */
    private String refId;

    /**
	 * 原始文件地址
	 */
    private String sourceUrl;

    /**
	 * 描述
	 */
    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}