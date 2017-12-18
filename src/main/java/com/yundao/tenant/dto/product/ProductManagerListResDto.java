package com.yundao.tenant.dto.product;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ProductManagerListResDto {
	
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
    
    /**
     * 产品规模
     */
    @ApiModelProperty("产品规模")
    private Double productScale;
    
    /**
     * 对接人id
     */
    @ApiModelProperty("对接人id")
    private Long receiverId;
    
    /**
     * 对接人名称
     */
    @ApiModelProperty("对接人名称")
    private String receiverRealName;
    
    
    /**
     * 助理id
     */
    @ApiModelProperty("助理id")
    private Long assistantId;
    
    /**
     * 助理姓名
     */
    @ApiModelProperty("助理姓名")
    private String assistantRealName;
    
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createDate;
    
    /**
     * 上线日期
     */
    @ApiModelProperty("上线日期")
    private Date onLineTime;
    @ApiModelProperty("创建者id")
    private Long createUserId;
    
    /**
     * 发行状态
     */
    @ApiModelProperty("发行状态")
    private Integer issuedStatus;
    /**
     * 发行状态文本
     */
    @ApiModelProperty("发行状态文本")
    private String issuedStatusText;
    @ApiModelProperty("审核状态")
    private  Integer examineStatus;
    @ApiModelProperty("审核状态文本")
    private  String examineStatusText;

    @ApiModelProperty("操作dto")
    private ProductActionDto actionDto;
    
    @ApiModelProperty("预约金额")
    private String reservationAmount;
    
    @ApiModelProperty("报单金额")
    private String declarationAmount;
    @ApiModelProperty("原因")
    private String reason;
    
    @ApiModelProperty("流程发起人id(申请人id)")
    private Long applyUserId;

	@ApiModelProperty("申请人姓名")
	private String applyUserName;
	
	@ApiModelProperty("募集形式")
	private Integer declarationModel;
    
	public Integer getDeclarationModel() {
	
		return declarationModel;
	}

	public void setDeclarationModel(Integer declarationModel) {
	
		this.declarationModel = declarationModel;
	}

	public Long getApplyUserId() {
	
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
	
		this.applyUserId = applyUserId;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ProductActionDto getActionDto() {
		return actionDto;
	}

	public void setActionDto(ProductActionDto actionDto) {
		this.actionDto = actionDto;
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

	public Integer getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(Integer examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getExamineStatusText() {
		return examineStatusText;
	}

	public void setExamineStatusText(String examineStatusText) {
		this.examineStatusText = examineStatusText;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getReceiverRealName() {
		return receiverRealName;
	}

	public void setReceiverRealName(String receiverRealName) {
		this.receiverRealName = receiverRealName;
	}

	public String getAssistantRealName() {
		return assistantRealName;
	}

	public void setAssistantRealName(String assistantRealName) {
		this.assistantRealName = assistantRealName;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getOnLineTime() {
		return onLineTime;
	}

	public void setOnLineTime(Date onLineTime) {
		this.onLineTime = onLineTime;
	}

	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}
}
