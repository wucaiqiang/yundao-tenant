package com.yundao.tenant.dto.customercenter.consult;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 预约产品数据请求dto
 *
 * @author jan
 * @create 2017-09-07 PM3:57
 **/
public class ConsultProductReqDto {

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "{" + CodeConstant.CODE_1200014 + "}")
    private Long userId;

    @ApiModelProperty(value = "产品id")
    @NotNull(message = "{" + CodeConstant.CODE_1200041 + "}")
    private Long productId;

    @ApiModelProperty(value = "渠道")
    private Integer channel;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}
