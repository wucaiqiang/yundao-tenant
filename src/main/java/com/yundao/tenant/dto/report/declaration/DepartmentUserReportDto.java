

package com.yundao.tenant.dto.report.declaration;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月4日 上午9:27:59 
 * @author   欧阳利
 * @version   
 */
public class DepartmentUserReportDto {
    private String date;
    
    private Double sumDealAmount;
    
    private String startDate;
    
    private String endDate;
    
    private Integer orderIndex;


	public String getDate() {
	
		return date;
	}

	public void setDate(String date) {
	
		this.date = date;
	}

	public Double getSumDealAmount() {
	
		return sumDealAmount;
	}

	public void setSumDealAmount(Double sumDealAmount) {
	
		this.sumDealAmount = sumDealAmount;
	}

	public String getStartDate() {
	
		return startDate;
	}

	public void setStartDate(String startDate) {
	
		this.startDate = startDate;
	}

	public String getEndDate() {
	
		return endDate;
	}

	public void setEndDate(String endDate) {
	
		this.endDate = endDate;
	}

	public Integer getOrderIndex() {
	
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
	
		this.orderIndex = orderIndex;
	}
    
    
}

