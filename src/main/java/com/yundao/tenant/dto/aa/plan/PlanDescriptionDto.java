

package com.yundao.tenant.dto.aa.plan;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午2:02:13 
 * @author   欧阳利
 * @version   
 */
public class PlanDescriptionDto {
	private Long id;
    @ApiModelProperty("风险测评类型值")
    private Integer riskValue;
    @ApiModelProperty("风险测评类型名称")
    private String riskText;
    @ApiModelProperty("图片说明")
    private String imgDescription;
    @ApiModelProperty("图片url")
    private String imgUrl;
    @ApiModelProperty("评语")
    private String comment;
    @ApiModelProperty("组合收益")
    private Double portfolioIncome;
    @ApiModelProperty("组合风险")
    private Double portfolioRisk;
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
	
		this.id = id;
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
	public String getImgDescription() {
	
		return imgDescription;
	}
	public void setImgDescription(String imgDescription) {
	
		this.imgDescription = imgDescription;
	}
	public String getImgUrl() {
	
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
	
		this.imgUrl = imgUrl;
	}
	public String getComment() {
	
		return comment;
	}
	public void setComment(String comment) {
	
		this.comment = comment;
	}
	public Double getPortfolioIncome() {
	
		return portfolioIncome;
	}
	public void setPortfolioIncome(Double portfolioIncome) {
	
		this.portfolioIncome = portfolioIncome;
	}
	public Double getPortfolioRisk() {
	
		return portfolioRisk;
	}
	public void setPortfolioRisk(Double portfolioRisk) {
	
		this.portfolioRisk = portfolioRisk;
	}
    
}

