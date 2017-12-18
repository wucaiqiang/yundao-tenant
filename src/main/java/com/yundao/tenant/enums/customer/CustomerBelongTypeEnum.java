

package com.yundao.tenant.enums.customer;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月19日 下午5:03:48 
 * @author   欧阳利
 * @version   
 */
public enum CustomerBelongTypeEnum {

    /**
     * 私人
     */
	PRIVATE(0, "私人"),
	
    /**
     * 销售线索
     */
	SALE_CLUE(2, "销售线索"),
    /**
     * 公海
     */
	OPENSEA(1, "公海");
	
    private Integer value;
    private String name;
	
	CustomerBelongTypeEnum(Integer value, String name) {
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

