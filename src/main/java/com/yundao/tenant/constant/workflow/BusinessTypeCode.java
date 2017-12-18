package com.yundao.tenant.constant.workflow;

import com.yundao.tenant.enums.ProcessDefineKeyEnum;

/**
 * 业务类型CODE
 *
 * @author jan
 * @create 2017-08-23 PM7:21
 **/
public interface BusinessTypeCode {

    /**
     * 预约
     */
    String RESERVATION = ProcessDefineKeyEnum.RESERVATIN.getKey();// "product_reservation";

    /**
     * 报单
     */
    String DECLARATION = ProcessDefineKeyEnum.DECLARATION.getKey();// "declaration";

    /**
     * 产品审核
     */
    String PRODUCT_AUDIT = ProcessDefineKeyEnum.PRODUCT_AUDIT.getKey(); //"product_audit";

    /**
     * 结佣
     */
    String KNOT_COMMISSION = ProcessDefineKeyEnum.KNOT_COMMISSION.getKey();// "knot_commission";
    
    /**
     * 退款审批
     */
    String REFUND =ProcessDefineKeyEnum.REFUND.getKey();//  "refund";
    
    
    /**
     * 产品公告审核
     */
    String PRODUCT_NOTICE = ProcessDefineKeyEnum.PRODUCT_NOTICE.getKey();//"product_notice";
    
    /**
	 * 立项会审批
	 */
    String PROJECT_DECISION = ProcessDefineKeyEnum.PROJECT_DECISION.getKey();
	
    /**
	 * 尽职调查审批
	 */
    String PROJECT_DUE_DILIGENCE = ProcessDefineKeyEnum.PROJECT_DUE_DILIGENCE.getKey();
	

    /**
	 * 初审审批
	 */
    String PROJECT_TIRST_TRIAL = ProcessDefineKeyEnum.PROJECT_FIRST_TRIAL.getKey();
	
    /**
	 * 投委会审批
	 */
    String PROJECT_INVESTMENT_COMMITTEE = ProcessDefineKeyEnum.PROJECT_INVESTMENT_COMMITTEE.getKey();
	
	
    /**
	 * 出资审批
	 */
    String PROJECT_INVEST = ProcessDefineKeyEnum.PROJECT_INVEST.getKey();
    
}
