package com.yundao.tenant.dto.finance.receipt.plan;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 移除关联报单请求dto
 *
 * @author jan
 * @create 2017-10-16 09:27
 **/
public class DeclarationRelDelReqDto {

    @ApiModelProperty(value = "报单id，多个逗号分隔")
    @NotEmpty(message = "{" + CodeConstant.CODE_1220061 + "}")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
