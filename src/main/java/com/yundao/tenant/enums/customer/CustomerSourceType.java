

package com.yundao.tenant.enums.customer;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月19日 下午5:03:48 
 * @author   欧阳利
 * @version   
 */
public enum CustomerSourceType {
	/**
     * 领取
     */
	RECEIVE(2, "领取"),
    /**
     * 自建
     */
	SELF_BUILT(0, "自建"),
    /**
     * 分配
     */
	DISTRIBUTION(1, "分配");
	
    private Integer value;
    private String name;
	
	CustomerSourceType(Integer value, String name) {
	        this.value = value;
	        this.name = name;
	    }

	public Integer getValue() {
	
		return value;
	}

	public void setValue(Integer value) {
	
		this.value = value;
	}

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}
	
}

