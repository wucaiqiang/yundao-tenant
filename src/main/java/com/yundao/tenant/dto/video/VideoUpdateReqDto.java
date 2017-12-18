
package com.yundao.tenant.dto.video;

import java.io.Serializable;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.GJLCodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class VideoUpdateReqDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "视频ID")
	@Number(isBlank = false, message = "{" + CommonCode.COMMON_1079 + "}")
	private Long id;
	@ApiModelProperty(value = "视频名称")
	@Length(min = 1, max = 50, message = "{" + GJLCodeConstant.CODE_1210103 + "}")
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	

}
