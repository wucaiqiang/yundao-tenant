package com.yundao.tenant.dto.customer.imports;

/**
 * 客户id手机dto
 *
 * @author jan
 * @create 2017-09-06 PM2:50
 **/
public class CustomerIdAndMobileDto {

    /**
     * id
     */
    private Long id;

    /**
     * 客户手机
     */
    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
