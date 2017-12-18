package com.yundao.tenant.dto.cms.article.front;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文章详情
 *
 * @author jan
 * @create 2017-10-20 16:40
 **/
public class ArticleFrontDetailDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "阅读数")
    private Integer pageview;

    @ApiModelProperty(value = "发布时间")
    private String publishDate;

    @ApiModelProperty(value = "导读")
    private String feature;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "seo标题")
    private String seoTitle;

    @ApiModelProperty(value = "seo关键字")
    private String seoKeywords;

    @ApiModelProperty(value = "seo描述")
    private String seoDescription;

    @ApiModelProperty(value = "文章内容")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
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
