package com.yundao.tenant.dto.question;

import io.swagger.annotations.ApiModelProperty;

public class QuestionAndOptionDto {
	@ApiModelProperty("题目id")
	private Long id;
    /**
	 * 标题
	 */
	@ApiModelProperty("标题")
    private String title;

	@ApiModelProperty("题目所属类型")
	private Long typeId;
	
    /**
	 * 类型，0：单选，1：多选，2：文本
	 */
	@ApiModelProperty("类型，0：单选，1：多选，2：文本")
    private Integer type;
	
	@ApiModelProperty("选项id")
	private Long optionId;
	
	@ApiModelProperty("选项内容")
    private String content;

	@ApiModelProperty("分数")
    private Integer grade;

	public Long getTypeId() {
	
		return typeId;
	}

	public void setTypeId(Long typeId) {
	
		this.typeId = typeId;
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

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
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
