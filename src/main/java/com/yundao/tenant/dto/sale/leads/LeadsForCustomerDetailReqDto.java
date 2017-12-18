package com.yundao.tenant.dto.sale.leads;

import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 客户详情销售线索数据请求dto
 *
 * @author jan
 * @create 2017-09-07 PM6:05
 **/
public class LeadsForCustomerDetailReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "客户id")
    @NotNull(message = "{" + CodeConstant.CODE_1220047 + "}")
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
