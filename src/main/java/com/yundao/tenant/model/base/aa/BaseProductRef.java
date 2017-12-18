package com.yundao.tenant.model.base.aa;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductRef extends BaseModel implements Serializable {
    /**
	 * 成绩id
	 */
    private Long scoreId;

    /**
	 * 产品id
	 */
    private Long productId;

    private static final long serialVersionUID = 1L;

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}