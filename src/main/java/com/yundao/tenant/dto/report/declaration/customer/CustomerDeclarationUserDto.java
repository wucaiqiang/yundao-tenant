

package com.yundao.tenant.dto.report.declaration.customer;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月6日 上午11:05:04 
 * @author   欧阳利
 * @version   
 */
public class CustomerDeclarationUserDto {
	/**
	 * 报单id
	 */
    private Long id;
    
    private Long userId;
    
    private Long customerId;
    
    private String username;

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public String getUsername() {
	
		return username;
	}

	public void setUsername(String username) {
	
		this.username = username;
	}

    
}

