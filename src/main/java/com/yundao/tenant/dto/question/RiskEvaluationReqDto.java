package com.yundao.tenant.dto.question;

import io.swagger.annotations.ApiModelProperty;

public class RiskEvaluationReqDto {
	
	
//	@ApiModelProperty("投资者id")
//	@NotNull(message = "{" + CodeConstant.CODE_1200124 + "}")
//	private Long userId;

	@ApiModelProperty("提醒选项答案 [{ \"questionId(题目id)\":1 ,\"optionIdList(选项ids)\": [1] }]")
	private String questionAndOptionDtos;
	
	
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}

	public String getQuestionAndOptionDtos() {
		return questionAndOptionDtos;
	}

	public void setQuestionAndOptionDtos(String questionAndOptionDtos) {
		this.questionAndOptionDtos = questionAndOptionDtos;
	}

}
