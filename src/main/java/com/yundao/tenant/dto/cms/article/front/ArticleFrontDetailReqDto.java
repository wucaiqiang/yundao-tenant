package com.yundao.tenant.dto.cms.article.front;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-10-20 16:45
 **/
public class ArticleFrontDetailReqDto {

    @ApiModelProperty(value = "文章编码")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
