package com.yundao.tenant.dto.cms.articlecolumn;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文章栏目下拉数据
 *
 * @author jan
 * @create 2017-10-21 17:25
 **/
public class ArticleColumnSelectDto {

    @ApiModelProperty(value = "栏目id")
    private Long id;

    @ApiModelProperty(value = "栏目名称")
    private String name;

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
}
