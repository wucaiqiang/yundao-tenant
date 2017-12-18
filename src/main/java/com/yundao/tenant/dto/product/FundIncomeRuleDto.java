package com.yundao.tenant.dto.product;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;

/**
 * 基金收益规则
 *
 * @author jan
 * @create 2017-11-25 14:27
 **/
public class FundIncomeRuleDto extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 基金ID
     */
    private Long fundId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 备注
     */
    private String remark;

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

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }
}
