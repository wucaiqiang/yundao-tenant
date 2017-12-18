
package com.yundao.tenant.dto.report;

import java.io.Serializable;

/**
 * Function: Reason: Date: 2017年9月19日 下午3:28:40
 * 
 * @author wucq
 * @version
 */
public class AfpReportDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 理财师ID
	 */
	private Long userId;
	/**
	 * 理财师名称
	 */
	private String userName;
	/**
	 * 总额
	 */
	private Double money;
	public Long getUserId() {
	
		return userId;
	}
	public void setUserId(Long userId) {
	
		this.userId = userId;
	}
	public String getUserName() {
	
		return userName;
	}
	public void setUserName(String userName) {
	
		this.userName = userName;
	}
	public Double getMoney() {
	
		return money;
	}
	public void setMoney(Double money) {
	
		this.money = money;
	}
	

}
