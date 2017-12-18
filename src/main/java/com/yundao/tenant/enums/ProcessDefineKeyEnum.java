package com.yundao.tenant.enums;

import java.util.EnumSet;

/**
 * 工作流 流程定义key
 * 
 * @author 欧阳利
 * 2017年8月31日
 */
public enum ProcessDefineKeyEnum {

    /**
     * 产品审核
     */
    PRODUCT_AUDIT("product_audit","产品上线审批"),

    /**
     * 报单审核
     */
    DECLARATION("declaration","报单审批"),
    
    /**
	 * 产品公告
	 */
	PRODUCT_NOTICE("product_notice", "公告发布审批"),

    /**
	 * 结佣
	 */
	KNOT_COMMISSION("knot_commission", "结佣申请审批"),
	
	
    /**
	 * 申请退款
	 */
	REFUND("refund", "申请退款"),
	
	
    /**
	 * 立项会审批
	 */
	PROJECT_DECISION("project_decision", "立项会审批"),
	
    /**
	 * 尽职调查审批
	 */
	PROJECT_DUE_DILIGENCE("project_due_diligence", "立项会审批"),
	

    /**
	 * 初审审批
	 */
	PROJECT_FIRST_TRIAL("project_first_trial", "初审审批"),
	
    /**
	 * 投委会审批
	 */
	PROJECT_INVESTMENT_COMMITTEE("project_investment_committee", "投委会审批"),
	
    /**
	 * 出资审批
	 */
	PROJECT_INVEST("project_invest", "出资审批"),
	
    /**
     * 预约审核
     */
    RESERVATIN("product_reservation","预约额度审批");

    private String key;
    private String name;

    public static String getName(String key){
    	EnumSet<ProcessDefineKeyEnum> set = EnumSet.allOf(ProcessDefineKeyEnum.class);
    	for (ProcessDefineKeyEnum each : set) {
    		if(each.getKey().equals(key)){
    			return each.getName();
    		}
        }
    	return null;
    }
    
    private ProcessDefineKeyEnum(String key,String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}
}
