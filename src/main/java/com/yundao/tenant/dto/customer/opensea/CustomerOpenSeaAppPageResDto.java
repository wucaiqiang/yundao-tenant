package com.yundao.tenant.dto.customer.opensea;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户池分页数据
 *
 * @author jan
 * @create 2017-08-14 AM8:56
 **/
public class CustomerOpenSeaAppPageResDto {

    @ApiModelProperty(value = "客户id")
    private Long id;

    @ApiModelProperty(value = "客户姓名")
    private String name;

    @ApiModelProperty(value = "客户编号")
    private String number;


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

	public String getNumber() {
	
		return number;
	}

	public void setNumber(String number) {
	
		this.number = number;
	}

    

}
