package com.yundao.tenant.model.base.video;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseVideoTranscode extends BaseModel implements Serializable {
    /**
	 * 原始视频关联ID
	 */
    private Long videoId;

    /**
	 * 大小
	 */
    private Long size;

    /**
	 * 转码类型 标清：20 高清：30
	 */
    private Integer definition;

    /**
	 * 文件格式
	 */
    private String type;

    /**
	 * 视频md5值
	 */
    private String md5;

    /**
	 * 文件地址（转码后）
	 */
    private String url;

    private static final long serialVersionUID = 1L;

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getDefinition() {
        return definition;
    }

    public void setDefinition(Integer definition) {
        this.definition = definition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}