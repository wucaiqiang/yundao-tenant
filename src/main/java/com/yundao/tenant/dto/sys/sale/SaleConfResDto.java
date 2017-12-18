package com.yundao.tenant.dto.sys.sale;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 销售管理配置
 *
 * @author jan
 * @create 2017-11-03 11:34
 **/
public class SaleConfResDto implements Serializable {

    static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "公海配置")
    private SaleConfOpenseaDto opensea;

    public SaleConfOpenseaDto getOpensea() {
        return opensea;
    }

    public void setOpensea(SaleConfOpenseaDto opensea) {
        this.opensea = opensea;
    }

}
