package com.yundao.tenant.dto.customer.bank;

import com.yundao.tenant.model.base.customer.BaseCustomerBank;

/**
 * 客户银行卡列表数据dto
 *
 * @author jan
 * @create 2017-08-28 PM11:12
 **/
public class CustomerBankListDto extends BaseCustomerBank {

    /**
     * 客户id
     */
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
