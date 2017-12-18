

package com.yundao.tenant.dto.question;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月11日 下午6:27:36 
 * @author   欧阳利
 * @version   
 */
public class CustomerRiskResDto {

	@ApiModelProperty("投资者id")
	private Long userId;
	
	@ApiModelProperty("客户id")
	private Long customerId;
	
	@ApiModelProperty("认定结果得分")
    private Integer grade;
    
	@ApiModelProperty("类型值")
    private Integer riskValue;
    
	@ApiModelProperty("类型名称")
    private String riskText;
	
	@ApiModelProperty("评测时间")
	private Date evaluationTime;
	
	@ApiModelProperty("是否存在对应的用户")
	private Boolean isExistUserId;
	
	@ApiModelProperty("是否测评")
	private Boolean isEvaluation;
	
	@ApiModelProperty("类型名称")
	private List<CustomerRiskQuestionResDto> questionDtos;

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

	public Boolean getIsExistUserId() {
	
		return isExistUserId;
	}

	public void setIsExistUserId(Boolean isExistUserId) {
	
		this.isExistUserId = isExistUserId;
	}

	public Boolean getIsEvaluation() {
	
		return isEvaluation;
	}

	public void setIsEvaluation(Boolean isEvaluation) {
	
		this.isEvaluation = isEvaluation;
	}

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}

	public Integer getGrade() {
	
		return grade;
	}

	public void setGrade(Integer grade) {
	
		this.grade = grade;
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

	public Date getEvaluationTime() {
	
		return evaluationTime;
	}

	public void setEvaluationTime(Date evaluationTime) {
	
		this.evaluationTime = evaluationTime;
	}

	public List<CustomerRiskQuestionResDto> getQuestionDtos() {
	
		return questionDtos;
	}

	public void setQuestionDtos(List<CustomerRiskQuestionResDto> questionDtos) {
	
		this.questionDtos = questionDtos;
	}
	
}

