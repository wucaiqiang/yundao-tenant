package com.yundao.tenant.dto;


import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jan
 * @create 2017-08-28 PM10:12
 **/
public class WorkflowAuditReqDto {


    @ApiModelProperty(value = "id")
    @Number(isBlank = false,message = "{" + GJLCodeConstant.CODE_1210098 + "}")
    private Long id;

    @ApiModelProperty(value = "动作，1：通过  2：驳回 3：取消 5：否决")
    @Number(isBlank = false,message = "{" + CodeConstant.CODE_1220064 + "}")
    private Integer action;

    @ApiModelProperty(value = "驳回/取消原因")
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
