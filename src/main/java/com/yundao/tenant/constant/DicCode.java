package com.yundao.tenant.constant;

/**
 * 数据字典编码
 *
 * @author jan
 * @create 2017-07-16 PM7:51
 **/
public interface DicCode {

    /** ###################数据字典 gjl start################## */
    /**
     * 跟进方式
     */
    String FOLLOW_TYPE = "dic_follow_up_type";
    /**
     * 跟进状态
     */
    String FOLLOW_STATUS = "dic_follow_up_status";

    /**
     * 通知二级类型
     */
    String MSG_MESSAGE_TWO_TYPE = "dic_msg_message_two_type";
    /**
     * 通知一级类型
     */
    String MSG_MESSAGE_FIRST_TYPE = "dic_msg_message_frist_type";
    /**
     * 动态类型
     */
    String MSG_FEED_TYPE = "dic_msg_feed_type";
    /**
     * 跟进状态
     */
    String DIC_FOLLOW_UP_STATUS = "dic_follow_up_status";
    /**
     * 跟进类型
     */
    String DIC_FOLLOW_UP_TYPE = "dic_follow_up_type";

    /**
     * 销售线索类型
     */
    String LEADS_TYPE = "dic_leads_type";

    /**
     * 销售线索渠道
     */
    String LEADS_CHANNEL = "dic_leads_channel";

    /**
     * 销售线索状态
     */
    String LEADS_STATUS = "dic_leads_status";

    /**
     * 客户状态
     */
    String CUSTOMER_STATUS = "dic_customer_status";

    /**
     * 销售线索回访状态
     */
    String LEADS_VISIT_STATUS = "dic_leads_visit_status";

    /**
     * 结佣管理状态
     */
    String DIC_KNOTCOMMISSION_STATUS = "dic_knotcommission_status";

    /** ###################数据字典 gjl end#################### */

    /**
     * 要素类型/字段类型
     */
    String FIELD_TYPE = "field_type";

    /**
     * 业务对象类型
     */
    String BUSINESS_TYPE = "_type";


    /**
     * 客户回访方式
     */
    String DIC_USER_VISIT_TYPE = "dic_user_visit_type";

    /**
     * 客户回访状态
     */
    String DIC_USER_VISIT_STATUS = "dic_user_visit_status";

    /**
     * 是否上传打款凭证
     */
    String DIC_HAS_PAY_EVIDENCE = "dic_has_pay_evidence";

    /**
     * 报单状态
     */
    String DIC_DECLARATION_STATUS = "dic_declaration_status";

    /**
     * 预约状态
     */
    String DIC_RESERVATION_STATUS = "dic_reservation_status";

    /**
     * 发行状态
     */
    String DIC_PRODUCT_ISSUED_STATUS = "dic_product_issued_status";

    /**
     * 客户状态
     */
    String DIC_CUSTOMER_STATUS = "dic_customer_status";

    /**
     * 性别
     */
    String DIC_SEX = "dic_sex";

    /**
     * 客户级别
     */
    String DIC_CUSTOMER_LEVEL="dic_customer_level";

    /**
     * 客户回退审核状态
     */
    String DIC_CUSTOMER_BACK_STATUS="dic_customer_back_status";


    /** ###################文章数据字典  begin#################### */

    /**
     * 文章状态
     */
    String DIC_ARTICLE_STATUS = "dic_article_status";
    /**
     * 路演栏目状态 
     */
    String DIC_ROADSHOW_COLUMN_STATUS = "dic_roadshow_column_status";
    /**
     * 路演状态 
     */

    String DIC_ROADSHOW_STATUS = "dic_roadshow_status";
    /**
     * 文章栏目状态
     */
    String DIC_ARTICLE_COLUMN_STATUS = "dic_article_column_status";

    /** ###################文章数据字典 end#################### */


    /** ###################财务管理数据字典  begin#################### */

    /**
     * 是否已开具发票
     */
    String DIC_RECEIPT_RECORD_IS_INVOICED = "dic_receipt_record_is_invoiced";

    /** ###################财务管理数据字典 end#################### */

    /** ###################公用数据字典  begin#################### */

    /**
     * 是否
     */
    String DIC_YES_OR_NO = "dic_yes_or_no";

    /** ###################公用数据字典 end#################### */
}
