package com.yundao.tenant.dto.customer.opensea;

import com.yundao.tenant.dto.AbstractBasePageDto;

/**
 * 客户池分页请求数据
 *
 * @author jan
 * @create 2017-08-14 AM9:10
 **/
public class CustomerOpenSeaAppPageReqDto extends AbstractBasePageDto {

    
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	private String keyword;

	public String getKeyword() {
	
		return keyword;
	}

	public void setKeyword(String keyword) {
	
		this.keyword = keyword;
	}
}
