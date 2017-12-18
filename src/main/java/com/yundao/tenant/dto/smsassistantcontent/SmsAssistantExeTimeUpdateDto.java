
package com.yundao.tenant.dto.smsassistantcontent;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.Code1200000;

public class SmsAssistantExeTimeUpdateDto implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "新增不需要传")
	@Number(isBlank = false, message = "{" + CommonCode.COMMON_1079 + "}")
	private Long id;

	@NotNull(message = "{" + Code1200000.CODE_1200198 + "}")
	@ApiModelProperty(value = "待执行时间")
	private Date executeTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExecuteTime() {

		return executeTime;
	}

	public void setExecuteTime(Date executeTime) {

		this.executeTime = executeTime;
	}

}
