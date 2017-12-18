

package com.yundao.tenant.dto.aa.plan;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午2:52:50 
 * @author   欧阳利
 * @version   
 */
public class PieDto {
	
	@ApiModelProperty("类型名称")
    private String classCodeName;
	@ApiModelProperty("类型所占比例")
    private Double investmentRatio;

	public String getClassCodeName() {
	
		return classCodeName;
	}

	public void setClassCodeName(String classCodeName) {
	
		this.classCodeName = classCodeName;
	}

	public Double getInvestmentRatio() {
	
		return investmentRatio;
	}

	public void setInvestmentRatio(Double investmentRatio) {
	
		this.investmentRatio = investmentRatio;
	}
    
    
}

