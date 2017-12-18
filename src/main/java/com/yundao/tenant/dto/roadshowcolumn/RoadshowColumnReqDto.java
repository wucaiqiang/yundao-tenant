
package com.yundao.tenant.dto.roadshowcolumn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class RoadshowColumnReqDto extends AbstractBasePageDto {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "平台ID，多个逗号分开")
	private String platformIds;
	@ApiModelProperty(value = "不需要传")
	private List<Integer> platformIdList;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "编码")
	private String code;

	@ApiModelProperty(value = "状态，多个逗号分开")
	private String statuss;
	@ApiModelProperty(value = "不需要传")
	private List<Integer> statusList;
	@ApiModelProperty(value = "更新人名称")
	private String updateUserName;
	@ApiModelProperty(value = "更新时间开始")
	private Date updateDateBegin;
	@ApiModelProperty(value = "更新时间结束")
	private Date updateDateEnd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPlatformIds() {

		return platformIds;
	}

	public void setPlatformIds(String platformIds) {

		this.platformIds = platformIds;
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

}
