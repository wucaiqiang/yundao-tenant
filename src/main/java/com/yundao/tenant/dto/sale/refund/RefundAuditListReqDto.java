

package com.yundao.tenant.dto.sale.refund;

import java.util.Date;

import com.yundao.tenant.dto.BasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月16日 下午2:15:18 
 * @author   欧阳利
 * @version   
 */
public class RefundAuditListReqDto extends BasePageDto{

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("客户名称")
	private String customerName;
	
	@ApiModelProperty("产品名称")
	private String productName;
	
	@ApiModelProperty("报单编号")
	private String declarationNumber;
	
	@ApiModelProperty("认购金额开始金额")
	private Double  dealAmountStart;
	
	@ApiModelProperty("认购金额结束金额")
	private Double  dealAmountEnd;
	
	@ApiModelProperty("打款日期开始日期")
	private Date payDateStart;
	
	@ApiModelProperty("打款日期结束日期")
	private Date payDateEnd;
	
	
	@ApiModelProperty("退款状态")
	private String statuss;
	
	@ApiModelProperty("申请人名称")
	private String applyUserName;
	
	@ApiModelProperty("操作时间开始时间")
	private Date auditDateStart;
	
	@ApiModelProperty("操作时间结束时间")
	private Date auditDateEnd;
	@ApiModelProperty("申请开始时间")
	private Date applyDateStart;
	@ApiModelProperty("申请结束时间")
	private Date applyDateEnd;
	
    @ApiModelProperty(value = "查询范围，all：所有，unprocess：未处理，默认all")
    private String scope;
	
	public Date getApplyDateStart() {
	
		return applyDateStart;
	}

	public void setApplyDateStart(Date applyDateStart) {
	
		this.applyDateStart = applyDateStart;
	}

	public Date getApplyDateEnd() {
	
		return applyDateEnd;
	}

	public void setApplyDateEnd(Date applyDateEnd) {
	
		this.applyDateEnd = applyDateEnd;
	}

	public String getScope() {
	
		return scope;
	}

	public void setScope(String scope) {
	
		this.scope = scope;
	}

	public Date getAuditDateStart() {
	
		return auditDateStart;
	}

	public void setAuditDateStart(Date auditDateStart) {
	
		this.auditDateStart = auditDateStart;
	}

	public Date getAuditDateEnd() {
	
		return auditDateEnd;
	}

	public void setAuditDateEnd(Date auditDateEnd) {
	
		this.auditDateEnd = auditDateEnd;
	}

	public String getApplyUserName() {
	
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
	
		this.applyUserName = applyUserName;
	}

	public String getStatuss() {
	
		return statuss;
	}

	public void setStatuss(String statuss) {
	
		this.statuss = statuss;
	}

	public String getCustomerName() {
	
		return customerName;
	}

	public void setCustomerName(String customerName) {
	
		this.customerName = customerName;
	}

	public String getProductName() {
	
		return productName;
	}

	public void setProductName(String productName) {
	
		this.productName = productName;
	}

	public String getDeclarationNumber() {
	
		return declarationNumber;
	}

	public void setDeclarationNumber(String declarationNumber) {
	
		this.declarationNumber = declarationNumber;
	}

	public Double getDealAmountStart() {
	
		return dealAmountStart;
	}

	public void setDealAmountStart(Double dealAmountStart) {
	
		this.dealAmountStart = dealAmountStart;
	}



	public Double getDealAmountEnd() {
	
		return dealAmountEnd;
	}

	public void setDealAmountEnd(Double dealAmountEnd) {
	
		this.dealAmountEnd = dealAmountEnd;
	}

	public Date getPayDateStart() {
	
		return payDateStart;
	}

	public void setPayDateStart(Date payDateStart) {
	
		this.payDateStart = payDateStart;
	}

	public Date getPayDateEnd() {
	
		return payDateEnd;
	}

	public void setPayDateEnd(Date payDateEnd) {
	
		this.payDateEnd = payDateEnd;
	}


	private Long userId;

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}
}

