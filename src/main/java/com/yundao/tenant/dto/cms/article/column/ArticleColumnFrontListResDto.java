package com.yundao.tenant.dto.cms.article.column;

import io.swagger.annotations.ApiModelProperty;

/**
 * 前端文章栏目
 *
 * @author jan
 * @create 2017-10-20 10:35
 **/
public class ArticleColumnFrontListResDto {

    @ApiModelProperty(value = "栏目id")
    private Long id;

    @ApiModelProperty(value = "栏目名称")
    private String name;

    @ApiModelProperty(value = "栏目url")
    private String url;

    @ApiModelProperty(value = "编码")
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
