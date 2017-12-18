package com.yundao.tenant.dto.sale.leads;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 分配给理财师数据请求dto
 *
 * @author jan
 * @create 2017-09-09 PM8:16
 **/
public class LeadsAllotToFpReqDto {

    @ApiModelProperty(value = "客户id")
    @NotNull(message = "{" + CodeConstant.CODE_1220047 + "}")
    private Long customerId;

    @ApiModelProperty(value = "理财师id")
    @NotNull(message = "{" + CodeConstant.CODE_1220048 + "}")
    private Long fpId;

    public Long getFpId() {
        return fpId;
    }

    public void setFpId(Long fpId) {
        this.fpId = fpId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
