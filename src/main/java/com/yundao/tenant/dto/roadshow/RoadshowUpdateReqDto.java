
package com.yundao.tenant.dto.roadshow;

import java.io.Serializable;
import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;

public class RoadshowUpdateReqDto implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "路演ID")
    @Number(isBlank = false, message = "{" + CodeConstant.CODE_1200000+ "}")
    private Long id;
    
    @ApiModelProperty(value = "栏目ID")
    private String columnIds;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "视频关联ID")
    private Long videoId;
    @ApiModelProperty(value = "产品ID")
    private Long productId;

    @ApiModelProperty(value = "封面地址")
    private String coverUrl;

    @ApiModelProperty(value = "主讲人")
    private String speaker;

    @ApiModelProperty(value = "主办方")
    private String sponsor;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "排序")
    private Integer sequence;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "发布时间")
    private Date releaseTime;


    public String getTitle (){
        return title;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public Long getVideoId (){
        return videoId;
    }

    public void setVideoId (Long videoId){
        this.videoId = videoId;
    }

    public String getCoverUrl (){
        return coverUrl;
    }

    public void setCoverUrl (String coverUrl){
        this.coverUrl = coverUrl;
    }

    public String getSpeaker (){
        return speaker;
    }

    public void setSpeaker (String speaker){
        this.speaker = speaker;
    }

    public String getSponsor (){
        return sponsor;
    }

    public void setSponsor (String sponsor){
        this.sponsor = sponsor;
    }

    public String getIntroduction (){
        return introduction;
    }

    public void setIntroduction (String introduction){
        this.introduction = introduction;
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

    public Date getReleaseTime (){
        return releaseTime;
    }

    public void setReleaseTime (Date releaseTime){
        this.releaseTime = releaseTime;
    }


	public String getColumnIds() {
	
		return columnIds;
	}

	public void setColumnIds(String columnIds) {
	
		this.columnIds = columnIds;
	}

	public Long getProductId() {
	
		return productId;
	}

	public void setProductId(Long productId) {
	
		this.productId = productId;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}
    

}
