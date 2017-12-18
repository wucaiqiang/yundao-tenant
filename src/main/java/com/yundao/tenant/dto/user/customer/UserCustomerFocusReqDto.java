package com.yundao.tenant.dto.user.customer;

import java.io.Serializable;

public class UserCustomerFocusReqDto implements Serializable {
    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 用户id
     */
    private Long userId;


    private static final long serialVersionUID = 1L;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}