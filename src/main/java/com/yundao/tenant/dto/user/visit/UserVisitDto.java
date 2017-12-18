
package com.yundao.tenant.dto.user.visit;

import com.yundao.tenant.model.base.customer.BaseUserVisit;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: Reason: Date: 2017年11月28日 上午11:46:02
 * 
 * @author wucq
 * @version
 */
public class UserVisitDto extends BaseUserVisit {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "回访方式文本")
	private String typeText;
	@ApiModelProperty(value = "回访状态文本")
	private String statusText;
	@ApiModelProperty(value = "客户状态")
	private Integer customerStatus;

	@ApiModelProperty(value = "客户状态文本")
	private String customerStatusText;
	@ApiModelProperty(value = "回访人")
	private String userName;

	public String getTypeText() {

		return typeText;
	}

	public void setTypeText(String typeText) {

		this.typeText = typeText;
	}

	public String getStatusText() {

		return statusText;
	}

	public void setStatusText(String statusText) {

		this.statusText = statusText;
	}

	public Integer getCustomerStatus() {
	
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
	
		this.customerStatus = customerStatus;
	}

	public String getCustomerStatusText() {
	
		return customerStatusText;
	}

	public void setCustomerStatusText(String customerStatusText) {
	
		this.customerStatusText = customerStatusText;
	}

	public String getUserName() {
	
		return userName;
	}

	public void setUserName(String userName) {
	
		this.userName = userName;
	}
	

}
