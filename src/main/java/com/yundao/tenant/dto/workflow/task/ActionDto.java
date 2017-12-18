

package com.yundao.tenant.dto.workflow.task;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月21日 上午9:07:47 
 * @author   欧阳利
 * @version   
 */
public class ActionDto {
	@ApiModelProperty(value = "操作值")
	private Integer actionValue;
	@ApiModelProperty(value = "操作名称")
	private String actionText;

	public String getActionText() {
	
		return actionText;
	}
	public void setActionText(String actionText) {
	
		this.actionText = actionText;
	}
	public Integer getActionValue() {
	
		return actionValue;
	}
	public void setActionValue(Integer actionValue) {
	
		this.actionValue = actionValue;
	}

}

