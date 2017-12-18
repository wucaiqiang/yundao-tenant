package com.yundao.tenant.dto.product.commission;

import java.util.List;

public class ProductCommissionRuleDetailDto {
	/**
	 *  佣金
	 */
	private Long id;
	
	/**
	 * 规则名称
	 */
	private String ruleName;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 佣金详情
	 */
	private List<ProductCommissionDetailDto>  productCommissionDtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<ProductCommissionDetailDto> getProductCommissionDtos() {
		return productCommissionDtos;
	}

	public void setProductCommissionDtos(List<ProductCommissionDetailDto> productCommissionDtos) {
		this.productCommissionDtos = productCommissionDtos;
	}
}
