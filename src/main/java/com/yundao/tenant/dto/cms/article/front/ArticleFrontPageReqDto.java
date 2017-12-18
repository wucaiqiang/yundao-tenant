package com.yundao.tenant.dto.cms.article.front;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-10-20 10:55
 **/
public class ArticleFrontPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "栏目编码")
    private String columnCode;

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }
}
