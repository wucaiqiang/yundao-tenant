

package com.yundao.tenant.dto.aa.asset;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.dto.question.QuestionAndOptionReqDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午3:33:22 
 * @author   欧阳利
 * @version   
 */
public class UpdateAssetAllocationReqDto {
	@ApiModelProperty("资产配置id")
	@NotNull(message = "{" + Code1200000.CODE_1200178 + "}")
	private Long id;

	@ApiModelProperty("提醒选项答案 [{ \"questionId(题目id)\":1 ,\"optionIdList(选项ids)\": [1] }]")
	private String questionAndOptionDtos;
	
	List<QuestionAndOptionReqDto> questionAndOptionDtoList;

	public List<QuestionAndOptionReqDto> getQuestionAndOptionDtoList() {
	
		return questionAndOptionDtoList;
	}

	public void setQuestionAndOptionDtoList(List<QuestionAndOptionReqDto> questionAndOptionDtoList) {
	
		this.questionAndOptionDtoList = questionAndOptionDtoList;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public String getQuestionAndOptionDtos() {
		return questionAndOptionDtos;
	}

	public void setQuestionAndOptionDtos(String questionAndOptionDtos) {
		this.questionAndOptionDtos = questionAndOptionDtos;
	}
}

