

package com.yundao.tenant.enums.sale.declaration;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月5日 上午11:42:18 
 * @author   欧阳利
 * @version   
 */
public enum DeclarationVideoTypeEnum {

    /**
     * 合规双录
     */
	 COMPLIANCE_RECORD(1, "合规双录");
	
    private Integer value;
    private String name;

    DeclarationVideoTypeEnum(Integer value, String name) {
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

