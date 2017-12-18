package com.yundao.tenant.dto.customer.imports;

/**
 * 客户银行卡dto
 *
 * @author jan
 * @create 2017-11-29 09:07
 **/
public class ImportBankDto {

    private Long id;

    /**
     * 银行卡账号
     */
    private String bankAccount;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 客户id
     */
    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
