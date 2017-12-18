
package com.yundao.tenant.dto.customer.customer;

import java.util.Date;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.model.customer.BaseContact;

import io.swagger.annotations.ApiModelProperty;

public class CustomerReqDto extends BaseContact {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "新增不需要传")
	@Number(isBlank = false, message = "{" + CommonCode.COMMON_1079 + "}", groups = { Update.class })
	private Long id;

	@ApiModelProperty(value = "姓名")
	@Length(min = 1, max = 20, message = "{" + GJLCodeConstant.CODE_1210033 + "}", groups = { Update.class,
			Insert.class })
	private String name;

	@ApiModelProperty(value = "性别(1：男，2：女)")
	private Integer sex;

	@ApiModelProperty(value = "客户级别(1：A[最重要]，2：[重要]，3：[普通]，4[沉默])")
	private Integer level;

	@ApiModelProperty(value = "风险特征（1：保守型，2：适度保守型，3：平衡型，4：适度进取型，5：进取型）")
	private Integer riskRating;

	@ApiModelProperty(value = "投资人类型（1：普通投资人，2：专业投资人）")
	private Integer type;

	@ApiModelProperty(value = "客户来源（1：自我开发，2：客户转介绍，3：市场活动，4：其他）")
	private Integer source;

	@ApiModelProperty(value = "备注")
	@Length(isBlank = true, min = 1, max = 200, message = "{" + GJLCodeConstant.CODE_1210021 + "}", groups = {
			Update.class, Insert.class })
	private String remark;

	@ApiModelProperty(value = "客户标签名称，多个使用逗号隔开")
	private String tags;

	@ApiModelProperty(value = "投资偏好ID，多个使用逗号隔开")
	private String investTypes;

	@ApiModelProperty(value = "生日")
	private Date birthday;

	@ApiModelProperty(value = "省份")
	private String provinceCode;

	@ApiModelProperty(value = "市")
	private String cityCode;

	@ApiModelProperty(value = "地址")
	@Length(isBlank = true, max = 100, message = "{" + GJLCodeConstant.CODE_1210038 + "}", groups = { Update.class,
			Insert.class })
	private String address;

	@ApiModelProperty(value = "行业")
	@Length(isBlank = true, max = 20, message = "{" + GJLCodeConstant.CODE_1210039 + "}", groups = { Update.class,
			Insert.class })
	private String trade;

	@ApiModelProperty(value = "机构")
	@Length(isBlank = true, max = 50, message = "{" + GJLCodeConstant.CODE_1210040 + "}", groups = { Update.class,
			Insert.class })
	private String organization;

	@ApiModelProperty(value = "职位")
	@Length(isBlank = true, max = 20, message = "{" + GJLCodeConstant.CODE_1210041 + "}", groups = { Update.class,
			Insert.class })
	private String position;

	@ApiModelProperty(value = "1代表我自己创建   2代表客户池创建")
	@Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210049 + "}", groups = { Update.class,
			Insert.class })
	private Integer addCustomerType;

	@ApiModelProperty(value = "银行卡类型 1：身份证，2：护照")
	private Integer card;

	@ApiModelProperty(value = "证件号码")
	private String cardId;
	@ApiModelProperty(value = "邮箱")
	private String email;

	public Integer getAddCustomerType() {
		return addCustomerType;
	}

	public void setAddCustomerType(Integer addCustomerType) {
		this.addCustomerType = addCustomerType;
	}

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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getRiskRating() {
		return riskRating;
	}

	public void setRiskRating(Integer riskRating) {
		this.riskRating = riskRating;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Integer getCard() {
		return card;
	}

	public void setCard(Integer card) {
		this.card = card;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getEmail() {
	
		return email;
	}

	public void setEmail(String email) {
	
		this.email = email;
	}
	
}
