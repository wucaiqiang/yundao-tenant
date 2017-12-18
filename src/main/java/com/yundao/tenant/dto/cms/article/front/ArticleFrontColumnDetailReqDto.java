package com.yundao.tenant.dto.cms.article.front;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-10-28 11:57
 **/
public class ArticleFrontColumnDetailReqDto {

    @ApiModelProperty(value = "栏目编码")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
