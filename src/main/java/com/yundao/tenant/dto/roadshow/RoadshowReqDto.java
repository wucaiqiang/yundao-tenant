
package com.yundao.tenant.dto.roadshow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class RoadshowReqDto extends AbstractBasePageDto {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "标题")
	private String title;
	@ApiModelProperty(value = "平台IDs")
	private String platformIds;
	@ApiModelProperty(value = "栏目IDs")
	private String columnIds;
	@ApiModelProperty(value = "栏目名称s")
	private String columnNames;
	@ApiModelProperty(value = "封面地址")
	private String productName;
	@ApiModelProperty(value = "主讲人")
	private String speaker;
	@ApiModelProperty(value = "主办方")
	private String sponsor;
	@ApiModelProperty(value = "状态值")
	private String statuss;
	@ApiModelProperty(value = "操作人名称")
	private String updateUserName;
	@ApiModelProperty(value = "创建时间开始")
	private Date createDateBegin;
	@ApiModelProperty(value = "创建时间结束")
	private Date createDateEnd;
	@ApiModelProperty(value = "更新时间开始")
	private Date updateDateBegin;
	@ApiModelProperty(value = "更新时间结束")
	private Date updateDateEnd;
	@ApiModelProperty(value = "不需要传")
	private List<Integer> statusList;
	@ApiModelProperty(value = "不需要传")
	private List<Integer> platformIdList;
	@ApiModelProperty(value = "不需要传")
	private List<Integer> columnIdList;
	@ApiModelProperty(value = "发布时间")
	private Date releaseTime;

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

	public String getProductName() {

		return productName;
	}

	public void setProductName(String productName) {

		this.productName = productName;
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

	public String getStatuss() {

		return statuss;
	}

	public void setStatuss(String statuss) {

		this.statuss = statuss;
	}

	public String getUpdateUserName() {

		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {

		this.updateUserName = updateUserName;
	}

	public Date getCreateDateBegin() {

		return createDateBegin;
	}

	public void setCreateDateBegin(Date createDateBegin) {

		this.createDateBegin = createDateBegin;
	}

	public Date getCreateDateEnd() {

		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {

		this.createDateEnd = createDateEnd;
	}

	public Date getUpdateDateBegin() {

		return updateDateBegin;
	}

	public void setUpdateDateBegin(Date updateDateBegin) {

		this.updateDateBegin = updateDateBegin;
	}

	public Date getUpdateDateEnd() {

		return updateDateEnd;
	}

	public void setUpdateDateEnd(Date updateDateEnd) {

		this.updateDateEnd = updateDateEnd;
	}

	public List<Integer> getStatusList() {
		if (StringUtils.isNotBlank(this.statuss)) {
			String[] statuses = this.statuss.split(",");
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < statuses.length; i++) {
				result.add(NumberUtils.toInt(statuses[i]));
			}
			return result;
		}
		return statusList;
	}

	public void setStatusList(List<Integer> statusList) {

		this.statusList = statusList;
	}

	public List<Integer> getPlatformIdList() {
		if (StringUtils.isNotBlank(this.platformIds)) {
			String[] platformIds = this.platformIds.split(",");
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < platformIds.length; i++) {
				result.add(NumberUtils.toInt(platformIds[i]));
			}
			return result;
		}
		return platformIdList;
	}

	public void setPlatformIdList(List<Integer> platformIdList) {

		this.platformIdList = platformIdList;
	}

	public List<Integer> getColumnIdList() {
		if (StringUtils.isNotBlank(this.columnIds)) {
			String[] columnIds = this.columnIds.split(",");
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < columnIds.length; i++) {
				result.add(NumberUtils.toInt(columnIds[i]));
			}
			return result;
		}
		return columnIdList;
	}

	public void setColumnIdList(List<Integer> columnIdList) {

		this.columnIdList = columnIdList;
	}

	public Date getReleaseTime() {

		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {

		this.releaseTime = releaseTime;
	}

	public String getColumnNames() {

		return columnNames;
	}

	public void setColumnNames(String columnNames) {

		this.columnNames = columnNames;
	}

}
