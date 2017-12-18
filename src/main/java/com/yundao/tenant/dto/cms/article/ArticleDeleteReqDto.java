package com.yundao.tenant.dto.cms.article;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 文章删除请求dto
 *
 * @author jan
 * @create 2017-10-20 17:46
 **/
public class ArticleDeleteReqDto {

    @ApiModelProperty(value = "文章id，多个逗号分隔")
    @NotBlank(message = "{" + CodeConstant.CODE_1220143 + "}")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
