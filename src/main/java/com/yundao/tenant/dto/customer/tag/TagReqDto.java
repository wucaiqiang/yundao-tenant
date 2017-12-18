
package com.yundao.tenant.dto.customer.tag;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class TagReqDto extends AbstractBasePageDto {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "新增不需要传")
	@Number(isBlank = false, message = "{" + CommonCode.COMMON_1079 + "}", groups = { Update.class })
	private Long id;

	@ApiModelProperty(value = "名称")
	private String name;

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

}
