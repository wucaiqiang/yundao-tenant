

package com.yundao.tenant.dto.customercenter;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月11日 下午3:12:45 
 * @author   欧阳利
 * @version   
 */
public class MyIndexDto {
	
	@ApiModelProperty("认定结果得分")
    private Integer grade;
    
	@ApiModelProperty("类型值")
    private Integer riskValue;
    
	@ApiModelProperty("类型名称")
    private String riskText;
	
	@ApiModelProperty("手机号码")
	private String mobile;

	public Integer getGrade() {
	
		return grade;
	}

	public void setGrade(Integer grade) {
	
		this.grade = grade;
	}

	public Integer getRiskValue() {
	
		return riskValue;
	}

	public void setRiskValue(Integer riskValue) {
	
		this.riskValue = riskValue;
	}

	public String getRiskText() {
	
		return riskText;
	}

	public void setRiskText(String riskText) {
	
		this.riskText = riskText;
	}

	public String getMobile() {
	
		return mobile;
	}

	public void setMobile(String mobile) {
	
		this.mobile = mobile;
	}
	
	
}

