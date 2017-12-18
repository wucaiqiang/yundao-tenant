package com.yundao.tenant.dto.product;

import java.util.Date;
import java.util.List;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductCenterListReqDto extends AbstractBasePageDto{

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
    
    @ApiModelProperty("产品范围(全部：0, 在售：1, 我关注的：2)")
    private Integer productRange;
    
    @ApiModelProperty("产品规模开始")
    private Integer productScaleStart;
    
    @ApiModelProperty("产品规模结束")
    private Integer productScaleEnd;
    
    @ApiModelProperty("发布状态(逗号分割开)")
    private String issuedStatuss;
    
    @ApiModelProperty("对接人/助理姓名")
    private String assistantOrReceiverRealName;
    
    @ApiModelProperty("上线日期开始")
    private Date onLineTimeStart;
    
    @ApiModelProperty("上线日期结束")
    private Date onLineTimeEnd;
    
    private Long receiverId;
    
    private Long assistantId;
    private Long userId;
    private String[] typeIdList;
    private String[] levelList;
    private String[] riskLevelList;
    private List<Integer> issuedStatusList;
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getIssuedStatuss() {
		return issuedStatuss;
	}
	public void setIssuedStatuss(String issuedStatuss) {
		this.issuedStatuss = issuedStatuss;
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
	public List<Integer> getIssuedStatusList() {
		return issuedStatusList;
	}
	public void setIssuedStatusList(List<Integer> issuedStatusList) {
		this.issuedStatusList = issuedStatusList;
	}
    
}
