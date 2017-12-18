
package com.yundao.tenant.dto.finance.knotcommission;

import com.yundao.tenant.dto.product.commission.ProductCommissionRuleDetailDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class KnotCommissionResDto {
    @ApiModelProperty(value = "计划总金额")
    private Double totalAmount;

    @ApiModelProperty(value = "实际回款金额")
    private Double realityAmount;

    @ApiModelProperty(value = "计划ID")
    private Long receiptPlanId;

    @ApiModelProperty(value = "成交产品佣金")
    List<ProductCommissionRuleDetailDto> productCommissionRules;

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getRealityAmount() {
        return realityAmount;
    }

    public void setRealityAmount(Double realityAmount) {
        this.realityAmount = realityAmount;
    }

    public List<ProductCommissionRuleDetailDto> getProductCommissionRules() {
        return productCommissionRules;
    }

    public void setProductCommissionRules(List<ProductCommissionRuleDetailDto> productCommissionRules) {
        this.productCommissionRules = productCommissionRules;
    }

    public Long getReceiptPlanId() {
        return receiptPlanId;
    }

    public void setReceiptPlanId(Long receiptPlanId) {
        this.receiptPlanId = receiptPlanId;
    }
}
