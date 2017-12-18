package com.yundao.tenant.dto.product;

import java.io.Serializable;
import java.util.List;

import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductSimpleResDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品id")
	private Long id;

	@ApiModelProperty("产品名称")
	private String name;
	
	@ApiModelProperty("产品类型")
	private Long typeId;
	
	@ApiModelProperty("产品类型名称")
	private String typeName;
	
	@ApiModelProperty("投资期限")
	private String timeLimit;
	
	@ApiModelProperty("投资期限")
	private String highlight;
	
	@ApiModelProperty("认购起点")
	private Double buyStartPoint;
	
	@ApiModelProperty("收益规则")
	private List<ProductIncomeRuleDto> prIncomeRuleDtos;
	
	
	
	public Double getBuyStartPoint() {
	
		return buyStartPoint;
	}
	public void setBuyStartPoint(Double buyStartPoint) {
	
		this.buyStartPoint = buyStartPoint;
	}
	public String getHighlight() {
	
		return highlight;
	}
	public void setHighlight(String highlight) {
	
		this.highlight = highlight;
	}
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
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTimeLimit() {
	
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
	
		this.timeLimit = timeLimit;
	}
	public List<ProductIncomeRuleDto> getPrIncomeRuleDtos() {
		return prIncomeRuleDtos;
	}
	public void setPrIncomeRuleDtos(List<ProductIncomeRuleDto> prIncomeRuleDtos) {
		this.prIncomeRuleDtos = prIncomeRuleDtos;
	}
	
	
}
