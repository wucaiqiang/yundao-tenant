package com.yundao.tenant.model.base.cms.article;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseArticle extends BaseModel implements Serializable {
    /**
	 * 平台id
	 */
    private Long platformId;

    /**
	 * 标题
	 */
    private String title;

    /**
	 * 编码，可用于URL地址
	 */
    private String code;

    /**
	 * 封面图片
	 */
    private String coverUrl;

    /**
	 * 浏览量
	 */
    private Integer pageview;

    /**
	 * 真实浏览量
	 */
    private Integer actualPageview;

    /**
	 * 发布时间
	 */
    private Date publishDate;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    /**
	 * 状态，0：停用，1：启用
	 */
    private Integer status;

    /**
	 * seo标题
	 */
    private String seoTitle;

    /**
	 * seo关键字
	 */
    private String seoKeywords;

    /**
	 * seo描述
	 */
    private String seoDescription;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public Integer getActualPageview() {
        return actualPageview;
    }

    public void setActualPageview(Integer actualPageview) {
        this.actualPageview = actualPageview;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }
}