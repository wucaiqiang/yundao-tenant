package com.yundao.tenant.dto.cms.article;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文章分页数据请求dto
 *
 * @author jan
 * @create 2017-10-21 14:02
 **/
public class ArticlePageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "平台id，多个逗号分隔")
    private String platformIds;

    @ApiModelProperty(value = "栏目id，多个逗号分隔")
    private String columnIds;

    @ApiModelProperty(value = "状态，多个逗号分隔")
    private String statuss;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作时间 - 开始")
    private String operateTimeBegin;

    @ApiModelProperty(value = "操作时间 - 结束")
    private String operateTimeEnd;

    @ApiModelProperty(value = "发布时间 - 开始")
    private String publishDateBegin;

    @ApiModelProperty(value = "发布时间 - 结束")
    private String publishDateEnd;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatformIds() {
        return platformIds;
    }

    public void setPlatformIds(String platformIds) {
        this.platformIds = platformIds;
    }

    public String getColumnIds() {
        return columnIds;
    }

    public void setColumnIds(String columnIds) {
        this.columnIds = columnIds;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperateTimeBegin() {
        return operateTimeBegin;
    }

    public void setOperateTimeBegin(String operateTimeBegin) {
        this.operateTimeBegin = operateTimeBegin;
    }

    public String getOperateTimeEnd() {
        return operateTimeEnd;
    }

    public void setOperateTimeEnd(String operateTimeEnd) {
        this.operateTimeEnd = operateTimeEnd;
    }

    public String getPublishDateBegin() {
        return publishDateBegin;
    }

    public void setPublishDateBegin(String publishDateBegin) {
        this.publishDateBegin = publishDateBegin;
    }

    public String getPublishDateEnd() {
        return publishDateEnd;
    }

    public void setPublishDateEnd(String publishDateEnd) {
        this.publishDateEnd = publishDateEnd;
    }
}
