package com.yundao.tenant.enums.msg;

/**
 * Created by gjl on 2017/8/14.
 */
public enum MsgMessageCodeEnum {


    PRODUCT_ON_LINE_AUDIT("product_on_line_audit", "有待上线审核的产品"),

    PRODUCT_AGAIN_AUDIT("product_again_audit", "有待上线审批的产品（驳回后重新提交）"),

    PRODUCT_NOTICE_AUDIT("product_notice_audit", "产品公告审核"),

    PRODUCT_NOTICE_AGAIN_AUDIT("product_notice_again_audit", "产品公告审核（驳回后重新提交）"),

    DECLARATION_AUDIO_PASS("declaration_audio_pass", "产品公告审核通过"),

    DECLARATION_AUDIO_REJECT("declaration_audio_reject", "产品公告审核驳回"),

    PRODUCT_ON_LINE("product_on_line", "产品上线"),

    PRODUCT_ADD_ATTACH("product_add_attach", "添加产品附件"),


    CUSTOMER_BACK_EXAMINE_PASS("customer_back_examine_pass", "回退客户审核通过"),

    CUSTOMER_BACK_EXAMINE_REJECT("customer_back_examine_reject", "回退客户审核驳回"),


    CUSTOMER_VISIT("customer_visit", "客户回访"),

    CUSTOMER_NEXT_VISIT("customer_next_visit", "客户下次回访"),

    ADD_CUSTOMER("add_customer", "新增客户"),
    CUSTOMER_FOLLOW("customer_follow", "客户跟进"),
    NEXT_FOLLOW("next_follow", "下次跟进"),

    CUSTOMER_ALLOT("customer_allot", "客户调配"),
    CUSTOMER_ALLOT_MULTI("customer_allot_multi", "批量客户调配"),

    CUSTOMER_RECYCLE("customer_recycle", "客户回收到客户池"),

    RESERVATION_AUDIT_TODO("reservation_audit_todo","额度预约待确认"),
    RESERVATION_AGAIN_AUDIT_TODO("reservation_again_audit","有待审批的额度预约（驳回后重新提交）"),
    DECLARATION_AUDIT_TODO("declaration_audit_todo","报单待审批"),
    DECLARATION_AGAIN_AUDIT_TODO("declaration_again_audit","有待审批的报单（驳回后重新提交）"),
    RESERVATION_APPROVED("reservation_approved","额度预约已确认"),
    RESERVATION_REJECT("reservation_reject","额度预约被驳回"),

    RENOUNCE_CUSTOMER("renounce_customer","放弃客户"),
    RESERVATION_DISCARD("reservation_discard","预约被作废"),
    DECLARATION_DISCARD("declaration_discard","报单被作废"),

    SEND_NOTICE("send_notice", "发布公告");

    private String code;
    private String name;

    MsgMessageCodeEnum(String code, String name) {
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
