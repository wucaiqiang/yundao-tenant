

package com.yundao.tenant.dto.report.declaration.customer;

import java.util.List;

import com.yundao.tenant.dto.sale.declaration.DeclarationUserDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月6日 上午10:58:24 
 * @author   欧阳利
 * @version   
 */
public class DeclarationRankResDto {
    private Long customerId;
    
    private String customerName;
    
    private Double sumDealAmount;
    
    private Integer declarationCount;
    
    private Double maxSumDealAmount;
    
    private List<DeclarationUserDto> userDtos;

	public Double getMaxSumDealAmount() {
	
		return maxSumDealAmount;
	}

	public void setMaxSumDealAmount(Double maxSumDealAmount) {
	
		this.maxSumDealAmount = maxSumDealAmount;
	}

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}

	public String getCustomerName() {
	
		return customerName;
	}

	public void setCustomerName(String customerName) {
	
		this.customerName = customerName;
	}

	public Double getSumDealAmount() {
	
		return sumDealAmount;
	}

	public void setSumDealAmount(Double sumDealAmount) {
	
		this.sumDealAmount = sumDealAmount;
	}

	public Integer getDeclarationCount() {
	
		return declarationCount;
	}

	public void setDeclarationCount(Integer declarationCount) {
	
		this.declarationCount = declarationCount;
	}

	public List<DeclarationUserDto> getUserDtos() {
	
		return userDtos;
	}

	public void setUserDtos(List<DeclarationUserDto> userDtos) {
	
		this.userDtos = userDtos;
	}

	
    
    
}

