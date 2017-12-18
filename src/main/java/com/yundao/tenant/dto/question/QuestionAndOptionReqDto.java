package com.yundao.tenant.dto.question;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class QuestionAndOptionReqDto {
	
	@ApiModelProperty("题目id")
    private Long questionId;
	
	@ApiModelProperty("选项id集合,逗号分割开")
    private List<Long> optionIdList;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public List<Long> getOptionIdList() {
		return optionIdList;
	}

	public void setOptionIdList(List<Long> optionIdList) {
		this.optionIdList = optionIdList;
	}
    
}
