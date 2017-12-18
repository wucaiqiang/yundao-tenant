package com.yundao.tenant.dto.customer.pool;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户池分页请求数据
 *
 * @author jan
 * @create 2017-08-14 AM9:10
 **/
public class CustomerPoolPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "搜索范围；全部：all，未分配：unallot，默认全部")
    private String scope;

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

    @ApiModelProperty(value = "理财师姓名")
    private String fpName;

    @ApiModelProperty(value = "创建日期，开始时间")
    private String createDateBegin;

    @ApiModelProperty(value = "创建日期，结束时间")
    private String createDateEnd;

    @ApiModelProperty(value = "是否成交1：是，0：否，多个逗号分隔")
    private String isDeals;

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

    public String getFpName() {
        return fpName;
    }

    public void setFpName(String fpName) {
        this.fpName = fpName;
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
}
