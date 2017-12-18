package com.yundao.tenant.enums.product;


/**
 * 字段类型枚举
 *
 * @author jan
 * @create 2017-07-06 PM3:55
 **/
public enum DeclarationModelEnum {

    /**
     * 直接报单
     */
	DECLARATION(1, "直接报单"),
	
    /**
	 * 先预约在报单
	 */
    RESERVATION_AND_DECLARATION(2, "先预约在报单");
	
    private Integer value;
    private String name;
    
    DeclarationModelEnum(Integer value, String name) {
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
