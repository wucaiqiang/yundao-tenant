
package com.yundao.tenant.dto.finance.knotcommission;

import java.util.Date;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class KnotCommissionReqDto{
    @ApiModelProperty(value = "报单ID")
    @Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210082 + "}")
    private Long declarationId;

    @ApiModelProperty(value = "佣金类型")
    @Length(min = 1, max = 32, message = "{" + GJLCodeConstant.CODE_1210091 + "}")
    private String type;

    @ApiModelProperty(value = "佣金费率")
    @Length(min = 1, max = 32, message = "{" + GJLCodeConstant.CODE_1210092 + "}")
    private Double rate;

    @ApiModelProperty(value = "佣金金额")
    @Length(min = 1, max = 32, message = "{" + GJLCodeConstant.CODE_1210093 + "}")
    private Double amount;

    @ApiModelProperty(value = "发放时间")
    @Length(min = 1, max = 32, message = "{" + GJLCodeConstant.CODE_1210094 + "}")
    private Date provideDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getDeclarationId (){
        return declarationId;
    }

    public void setDeclarationId (Long declarationId){
        this.declarationId = declarationId;
    }

    public String getType (){
        return type;
    }

    public void setType (String type){
        this.type = type;
    }

    public Date getProvideDate (){
        return provideDate;
    }

    public void setProvideDate (Date provideDate){
        this.provideDate = provideDate;
    }

    public String getRemark (){
        return remark;
    }

    public void setRemark (String remark){
        this.remark = remark;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
