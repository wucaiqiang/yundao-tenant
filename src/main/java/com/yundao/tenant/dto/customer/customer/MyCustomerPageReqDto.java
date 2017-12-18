package com.yundao.tenant.dto.customer.customer;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询我的客户列表入参dto
 *
 * @author jan
 * @create 2017-08-09 PM2:03
 **/
public class MyCustomerPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "客户编号")
    private String number;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "性别，多个逗号分隔")
    private String sexs;

    @ApiModelProperty(value = "省份")
    private String provinceCodes;

    @ApiModelProperty(value = "城市")
    private String cityCodes;

    @ApiModelProperty(value = "客户级别，多个逗号分隔")
    private String levels;

    @ApiModelProperty(value = "成交日期，开始时间")
    private String dealDateBegin;

    @ApiModelProperty(value = "成交日期，结束时间")
    private String dealDateEnd;

    @ApiModelProperty(value = "分配日期，开始时间")
    private String distributionDateBegin;

    @ApiModelProperty(value = "分配日期，结束时间")
    private String distributionDateEnd;

    @ApiModelProperty(value = "搜索范围；all：全部，focus：我关注的，unfollow：未跟进；默认all")
    private String scope;

    @ApiModelProperty(value = "是否成交1：是，0：否，多个逗号分隔")
    private String isDeals;
    
    @ApiModelProperty(value = "生日，开始时间")
    private String birthDayBegin;

    @ApiModelProperty(value = "生日，结束时间")
    private String birthDayEnd;
    
    @ApiModelProperty(value = "标签名，多个逗号分隔")
    private String tagNames;

    @ApiModelProperty(value = "投资偏好ids，多个逗号分隔")
    private String invests;
    
    @ApiModelProperty(value = "风险特征，多个逗号分隔")
    private String riskRatings;
    
    @ApiModelProperty(value = "投资人类型，多个逗号分隔")
    private String customerTypes;
    
    @ApiModelProperty(value = "客户来源，多个逗号分隔")
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

    public String getSexs() {
        return sexs;
    }

    public void setSexs(String sexs) {
        this.sexs = sexs;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
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

    public String getIsDeals() {
        return isDeals;
    }

    public void setIsDeals(String isDeals) {
        this.isDeals = isDeals;
    }


	public String getTagNames() {
	
		return tagNames;
	}

	public void setTagNames(String tagNames) {
	
		this.tagNames = tagNames;
	}

	public String getInvests() {
	
		return invests;
	}

	public void setInvests(String invests) {
	
		this.invests = invests;
	}

	public String getRiskRatings() {
	
		return riskRatings;
	}

	public void setRiskRatings(String riskRatings) {
	
		this.riskRatings = riskRatings;
	}

	public String getCustomerTypes() {
	
		return customerTypes;
	}

	public void setCustomerTypes(String customerTypes) {
	
		this.customerTypes = customerTypes;
	}

	public String getSources() {
	
		return sources;
	}

	public void setSources(String sources) {
	
		this.sources = sources;
	}

	public String getBirthDayBegin() {
	
		return birthDayBegin;
	}

	public void setBirthDayBegin(String birthDayBegin) {
	
		this.birthDayBegin = birthDayBegin;
	}

	public String getBirthDayEnd() {
	
		return birthDayEnd;
	}

	public void setBirthDayEnd(String birthDayEnd) {
	
		this.birthDayEnd = birthDayEnd;
	}
	
}
