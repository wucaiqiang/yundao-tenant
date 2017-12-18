package com.yundao.tenant.dto.product;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

public class ProductSelectOptionDto {

	@ApiModelProperty("产品id")
	private Long id;
	
	@ApiModelProperty("产品名称")
	private String name;
	
    @ApiModelProperty(value = "发行状态")
    private Integer issuedStatus;
    
    @ApiModelProperty(value = "发行状态名称")
    private String issuedStatusText;

	@ApiModelProperty("是否允许预约")
	private Boolean canReservation;

	@ApiModelProperty("不能预约提示语句")
	private String notCanReservationTitle;

	@ApiModelProperty("报单模式： 1：直接报单: 2：先预约在报单")
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

}
