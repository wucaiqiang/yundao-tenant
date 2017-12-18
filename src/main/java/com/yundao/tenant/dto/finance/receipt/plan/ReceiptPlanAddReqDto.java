package com.yundao.tenant.dto.finance.receipt.plan;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 回款计划请求dto
 *
 * @author jan
 * @create 2017-10-12 13:56
 **/
public class ReceiptPlanAddReqDto {

    @ApiModelProperty(value = "回款计划名称")
    @NotEmpty(message = "{" + CodeConstant.CODE_1220116 + "}")
    @Length(max = 30, message = "{" + CodeConstant.CODE_1220117 + "}")
    private String name;

    @ApiModelProperty(value = "回款产品id")
    @NotNull(message = "{" + CodeConstant.CODE_1220121 + "}")
    private Long productId;

    @ApiModelProperty(value = "供应商id")
    private Long supplierId;

    @ApiModelProperty(value = "计划回款金额")
    @NotNull(message = "{" + CodeConstant.CODE_1220118 + "}")
    private Double amount;

    @ApiModelProperty(value = "回款单位")
    @Length(max = 50, message = "{" + CodeConstant.CODE_1220119 + "}")
    private String payUnit;

    @ApiModelProperty(value = "回款备注")
    @Length(max = 200, message = "{" + CodeConstant.CODE_1220120 + "}")
    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
