package com.yundao.tenant.dto.cms.articlecolumn;

import com.yundao.tenant.model.base.cms.article.BaseArticleColumn;

import java.util.Date;

/**
 * Created by gjl on 2017/10/20.
 */
public class ArticleColumnPageResDto extends BaseArticleColumn{
    private String handlers;
    private Date handlerDate;
    private String platformUrl;
    private String platformCode;
    private String platformName;

    public String getPlatformUrl() {
        return platformUrl;
    }

    public void setPlatformUrl(String platformUrl) {
        this.platformUrl = platformUrl;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getHandlers() {
        return handlers;
    }

    public void setHandlers(String handlers) {
        this.handlers = handlers;
    }

    public Date getHandlerDate() {
        return handlerDate;
    }

    public void setHandlerDate(Date handlerDate) {
        this.handlerDate = handlerDate;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }
}
