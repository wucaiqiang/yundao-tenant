
package com.yundao.tenant.dto.customer.customerfollowup;

import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

public class CustomerFollowUpPageDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "客户id")
    @Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210022 + "}")
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
