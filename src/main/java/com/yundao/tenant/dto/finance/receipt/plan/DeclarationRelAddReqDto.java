package com.yundao.tenant.dto.finance.receipt.plan;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 关联报单请求dto
 *
 * @author jan
 * @create 2017-10-16 08:24
 **/
public class DeclarationRelAddReqDto {

    @ApiModelProperty(value = "回款计划id")
    @NotNull(message = "{" + CodeConstant.CODE_1220124 + "}")
    private Long receiptPlanId;

    @ApiModelProperty(value = "报单id，多个逗号分隔")
    @NotEmpty(message = "{" + CodeConstant.CODE_1220061 + "}")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Long getReceiptPlanId() {
        return receiptPlanId;
    }

    public void setReceiptPlanId(Long receiptPlanId) {
        this.receiptPlanId = receiptPlanId;
    }
}
