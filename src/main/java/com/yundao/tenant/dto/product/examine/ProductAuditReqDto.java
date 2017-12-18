package com.yundao.tenant.dto.product.examine;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 产品审核请求dto
 *
 * @author jan
 * @create 2017-08-03 PM3:05
 **/
public class ProductAuditReqDto {

    @NotNull(message = "{" + CodeConstant.CODE_1220033 + "}")
    @ApiModelProperty(value = "产品审核id")
    private Long id;

    @ApiModelProperty(value = "动作，1：通过  2：驳回 3：取消")
    @NotNull(message = "{" + CodeConstant.CODE_1220064 + "}")
    private Integer action;

    @Length(max = 512, message = "{" + CodeConstant.CODE_1220041 + "}", isBlank = true)
    @ApiModelProperty(value = "驳回理由")
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }
}
