package com.yundao.tenant.dto.finance.receipt.plan;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 回款计划删除
 *
 * @author jan
 * @create 2017-10-13 13:37
 **/
public class ReceiptPlanDelReqDto {

    @ApiModelProperty(value = "回款计划id，多个逗号分隔")
    @NotEmpty(message = "{" + CodeConstant.CODE_1220126 + "}")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
