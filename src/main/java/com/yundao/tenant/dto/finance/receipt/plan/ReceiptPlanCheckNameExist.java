package com.yundao.tenant.dto.finance.receipt.plan;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 检查回款计划名称是否存在
 *
 * @author jan
 * @create 2017-10-13 08:28
 **/
public class ReceiptPlanCheckNameExist {

    @ApiModelProperty(value = "回款计划名称")
    @NotEmpty(message = "{" + CodeConstant.CODE_1220116 + "}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
