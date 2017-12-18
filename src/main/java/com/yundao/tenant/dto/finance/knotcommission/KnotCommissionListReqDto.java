
package com.yundao.tenant.dto.finance.knotcommission;

import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class KnotCommissionListReqDto{
    @ApiModelProperty(value = "报单ID")
    @NotNull(message = "{" + GJLCodeConstant.CODE_1210082 + "}")
    private Long declarationId;


    public Long getDeclarationId (){
        return declarationId;
    }

    public void setDeclarationId (Long declarationId){
        this.declarationId = declarationId;
    }
}
