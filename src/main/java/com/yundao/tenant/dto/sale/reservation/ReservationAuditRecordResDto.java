package com.yundao.tenant.dto.sale.reservation;

import java.util.Date;
import java.util.List;

import com.yundao.tenant.dto.workflow.AuditDetailResDTO;

import io.swagger.annotations.ApiModelProperty;

public class ReservationAuditRecordResDto {
    
	@ApiModelProperty("预约id")
	private Long id;
	@ApiModelProperty("是否已经作废")
	private Boolean discard;
	@ApiModelProperty("作废时间")
	private Date discardTime;
	
	@ApiModelProperty("作废操作人id")
	private Long discardUserId;
	@ApiModelProperty("作废操作人名称")
	private String discardUserName;
	@ApiModelProperty("原因")
	private String reason;
	@ApiModelProperty("预约状态")
	private Integer status;
	@ApiModelProperty("预约状态名称")
	private String statusText;
	
	@ApiModelProperty("预约审核记录")
	List<AuditDetailResDTO> auditList;
	
	@ApiModelProperty("是否已经报单")
	private Boolean hasDeclaration;


	public Boolean getHasDeclaration() {
	
		return hasDeclaration;
	}

	public void setHasDeclaration(Boolean hasDeclaration) {
	
		this.hasDeclaration = hasDeclaration;
	}

	public Date getDiscardTime() {
	
		return discardTime;
	}

	public void setDiscardTime(Date discardTime) {
	
		this.discardTime = discardTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getDiscardUserName() {
		return discardUserName;
	}

	public void setDiscardUserName(String discardUserName) {
		this.discardUserName = discardUserName;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDiscard() {
		return discard;
	}

	public void setDiscard(Boolean discard) {
		this.discard = discard;
	}

	public Long getDiscardUserId() {
		return discardUserId;
	}

	public void setDiscardUserId(Long discardUserId) {
		this.discardUserId = discardUserId;
	}


	public List<AuditDetailResDTO> getAuditList() {
		return auditList;
	}

	public void setAuditList(List<AuditDetailResDTO> auditList) {
		this.auditList = auditList;
	}

	public String getReason() {
		return reason;
	}
	
}
