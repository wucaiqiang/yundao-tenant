package com.yundao.tenant.dto.sale.leads;

import io.swagger.annotations.ApiModelProperty;

/**
 * 销售线索分页数据返回dto
 *
 * @author jan
 * @create 2017-09-06 PM8:03
 **/
public class LeadsPageResDto {

    @ApiModelProperty(value = "线索id")
    private Long id;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "客户编号")
    private String number;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "所属理财师id")
    private Long fpId;

    @ApiModelProperty(value = "所属理财师姓名")
    private String fpName;

    @ApiModelProperty(value = "线索类型")
    private Integer type;

    @ApiModelProperty(value = "线索类型文本")
    private String typeText;

    @ApiModelProperty(value = "渠道")
    private Integer channel;

    @ApiModelProperty(value = "渠道wenb")
    private String channelText;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

    @ApiModelProperty(value = "线索跟进状态")
    private Integer status;

    @ApiModelProperty(value = "线索跟进状态文本")
    private String statusText;

    @ApiModelProperty(value = "客户状态")
    private Integer customerStatus;

    @ApiModelProperty(value = "客户状态文本")
    private String customerStatusText;

    @ApiModelProperty(value = "回访id")
    private Long userVisitId;

    @ApiModelProperty(value = "线索所属客户的状态，是否曾经被设置过无效，0：否，1：是，默认0")
    private Integer isOnceInvalid;

    @ApiModelProperty(value = "是否已被分配给客服，0：否，1：是")
    private Integer isAllotedCs;

    @ApiModelProperty(value = "是否已被分配给理财师，0：否，1：是")
    private Integer isAllotedFp;

    @ApiModelProperty(value = "是否能够进行分配给理财师")
    private Boolean canAllotToFp;

    @ApiModelProperty(value = "是否能够进行分配给客服回访")
    private Boolean canAllotToCs;

    @ApiModelProperty(value = "是否可以查看回访情况")
    private Boolean canViewVisitDetail;

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

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getChannelText() {
        return channelText;
    }

    public void setChannelText(String channelText) {
        this.channelText = channelText;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public Boolean getCanAllotToFp() {
        return canAllotToFp;
    }

    public void setCanAllotToFp(Boolean canAllotToFp) {
        this.canAllotToFp = canAllotToFp;
    }

    public Boolean getCanAllotToCs() {
        return canAllotToCs;
    }

    public void setCanAllotToCs(Boolean canAllotToCs) {
        this.canAllotToCs = canAllotToCs;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getUserVisitId() {
        return userVisitId;
    }

    public void setUserVisitId(Long userVisitId) {
        this.userVisitId = userVisitId;
    }

    public Boolean getCanViewVisitDetail() {
        return canViewVisitDetail;
    }

    public void setCanViewVisitDetail(Boolean canViewVisitDetail) {
        this.canViewVisitDetail = canViewVisitDetail;
    }

    public Integer getIsOnceInvalid() {
        return isOnceInvalid;
    }

    public void setIsOnceInvalid(Integer isOnceInvalid) {
        this.isOnceInvalid = isOnceInvalid;
    }

    public Integer getIsAllotedCs() {
        return isAllotedCs;
    }

    public void setIsAllotedCs(Integer isAllotedCs) {
        this.isAllotedCs = isAllotedCs;
    }

    public Integer getIsAllotedFp() {
        return isAllotedFp;
    }

    public void setIsAllotedFp(Integer isAllotedFp) {
        this.isAllotedFp = isAllotedFp;
    }
}
