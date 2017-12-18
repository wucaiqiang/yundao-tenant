
package com.yundao.tenant.dto.customer.customer;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

public class CustomerScaningAddReqDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "姓名")
	@Length(min = 1, max = 20, message = "{" + GJLCodeConstant.CODE_1210033 + "}")
	private String name;
	@ApiModelProperty(value = "手机号码")
	@NotNull(message = "{" + CodeConstant.CODE_1220023 + "}")
	private String mobile;
	@ApiModelProperty(value = "邮箱")
	private String email;
	@ApiModelProperty(value = "机构")
	private String organization;
	@ApiModelProperty(value = "职位")
	private String position;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getMobile() {

		return mobile;
	}

	public void setMobile(String mobile) {

		this.mobile = mobile;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getOrganization() {

		return organization;
	}

	public void setOrganization(String organization) {

		this.organization = organization;
	}

	public String getPosition() {

		return position;
	}

	public void setPosition(String position) {

		this.position = position;
	}

}
