
package com.yundao.tenant.dto.smsassistantcontent;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;

import io.swagger.annotations.ApiModelProperty;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.CodeConstant;

public class SmsAssistantContentAddReqDto {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "称呼")
	private String callTitle;

	@ApiModelProperty(value = "签名")
	private String sendTitle;

	@ApiModelProperty(value = "内容")
	@Length(min = 1, max = 200, message = "{" + Code1200000.CODE_1200195 + "}")
	private String content;

	@ApiModelProperty(value = "发送状态 ： 0:未发送 1：发送成功 2：发送失败")
	@NotNull(message = "{" + Code1200000.CODE_1200194 + "}")
	private Integer sendStatus;

	@ApiModelProperty(value = "待执行时间")
	private Date executeTime;

	@ApiModelProperty(value = "客户IDs")
//	@NotNull(message = "{" + CodeConstant.CODE_1220047 + "}")
	private String customerIds;

	public String getCallTitle() {
		return callTitle;
	}

	public void setCallTitle(String callTitle) {
		this.callTitle = callTitle;
	}

	public String getSendTitle() {
		return sendTitle;
	}

	public void setSendTitle(String sendTitle) {
		this.sendTitle = sendTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Date getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Date executeTime) {
		this.executeTime = executeTime;
	}

	public String getCustomerIds() {

		return customerIds;
	}

	public void setCustomerIds(String customerIds) {

		this.customerIds = customerIds;
	}

}
