package com.yundao.tenant.dto.customer.imports;

/**
 * 客户证件dto
 *
 * @author jan
 * @create 2017-11-28 22:27
 **/
public class ImportCredentialDto {

    private Long id;

    /**
     * 证件类型（1：身份证，2：护照）
     */
    private Long type;

    /**
     * 证件号码
     */
    private String number;

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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
