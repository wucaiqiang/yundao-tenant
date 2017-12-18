package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCustomerBankRel extends BaseModel implements Serializable {
    /**
	 * 客户id
	 */
    private Long customerId;

    /**
	 * 银行卡id
	 */
    private Long bankId;

    private static final long serialVersionUID = 1L;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }
}