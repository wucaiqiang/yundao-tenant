package com.yundao.tenant.dto.product.add;

import java.util.List;

/**
 * 产品供应商
 * 
 * @author 欧阳利
 * 2017年7月5日
 */
public class ProductSupplierDto {
	
	/**
	 * 供应商名称
	 */
	private String supplierName;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 产品供应商报价
	 */
    private List<ProductQuotationDto> productQuotationDtos;

	public List<ProductQuotationDto> getProductQuotationDtos() {
		return productQuotationDtos;
	}

	public void setProductQuotationDtos(List<ProductQuotationDto> productQuotationDtos) {
		this.productQuotationDtos = productQuotationDtos;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
