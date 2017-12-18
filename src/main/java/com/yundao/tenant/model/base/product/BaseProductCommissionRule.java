package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductCommissionRule extends BaseModel implements Serializable {
    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 规则名称
	 */
    private String ruleName;

    /**
	 * 备注
	 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}