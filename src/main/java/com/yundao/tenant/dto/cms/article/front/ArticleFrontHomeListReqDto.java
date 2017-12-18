package com.yundao.tenant.dto.cms.article.front;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文章首页请求数据dto
 *
 * @author jan
 * @create 2017-10-27 13:51
 **/
public class ArticleFrontHomeListReqDto {

    @ApiModelProperty(value = "获取栏目的数量，默认3，小于1的数值无效")
    private Integer columnCount;

    @ApiModelProperty(value = "获取每个栏目下文章数量，默认4，小于1的数值无效")
    private Integer articleCount;

    public Integer getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}
