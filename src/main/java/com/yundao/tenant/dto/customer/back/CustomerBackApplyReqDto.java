package com.yundao.tenant.dto.customer.back;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.CustomerMultiIdReqDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 申请请求回退dto
 *
 * @author jan
 * @create 2017-08-10 PM3:40
 **/
public class CustomerBackApplyReqDto extends CustomerMultiIdReqDto {

    @ApiModelProperty(value = "回退原因")
    @Length(min = 1, max = 50, message = "{" + CodeConstant.CODE_1220046 + "}")
    private String reason;

    @ApiModelProperty(value = "是否执行，默认false")
    private Boolean execute;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getExecute() {
        return execute;
    }

    public void setExecute(Boolean execute) {
        this.execute = execute;
    }
}
