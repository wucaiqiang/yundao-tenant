
package com.yundao.tenant.dto.videotranscode;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class VideoTranscodeReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "原始视频关联ID")
    private Long videoId;

    @ApiModelProperty(value = "大小")
    private Long size;

    @ApiModelProperty(value = "转码类型")
    private Integer definition;

    @ApiModelProperty(value = "文件格式")
    private String type;

    @ApiModelProperty(value = "文件地址（转码后）")
    private String url;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getVideoId (){
        return videoId;
    }

    public void setVideoId (Long videoId){
        this.videoId = videoId;
    }

    public Long getSize (){
        return size;
    }

    public void setSize (Long size){
        this.size = size;
    }

    public Integer getDefinition (){
        return definition;
    }

    public void setDefinition (Integer definition){
        this.definition = definition;
    }

    public String getType (){
        return type;
    }

    public void setType (String type){
        this.type = type;
    }

    public String getUrl (){
        return url;
    }

    public void setUrl (String url){
        this.url = url;
    }

}
