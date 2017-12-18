
package com.yundao.tenant.dto.customer.customeranniversaries;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CustomerAnniversariesReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079 + "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "客户id")
    @Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210019 + "}")
    private Long customerId;

    @ApiModelProperty(value = "名称")
    @Length(min = 1, max = 20, message = "{" + CodeConstant.CODE_1200002 + "}")
    private String name;

    @ApiModelProperty(value = "日期")
    @Length(min = 1, max = 32, message = "{" + GJLCodeConstant.CODE_1210020 + "}")
    private Date anvrTime;

    @ApiModelProperty(value = "备注")
    @Length(isBlank = true,min = 1, max = 200, message = "{" + GJLCodeConstant.CODE_1210021 + "}")
    private String remark;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getCustomerId (){
        return customerId;
    }

    public void setCustomerId (Long customerId){
        this.customerId = customerId;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public Date getAnvrTime (){
        return anvrTime;
    }

    public void setAnvrTime (Date anvrTime){
        this.anvrTime = anvrTime;
    }

    public String getRemark (){
        return remark;
    }

    public void setRemark (String remark){
        this.remark = remark;
    }

}
