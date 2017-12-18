

package com.yundao.tenant.dto.report.customer;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午11:02:03 
 * @author   欧阳利
 * @version   
 */
public class UserAddCustomerRankReqDto extends AbstractBasePageDto{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("部门id")
	private Long departmentId;
	@ApiModelProperty("部门code")
	private String departmentCode;
	@ApiModelProperty("用户id")
	private Long userId;
	@ApiModelProperty("过滤类型")
	private Integer filterType;
	@ApiModelProperty("开始日期")
	private String customStart;
	@ApiModelProperty("结束日期")
    private String customEnd;

	
	private String startDate;
	
	private String endDate;

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

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

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

	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}
	
}

