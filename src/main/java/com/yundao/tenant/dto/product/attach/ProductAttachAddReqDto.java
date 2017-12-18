package com.yundao.tenant.dto.product.attach;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加产品附件请求
 * 
 * @author 欧阳利
 * 2017年7月11日
 */
@ApiModel(value="添加产品附件请求参数")
public class ProductAttachAddReqDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 产品id
	 */
	@ApiModelProperty(value = "产品id")
	@NotNull(message = "{" + CodeConstant.CODE_1200041 + "}")
	private Long productId;
	
    /**
	 * 文件名称
	 */
	@ApiModelProperty(value = "文件名称")
	@NotNull(message = "{" + CodeConstant.CODE_1200047 + "}")
    private String sourceName;

    /**
	 * url
	 */
	@ApiModelProperty(value = "文件url")
	@NotNull(message = "{" + CodeConstant.CODE_1200048 + "}")
    private String url;
    
    /**
	 * 排序
	 */
	@ApiModelProperty(value = "排序")
    private Double sort;
	
	@ApiModelProperty(value = "文件类型")
	private String type;
	@ApiModelProperty(value = "可见性：1：内部可见 2：外部可见 0或null：全部可见")
	private Integer showType;

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public Long getProductId() {
	
		return productId;
	}

	public void setProductId(Long productId) {
	
		this.productId = productId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getSort() {
		return sort;
	}

	public void setSort(Double sort) {
		this.sort = sort;
	}

	public Integer getShowType() {
	
		return showType;
	}

	public void setShowType(Integer showType) {
	
		this.showType = showType;
	}

}
