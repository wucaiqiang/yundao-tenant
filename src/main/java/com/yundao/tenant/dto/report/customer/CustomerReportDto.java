

package com.yundao.tenant.dto.report.customer;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午11:05:20 
 * @author   欧阳利
 * @version   
 */
public class CustomerReportDto {
	@ApiModelProperty("客户id")
    private Long id;
	@ApiModelProperty("客户名称")
	private String name;
	@ApiModelProperty("客户编号")
    private String number;
	@ApiModelProperty("创建者id")
    private Long createUserId;
	@ApiModelProperty("创建者名称")
    private String createUserName;
	@ApiModelProperty("等级")
    private Integer level;
	@ApiModelProperty("等级名称")
    private String levelText;
	@ApiModelProperty("报单个数")
    private Integer declarationCount;
	@ApiModelProperty("创建时间")
	private Date createDate;
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public Date getCreateDate() {
	
		return createDate;
	}
	public void setCreateDate(Date createDate) {
	
		this.createDate = createDate;
	}
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
	
		this.id = id;
	}
	public String getNumber() {
	
		return number;
	}
	public void setNumber(String number) {
	
		this.number = number;
	}
	public Long getCreateUserId() {
	
		return createUserId;
	}
	public void setCreateUserId(Long createUserId) {
	
		this.createUserId = createUserId;
	}
	public String getCreateUserName() {
	
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
	
		this.createUserName = createUserName;
	}
	public Integer getLevel() {
	
		return level;
	}
	public void setLevel(Integer level) {
	
		this.level = level;
	}
	public String getLevelText() {
	
		return levelText;
	}
	public void setLevelText(String levelText) {
	
		this.levelText = levelText;
	}
	public Integer getDeclarationCount() {
	
		return declarationCount;
	}
	public void setDeclarationCount(Integer declarationCount) {
	
		this.declarationCount = declarationCount;
	}

	
}

