package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductCommission extends BaseModel implements Serializable {
    /**
	 * 佣金规则id
	 */
    private Long commissionRuleId;

    /**
	 * 销售最大值
	 */
    private Double saleMax;

    /**
	 * 销售最小值
	 */
    private Double saleMin;

    /**
	 * 佣金类型
	 */
    private String commissionType;

    /**
	 * 前端佣金
	 */
    private Double frontCommission;

    /**
	 * 后端佣金
	 */
    private Double backCommission;

    /**
	 * 修改人id
	 */
    private Long updateId;

    private static final long serialVersionUID = 1L;

    public Long getCommissionRuleId() {
        return commissionRuleId;
    }

    public void setCommissionRuleId(Long commissionRuleId) {
        this.commissionRuleId = commissionRuleId;
    }

    public Double getSaleMax() {
        return saleMax;
    }

    public void setSaleMax(Double saleMax) {
        this.saleMax = saleMax;
    }

    public Double getSaleMin() {
        return saleMin;
    }

    public void setSaleMin(Double saleMin) {
        this.saleMin = saleMin;
    }

    public String getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
    }

    public Double getFrontCommission() {
        return frontCommission;
    }

    public void setFrontCommission(Double frontCommission) {
        this.frontCommission = frontCommission;
    }

    public Double getBackCommission() {
        return backCommission;
    }

    public void setBackCommission(Double backCommission) {
        this.backCommission = backCommission;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }
}