package com.yundao.tenant.dto.question;

import io.swagger.annotations.ApiModelProperty;

public class QuestionOptionDto {
	@ApiModelProperty("选项id")
	private Long id;
    /**
	 * 
	 */
	@ApiModelProperty("选项内容")
    private String content;

    /**
	 * 分数
	 */
	@ApiModelProperty("分数")
    private Integer grade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}
