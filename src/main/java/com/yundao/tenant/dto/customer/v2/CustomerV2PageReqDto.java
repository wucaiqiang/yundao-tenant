package com.yundao.tenant.dto.customer.v2;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户分页请求dto
 *
 * @author jan
 * @create 2017-10-31 21:40
 **/
public class CustomerV2PageReqDto extends AbstractBasePageDto {

	@ApiModelProperty(value = "搜索范围；全部客户：all，我负责的：my，我未跟进的：neverfollow，我关注的：focus，我部门的：department，默认全部")
	private String scope;

	@ApiModelProperty(value = "客户姓名")
	private String name;

	@ApiModelProperty(value = "客户编号")
	private String number;

	@ApiModelProperty(value = "手机号码")
	private String mobile;

	@ApiModelProperty(value = "理财师姓名")
	private String fpName;

	@ApiModelProperty(value = "理财师所在部门")
	private String department;

	@ApiModelProperty(value = "性别，多个逗号分隔")
	private String sexs;

	@ApiModelProperty(value = "省份")
	private String provinceCodes;

	@ApiModelProperty(value = "城市")
	private String cityCodes;

	@ApiModelProperty(value = "客户级别，多个逗号分隔")
	private String levels;

	@ApiModelProperty(value = "是否成交1：是，0：否，多个逗号分隔")
	private String isDeals;

	@ApiModelProperty(value = "状态，多个逗号分隔")
	private String statuss;

	@ApiModelProperty(value = "成交日期，开始时间")
	private String dealDateBegin;

	@ApiModelProperty(value = "成交日期，结束时间")
	private String dealDateEnd;

	@ApiModelProperty(value = "跟进日期，开始时间")
	private String followDateBegin;

	@ApiModelProperty(value = "跟进日期，结束时间")
	private String followDateEnd;

	@ApiModelProperty(value = "分配日期，开始时间")
	private String distributionDateBegin;

	@ApiModelProperty(value = "分配日期，结束时间")
	private String distributionDateEnd;

	@ApiModelProperty(value = "创建日期，开始时间")
	private String createDateBegin;

	@ApiModelProperty(value = "创建日期，结束时间")
	private String createDateEnd;

	/**
	 * 高级筛选
	 **/

	@ApiModelProperty(value = "标签，多个逗号分隔")
	private String tags;

	@ApiModelProperty(value = "投资偏好，多个逗号分隔")
	private String investTypes;

	@ApiModelProperty(value = "风险特征，多个逗号分隔")
	private String riskRatings;

	@ApiModelProperty(value = "投资人类型，多个逗号分隔")
	private String typies;

	@ApiModelProperty(value = "生日，开始时间")
	private String birthdayBegin;

	@ApiModelProperty(value = "生日，结束时间")
	private String birthdayEnd;

	@ApiModelProperty(value = "行业")
	private String trade;

	@ApiModelProperty(value = "机构")
	private String organization;

	@ApiModelProperty(value = "职位")
	private String position;

	@ApiModelProperty("来源")
	private String sources;

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSexs() {
		return sexs;
	}

	public void setSexs(String sexs) {
		this.sexs = sexs;
	}

	public String getProvinceCodes() {
		return provinceCodes;
	}

	public void setProvinceCodes(String provinceCodes) {
		this.provinceCodes = provinceCodes;
	}

	public String getCityCodes() {
		return cityCodes;
	}

	public void setCityCodes(String cityCodes) {
		this.cityCodes = cityCodes;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getIsDeals() {
		return isDeals;
	}

	public void setIsDeals(String isDeals) {
		this.isDeals = isDeals;
	}

	public String getStatuss() {
		return statuss;
	}

	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}

	public String getDealDateBegin() {
		return dealDateBegin;
	}

	public void setDealDateBegin(String dealDateBegin) {
		this.dealDateBegin = dealDateBegin;
	}

	public String getDealDateEnd() {
		return dealDateEnd;
	}

	public void setDealDateEnd(String dealDateEnd) {
		this.dealDateEnd = dealDateEnd;
	}

	public String getFollowDateBegin() {
		return followDateBegin;
	}

	public void setFollowDateBegin(String followDateBegin) {
		this.followDateBegin = followDateBegin;
	}

	public String getFollowDateEnd() {
		return followDateEnd;
	}

	public void setFollowDateEnd(String followDateEnd) {
		this.followDateEnd = followDateEnd;
	}

	public String getDistributionDateBegin() {
		return distributionDateBegin;
	}

	public void setDistributionDateBegin(String distributionDateBegin) {
		this.distributionDateBegin = distributionDateBegin;
	}

	public String getDistributionDateEnd() {
		return distributionDateEnd;
	}

	public void setDistributionDateEnd(String distributionDateEnd) {
		this.distributionDateEnd = distributionDateEnd;
	}

	public String getCreateDateBegin() {
		return createDateBegin;
	}

	public void setCreateDateBegin(String createDateBegin) {
		this.createDateBegin = createDateBegin;
	}

	public String getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(String createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getInvestTypes() {
		return investTypes;
	}

	public void setInvestTypes(String investTypes) {
		this.investTypes = investTypes;
	}

	public String getRiskRatings() {
		return riskRatings;
	}

	public void setRiskRatings(String riskRatings) {
		this.riskRatings = riskRatings;
	}

	public String getTypies() {
		return typies;
	}

	public void setTypies(String typies) {
		this.typies = typies;
	}

	public String getBirthdayBegin() {
		return birthdayBegin;
	}

	public void setBirthdayBegin(String birthdayBegin) {
		this.birthdayBegin = birthdayBegin;
	}

	public String getBirthdayEnd() {
		return birthdayEnd;
	}

	public void setBirthdayEnd(String birthdayEnd) {
		this.birthdayEnd = birthdayEnd;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getSources() {
	
		return sources;
	}

	public void setSources(String sources) {
	
		this.sources = sources;
	}
	
}
