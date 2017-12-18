package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseProduct extends BaseModel implements Serializable {
    /**
	 * 产品类型编码
	 */
    private Long typeId;

    /**
	 * 产品名称
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
	 * 投资人数上限
	 */
    private Integer buyPersonLimit;

    /**
	 * 产品等级
	 */
    private String level;

    /**
	 * 风险等级
	 */
    private String riskLevel;

    /**
	 * 产品对接人
	 */
    private Long receiverId;

    /**
	 * 产品助理
	 */
    private Long assistantId;

    /**
	 * 简要亮点
	 */
    private String highlight;

    /**
	 * 上线时间
	 */
    private Date onLineTime;

    /**
	 * 产品发行状态(0:未上线; 1:上线准备中; 2:预售; 3:募集中; 4:募集结束; 5:存续封闭中;6:清算退出)
	 */
    private Integer issuedStatus;

    /**
	 * 报单模式： 1：直接报单: 2：先预约在报单
	 */
    private Integer declarationModel;

    /**
	 * 微信版内容
	 */
    private String wxContent;

    /**
	 * 到期日期
	 */
    private Date maturityDate;

    private static final long serialVersionUID = 1L;

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

    public Long getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public Date getOnLineTime() {
        return onLineTime;
    }

    public void setOnLineTime(Date onLineTime) {
        this.onLineTime = onLineTime;
    }

    public Integer getIssuedStatus() {
        return issuedStatus;
    }

    public void setIssuedStatus(Integer issuedStatus) {
        this.issuedStatus = issuedStatus;
    }

    public Integer getDeclarationModel() {
        return declarationModel;
    }

    public void setDeclarationModel(Integer declarationModel) {
        this.declarationModel = declarationModel;
    }

    public String getWxContent() {
        return wxContent;
    }

    public void setWxContent(String wxContent) {
        this.wxContent = wxContent;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }
}