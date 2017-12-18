package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductSupplier extends BaseModel implements Serializable {
    /**
	 * 供应商id
	 */
    private Long supplierId;

    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 备注
	 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}