
package com.yundao.tenant.dto.customer.customer;

import java.io.Serializable;
import java.util.Date;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.GJLCodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class CustomerExclusiveContactReqDto implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "姓名")
    @Length(min = 1, max = 20, message = "{" + GJLCodeConstant.CODE_1210033 + "}", groups = { Update.class,
            Insert.class })
    private String name;

    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String provinceCode;
    /**
     * 城市
     */
    @ApiModelProperty(value = "市")
    private String cityCode;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    @Length(isBlank = true, max = 100, message = "{" + GJLCodeConstant.CODE_1210038 + "}", groups = {Update.class,Insert.class})
    private String address;
    /**
     * 行业
     */
    @ApiModelProperty(value = "行业")
    @Length(isBlank = true, max = 20, message = "{" + GJLCodeConstant.CODE_1210039 + "}", groups = {Update.class,Insert.class})
    private String trade;
    /**
     * 机构
     */
    @ApiModelProperty(value = "机构")
    @Length(isBlank = true, max = 50, message = "{" + GJLCodeConstant.CODE_1210040 + "}", groups = {Update.class,Insert.class})
    private String organization;
    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
    @Length(isBlank = true, max = 20, message = "{" + GJLCodeConstant.CODE_1210041 + "}", groups = {Update.class,Insert.class})
    private String position;


    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;
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
    @Length(isBlank = true,min = 1, max = 200, message = "{" + GJLCodeConstant.CODE_1210021 + "}", groups = {Update.class,Insert.class})
    private String remark;

    @ApiModelProperty(value = "客户标签名称，多个使用逗号隔开")
    private String tags;

    @ApiModelProperty(value = "投资偏好ID，多个使用逗号隔开")
    private String investTypes;

    @ApiModelProperty(value = "生日")
    private Date birthday;
    
    @ApiModelProperty(value = "证件类型")
    private Integer certType;
    @ApiModelProperty(value = "证件号码")
    private String certNo;
    @ApiModelProperty(value = "证件正面")
    private String certFront;
    @ApiModelProperty(value = "证件反面")
    private String certBack;
    @ApiModelProperty(value = "资产证明")
    private String assets;
    @ApiModelProperty(value = "开户行名")
    private String bankName;
    @ApiModelProperty(value = "银行卡帐号")
    private String bankAccount;
    @ApiModelProperty(value = "银行卡正面")
    private String bankFront;
    @ApiModelProperty(value = "银行卡反面")
    private String bankBack;

    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }


    public Integer getSex (){
        return sex;
    }

    public void setSex (Integer sex){
        this.sex = sex;
    }


    public Integer getLevel (){
        return level;
    }

    public void setLevel (Integer level){
        this.level = level;
    }

    public Integer getRiskRating (){
        return riskRating;
    }

    public void setRiskRating (Integer riskRating){
        this.riskRating = riskRating;
    }

    public Integer getType (){
        return type;
    }

    public void setType (Integer type){
        this.type = type;
    }

    public Integer getSource (){
        return source;
    }

    public void setSource (Integer source){
        this.source = source;
    }

    public String getRemark (){
        return remark;
    }

    public void setRemark (String remark){
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

	public Integer getCertType() {
	
		return certType;
	}

	public void setCertType(Integer certType) {
	
		this.certType = certType;
	}

	public String getCertNo() {
	
		return certNo;
	}

	public void setCertNo(String certNo) {
	
		this.certNo = certNo;
	}

	public String getCertFront() {
	
		return certFront;
	}

	public void setCertFront(String certFront) {
	
		this.certFront = certFront;
	}

	public String getCertBack() {
	
		return certBack;
	}

	public void setCertBack(String certBack) {
	
		this.certBack = certBack;
	}


	public String getAssets() {
	
		return assets;
	}

	public void setAssets(String assets) {
	
		this.assets = assets;
	}

	public String getBankName() {
	
		return bankName;
	}

	public void setBankName(String bankName) {
	
		this.bankName = bankName;
	}

	public String getBankAccount() {
	
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
	
		this.bankAccount = bankAccount;
	}

	public String getBankFront() {
	
		return bankFront;
	}

	public void setBankFront(String bankFront) {
	
		this.bankFront = bankFront;
	}

	public String getBankBack() {
	
		return bankBack;
	}

	public void setBankBack(String bankBack) {
	
		this.bankBack = bankBack;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
