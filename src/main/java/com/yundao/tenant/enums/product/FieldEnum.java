package com.yundao.tenant.enums.product;


/**
 * 字段类型枚举
 *
 * @author jan
 * @create 2017-07-06 PM3:55
 **/
public enum FieldEnum {

	
    /**
     * 认购费
     */
    PRO_BUY_FEE("product_pro_buy_fee", "认购费"),
    /**
	 * 管理费
	 */
    PRO_MANAGE_FEE("product_pro_manage_fee", "管理费"),
    /**
     * 投资标的
     */
    INVEST_DOMAIN("product_invest_domain", "投资标的"),
    /**
     * 发行通道
     */
    ISSUED_CHANNEL("product_issued_channel", "发行通道"),
    /**
     * 投资币种
     */
	CURRENCY_CODE("product_currency_code", "投资币种");
	
    private String code;
    private String name;
    
    FieldEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
	public String getCode() {
	
		return code;
	}

	public void setCode(String code) {
	
		this.code = code;
	}

	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}

}
