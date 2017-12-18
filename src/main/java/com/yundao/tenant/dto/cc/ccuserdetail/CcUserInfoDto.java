package com.yundao.tenant.dto.cc.ccuserdetail;

import io.swagger.annotations.ApiModelProperty;

/**
 * 获取理财用户信息
 *
 * @author jan
 * @create 2017-10-19 17:28
 **/
public class CcUserInfoDto {

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "是否已做风险评测")
    private Boolean evaluating;

    @ApiModelProperty(value = "风险评估等级文本")
    private String riskRatingText;

    @ApiModelProperty(value = "评估成绩id")
    private Long scoreId;

    @ApiModelProperty(value = "成绩")
    private Integer grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRiskRatingText() {
        return riskRatingText;
    }

    public void setRiskRatingText(String riskRatingText) {
        this.riskRatingText = riskRatingText;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEvaluating() {
        return evaluating;
    }

    public void setEvaluating(Boolean evaluating) {
        this.evaluating = evaluating;
    }
}
