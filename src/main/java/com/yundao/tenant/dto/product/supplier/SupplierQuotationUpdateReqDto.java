package com.yundao.tenant.dto.product.supplier;

import javax.validation.constraints.NotNull;

import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class SupplierQuotationUpdateReqDto {
	
	/**
	 * 产品id
	 */
	@ApiModelProperty(value="产品id")
	@NotNull(message = "{" + CodeConstant.CODE_1200041 + "}")
	Long productId;
	
	/**
	 * 供应商报价
	 */
    @ApiModelProperty(value="供应商报价: [{ \"id(供应商报价id)\": '', \"supplierName(供应商名称)\": '', \"remark(备注)\": '',\"productQuotationDtos(单个报价详情)\": "
    		+ "[{\"id(报价id)\": '', \"saleMax(销售金额最大)\": '', \"saleMin(销售金额最小)\": '',\"commissionType(佣金类型)\": '',\"frontCommission(前端)\": '',\"backCommission(后端)\": '' }] }]")
    String supplierDtos;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getSupplierDtos() {
		return supplierDtos;
	}
	public void setSupplierDtos(String supplierDtos) {
		this.supplierDtos = supplierDtos;
	}

}
