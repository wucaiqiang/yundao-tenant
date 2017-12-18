package com.yundao.tenant.dto.product;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划产品下拉选项
 *
 * @author jan
 * @create 2017-10-12 16:27
 **/
public class ProductSelectionForReceiptPlanDto {

    @ApiModelProperty(value = "产品id")
    private Long id;

    @ApiModelProperty(value = "产品名称")
    private String name;

    @ApiModelProperty(value = "供应商id")
    private Long supplierId;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
