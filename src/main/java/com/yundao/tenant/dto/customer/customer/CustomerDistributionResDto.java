package com.yundao.tenant.dto.customer.customer;

/**
 * @author jan
 * @create 2017-09-15 AM11:36
 **/
public class CustomerDistributionResDto {

    private Long id;

    private String name;

    private Long fpId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
    }
}
