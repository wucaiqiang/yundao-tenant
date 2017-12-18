

package com.yundao.tenant.dto.sale.declaration;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午3:44:01 
 * @author   欧阳利
 * @version   
 */
public class DeclarationUserReqDto {
    private Integer filterType;
    
    private String customStart;
    
    private String customEnd;

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

