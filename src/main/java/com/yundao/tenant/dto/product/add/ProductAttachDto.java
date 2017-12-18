package com.yundao.tenant.dto.product.add;

import com.yundao.tenant.enums.product.ProductAttachShowTypeEnum;

import io.swagger.annotations.ApiModelProperty;

public class ProductAttachDto {
	/**
	 * 文件名称
	 */
	private String sourceName;

	/**
	 * url
	 */
	private String url;

	/**
	 * 排序
	 */
	private Double sort;

	/**
	 * 附件类型
	 */
	private String type;
	@ApiModelProperty(value = "可见性：1：内部可见 2：外部可见 0或null：全部可见")
	private Integer showType;
	@ApiModelProperty("可见性 文本")
	private String showTypeText;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getSort() {
		return sort;
	}

	public void setSort(Double sort) {
		this.sort = sort;
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

	public Integer getShowType() {

		return showType;
	}

	public void setShowType(Integer showType) {

		this.showType = showType;
	}

	public String getShowTypeText() {
		if (this.showType != null) {
			return ProductAttachShowTypeEnum.getEnumName(this.showType);
		}
		return showTypeText;
	}

	public void setShowTypeText(String showTypeText) {

		this.showTypeText = showTypeText;
	}

}
