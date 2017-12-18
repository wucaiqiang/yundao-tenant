

package com.yundao.tenant.dto.report.declaration;

import java.util.List;

import com.yundao.core.pagination.PaginationSupport;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月1日 上午9:00:03 
 * @author   欧阳利
 * @version   
 */
public class DepartmentUserDeclarationReportDetailDto {
	
	private String departmentName;
	
	private String userName;
	
	@ApiModelProperty("部门/员工报表")
    private List<DepartmentUserReportDto> reportDtos;

	@ApiModelProperty("报单列表")
    private PaginationSupport<DepartmentUserDeclarationDto> declarationDtos;

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
	public List<DepartmentUserReportDto> getReportDtos() {
	
		return reportDtos;
	}
	public void setReportDtos(List<DepartmentUserReportDto> reportDtos) {
	
		this.reportDtos = reportDtos;
	}
	public PaginationSupport<DepartmentUserDeclarationDto> getDeclarationDtos() {
	
		return declarationDtos;
	}
	public void setDeclarationDtos(PaginationSupport<DepartmentUserDeclarationDto> declarationDtos) {
	
		this.declarationDtos = declarationDtos;
	}

}

