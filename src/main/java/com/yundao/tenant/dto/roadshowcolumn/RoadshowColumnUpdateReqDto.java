
package com.yundao.tenant.dto.roadshowcolumn;

import java.io.Serializable;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class RoadshowColumnUpdateReqDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "ID")
	@Number(isBlank = false, message = "{" + CommonCode.COMMON_1079 + "}")
	private Long id;
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "编码")
	private String code;
	@ApiModelProperty(value = "状态")
	private Integer status;
	@ApiModelProperty(value = "排序")
	private Integer sequence;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public Integer getStatus() {

		return status;
	}

	public void setStatus(Integer status) {

		this.status = status;
	}

	public Integer getSequence() {

		return sequence;
	}

	public void setSequence(Integer sequence) {

		this.sequence = sequence;
	}

}
