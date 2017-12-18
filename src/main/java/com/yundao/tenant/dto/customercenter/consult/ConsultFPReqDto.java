package com.yundao.tenant.dto.customercenter.consult;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 预约理财师数据请求dto
 *
 * @author jan
 * @create 2017-10-25 15:11
 **/
public class ConsultFPReqDto {

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "{" + CodeConstant.CODE_1200014 + "}")
    private Long userId;

    @ApiModelProperty(value = "渠道")
    private Integer channel;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}
