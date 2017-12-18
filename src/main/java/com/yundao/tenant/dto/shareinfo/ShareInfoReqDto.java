
package com.yundao.tenant.dto.shareinfo;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class ShareInfoReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "类型：product:产品 product_notice:产品公告 product_attach:产品附件")
    private String type;

    @ApiModelProperty(value = "对象ID")
    private Long objectId;

    @ApiModelProperty(value = "描述")
    private String desc;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "分享地址")
    private String shareUrl;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getType (){
        return type;
    }

    public void setType (String type){
        this.type = type;
    }

    public Long getObjectId (){
        return objectId;
    }

    public void setObjectId (Long objectId){
        this.objectId = objectId;
    }

    public String getDesc (){
        return desc;
    }

    public void setDesc (String desc){
        this.desc = desc;
    }

    public Long getUserId (){
        return userId;
    }

    public void setUserId (Long userId){
        this.userId = userId;
    }

    public String getShareUrl (){
        return shareUrl;
    }

    public void setShareUrl (String shareUrl){
        this.shareUrl = shareUrl;
    }

}
