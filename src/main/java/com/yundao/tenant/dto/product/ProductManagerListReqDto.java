package com.yundao.tenant.dto.product;

import java.util.Date;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductManagerListReqDto extends AbstractBasePageDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品名称")
    private String name;
    
    @ApiModelProperty("产品类型id(逗号分割开)")
    private String typeIds;
    
    
    @ApiModelProperty("产品等级(逗号分割开)")
    private String levels;
    
    
    @ApiModelProperty("风险等级(逗号分割开)")
    private String riskLevels;
    
    /**
     * 对接人名称
     */
    @ApiModelProperty("产品范围(全部：0, 我对接的：1, 我助理的：2 , 我对接的或者我助理的：3)")
    private Integer productRange;

    /**
     * 助理姓名
     */
    @ApiModelProperty("助理姓名")
    private String assistantOrReceiverRealName;
    
    /**
     * 对接人名称
     */
    @ApiModelProperty("对接人id")
    private Long receiverId;
    
    /**
     * 助理姓名
     */
    @ApiModelProperty("助理id")
    private Long assistantId;
    
    @ApiModelProperty("发布状态(逗号分割开)")
    private String issuedStatuss;
    @ApiModelProperty("审核状态(逗号分割开)")
    private String examineStatuss;
    
    @ApiModelProperty("产品规模开始")
    private Integer productScaleStart;
    @ApiModelProperty("产品规模结束")
    private Integer productScaleEnd;
    @ApiModelProperty("创建日期开始")
    private Date createDateStart;
    @ApiModelProperty("创建日期结束")
    private Date createDateEnd;
    @ApiModelProperty("上线日期开始")
    private Date onLineTimeStart;
    @ApiModelProperty("上线日期结束")
    private Date onLineTimeEnd;
    
    private Long assistantIdOrreceiverId;
    
    private String[] typeIdList;
    private String[] levelList;
    private String[] riskLevelList;
    private String[] issuedStatusList;
    private String[] examineStatusList;
    
	public Long getAssistantIdOrreceiverId() {
	
		return assistantIdOrreceiverId;
	}

	public void setAssistantIdOrreceiverId(Long assistantIdOrreceiverId) {
	
		this.assistantIdOrreceiverId = assistantIdOrreceiverId;
	}

	public Integer getProductRange() {
		return productRange;
	}

	public void setProductRange(Integer productRange) {
		this.productRange = productRange;
	}

	public Integer getProductScaleStart() {
		return productScaleStart;
	}

	public void setProductScaleStart(Integer productScaleStart) {
		this.productScaleStart = productScaleStart;
	}

	public Integer getProductScaleEnd() {
		return productScaleEnd;
	}

	public void setProductScaleEnd(Integer productScaleEnd) {
		this.productScaleEnd = productScaleEnd;
	}

	public Date getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(Date createDateStart) {
		this.createDateStart = createDateStart;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public Date getOnLineTimeStart() {
		return onLineTimeStart;
	}

	public void setOnLineTimeStart(Date onLineTimeStart) {
		this.onLineTimeStart = onLineTimeStart;
	}

	public Date getOnLineTimeEnd() {
		return onLineTimeEnd;
	}

	public void setOnLineTimeEnd(Date onLineTimeEnd) {
		this.onLineTimeEnd = onLineTimeEnd;
	}

	public String getTypeIds() {
		return typeIds;
	}

	public void setTypeIds(String typeIds) {
		this.typeIds = typeIds;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getRiskLevels() {
		return riskLevels;
	}

	public void setRiskLevels(String riskLevels) {
		this.riskLevels = riskLevels;
	}

	public String getIssuedStatuss() {
		return issuedStatuss;
	}

	public void setIssuedStatuss(String issuedStatuss) {
		this.issuedStatuss = issuedStatuss;
	}

	public String getExamineStatuss() {
		return examineStatuss;
	}

	public void setExamineStatuss(String examineStatuss) {
		this.examineStatuss = examineStatuss;
	}


	public String[] getTypeIdList() {
		return typeIdList;
	}

	public void setTypeIdList(String[] typeIdList) {
		this.typeIdList = typeIdList;
	}


	public String[] getLevelList() {
		return levelList;
	}

	public void setLevelList(String[] levelList) {
		this.levelList = levelList;
	}

	public String[] getRiskLevelList() {
		return riskLevelList;
	}

	public void setRiskLevelList(String[] riskLevelList) {
		this.riskLevelList = riskLevelList;
	}

	public String[] getIssuedStatusList() {
		return issuedStatusList;
	}

	public void setIssuedStatusList(String[] issuedStatusList) {
		this.issuedStatusList = issuedStatusList;
	}

	public String[] getExamineStatusList() {
		return examineStatusList;
	}

	public void setExamineStatusList(String[] examineStatusList) {
		this.examineStatusList = examineStatusList;
	}


	public String getAssistantOrReceiverRealName() {
		return assistantOrReceiverRealName;
	}

	public void setAssistantOrReceiverRealName(String assistantOrReceiverRealName) {
		this.assistantOrReceiverRealName = assistantOrReceiverRealName;
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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


    
}
