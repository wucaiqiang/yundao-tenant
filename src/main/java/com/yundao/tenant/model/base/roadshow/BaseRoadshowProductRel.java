package com.yundao.tenant.model.base.roadshow;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseRoadshowProductRel extends BaseModel implements Serializable {
    /**
	 * 路演ID
	 */
    private Long roadshowId;

    /**
	 * 产品ID
	 */
    private Long productId;

    private static final long serialVersionUID = 1L;

    public Long getRoadshowId() {
        return roadshowId;
    }

    public void setRoadshowId(Long roadshowId) {
        this.roadshowId = roadshowId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}