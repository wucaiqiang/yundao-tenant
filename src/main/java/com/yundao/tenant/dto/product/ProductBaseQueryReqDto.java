package com.yundao.tenant.dto.product;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductBaseQueryReqDto extends AbstractBasePageDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品名称")
    private String name;
	@ApiModelProperty("产品发行状态，多个逗号分开")
	private String issuedStatuses;
	@ApiModelProperty("当前用户ID")
	private Long userId;

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}

	public String getIssuedStatuses() {
	
		return issuedStatuses;
	}

	public void setIssuedStatuses(String issuedStatuses) {
	
		this.issuedStatuses = issuedStatuses;
	}

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

    
}
