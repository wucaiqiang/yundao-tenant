package com.yundao.tenant.dto.cms.article;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 文章分页数据
 *
 * @author jan
 * @create 2017-10-21 11:00
 **/
public class ArticlePageResDto {

    @ApiModelProperty(value = "文章id")
    private Long id;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "平台id")
    private Long platformId;

    @ApiModelProperty(value = "平台")
    private String platformName;

    @ApiModelProperty(value = "平台code")
    private String platformCode;

    @ApiModelProperty(value = "平台Url")
    private String platformUrl;

    @ApiModelProperty(value = "栏目")
    private String columnName;

    public String getPlatformUrl() {
        return platformUrl;
    }

    public void setPlatformUrl(String platformUrl) {
        this.platformUrl = platformUrl;
    }

    public String getColumnUrl() {
        return columnUrl;
    }

    public void setColumnUrl(String columnUrl) {
        this.columnUrl = columnUrl;
    }

    @ApiModelProperty(value = "栏目URL")
    private String columnUrl;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "排序")
    private Integer sequence;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "状态问")
    private String statusText;

    @ApiModelProperty(value = "显示阅读数")
    private Integer pageview;

    @ApiModelProperty(value = "实际阅读数")
    private Integer actualPageview;

    @ApiModelProperty(value = "发布日期")
    private String publishDate;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    private String operateTime;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

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

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public Integer getActualPageview() {
        return actualPageview;
    }

    public void setActualPageview(Integer actualPageview) {
        this.actualPageview = actualPageview;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }
}
