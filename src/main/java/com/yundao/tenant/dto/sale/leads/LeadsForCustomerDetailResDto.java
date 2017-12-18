package com.yundao.tenant.dto.sale.leads;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户详情销售线索数据返回dto
 *
 * @author jan
 * @create 2017-09-07 PM5:31
 **/
public class LeadsForCustomerDetailResDto {

    @ApiModelProperty(value = "线索id")
    private Long id;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "类型文本")
    private String typeText;

    @ApiModelProperty(value = "渠道")
    private Integer channel;

    @ApiModelProperty(value = "渠道wenb")
    private String channelText;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "线索时间")
    private String createDate;

    @ApiModelProperty(value = "线索跟进状态")
    private Integer status;

    @ApiModelProperty(value = "线索跟进状态文本")
    private String statusText;

    @ApiModelProperty(value = "处理人id")
    private Long processUserId;

    @ApiModelProperty(value = "处理人名称")
    private String processUserName;

    @ApiModelProperty(value = "处理时间")
    private String processDate;

    @ApiModelProperty(value = "客户所属理财师id")
    private Long fpId;

    @ApiModelProperty(value = "是否能处理")
    private Boolean canProcess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(Long processUserId) {
        this.processUserId = processUserId;
    }

    public String getProcessUserName() {
        return processUserName;
    }

    public void setProcessUserName(String processUserName) {
        this.processUserName = processUserName;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public Boolean getCanProcess() {
        return canProcess;
    }

    public void setCanProcess(Boolean canProcess) {
        this.canProcess = canProcess;
    }

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
    }
}
