

package com.yundao.tenant.dto.report.customer;

import java.util.List;

import com.yundao.core.pagination.PaginationSupport;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午11:11:10 
 * @author   欧阳利
 * @version   
 */
public class DepartmentAndUserDetailResDto {
	private String departmentName;
	
	private String userName;
	
	@ApiModelProperty("部门/员工报表")
    private List<DepartmentUserAddCustomerReportDto> reportDtos;

	@ApiModelProperty("客户列表")
    private PaginationSupport<CustomerReportDto> customerDtos;

	public String getDepartmentName() {
	
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
	
		this.departmentName = departmentName;
	}

	public String getUserName() {
	
		return userName;
	}

	public void setUserName(String userName) {
	
		this.userName = userName;
	}

	public List<DepartmentUserAddCustomerReportDto> getReportDtos() {
	
		return reportDtos;
	}

	public void setReportDtos(List<DepartmentUserAddCustomerReportDto> reportDtos) {
	
		this.reportDtos = reportDtos;
	}

	public PaginationSupport<CustomerReportDto> getCustomerDtos() {
	
		return customerDtos;
	}

	public void setCustomerDtos(PaginationSupport<CustomerReportDto> customerDtos) {
	
		this.customerDtos = customerDtos;
	}
	
}

