package com.yundao.tenant.dto.user;

import java.io.Serializable;


import io.swagger.annotations.ApiModelProperty;

public class UserSearchReqDto implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 真实姓名
	 */
	@ApiModelProperty(value = "真实姓名")
	private String realName;
	/**
	 * 条数
	 */
	@ApiModelProperty(value = "条数")
	private Integer limit=10;

	public String getRealName() {

		return realName;
	}

	public void setRealName(String realName) {

		this.realName = realName;
	}

	public Integer getLimit() {

		return limit;
	}

	public void setLimit(Integer limit) {

		this.limit = limit;
	}

}
