package com.yundao.tenant.dto.customer.v2;

import java.util.ArrayList;
import java.util.List;

import com.yundao.tenant.dto.customer.tag.TagResDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户分页列表
 *
 * @author jan
 * @create 2017-10-31 21:00
 **/
public class CustomerV2PageResDto {

	@ApiModelProperty(value = "客户id")
	private Long id;

	@ApiModelProperty(value = "客户姓名")
	private String name;

	@ApiModelProperty(value = "客户编号")
	private String number;

	@ApiModelProperty(value = "手机号码")
	private String mobile;

	@ApiModelProperty(value = "理财师")
	private String fpName;

	@ApiModelProperty(value = "理财师所在部门")
	private String department;

	@ApiModelProperty(value = "性别")
	private Integer sex;

	@ApiModelProperty(value = "性别文本")
	private String sexText;

	@ApiModelProperty(value = "省份")
	private String provinceCode;

	@ApiModelProperty(value = "城市")
	private String cityCode;

	@ApiModelProperty(value = "省份文本")
	private String provinceText;

	@ApiModelProperty(value = "城市文本")
	private String cityText;

	@ApiModelProperty(value = "客户级别")
	private Integer level;

	@ApiModelProperty(value = "客户级别文本")
	private String levelText;

	@ApiModelProperty(value = "是否成交文本")
	private String isDealText;

	@ApiModelProperty(value = "状态")
	private Integer status;

	@ApiModelProperty(value = "状态文本")
	private String statusText;

	@ApiModelProperty(value = "最近成交日期")
	private String dealDate;

	@ApiModelProperty(value = "最近跟进日期")
	private String followDate;

	@ApiModelProperty(value = "分配日期")
	private String distributionDate;

	@ApiModelProperty(value = "创建日期")
	private String createDate;

	@ApiModelProperty(value = "理财师id")
	private Long fpId;

	@ApiModelProperty(value = "是否能跟进；1：能，0：不能")
	private Integer canFollow;

	@ApiModelProperty(value = "当不能跟进时，显示的提示")
	private String tipsForDisabledFollow;
	@ApiModelProperty(value = "是否关注")
	private Boolean focus;
	/**
	 * 客户标签
	 */
	private List<TagResDto> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFpName() {
		return fpName;
	}

	public void setFpName(String fpName) {
		this.fpName = fpName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSexText() {
		return sexText;
	}

	public void setSexText(String sexText) {
		this.sexText = sexText;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getProvinceText() {
		return provinceText;
	}

	public void setProvinceText(String provinceText) {
		this.provinceText = provinceText;
	}

	public String getCityText() {
		return cityText;
	}

	public void setCityText(String cityText) {
		this.cityText = cityText;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLevelText() {
		return levelText;
	}

	public void setLevelText(String levelText) {
		this.levelText = levelText;
	}

	public String getIsDealText() {
		return isDealText;
	}

	public void setIsDealText(String isDealText) {
		this.isDealText = isDealText;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public String getFollowDate() {
		return followDate;
	}

	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}

	public String getDistributionDate() {
		return distributionDate;
	}

	public void setDistributionDate(String distributionDate) {
		this.distributionDate = distributionDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Long getFpId() {
		return fpId;
	}

	public void setFpId(Long fpId) {
		this.fpId = fpId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getCanFollow() {
		return canFollow;
	}

	public void setCanFollow(Integer canFollow) {
		this.canFollow = canFollow;
	}

	public String getTipsForDisabledFollow() {
		return tipsForDisabledFollow;
	}

	public void setTipsForDisabledFollow(String tipsForDisabledFollow) {
		this.tipsForDisabledFollow = tipsForDisabledFollow;
	}

	public Boolean getFocus() {

		return focus;
	}

	public void setFocus(Boolean focus) {

		this.focus = focus;
	}

	public List<TagResDto> getTags() {
	    if(tags==null){
	    	tags=new ArrayList<>();
	    }
		return tags;
	}

	public void setTags(List<TagResDto> tags) {
	
		this.tags = tags;
	}
	

}
