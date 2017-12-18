package com.yundao.tenant.dto.product.add;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductIncomeRuleDto {

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
     * 收益
     */
    private List<ProductIncomeDto> productIncomeDtos;


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


	public List<ProductIncomeDto> getProductIncomeDtos() {
		return productIncomeDtos;
	}


	public void setProductIncomeDtos(List<ProductIncomeDto> productIncomeDtos) {
		this.productIncomeDtos = productIncomeDtos;
	}


	public Long getProductId() {
	
		return productId;
	}


	public void setProductId(Long productId) {
	
		this.productId = productId;
	}
    
    
}
