

package com.yundao.tenant.dto.report.declaration.customer;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月6日 下午5:11:17 
 * @author   欧阳利
 * @version   
 */
public class CustomerDeclarationReqDto extends AbstractBasePageDto{
	
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("客户id")
	private Long customerId;
	
	@ApiModelProperty("筛选")
    private Integer filterType;
    
    @ApiModelProperty("自定义筛选开始时间")
    private String customStart;
    
    @ApiModelProperty("自定义筛选结束时间")
    private String customEnd;
    

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
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
    
}

