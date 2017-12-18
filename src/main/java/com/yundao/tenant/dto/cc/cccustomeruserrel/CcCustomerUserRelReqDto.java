
package com.yundao.tenant.dto.cc.cccustomeruserrel;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CcCustomerUserRelReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "用户账号id")
    private Long userAccountId;

    @ApiModelProperty(value = "客户id")
    private Long customerId;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getUserAccountId (){
        return userAccountId;
    }

    public void setUserAccountId (Long userAccountId){
        this.userAccountId = userAccountId;
    }

    public Long getCustomerId (){
        return customerId;
    }

    public void setCustomerId (Long customerId){
        this.customerId = customerId;
    }

}
