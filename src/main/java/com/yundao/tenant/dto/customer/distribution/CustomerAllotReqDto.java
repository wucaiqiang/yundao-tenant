package com.yundao.tenant.dto.customer.distribution;

import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.CustomerMultiIdReqDto;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 客户分配请求
 *
 * @author jan
 * @create 2017-08-14 PM4:54
 **/
public class CustomerAllotReqDto extends CustomerMultiIdReqDto {

    @ApiModelProperty(value = "理财师id")
    @NotNull(message = "{" + CodeConstant.CODE_1220048 + "}")
    private long fpId;

    public long getFpId() {
        return fpId;
    }

    public void setFpId(long fpId) {
        this.fpId = fpId;
    }
}
