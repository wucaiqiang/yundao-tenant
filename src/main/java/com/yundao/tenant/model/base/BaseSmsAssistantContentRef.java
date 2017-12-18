package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSmsAssistantContentRef extends BaseModel implements Serializable {
    /**
	 * 短信助手内容ID
	 */
    private Long smsAssistantContentId;

    /**
	 * 客户ID
	 */
    private Long customerId;

    /**
	 * 客户手机号
	 */
    private String customerMobile;

    private static final long serialVersionUID = 1L;

    public Long getSmsAssistantContentId() {
        return smsAssistantContentId;
    }

    public void setSmsAssistantContentId(Long smsAssistantContentId) {
        this.smsAssistantContentId = smsAssistantContentId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }
}