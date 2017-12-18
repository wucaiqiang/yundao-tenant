package com.yundao.tenant.model.base.cms.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductRecommend extends BaseModel implements Serializable {
    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 平台id
	 */
    private Long platformId;

    /**
	 * 位置id
	 */
    private Long positionId;

    /**
	 * 状态(0:停用， 1：启用)
	 */
    private Integer status;

    /**
	 * 排序
	 */
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}