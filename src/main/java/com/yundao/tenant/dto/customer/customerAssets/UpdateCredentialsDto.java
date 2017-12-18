package com.yundao.tenant.dto.customer.customerAssets;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by gjl on 2017/9/18.
 */
public class UpdateCredentialsDto {
    @ApiModelProperty("证件背面")
    private String back;

    @ApiModelProperty("证件正面")
    private String front;

    @ApiModelProperty("证件号")
    private String number;

    @ApiModelProperty("证件类型（1：身份证，2：护照）")
    private Integer type;

    @ApiModelProperty("客户ID")
    @NotNull(message = "{" + CodeConstant.CODE_1220047 + "}")
    private Long id;

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
