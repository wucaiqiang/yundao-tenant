package com.yundao.tenant.model.base.cms.article;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseArticleColumn extends BaseModel implements Serializable {
    /**
	 * 平台id
	 */
    private Long platformId;

    /**
	 * 名称
	 */
    private String name;

    /**
	 * 编码，可用于URL地址
	 */
    private String code;

    /**
	 * 封面图片
	 */
    private String coverUrl;

    /**
	 * seo title
	 */
    private String seoTitle;

    /**
	 * seo keywords
	 */
    private String seoKeywords;

    /**
	 * seo description
	 */
    private String seoDescription;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    /**
	 * 状态，0：停用，1：启用
	 */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}