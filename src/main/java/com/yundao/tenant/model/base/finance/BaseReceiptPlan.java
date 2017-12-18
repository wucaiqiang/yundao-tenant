package com.yundao.tenant.model.base.finance;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseReceiptPlan extends BaseModel implements Serializable {
    /**
	 * 回款计划名称
	 */
    private String name;

    /**
	 * 回款产品
	 */
    private Long productId;

    /**
	 * 供应商
	 */
    private Long productSupplierId;

    /**
	 * 计划回款金额
	 */
    private Double amount;

    /**
	 * 付款单位
	 */
    private String payUnit;

    /**
	 * 首页内容
	 */
    private String indexContent;

    /**
	 * 备注
	 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductSupplierId() {
        return productSupplierId;
    }

    public void setProductSupplierId(Long productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public String getIndexContent() {
        return indexContent;
    }

    public void setIndexContent(String indexContent) {
        this.indexContent = indexContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}