

package com.yundao.tenant.dto.report.customer;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午11:04:05 
 * @author   欧阳利
 * @version   
 */
public class DepartmentUserAddCustomerReportDto {
    private String date;
    
    private Integer sumCount;
    
    private String startDate;
    
    private String endDate;
    
    private Integer orderIndex;

	public String getDate() {
	
		return date;
	}

	public void setDate(String date) {
	
		this.date = date;
	}

	public Integer getSumCount() {
	
		return sumCount;
	}

	public void setSumCount(Integer sumCount) {
	
		this.sumCount = sumCount;
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

