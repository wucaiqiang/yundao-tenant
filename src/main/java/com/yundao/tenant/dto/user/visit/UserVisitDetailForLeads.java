package com.yundao.tenant.dto.user.visit;

import io.swagger.annotations.ApiModelProperty;

/**
 * 线索列表回访详情dto
 *
 * @author jan
 * @create 2017-09-08 PM3:17
 **/
public class UserVisitDetailForLeads {

    @ApiModelProperty(value = "回访id")
    private Long id;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

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

    @ApiModelProperty(value = "回访事由")
    private String matter;

    @ApiModelProperty(value = "回访负责人")
    private Long userId;

    @ApiModelProperty(value = "回访负责人姓名")
    private String userName;

    @ApiModelProperty(value = "回访时间")
    private String visitDate;

    @ApiModelProperty(value = "客户状态")
    private Integer customerStatus;

    @ApiModelProperty(value = "客户状态文本")
    private String customerStatusText;

    @ApiModelProperty(value = "是否已回访")
    private Boolean isProcess;

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

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public Boolean getIsProcess() {
        return this.isProcess;
    }

    public void setIsProcess(Boolean isProcess) {
        this.isProcess = isProcess;
    }
}
