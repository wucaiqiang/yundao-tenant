package com.yundao.tenant.model.base.cms.article;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseArticleDetail extends BaseModel implements Serializable {
    /**
	 * 文章id
	 */
    private Long articleId;

    /**
	 * 导读
	 */
    private String feature;

    /**
	 * 作者
	 */
    private String author;

    /**
	 * 文章来源
	 */
    private String source;

    /**
	 * 文章内容
	 */
    private String content;

    private static final long serialVersionUID = 1L;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}