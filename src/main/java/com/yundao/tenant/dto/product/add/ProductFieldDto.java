package com.yundao.tenant.dto.product.add;

import java.util.List;

import com.yundao.tenant.dto.field.FieldDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductFieldDto {

	@ApiModelProperty(" 产品信息字段 ")
	List<FieldDto> productFieldDtos;
	@ApiModelProperty("销售信息 字段")
	List<FieldDto> productSaleFieldDtos;
	
	public List<FieldDto> getProductFieldDtos() {
		return productFieldDtos;
	}
	public void setProductFieldDtos(List<FieldDto> productFieldDtos) {
		this.productFieldDtos = productFieldDtos;
	}
	public List<FieldDto> getProductSaleFieldDtos() {
		return productSaleFieldDtos;
	}
	public void setProductSaleFieldDtos(List<FieldDto> productSaleFieldDtos) {
		this.productSaleFieldDtos = productSaleFieldDtos;
	}
	
}
