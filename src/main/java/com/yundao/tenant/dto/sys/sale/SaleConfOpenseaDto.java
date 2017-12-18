package com.yundao.tenant.dto.sys.sale;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author jan
 * @create 2017-11-03 14:14
 **/
public class SaleConfOpenseaDto implements Serializable {

    static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "领取限制数")
    private Integer takeLimitCount;

    @ApiModelProperty(value = "是否开启领取限制；1：是，0：否")
    private Integer takeLimitEnable;

    public Integer getTakeLimitCount() {
        return takeLimitCount;
    }

    public void setTakeLimitCount(Integer takeLimitCount) {
        this.takeLimitCount = takeLimitCount;
    }

    public Integer getTakeLimitEnable() {
        return takeLimitEnable;
    }

    public void setTakeLimitEnable(Integer takeLimitEnable) {
        this.takeLimitEnable = takeLimitEnable;
    }
}
