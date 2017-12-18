package com.yundao.tenant.dto.product;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ProductCenterListResDto {
	@ApiModelProperty("产品id")
    private Long id;
    
	@ApiModelProperty("产品名称")
    private String name;
    
    @ApiModelProperty("产品类型")
    private Long typeId;
    
    @ApiModelProperty("产品类型名称")
    private String typeName;
    
    @ApiModelProperty("产品等级")
    private String level;
    
    @ApiModelProperty("产品等级文本")
    private String levelText;
    
    @ApiModelProperty("风险等级")
    private String riskLevel;
    
    @ApiModelProperty("风险等级文本")
    private String riskLevelText;
    
    @ApiModelProperty("产品规模")
    private Double productScale;
    
    @ApiModelProperty("发行状态")
    private Integer issuedStatus;
    
    @ApiModelProperty("发行状态文本")
    private String issuedStatusText;
    
    @ApiModelProperty("上线日期")
    private Date onLineTime;

    @ApiModelProperty("对接人id")
    private Long receiverId;
    
    @ApiModelProperty("对接人名称")
    private String receiverRealName;
    
    @ApiModelProperty("助理id")
    private Long assistantId;
    
    @ApiModelProperty("助理姓名")
    private String assistantRealName;
    
    @ApiModelProperty("预约金额")
    private String reservationAmount;
    
    @ApiModelProperty("报单金额")
    private String declarationAmount;
  
    @ApiModelProperty("是否存在已通过的预约")
    private Boolean existPassReservation;
    
    @ApiModelProperty("是否能操作预约   true：可以操作， false：不能操作")
    private Boolean canReservation;
    
    @ApiModelProperty("不能操作预约提示")
    private String  notCanReservationTitle;
    
    @ApiModelProperty("是否能操作报单  true：可以操作， false：不能操作")
    private Boolean canDeclaration;
    
    @ApiModelProperty("不能操作报单提示")
    private String  notCanDeclarationTitle;
    
    @ApiModelProperty("募集形式")
    private Integer declarationModel;
    
	public Integer getDeclarationModel() {
	
		return declarationModel;
	}

	public void setDeclarationModel(Integer declarationModel) {
	
		this.declarationModel = declarationModel;
	}

	public Boolean getCanReservation() {
	
		return canReservation;
	}

	public void setCanReservation(Boolean canReservation) {
	
		this.canReservation = canReservation;
	}

	public String getNotCanReservationTitle() {
	
		return notCanReservationTitle;
	}

	public void setNotCanReservationTitle(String notCanReservationTitle) {
	
		this.notCanReservationTitle = notCanReservationTitle;
	}

	public Boolean getCanDeclaration() {
	
		return canDeclaration;
	}

	public void setCanDeclaration(Boolean canDeclaration) {
	
		this.canDeclaration = canDeclaration;
	}

	public String getNotCanDeclarationTitle() {
	
		return notCanDeclarationTitle;
	}

	public void setNotCanDeclarationTitle(String notCanDeclarationTitle) {
	
		this.notCanDeclarationTitle = notCanDeclarationTitle;
	}

	public Boolean getExistPassReservation() {
		return existPassReservation;
	}

	public void setExistPassReservation(Boolean existPassReservation) {
		this.existPassReservation = existPassReservation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevelText() {
		return levelText;
	}

	public void setLevelText(String levelText) {
		this.levelText = levelText;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getRiskLevelText() {
		return riskLevelText;
	}

	public void setRiskLevelText(String riskLevelText) {
		this.riskLevelText = riskLevelText;
	}

	public Double getProductScale() {
		return productScale;
	}

	public void setProductScale(Double productScale) {
		this.productScale = productScale;
	}

	public Integer getIssuedStatus() {
		return issuedStatus;
	}

	public void setIssuedStatus(Integer issuedStatus) {
		this.issuedStatus = issuedStatus;
	}

	public String getIssuedStatusText() {
		return issuedStatusText;
	}

	public void setIssuedStatusText(String issuedStatusText) {
		this.issuedStatusText = issuedStatusText;
	}

	public Date getOnLineTime() {
		return onLineTime;
	}

	public void setOnLineTime(Date onLineTime) {
		this.onLineTime = onLineTime;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public String getReceiverRealName() {
		return receiverRealName;
	}

	public void setReceiverRealName(String receiverRealName) {
		this.receiverRealName = receiverRealName;
	}

	public Long getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(Long assistantId) {
		this.assistantId = assistantId;
	}

	public String getAssistantRealName() {
		return assistantRealName;
	}

	public void setAssistantRealName(String assistantRealName) {
		this.assistantRealName = assistantRealName;
	}

	public String getReservationAmount() {
		return reservationAmount;
	}

	public void setReservationAmount(String reservationAmount) {
		this.reservationAmount = reservationAmount;
	}

	public String getDeclarationAmount() {
		return declarationAmount;
	}

	public void setDeclarationAmount(String declarationAmount) {
		this.declarationAmount = declarationAmount;
	}
    
}
