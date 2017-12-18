package com.yundao.tenant.model.base.roadshow;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseRoadshow extends BaseModel implements Serializable {
    /**
	 * 平台ID
	 */
    private Long platformId;

    /**
	 * 标题
	 */
    private String title;

    /**
	 * 视频关联ID
	 */
    private Long videoId;

    /**
	 * 封面地址
	 */
    private String coverUrl;

    /**
	 * 主讲人
	 */
    private String speaker;

    /**
	 * 主办方
	 */
    private String sponsor;

    /**
	 * 简介
	 */
    private String introduction;

    /**
	 * 排序
	 */
    private Integer sequence;

    /**
	 * 状态
	 */
    private Integer status;

    /**
	 * 发布时间
	 */
    private Date releaseTime;

    private static final long serialVersionUID = 1L;

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
}