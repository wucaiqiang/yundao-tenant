

package com.yundao.tenant.dto.report.declaration;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月1日 上午10:00:50 
 * @author   欧阳利
 * @version   
 */
public class DepartmentReportDto  implements Comparable<DepartmentReportDto>{
    private Long departmentId;
    
    private String departmentName;
    
    private String departmentCode;
    
    private Double sumDealAmount;
    
    private Boolean hasChildDepartment;
    
    private Long userId;
    
    private String username;

	public String getDepartmentCode() {
	
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
	
		this.departmentCode = departmentCode;
	}

	public Long getDepartmentId() {
	
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
	
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
	
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
	
		this.departmentName = departmentName;
	}

	public Double getSumDealAmount() {
	
		return sumDealAmount;
	}

	public void setSumDealAmount(Double sumDealAmount) {
	
		this.sumDealAmount = sumDealAmount;
	}

	public Boolean getHasChildDepartment() {
	
		return hasChildDepartment;
	}

	public void setHasChildDepartment(Boolean hasChildDepartment) {
	
		this.hasChildDepartment = hasChildDepartment;
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
    
	public int compareTo(DepartmentReportDto arg0) {
        return arg0.getSumDealAmount().compareTo(this.getSumDealAmount());
    }
}

