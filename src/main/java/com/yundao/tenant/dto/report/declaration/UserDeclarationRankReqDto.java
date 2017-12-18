package com.yundao.tenant.dto.report.declaration;

import com.yundao.tenant.dto.AbstractBasePageDto;

public class UserDeclarationRankReqDto extends AbstractBasePageDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long departmentId;
	private Long userId;
	private Integer filterType;
	private String customStart;
	   
    private String customEnd;
	
	private String startDate;
	
	private String endDate;
	
	public Integer getFilterType() {
	
		return filterType;
	}

	public void setFilterType(Integer filterType) {
	
		this.filterType = filterType;
	}

	public String getCustomStart() {
	
		return customStart;
	}

	public void setCustomStart(String customStart) {
	
		this.customStart = customStart;
	}

	public String getCustomEnd() {
	
		return customEnd;
	}

	public void setCustomEnd(String customEnd) {
	
		this.customEnd = customEnd;
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

	private String departmentCode;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}


	
}
