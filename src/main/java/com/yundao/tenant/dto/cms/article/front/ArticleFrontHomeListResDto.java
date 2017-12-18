package com.yundao.tenant.dto.cms.article.front;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文章
 *
 * @author jan
 * @create 2017-10-19 09:01
 **/
public class ArticleFrontHomeListResDto {

    @ApiModelProperty(value = "文章id")
    private Long id;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章code")
    private String code;

    @ApiModelProperty(value = "文章链接地址")
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
