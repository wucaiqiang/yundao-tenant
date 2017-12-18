package com.yundao.tenant.dto.product.supplier;

import java.util.List;

/**
 * 产品供应商
 * 
 * @author 欧阳利
 * 2017年7月5日
 */
public class ProductSupplierQuotationDto {
	
	/**
	 * 供应商id
	 */
	private Long id;
	
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
    private List<ProductQuotationUpdateDto> productQuotationDtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProductQuotationUpdateDto> getProductQuotationDtos() {
		return productQuotationDtos;
	}

	public void setProductQuotationDtos(List<ProductQuotationUpdateDto> productQuotationDtos) {
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
