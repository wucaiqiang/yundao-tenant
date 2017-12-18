package com.yundao.tenant.dto.product.add;

import java.io.Serializable;
import java.util.List;

public class ProductCommissionRuleDto implements Serializable{
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

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
	 * 产品ID
	 */
	private Long productId;
	
	/**
	 * 佣金详情
	 */
    private List<ProductCommissionDto> productCommissionDtos;


	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public Long getProductId() {
	
		return productId;
	}

	public void setProductId(Long productId) {
	
		this.productId = productId;
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

	public List<ProductCommissionDto> getProductCommissionDtos() {
		return productCommissionDtos;
	}

	public void setProductCommissionDtos(List<ProductCommissionDto> productCommissionDtos) {
		this.productCommissionDtos = productCommissionDtos;
	}
    
    
}
