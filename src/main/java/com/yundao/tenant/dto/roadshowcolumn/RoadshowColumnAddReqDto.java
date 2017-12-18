
package com.yundao.tenant.dto.roadshowcolumn;

import java.io.Serializable;

import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.GJLCodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class RoadshowColumnAddReqDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "平台ID")
	@Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210102 + "}")
	private Long platformId;
	@ApiModelProperty(value = "名称")
	@Length(min = 1, max = 20, message = "{" + GJLCodeConstant.CODE_1210103 + "}")
	private String name;
	@ApiModelProperty(value = "编码")
	private String code;
	@ApiModelProperty(value = "状态，0：停用，1：启用")
	@Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210107 + "}")
	private Integer status;
	@ApiModelProperty(value = "排序，越小越靠前")
	@Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210106 + "}")
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

	public Long getPlatformId() {

		return platformId;
	}

	public void setPlatformId(Long platformId) {

		this.platformId = platformId;
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
