package com.yundao.tenant.model.base.cms.article;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseArticleColumnRel extends BaseModel implements Serializable {
    /**
	 * 文章id
	 */
    private Long articleId;

    /**
	 * 栏目id
	 */
    private Long columnId;

    private static final long serialVersionUID = 1L;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }
}