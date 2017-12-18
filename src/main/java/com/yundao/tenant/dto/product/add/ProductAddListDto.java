package com.yundao.tenant.dto.product.add;

import java.util.List;

/**
 * 添加产品时的集合信息
 * 
 * @author 欧阳利
 * 2017年7月28日
 */
public class ProductAddListDto {
    /**
     * 供应商报价信息
     */
	List<ProductSupplierDto> supplierDtos;
	
	/**
	 * 销售佣金
	 */
	List<ProductCommissionRuleDto> commissionDtos;
	
	/**
	 * 收益
	 */
	List<ProductIncomeRuleDto> productIncomeRuleDtos;
	
	/**
	 * 产品附件
	 */
	List<ProductAttachDto> attachDtos;

	public List<ProductSupplierDto> getSupplierDtos() {
		return supplierDtos;
	}

	public void setSupplierDtos(List<ProductSupplierDto> supplierDtos) {
		this.supplierDtos = supplierDtos;
	}

	public List<ProductCommissionRuleDto> getCommissionDtos() {
		return commissionDtos;
	}

	public void setCommissionDtos(List<ProductCommissionRuleDto> commissionDtos) {
		this.commissionDtos = commissionDtos;
	}

	public List<ProductIncomeRuleDto> getProductIncomeRuleDtos() {
		return productIncomeRuleDtos;
	}

	public void setProductIncomeRuleDtos(List<ProductIncomeRuleDto> productIncomeRuleDtos) {
		this.productIncomeRuleDtos = productIncomeRuleDtos;
	}

	public List<ProductAttachDto> getAttachDtos() {
		return attachDtos;
	}

	public void setAttachDtos(List<ProductAttachDto> attachDtos) {
		this.attachDtos = attachDtos;
	}
	
}
