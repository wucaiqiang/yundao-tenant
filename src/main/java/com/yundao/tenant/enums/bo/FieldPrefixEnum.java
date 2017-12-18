package com.yundao.tenant.enums.bo;

public enum FieldPrefixEnum {
	 /**
     * 产品名称
     */
    PRODUCT("product_");
    
	private String prefix;
	
	FieldPrefixEnum(String prefix) {
	    this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
}
