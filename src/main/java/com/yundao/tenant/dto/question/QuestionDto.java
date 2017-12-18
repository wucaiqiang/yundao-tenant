package com.yundao.tenant.dto.question;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class QuestionDto {
	@ApiModelProperty("题目id")
	private Long id;
    /**
	 * 标题
	 */
	@ApiModelProperty("标题")
    private String title;

    /**
	 * 类型，0：单选，1：多选，2：文本
	 */
	@ApiModelProperty("类型，0：单选，1：多选，2：文本")
    private Integer type;

    /**
	 * 排序
	 */
	@ApiModelProperty("排序")
    private Integer sequence;
	
	@ApiModelProperty("选项")
	private List<QuestionOptionDto> optionList;

	public List<QuestionOptionDto> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<QuestionOptionDto> optionList) {
		this.optionList = optionList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
}
