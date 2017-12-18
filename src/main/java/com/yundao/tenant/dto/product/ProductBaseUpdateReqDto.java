package com.yundao.tenant.dto.product;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class ProductBaseUpdateReqDto {
	/**
	 * id
	 */
	@ApiModelProperty(value="id")
	@NotNull(message = "{" + CodeConstant.CODE_1200041 + "}")
	private Long id;
	
    /**
	 * 产品类型id
	 */
	@ApiModelProperty(value="产品类型id")
	@NotNull(message = "{" + CodeConstant.CODE_1200044 + "}")
    private Long typeId;

    /**
	 * 产品名称
	 */
    @ApiModelProperty(value="产品名称")
    private String name;

    /**
	 * 发行通道
	 */
    @ApiModelProperty(value="发行通道")
    private String issuedChannel;

    /**
	 * 投资标的
	 */
    @ApiModelProperty(value="投资标的")
    private String investDomain;

    /**
	 * 投资期限
	 */
    @ApiModelProperty(value="投资期限")
    private String timeLimit;

    /**
	 * 管理机构
	 */
    @ApiModelProperty(value="管理机构")
    private String mechanism;

    /**
	 * 认购起点
	 */
    @ApiModelProperty(value="认购起点")
    private Double buyStartPoint;

    /**
	 * 递增金额
	 */
    @ApiModelProperty(value="递增金额")
    private Double incrementalAmount;

    /**
	 * 投资人数上限
	 */
    @ApiModelProperty(value="投资人数上限")
    private Integer buyPersonLimit;

    /**
	 * 产品等级
	 */
    @ApiModelProperty(value=" 产品等级")
    private String level;

    /**
	 * 风险等级
	 */
    @ApiModelProperty(value=" 风险等级")
    private String riskLevel;

    /**
	 * 产品对接人
	 */
    @ApiModelProperty(value=" 产品对接人")
    private Long receiverId;

    /**
	 * 产品助理
	 */
    @ApiModelProperty(value=" 产品助理")
    private Long assistantId;

    /**
	 * 简要亮点
	 */
    @ApiModelProperty(value=" 简要亮点")
    private String highlight;
    
    @ApiModelProperty(value="微信简版")
    private String wxContent;
    
    @ApiModelProperty(value="到期日期")
    private Date maturityDate;

	public Date getMaturityDate() {
	
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
	
		this.maturityDate = maturityDate;
	}

	public String getWxContent() {
		return wxContent;
	}

	public void setWxContent(String wxContent) {
		this.wxContent = wxContent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
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


}
