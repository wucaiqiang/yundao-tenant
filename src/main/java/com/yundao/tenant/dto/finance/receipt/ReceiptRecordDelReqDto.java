package com.yundao.tenant.dto.finance.receipt;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 回款记录删除
 *
 * @author jan
 * @create 2017-10-15 20:41
 **/
public class ReceiptRecordDelReqDto {

    @ApiModelProperty(value = "回款记录id，多个逗号分隔")
    @NotEmpty(message = "{" + CodeConstant.CODE_1220139 + "}")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

}
