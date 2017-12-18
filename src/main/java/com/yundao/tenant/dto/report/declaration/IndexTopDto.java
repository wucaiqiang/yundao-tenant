

package com.yundao.tenant.dto.report.declaration;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月31日 下午4:46:02 
 * @author   欧阳利
 * @version   
 */
public class IndexTopDto {
    private Long userId;
    
    private Double sumDealAmount;
    
    private String usermame;

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

	public Double getSumDealAmount() {
	
		return sumDealAmount;
	}

	public void setSumDealAmount(Double sumDealAmount) {
	
		this.sumDealAmount = sumDealAmount;
	}

	public String getUsermame() {
	
		return usermame;
	}

	public void setUsermame(String usermame) {
	
		this.usermame = usermame;
	}
    
}

