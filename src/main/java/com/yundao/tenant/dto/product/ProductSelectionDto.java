package com.yundao.tenant.dto.product;

import io.swagger.annotations.ApiModelProperty;

/**
 * 产品选型数据dto
 *
 * @author jan
 * @create 2017-08-30 PM1:48
 **/
public class ProductSelectionDto {

    @ApiModelProperty(value = "产品id")
    private Long id;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
