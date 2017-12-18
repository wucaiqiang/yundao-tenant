package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductIncome extends BaseModel implements Serializable {
    /**
	 * 收益规则id
	 */
    private Long incomeRuleId;

    /**
	 * 认购最大值
	 */
    private Double buyMax;

    /**
	 * 认购最小值
	 */
    private Double buyMin;

    /**
	 * 认购期限
	 */
    private Long buyTimeLimit;

    /**
	 * 收益类型
	 */
    private String incomeType;

    /**
	 * 收益率
	 */
    private Double fixIncomeRate;

    /**
	 * 浮动收益
	 */
    private Double floatIncomeRate;

    private static final long serialVersionUID = 1L;

    public Long getIncomeRuleId() {
        return incomeRuleId;
    }

    public void setIncomeRuleId(Long incomeRuleId) {
        this.incomeRuleId = incomeRuleId;
    }

    public Double getBuyMax() {
        return buyMax;
    }

    public void setBuyMax(Double buyMax) {
        this.buyMax = buyMax;
    }

    public Double getBuyMin() {
        return buyMin;
    }

    public void setBuyMin(Double buyMin) {
        this.buyMin = buyMin;
    }

    public Long getBuyTimeLimit() {
        return buyTimeLimit;
    }

    public void setBuyTimeLimit(Long buyTimeLimit) {
        this.buyTimeLimit = buyTimeLimit;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public Double getFixIncomeRate() {
        return fixIncomeRate;
    }

    public void setFixIncomeRate(Double fixIncomeRate) {
        this.fixIncomeRate = fixIncomeRate;
    }

    public Double getFloatIncomeRate() {
        return floatIncomeRate;
    }

    public void setFloatIncomeRate(Double floatIncomeRate) {
        this.floatIncomeRate = floatIncomeRate;
    }
}