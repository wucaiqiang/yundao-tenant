

package com.yundao.tenant.dto.report.customer;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午10:00:33 
 * @author   欧阳利
 * @version   
 */
public class DepartAddCustReportResDto implements Comparable<DepartAddCustReportResDto> {
	@ApiModelProperty("部门id")
    private Long departmentId;
	@ApiModelProperty("部门id")
    private String departmentName;
	@ApiModelProperty("部门code")
    private String departmentCode;
	@ApiModelProperty("新增客户总个数")
    private Integer sumCount;
	@ApiModelProperty("是否有下级部门")
    private Boolean hasChildDepartment;
	@ApiModelProperty("员工id")
    private Long userId;
	@ApiModelProperty("员工姓名")
    private String username;

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

	public String getDepartmentCode() {
	
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
	
		this.departmentCode = departmentCode;
	}

	public Integer getSumCount() {
	
		return sumCount;
	}

	public void setSumCount(Integer sumCount) {
	
		this.sumCount = sumCount;
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

	@Override
	public int compareTo(DepartAddCustReportResDto arg0) {
		  return arg0.getSumCount().compareTo(this.getSumCount());
	}
}

