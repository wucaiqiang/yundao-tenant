package com.yundao.tenant.dto.cms.article;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文章栏目关系数据dto
 *
 * @author jan
 * @create 2017-10-21 15:59
 **/
public class ArticleColumnRelInfoDto {

    @ApiModelProperty(value = "文章id")
    private Long id;

    @ApiModelProperty(value = "栏目id")
    private Long columnId;

    @ApiModelProperty(value = "栏目名称")
    private String columnName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
