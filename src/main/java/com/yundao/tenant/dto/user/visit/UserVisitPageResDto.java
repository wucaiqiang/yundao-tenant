package com.yundao.tenant.dto.user.visit;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户回访分页数据dto
 *
 * @author jan
 * @create 2017-08-29 PM4:56
 **/
public class UserVisitPageResDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户编号")
    private String customerNumber;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

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

    @ApiModelProperty(value = "所属理财师id")
    private Long fpId;

    @ApiModelProperty(value = "所属理财师名称")
    private String fpName;

    @ApiModelProperty(value = "回访事由")
    private String matter;

    @ApiModelProperty(value = "分配回访时间")
    private String subDate;

    @ApiModelProperty(value = "回访方式")
    private Integer type;

    @ApiModelProperty(value = "回访方式文本")
    private String typeText;

    @ApiModelProperty(value = "回访状态")
    private Integer status;

    @ApiModelProperty(value = "回访状态文本")
    private String statusText;

    @ApiModelProperty(value = "回访内容")
    private String content;

    @ApiModelProperty(value = "回访负责人")
    private Long userId;

    @ApiModelProperty(value = "回访负责人姓名")
    private String userName;

    @ApiModelProperty(value = "回访时间")
    private String visitDate;

    @ApiModelProperty(value = "是否能回访")
    private Boolean canVisit;

    @ApiModelProperty(value = "是否回访文本")
    private String isVisitText;
    
    @ApiModelProperty(value = "客户状态")
    private Integer customerStatus;
    
    @ApiModelProperty(value = "客户状态名称")
    private String customerStatusText;

    public Integer getCustomerStatus() {
	
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
	
		this.customerStatus = customerStatus;
	}

	public String getCustomerStatusText() {
	
		return customerStatusText;
	}

	public void setCustomerStatusText(String customerStatusText) {
	
		this.customerStatusText = customerStatusText;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
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

    public String getSubDate() {
        return subDate;
    }

    public void setSubDate(String subDate) {
        this.subDate = subDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getIsVisitText() {
        return isVisitText;
    }

    public void setIsVisitText(String isVisitText) {
        this.isVisitText = isVisitText;
    }

    public Boolean getCanVisit() {
        return canVisit;
    }

    public void setCanVisit(Boolean canVisit) {
        this.canVisit = canVisit;
    }
}
