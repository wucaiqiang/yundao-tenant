package com.yundao.tenant.dto.product;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 基金
 *
 * @author jan
 * @create 2017-11-25 13:57
 **/
public class FundDto extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
    private Long typeId;

    /**
     * 名称
     */
    private String name;

    /**
     * 发行通道
     */
    private String issuedChannel;

    /**
     * 投资标的
     */
    private String investDomain;

    /**
     * 投资期限
     */
    private String timeLimit;

    /**
     * 管理机构
     */
    private String mechanism;

    /**
     * 认购起点
     */
    private Double buyStartPoint;

    /**
     * 递增金额
     */
    private Double incrementalAmount;

    /**
     * 投资方式投资人数上限
     */
    private Integer buyPersonLimit;

    /**
     * 基金等级
     */
    private String level;

    /**
     * 风险等级
     */
    private String riskLevel;

    /**
     * 基金负责人
     */
    private Long receiverId;

    /**
     * 简要亮点
     */
    private String highlight;

    /**
     * 到期日期
     */
    private Date maturityDate;

    /**
     * 自定义字段
     */
    private List<FundFieldValueDto> fieldValues;

    /**
     * 附件
     */
    private List<FundAttachDto> attachs;

    /**
     * 基金收益
     */
    private List<FundIncomeDto> incomes;

    /**
     * 基金收益规则
     */
    private List<FundIncomeRuleDto> incomeRules;

    /**
     * 基金募集信息
     */
    private List<FundRaiseDto> raises;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuedChannel() {
        return issuedChannel;
    }

    public void setIssuedChannel(String issuedChannel) {
        this.issuedChannel = issuedChannel;
    }

    public String getInvestDomain() {
        return investDomain;
    }

    public void setInvestDomain(String investDomain) {
        this.investDomain = investDomain;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getMechanism() {
        return mechanism;
    }

    public void setMechanism(String mechanism) {
        this.mechanism = mechanism;
    }

    public Double getBuyStartPoint() {
        return buyStartPoint;
    }

    public void setBuyStartPoint(Double buyStartPoint) {
        this.buyStartPoint = buyStartPoint;
    }

    public Double getIncrementalAmount() {
        return incrementalAmount;
    }

    public void setIncrementalAmount(Double incrementalAmount) {
        this.incrementalAmount = incrementalAmount;
    }

    public Integer getBuyPersonLimit() {
        return buyPersonLimit;
    }

    public void setBuyPersonLimit(Integer buyPersonLimit) {
        this.buyPersonLimit = buyPersonLimit;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public List<FundFieldValueDto> getFieldValues() {
        return fieldValues;
    }

    public void setFieldValues(List<FundFieldValueDto> fieldValues) {
        this.fieldValues = fieldValues;
    }

    public List<FundAttachDto> getAttachs() {
        return attachs;
    }

    public void setAttachs(List<FundAttachDto> attachs) {
        this.attachs = attachs;
    }

    public List<FundIncomeDto> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<FundIncomeDto> incomes) {
        this.incomes = incomes;
    }

    public List<FundIncomeRuleDto> getIncomeRules() {
        return incomeRules;
    }

    public void setIncomeRules(List<FundIncomeRuleDto> incomeRules) {
        this.incomeRules = incomeRules;
    }

    public List<FundRaiseDto> getRaises() {
        return raises;
    }

    public void setRaises(List<FundRaiseDto> raises) {
        this.raises = raises;
    }
}
