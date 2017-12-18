package com.yundao.tenant.dto.finance.receipt.plan;

import io.swagger.annotations.ApiModelProperty;

/**
 * 添加回款计划返回结果
 *
 * @author jan
 * @create 2017-10-13 10:17
 **/
public class ReceiptPlanAddResult {

    @ApiModelProperty(value = "回款计划id")
    private Long id;

    @ApiModelProperty(value = "关联的报单数")
    private Integer declarationCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeclarationCount() {
        return declarationCount;
    }

    public void setDeclarationCount(Integer declarationCount) {
        this.declarationCount = declarationCount;
    }
}

