package com.yundao.tenant.dto.product.income;

import io.swagger.annotations.ApiModelProperty;

public class IncomeRuleUpdateReqDto {
	
	@ApiModelProperty(value="产品id")
    Long productId;
    
	
    @ApiModelProperty(value="收益规则信息: [{\"id(规则id)\": '', \"ruleName(规则名称)\": '', \"remark(备注)\": '',\"productIncomeDtos(单个规则详情)\": "
    		+ "[{ \"id(规则id)\": '', \"buyMax(认购最大值)\": '', \"buyMin(认购最小值)\": '',\"buyTimeLimit(认购期限)\": '',\"incomeType(收益类型)\": '',\"fixIncomeRate(收益率)\": '',\"floatIncomeRate(浮动收益)\": '' }] }]")
    String incomeDtos;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getIncomeDtos() {
		return incomeDtos;
	}

	public void setIncomeDtos(String incomeDtos) {
		this.incomeDtos = incomeDtos;
	}
    
    
}
