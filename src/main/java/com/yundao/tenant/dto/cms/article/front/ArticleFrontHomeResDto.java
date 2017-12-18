package com.yundao.tenant.dto.cms.article.front;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页文章列表数据dto
 *
 * @author jan
 * @create 2017-10-19 08:55
 **/
public class ArticleFrontHomeResDto {

    @ApiModelProperty(value = "栏目id")
    private Long columnId;

    @ApiModelProperty(value = "栏目名称")
    private String columnName;

    @ApiModelProperty(value = "栏目封面")
    private String columnCoverUrl;

     @ApiModelProperty(value="栏目url")
      private String url;

    @ApiModelProperty(value = "文章列表")
    private List<ArticleFrontHomeListResDto> articles;

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public List<ArticleFrontHomeListResDto> getArticles() {
        if (articles == null)
            articles = new ArrayList<>();
        return articles;
    }

    public void setArticles(List<ArticleFrontHomeListResDto> articles) {
        this.articles = articles;
    }

    public String getColumnCoverUrl() {
        return columnCoverUrl;
    }

    public void setColumnCoverUrl(String columnCoverUrl) {
        this.columnCoverUrl = columnCoverUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
