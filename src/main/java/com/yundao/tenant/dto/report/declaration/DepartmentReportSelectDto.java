

package com.yundao.tenant.dto.report.declaration;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月2日 下午2:47:10 
 * @author   欧阳利
 * @version   
 */
public class DepartmentReportSelectDto {
	 private String departmentCode;
	 
	 private Long departmentId;
	 
	 private String range;
	 
	 private String startDate;
	 
	 private String endDate;

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

	public String getRange() {
	
		return range;
	}

	public void setRange(String range) {
	
		this.range = range;
	}
}

