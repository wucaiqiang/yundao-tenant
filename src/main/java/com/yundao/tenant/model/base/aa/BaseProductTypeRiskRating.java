package com.yundao.tenant.model.base.aa;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductTypeRiskRating extends BaseModel implements Serializable {
    /**
	 * 产品类型id
	 */
    private Long productTypeId;

    /**
	 * 风险评测类型id
	 */
    private Long riskRatingId;

    /**
	 * 性质
	 */
    private Double rate;

    private static final long serialVersionUID = 1L;

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Long getRiskRatingId() {
        return riskRatingId;
    }

    public void setRiskRatingId(Long riskRatingId) {
        this.riskRatingId = riskRatingId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}