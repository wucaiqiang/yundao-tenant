

package com.yundao.tenant.dto.report.customer;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月2日 上午11:10:58 
 * @author   欧阳利
 * @version   
 */
public class DepartmentAndUserDetailReqDto extends AbstractBasePageDto{

	private static final long serialVersionUID = 1L;
	private Long departmentId;
    
    private Long userId;
    
    @ApiModelProperty("筛选1:自定义，2：本月, 3：上个月, 4：本季度, 5：上一季度, 6：本年度, 6：上一年度")
    private Integer filterType;
    
    private String customStart;
    
    private String customEnd;
    @ApiModelProperty("自定义分组1：天，  2： 周， 3： 月")
    private String statType;
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
	public String getStatType() {
	
		return statType;
	}
	public void setStatType(String statType) {
	
		this.statType = statType;
	}
    
    
    
}

