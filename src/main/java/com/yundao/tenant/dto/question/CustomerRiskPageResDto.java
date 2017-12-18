

package com.yundao.tenant.dto.question;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月11日 上午11:17:21 
 * @author   欧阳利
 * @version   
 */
public class CustomerRiskPageResDto {
	@ApiModelProperty("客户id")
    private Long customerId;
	@ApiModelProperty("客户名称")
    private String customerName;
	@ApiModelProperty("测评分数")
    private Integer grade;
	@ApiModelProperty("类型值")
    private Integer riskValue;
	@ApiModelProperty("类型名称")
    private String riskText;
	@ApiModelProperty("风险测评时间")
	private Date riskEvaluationDate;
	
	@ApiModelProperty("是否有预约")
	private Boolean hasReservation;
	
	public Boolean getHasReservation() {
	
		return hasReservation;
	}
	public void setHasReservation(Boolean hasReservation) {
	
		this.hasReservation = hasReservation;
	}
	
	public Integer getRiskValue() {
	
		return riskValue;
	}
	public void setRiskValue(Integer riskValue) {
	
		this.riskValue = riskValue;
	}
	public String getRiskText() {
	
		return riskText;
	}
	public void setRiskText(String riskText) {
	
		this.riskText = riskText;
	}
	public Date getRiskEvaluationDate() {
	
		return riskEvaluationDate;
	}
	public void setRiskEvaluationDate(Date riskEvaluationDate) {
	
		this.riskEvaluationDate = riskEvaluationDate;
	}
	public Long getCustomerId() {
	
		return customerId;
	}
	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}
	public String getCustomerName() {
	
		return customerName;
	}
	public void setCustomerName(String customerName) {
	
		this.customerName = customerName;
	}
	public Integer getGrade() {
	
		return grade;
	}
	public void setGrade(Integer grade) {
	
		this.grade = grade;
	}
	
	
}

