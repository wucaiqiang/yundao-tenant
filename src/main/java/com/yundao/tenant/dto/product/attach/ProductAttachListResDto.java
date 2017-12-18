package com.yundao.tenant.dto.product.attach;

import com.yundao.tenant.enums.product.ProductAttachShowTypeEnum;

import io.swagger.annotations.ApiModelProperty;

/**
 * 产品列表信息
 * 
 * @author 欧阳利 2017年7月11日
 */
public class ProductAttachListResDto {

	/**
	 * 产品附件id
	 */
	@ApiModelProperty("产品附件id")
	private Long id;

	/**
	 * 文件名称
	 */
	@ApiModelProperty("文件名称")
	private String sourceName;

	/**
	 * url
	 */
	@ApiModelProperty("url")
	private String url;

	/**
	 * 产品id
	 */
	@ApiModelProperty("产品id")
	private Long productId;

	/**
	 * 附件类型
	 */
	@ApiModelProperty("附件类型")
	private String type;
	@ApiModelProperty("可见性：0：全部可见 1：内部可见 2：外部可见  3：全部不可见")
	private Integer showType;
	@ApiModelProperty("可见性 文本")
	private String showTypeText;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
