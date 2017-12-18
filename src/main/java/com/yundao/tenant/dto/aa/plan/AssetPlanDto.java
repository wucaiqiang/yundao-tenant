

package com.yundao.tenant.dto.aa.plan;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午2:03:06 
 * @author   欧阳利
 * @version   
 */
public class AssetPlanDto {
   @ApiParam("测评id")
   private Long id;
   @ApiParam("理财师id")
   private Long userId;
   @ApiParam("理财师名称")
   private String username;
   @ApiParam("理财师手机号码")
   private String userMobile;
   @ApiParam("客户id")
   private Long customerId;

   @ApiModelProperty("饼图")
   private List<PieDto> pie;
   
   @ApiParam("客户名称")
   private String customerName;
   
   @ApiModelProperty("评语")
   private String comment;
   @ApiModelProperty("组合收益")
   private Double portfolioIncome;
   @ApiModelProperty("组合风险")
   private Double portfolioRisk;
   @ApiModelProperty("风险测评类型值")
   private Integer riskValue;
   @ApiModelProperty("风险测评类型名称")
   private String riskText;
   



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

	public String getUsername() {

	return username;
}

public void setUsername(String username) {

	this.username = username;
}

public String getCustomerName() {

	return customerName;
}

public void setCustomerName(String customerName) {

	this.customerName = customerName;
}

	public Long getId() {
	
		return id;
	}
	
	public void setId(Long id) {
	
		this.id = id;
	}
	
	public Long getUserId() {
	
		return userId;
	}
	
	public void setUserId(Long userId) {
	
		this.userId = userId;
	}
	
	public Long getCustomerId() {
	
		return customerId;
	}
	
	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}

	public String getUserMobile() {
	
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
	
		this.userMobile = userMobile;
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

	public List<PieDto> getPie() {
	
		return pie;
	}

	public void setPie(List<PieDto> pie) {
	
		this.pie = pie;
	}

}

