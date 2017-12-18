
package com.yundao.tenant.dto.cloudfile;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CloudFileReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "云类型，0：阿里云；1：腾讯云；2：ucloud云")
    private Integer type;

    @ApiModelProperty(value = "链接")
    private String url;

    @ApiModelProperty(value = "创建者id")
    private Integer creatorId;

    @ApiModelProperty(value = "创建时间 ")
    private Date createTime;

    @ApiModelProperty(value = "更新者id")
    private Integer updaterId;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Integer getType (){
        return type;
    }

    public void setType (Integer type){
        this.type = type;
    }

    public String getUrl (){
        return url;
    }

    public void setUrl (String url){
        this.url = url;
    }

    public Integer getCreatorId (){
        return creatorId;
    }

    public void setCreatorId (Integer creatorId){
        this.creatorId = creatorId;
    }

    public Date getCreateTime (){
        return createTime;
    }

    public void setCreateTime (Date createTime){
        this.createTime = createTime;
    }

    public Integer getUpdaterId (){
        return updaterId;
    }

    public void setUpdaterId (Integer updaterId){
        this.updaterId = updaterId;
    }

    public Date getUpdateTime (){
        return updateTime;
    }

    public void setUpdateTime (Date updateTime){
        this.updateTime = updateTime;
    }

}
