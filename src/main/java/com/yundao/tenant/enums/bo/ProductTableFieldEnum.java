package com.yundao.tenant.enums.bo;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FiledSelectDto;

/**
 * 字段类型枚举
 *
 * @author jan
 * @create 2017-07-06 PM3:55
 **/
public enum ProductTableFieldEnum {

	
    /**
     * 产品名称
     */
    NAME("product_name", "name"),
    /**
	 * 投资标的
	 */
    INVEST_DOMAIN("product_invest_domain", "investDomain"),
    
    /**
	 *  投资期限
	 */
    TIME_LIMIT("product_time_limit", "timeLimit"),
    
    /**
	 *  管理机构
	 */
    MECHANISM("product_mechanism", "mechanism"),
    
    /**
	 * 认购起点
	 */
    BUY_START_POINT("product_buy_start_point", "buyStartPoint"),
    
    /**
	 * 递增金额
	 */
    INCREMENTAL_AMOUNT("product_Incremental_amount", "incrementalAmount"),
    
    /**
	 * 投资人数上限
	 */
    BUY_PERSON_LIMIT("product_buy_person_count_limit", "buyPersonLimit"),
    
    /**
	 * 产品等级
	 */
    LEVEL("product_level", "level"),
    
    /**
	 * 风险等级
	 */
    RISK_LEVEL("product_risk_level", "riskLevel"),
    
    
    /**
	 * 产品对接人
	 */
    RECEIVER_ID("product_receiver_id", "receiverId"),
    
    /**
	 * 产品助理
	 */
    ASSISTANT_ID("product_assistant_id", "assistantId"),
    
    
    /**
	 * 简要亮点
	 */
    HIGHLIGHT("product_highlight", "highlight"),
    
    /**
     * 微信版本
     */
    WX_CONTENT("product_wx_content", "wxContent"),
    
    
    /**
	 * 是否有规模
	 */
    IS_SCALE("product_is_scale", "isScale"),
    
    /**
	 * 产品规模
	 */
    PRODUCT_SCALE("product_product_scale", "productScale"),
    
    /**
	 * 投资币种
	 */
    CURRENCY_CODE("product_currency_code", "currencyCode"),
    
    /**
	 * 打款账号
	 */
    PAY_ACCOUNT("product_pay_account", "payAccount"),
    
    /**
	 * 发行通道
	 */
	ISSUED_CHANNEL("product_issued_channel", "issuedChannel"),
   
	/**
	 * 打款账号
	 */
	ACCOUNT_NAME("product_account_name", "accountName"),
	
	/**
	 * 募集银行
	 */
	RAISE_BANK("product_raise_bank", "raiseBank"),
	
	/**
	 * 打款备注
	 */
	PAY_REMARK("product_pay_remark", "payRemark"),
	
	
    /**
     * 到期时间
     */
    MATURITY_DATE("product_maturity_date", "maturityDate"),
	
	
    /**
	 * 拟销售日期
	 */
	SALE_DATE("product_sale_start_date", "saleDate");
	
    private String fieldName;
    private String propertyName;
    private static Map<String, ProductTableFieldEnum> enumMap = new HashMap<>();
    private static Map<String, ProductTableFieldEnum> fieldEnumMap = new HashMap<>();
    private static Map<String, ProductTableFieldEnum> productSaleMap = new HashMap<>();
    private static Map<String, ProductTableFieldEnum> appNotContainsMap = new HashMap<>();
    

    static {
        EnumSet<ProductTableFieldEnum> set = EnumSet.allOf(ProductTableFieldEnum.class);
        for (ProductTableFieldEnum each : set) {
            enumMap.put(each.getPropertyName(), each);
            fieldEnumMap.put(each.getFieldName(), each);
        }
        productSaleMap.put(IS_SCALE.getPropertyName(), IS_SCALE);
        productSaleMap.put(PRODUCT_SCALE.getPropertyName(), PRODUCT_SCALE);
        productSaleMap.put(CURRENCY_CODE.getPropertyName(), CURRENCY_CODE);
        productSaleMap.put(PAY_ACCOUNT.getPropertyName(), PAY_ACCOUNT);
        productSaleMap.put(SALE_DATE.getPropertyName(), SALE_DATE);
        productSaleMap.put(RAISE_BANK.getPropertyName(), RAISE_BANK);
        productSaleMap.put(PAY_REMARK.getPropertyName(), PAY_REMARK);
        productSaleMap.put(ACCOUNT_NAME.getPropertyName(), ACCOUNT_NAME);
        
        
        appNotContainsMap.put(HIGHLIGHT.getPropertyName(), HIGHLIGHT);
        appNotContainsMap.put(WX_CONTENT.getPropertyName(), WX_CONTENT);
    }

    ProductTableFieldEnum(String fieldName, String propertyName) {
        this.fieldName = fieldName;
        this.propertyName = propertyName;
    }

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

    public static void resetPropertyName(List<FieldDto> list){
    	if(BooleanUtils.isEmpty(list)){
    		return;
    	}
    	for(FieldDto dto:list){
    		ProductTableFieldEnum field = fieldEnumMap.get(dto.getName());
    		if(field != null){
    			dto.setName(field.getPropertyName());
    		}
    	}
    }
    
    
    public static void resetFiledSelectPropertyName(List<FiledSelectDto> list){
    	if(BooleanUtils.isEmpty(list)){
    		return;
    	}
    	for(FiledSelectDto dto:list){
    		ProductTableFieldEnum field = fieldEnumMap.get(dto.getName());
    		if(field != null){
    			dto.setName(field.getPropertyName());
    		}
    	}
    }
    
    
    public static void removeProductSale(List<FieldDto> list){
    	if(BooleanUtils.isEmpty(list)){
    		return;
    	}
    	List<FieldDto> saleDtos = new ArrayList<FieldDto>();
    	for(FieldDto dto:list){
    		for(String name:productSaleMap.keySet()){
    			if(dto.getName().equals(name)){
    				saleDtos.add(dto);
    			}
    		}
    	}
    	
    	list.removeAll(saleDtos);
    }

	public static Map<String, ProductTableFieldEnum> getProductSaleMap() {
		return productSaleMap;
	}

	public static Map<String, ProductTableFieldEnum> getAppNotContainMap() {
		return appNotContainsMap;
	}
	
	public static List<String> getAppNotContainPropertyNames() {
		Set<String> set = appNotContainsMap.keySet();
		List<String> list = new ArrayList<String>(set);  
		return list;
	}
}
