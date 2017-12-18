

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
public class MyRefundListReqDto extends BasePageDto{

	
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
	
	@ApiModelProperty("报单时间开始日期")
	private Date declarationDateStart;
	
	@ApiModelProperty("报单时间结束")
	private Date declarationDateEnd;
	
	@ApiModelProperty("退款状态")
	private String statuss;
	
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

	public Date getDeclarationDateStart() {
	
		return declarationDateStart;
	}

	public void setDeclarationDateStart(Date declarationDateStart) {
	
		this.declarationDateStart = declarationDateStart;
	}

	public Date getDeclarationDateEnd() {
	
		return declarationDateEnd;
	}

	public void setDeclarationDateEnd(Date declarationDateEnd) {
	
		this.declarationDateEnd = declarationDateEnd;
	}

	private Long userId;

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}
}

