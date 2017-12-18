package com.yundao.tenant.dto.user.visit;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户回访分页数据请求dto
 *
 * @author jan
 * @create 2017-08-29 PM5:58
 **/
public class UserVisitPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户编号")
    private String customerNumber;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "性别，多个逗号分隔")
    private String sexs;

    @ApiModelProperty(value = "省份")
    private String provinceCodes;

    @ApiModelProperty(value = "城市")
    private String cityCodes;

    @ApiModelProperty(value = "所属理财师名称")
    private String fpName;

    @ApiModelProperty(value = "回访事由")
    private String matter;

    @ApiModelProperty(value = "分配回访时间 - 开始")
    private String subDateBegin;

    @ApiModelProperty(value = "分配回访时间 - 结束")
    private String subDateEnd;

    @ApiModelProperty(value = "回访方式，多个逗号分隔")
    private String types;

    @ApiModelProperty(value = "回访状态，多个逗号分隔")
    private String statuss;

    @ApiModelProperty(value = "客户状态，多个逗号分隔")
    private String customerStatuss;
    
    @ApiModelProperty(value = "回访负责人姓名")
    private String userName;

    @ApiModelProperty(value = "回访时间 - 开始")
    private String visitDateBegin;

    @ApiModelProperty(value = "回访时间 - 结束")
    private String visitDateEnd;

    @ApiModelProperty(value = "查询范围，all：所有，todo：未处理，默认all")
    private String scope;

    public String getCustomerStatuss() {
	
		return customerStatuss;
	}

	public void setCustomerStatuss(String customerStatuss) {
	
		this.customerStatuss = customerStatuss;
	}

	public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getFpName() {
        return fpName;
    }

    public void setFpName(String fpName) {
        this.fpName = fpName;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getSubDateBegin() {
        return subDateBegin;
    }

    public void setSubDateBegin(String subDateBegin) {
        this.subDateBegin = subDateBegin;
    }

    public String getSubDateEnd() {
        return subDateEnd;
    }

    public void setSubDateEnd(String subDateEnd) {
        this.subDateEnd = subDateEnd;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVisitDateBegin() {
        return visitDateBegin;
    }

    public void setVisitDateBegin(String visitDateBegin) {
        this.visitDateBegin = visitDateBegin;
    }

    public String getVisitDateEnd() {
        return visitDateEnd;
    }

    public void setVisitDateEnd(String visitDateEnd) {
        this.visitDateEnd = visitDateEnd;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getSexs() {
        return sexs;
    }

    public void setSexs(String sexs) {
        this.sexs = sexs;
    }
}
