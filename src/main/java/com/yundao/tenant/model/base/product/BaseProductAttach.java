package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductAttach extends BaseModel implements Serializable {
    /**
	 * 文件名称
	 */
    private String sourceName;

    /**
	 * url
	 */
    private String url;

    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 排序
	 */
    private Double sort;

    /**
	 * 可见性：1：内部可见 2：外部可见 0或null：全部可见
	 */
    private Integer showType;

    /**
	 * 附件类型
	 */
    private String type;

    private static final long serialVersionUID = 1L;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}