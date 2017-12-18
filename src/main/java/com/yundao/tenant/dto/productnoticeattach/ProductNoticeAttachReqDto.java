
package com.yundao.tenant.dto.productnoticeattach;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class ProductNoticeAttachReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "公告id")
    private Long noticeId;

    @ApiModelProperty(value = "文件名称")
    private String sourceName;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "排序")
    private String sort;

    @ApiModelProperty(value = "附件类型")
    private String type;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getNoticeId (){
        return noticeId;
    }

    public void setNoticeId (Long noticeId){
        this.noticeId = noticeId;
    }

    public String getSourceName (){
        return sourceName;
    }

    public void setSourceName (String sourceName){
        this.sourceName = sourceName;
    }

    public String getUrl (){
        return url;
    }

    public void setUrl (String url){
        this.url = url;
    }

    public String getSort (){
        return sort;
    }

    public void setSort (String sort){
        this.sort = sort;
    }

    public String getType (){
        return type;
    }

    public void setType (String type){
        this.type = type;
    }

}
