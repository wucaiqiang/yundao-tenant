
package com.yundao.tenant.dto.msg.msgmessage;

import io.swagger.annotations.ApiModelProperty;

public class MsgMessagePageDto {

    @ApiModelProperty(value = "1、代办 ，2、消息")
    private Integer firstType;

    public Integer getFirstType() {
        return firstType;
    }

    public void setFirstType(Integer firstType) {
        this.firstType = firstType;
    }
}
