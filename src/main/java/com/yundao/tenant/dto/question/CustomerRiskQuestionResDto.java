

package com.yundao.tenant.dto.question;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月11日 下午6:36:03 
 * @author   欧阳利
 * @version   
 */
public class CustomerRiskQuestionResDto {
	@ApiModelProperty("问题id")
    private Long questionId;
	@ApiModelProperty("问题信息")
    private String questionText;
	@ApiModelProperty("选择id")
    private Long optionId;
	@ApiModelProperty("选择文本")
    private String optionText;
	public Long getQuestionId() {
	
		return questionId;
	}
	public void setQuestionId(Long questionId) {
	
		this.questionId = questionId;
	}
	public String getQuestionText() {
	
		return questionText;
	}
	public void setQuestionText(String questionText) {
	
		this.questionText = questionText;
	}
	public Long getOptionId() {
	
		return optionId;
	}
	public void setOptionId(Long optionId) {
	
		this.optionId = optionId;
	}
	public String getOptionText() {
	
		return optionText;
	}
	public void setOptionText(String optionText) {
	
		this.optionText = optionText;
	}
	
}

