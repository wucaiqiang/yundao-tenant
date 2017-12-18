

package com.yundao.tenant.dto.report.declaration.customer;

import java.util.List;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月6日 上午10:58:12 
 * @author   欧阳利
 * @version   
 */
public class DeclarationRankReqDto extends AbstractBasePageDto  {
	
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("筛选")
    private Integer filterType;
    
    @ApiModelProperty("自定义筛选开始时间")
    private String customStart;
    
    @ApiModelProperty("自定义筛选结束时间")
    private String customEnd;
    
    @ApiModelProperty("成单理财师Id")
    private Long userId;
    
    @ApiModelProperty("客户类型，默认为空，所有客户, 1:首次成单客户  2： 多次成单客户")
    private Integer customerType;
    
    private List<Long> customerIds;
    
    private Long departmentId;
    
    private String departmentCode;
    

	public Long getDepartmentId() {
	
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
	
		this.departmentId = departmentId;
	}

	public String getDepartmentCode() {
	
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
	
		this.departmentCode = departmentCode;
	}

	public List<Long> getCustomerIds() {
	
		return customerIds;
	}

	public void setCustomerIds(List<Long> customerIds) {
	
		this.customerIds = customerIds;
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

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

	public Integer getCustomerType() {
	
		return customerType;
	}

	public void setCustomerType(Integer customerType) {
	
		this.customerType = customerType;
	}
    
    
    
}

