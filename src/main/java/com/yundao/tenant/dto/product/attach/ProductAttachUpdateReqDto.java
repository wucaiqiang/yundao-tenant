package com.yundao.tenant.dto.product.attach;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.yundao.tenant.constant.code.Code1230000;
import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加产品附件请求
 * 
 * @author 欧阳利 2017年7月11日
 */
@ApiModel(value = "添加产品附件请求参数")
public class ProductAttachUpdateReqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 附件id
	 */
	@ApiModelProperty(value = " 附件id")
	@NotNull(message = "{" + CodeConstant.CODE_1200049 + "}")
	private Long id;

	@ApiModelProperty(value = "可见性：0： 全部可见 1：内部可见 2：外部可见 3:全部不可见")
	@NotNull(message = "{" + Code1230000.CODE_1230005 + "}")
	private Integer showType;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public Integer getShowType() {

		return showType;
	}

	public void setShowType(Integer showType) {

		this.showType = showType;
	}

}
