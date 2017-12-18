
package com.yundao.tenant.dto.cms.articlecolumn;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ArticleColumnPageReqDto {
    @ApiModelProperty(value = "平台id")
    private String platformIds;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "操作者")
    private String handlers;

    @ApiModelProperty(value = "操作时间开始")
    private Date handlerDateStart;

    @ApiModelProperty(value = "操作时间结束")
    private Date handlerDateEnd;

    @ApiModelProperty(value = "排序，越小越靠前")
    private Integer sequence;

    @ApiModelProperty(value = "状态，0：停用，1：启用")
    private Integer status;

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public Integer getSequence (){
        return sequence;
    }

    public void setSequence (Integer sequence){
        this.sequence = sequence;
    }

    public Integer getStatus (){
        return status;
    }

    public void setStatus (Integer status){
        this.status = status;
    }

    public String getPlatformIds() {
        return platformIds;
    }

    public void setPlatformIds(String platformIds) {
        this.platformIds = platformIds;
    }

    public String getHandlers() {
        return handlers;
    }

    public void setHandlers(String handlers) {
        this.handlers = handlers;
    }

    public Date getHandlerDateStart() {
        return handlerDateStart;
    }

    public void setHandlerDateStart(Date handlerDateStart) {
        this.handlerDateStart = handlerDateStart;
    }

    public Date getHandlerDateEnd() {
        return handlerDateEnd;
    }

    public void setHandlerDateEnd(Date handlerDateEnd) {
        this.handlerDateEnd = handlerDateEnd;
    }
}
