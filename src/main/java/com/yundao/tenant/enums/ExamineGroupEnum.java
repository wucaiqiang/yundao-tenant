package com.yundao.tenant.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


/**
 * 工作流 审核组
 * 
 * @author 欧阳利
 * 2017年8月31日
 */
public enum ExamineGroupEnum {
	
	/**
	 * 预约审核组reservation
	 */
	PRODUCT_RESERVATION_GROUP("product_reservation", "reservation.audit.do"),
	
	/**
	 * 报单审核组
	 */
	DECLARATION_GROUP("declaration", "declaration.audit.do"),

	/**
	 * 产品公告
	 */
	PRODUCT_NOTICE_GROUP("product_notice", "product.notice.flow"),

	
    /**
	 * 结佣审批
	 */
	KNOT_COMMISSION("knot_commission", "knot.commission.audit"),
	
	
    /**
	 * 退款审批
	 */
	REFUND("refund", "refund.audit.do"),
	
    /**
     * 立项会审批
     */
    PROJECT_DECISION("project_decision", "assets.project.decision.audit_decisioning"),

    /**
     * 尽职调查审批
     */
    PROJECT_DUE_DILIGENCE("project_due_diligence", "assets.project.decision.audit_due_diligence"),

    /**
     * 初审审批
     */
    PROJECT_FIRST_TRIAL("project_first_trial", "assets.project.decision.audit_first_trial"),

    /**
     * 投委会审批
     */
    PROJECT_INVESTMENT_COMMITTEE("project_investment_committee", "assets.project.decision.audit_investment_commission"),

    /**
     * 出资审批
     */
    PROJECT_INVEST("project_invest", "assets.project.decision.audit_invest"),
	
	
	/**
	 * 产品审核组
	 */
	PRODUCT_AUDIT_GROUP("product_audit", "product.examine.audit");
	
	private String groupCode;
	private String resourceCode;
	
    
    
    public static List<String> getAllGroupCodes(){
    	EnumSet<ExamineGroupEnum> set = EnumSet.allOf(ExamineGroupEnum.class);
    	List<String> list = new ArrayList<String>();
    	for (ExamineGroupEnum each : set) {
    		list.add(each.getGroupCode());
        }
    	return list;
    }
    
	
	public static String getGroupCode(String resourceCode){
		EnumSet<ExamineGroupEnum> set = EnumSet.allOf(ExamineGroupEnum.class);
        for (ExamineGroupEnum each : set) {
        	if(each.getResourceCode().equals(resourceCode)){
    			return each.groupCode;
    		}
        }
		return null;
	}
	

	private ExamineGroupEnum(String groupCode, String resourceCode) {
		this.groupCode = groupCode;
		this.resourceCode = resourceCode;
	}

	public static List<String> getAllResourceCodeAll(){
		EnumSet<ExamineGroupEnum> set = EnumSet.allOf(ExamineGroupEnum.class);
    	List<String> list = new ArrayList<String>();
    	for (ExamineGroupEnum each : set) {
    		list.add(each.getResourceCode());
        }
    	return list;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	




}
