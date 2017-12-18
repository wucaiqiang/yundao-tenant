package com.yundao.tenant.dto.cms.article;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-10-19 16:43
 **/
public class ArticleCodeDto {

    @ApiModelProperty(value = "文章编码")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
