package com.yundao.tenant.dto.report.declaration;

public class UserDeclarationRankResDto {
   private Double sumDealAmount;
   
   private Long userId;
   
   private String username;
   
   private Double maxSumDealAmount;

	public Double getMaxSumDealAmount() {

	return maxSumDealAmount;
}

public void setMaxSumDealAmount(Double maxSumDealAmount) {

	this.maxSumDealAmount = maxSumDealAmount;
}

	public Double getSumDealAmount() {
		return sumDealAmount;
	}
	
	public void setSumDealAmount(Double sumDealAmount) {
		this.sumDealAmount = sumDealAmount;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
	
		return username;
	}

	public void setUsername(String username) {
	
		this.username = username;
	}

   
}
