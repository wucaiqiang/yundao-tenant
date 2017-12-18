package com.yundao.tenant.dto.sale.declaration.apply;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 我的报单申请审核请求数据dto
 *
 * @author jan
 * @create 2017-08-25 AM11:39
 **/
public class DeclarationApplyrReqDto {

    @ApiModelProperty(value = "报单id")
    @NotNull(message = "{" + CodeConstant.CODE_1220061 + "}")
    private Long id;

    @ApiModelProperty(value = "取消原因")
    @Length(max = 50, message = "{" + CodeConstant.CODE_1220060 + "}", isBlank = true)
    private String reason;

    @ApiModelProperty(value = "动作,对应WorkflowActionEnum")
    private Integer action;

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
