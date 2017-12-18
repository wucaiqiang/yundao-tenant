
package com.yundao.tenant.dto.roadshow;

import java.io.Serializable;
import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;

import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;

public class RoadshowAddReqDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "平台ID")
	@Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210102 + "}")
	private Long platformId;

	@ApiModelProperty(value = "栏目IDs")
	private String columnIds;

	@ApiModelProperty(value = "标题")
	@Length(min = 1, max = 100, message = "{" + GJLCodeConstant.CODE_1210120 + "}")
	private String title;

	@ApiModelProperty(value = "视频关联ID")
	@Number(isBlank = false, message = "{" + Code1200000.CODE_1200177 + "}")
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
	@Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210106 + "}")
	private Integer sequence;

	@ApiModelProperty(value = "状态，0：停用，1：启用")
	@Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210107 + "}")
	private Integer status;

	@ApiModelProperty(value = "发布时间")
	private Date releaseTime;

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
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

}
