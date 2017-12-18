package com.yundao.tenant.dto.customer.customer;


import io.swagger.annotations.ApiModelProperty;

/**
 * 客户详情线索机会条数
 *
 * @author jan
 * @create 2017-09-09 PM5:43
 **/
public class CustomerDetailLeadsChanceResCount {

    @ApiModelProperty(value = "销售线索条数")
    private Integer leadsCount;

    @ApiModelProperty(value = "销售机会体条数")
    private Integer chanceCount;

    public Integer getLeadsCount() {
        return leadsCount;
    }

    public void setLeadsCount(Integer leadsCount) {
        this.leadsCount = leadsCount;
    }

    public Integer getChanceCount() {
        return chanceCount;
    }

    public void setChanceCount(Integer chanceCount) {
        this.chanceCount = chanceCount;
    }
}
