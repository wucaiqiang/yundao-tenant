
package com.yundao.tenant.dto.msg.msgfeed;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.number.Number;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class MsgFeedPageDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
