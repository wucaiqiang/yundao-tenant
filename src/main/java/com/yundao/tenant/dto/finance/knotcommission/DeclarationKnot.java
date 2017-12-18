package com.yundao.tenant.dto.finance.knotcommission;


import com.yundao.tenant.model.sale.DeclarationModel;

/**
 * Created by gjl on 2017/10/13.
 */
public class DeclarationKnot extends DeclarationModel {
    private Integer totalCount;
    private Double totalAmount;
    private String customerNumber;
    private String userName;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
