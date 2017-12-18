

package com.yundao.tenant.dto.report.customer;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午11:02:13 
 * @author   欧阳利
 * @version   
 */
public class UserAddCustomerRankResDto {
	   private Integer sumCount;
	   
	   private Long userId;
	   
	   private String username;
	   
	   private Integer maxSumCount;

	public Integer getSumCount() {
	
		return sumCount;
	}

	public void setSumCount(Integer sumCount) {
	
		this.sumCount = sumCount;
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

	public Integer getMaxSumCount() {
	
		return maxSumCount;
	}

	public void setMaxSumCount(Integer maxSumCount) {
	
		this.maxSumCount = maxSumCount;
	}
}

