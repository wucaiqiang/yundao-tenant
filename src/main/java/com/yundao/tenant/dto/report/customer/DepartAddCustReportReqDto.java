

package com.yundao.tenant.dto.report.customer;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午10:08:01 
 * @author   欧阳利
 * @version   
 */
public class DepartAddCustReportReqDto {
	@ApiModelProperty("部门id")
    private Long departmentId;
    @ApiModelProperty("筛选1:自定义，2：本月, 3：上个月, 4：本季度, 5：上一季度, 6：本年度, 7：上一年度")
    private Integer filterType;
    @ApiModelProperty("自定义筛选开始时间")
    private Date customStart;
    @ApiModelProperty("自定义筛选结束时间")
    private Date customEnd;
	public Long getDepartmentId() {
	
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
	
		this.departmentId = departmentId;
	}
	public Integer getFilterType() {
	
		return filterType;
	}
	public void setFilterType(Integer filterType) {
	
		this.filterType = filterType;
	}
	public Date getCustomStart() {
	
		return customStart;
	}
	public void setCustomStart(Date customStart) {
	
		this.customStart = customStart;
	}
	public Date getCustomEnd() {
	
		return customEnd;
	}
	public void setCustomEnd(Date customEnd) {
	
		this.customEnd = customEnd;
	}
}

