
package com.yundao.tenant.dto.sale.declaration;


import io.swagger.annotations.ApiModelProperty;

public class DeclarationUpdateCredentialsDto{
    @ApiModelProperty(value = "报单ID")
    private Long id;

    /**
     * 证件类型（1：身份证，2：护照）
     */
    @ApiModelProperty(value = "证件类型（1：身份证，2：护照）")
    private Long type;

    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码")
    private String number;

    /**
     * 证件正面
     */
    @ApiModelProperty(value = "证件正面")
    private String front;

    /**
     * 证件反面
     */
    @ApiModelProperty(value = "证件反面")
    private String back;

    //资产证明
    private String declarationAttachs;

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getDeclarationAttachs() {
        return declarationAttachs;
    }

    public void setDeclarationAttachs(String declarationAttachs) {
        this.declarationAttachs = declarationAttachs;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

