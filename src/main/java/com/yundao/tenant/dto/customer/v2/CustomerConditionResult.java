package com.yundao.tenant.dto.customer.v2;

import com.yundao.core.utils.BooleanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jan
 * @create 2017-11-02 18:10
 **/
public class CustomerConditionResult {

    private List<Long> customerIds;

    private Boolean hasCondition;

    public Boolean hasEmptyResult() {
        return hasCondition && BooleanUtils.isEmpty(customerIds);
    }

    public List<Long> getCustomerIds() {
        return customerIds;
    }

    public Boolean getHasCondition() {
        return hasCondition;
    }

    public void setHasCondition(Boolean hasCondition) {
        this.hasCondition = hasCondition;
    }

    public void setCustomerIds(List<Long> customerIds) {
        this.customerIds = customerIds;
    }
}
