package com.yundao.tenant.enums.customer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 字段类型枚举
 *
 * @author jan
 * @create 2017-07-06 PM3:55
 **/
public enum CustomerAddTypEnum {

	/**
	 * 自建客户
	 */
	CUSTOMER_ADD_TYPE_1(1, "自建客户"),
	/**
	 * 客户池新建
	 */
	CUSTOMER_ADD_TYPE_2(2, "客户池新建");
	private Integer type;
	private String name;

	CustomerAddTypEnum(Integer type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
