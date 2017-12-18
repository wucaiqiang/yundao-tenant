
package com.yundao.tenant.dto.sale.declaration;


import io.swagger.annotations.ApiModelProperty;

public class DeclarationUpdateComplianceDto{
    @ApiModelProperty(value = "报单ID")
    private Long id;
    //合规双录
    @ApiModelProperty(value = "合规双录")
    private String complianceRecord;
    //投资者基本信息表（自然人）
    @ApiModelProperty(value = "投资者基本信息表（自然人）")
    private String baseInfo;
    //投资者风险匹配告知书及投资者确认函
    @ApiModelProperty(value = "投资者风险匹配告知书及投资者确认函")
    private String riskNotify;
    //风险承受能力调查问卷（自然人）
    @ApiModelProperty(value = "风险承受能力调查问卷（自然人）")
    private String riskQuesstionnaire;
    //基金回访确认书
    @ApiModelProperty(value = "风基金回访确认书")
    private String returnConfirmation;
    //其他合规文件
    @ApiModelProperty(value = "其他合规文件")
    private String otherFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplianceRecord() {
        return complianceRecord;
    }

    public void setComplianceRecord(String complianceRecord) {
        this.complianceRecord = complianceRecord;
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo;
    }

    public String getRiskNotify() {
        return riskNotify;
    }

    public void setRiskNotify(String riskNotify) {
        this.riskNotify = riskNotify;
    }

    public String getRiskQuesstionnaire() {
        return riskQuesstionnaire;
    }

    public void setRiskQuesstionnaire(String riskQuesstionnaire) {
        this.riskQuesstionnaire = riskQuesstionnaire;
    }

    public String getReturnConfirmation() {
        return returnConfirmation;
    }

    public void setReturnConfirmation(String returnConfirmation) {
        this.returnConfirmation = returnConfirmation;
    }

    public String getOtherFile() {
        return otherFile;
    }

    public void setOtherFile(String otherFile) {
        this.otherFile = otherFile;
    }
}

