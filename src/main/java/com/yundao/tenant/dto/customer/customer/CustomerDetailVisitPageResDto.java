package com.yundao.tenant.dto.customer.customer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户详情页回访分页数据
 *
 * @author jan
 * @create 2017-08-11 AM10:25
 **/
public class CustomerDetailVisitPageResDto {

    @ApiModelProperty(value = "回访id")
    private Long id;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "回访日期")
    private String visitDate;

    @ApiModelProperty(value = "回访事由")
    private String matter;

    @ApiModelProperty(value = "回访状态")
    private Integer status;

    @ApiModelProperty(value = "回访状态文本")
    private String statusText;

    @ApiModelProperty(value = "回访方式")
    private Integer type;

    @ApiModelProperty(value = "回访方式文本")
    private String typeText;

    @ApiModelProperty(value = "回访内容")
    private String content;

    @ApiModelProperty(value = "回访人姓名")
    private String userName;

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

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
