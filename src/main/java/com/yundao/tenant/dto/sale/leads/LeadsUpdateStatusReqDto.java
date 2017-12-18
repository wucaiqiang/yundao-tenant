package com.yundao.tenant.dto.sale.leads;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 更新线索状态请求dto
 *
 * @author jan
 * @create 2017-09-07 PM7:46
 **/
public class LeadsUpdateStatusReqDto {

    @ApiModelProperty(value = "线索id")
    @NotNull(message = "{" + CodeConstant.CODE_1220089 + "}")
    private Long id;

    @ApiModelProperty(value = "状态")
    @NotNull(message = "{" + CodeConstant.CODE_1220086 + "}")
    private Integer status;

    @ApiModelProperty(value = "跟进备注")
    private String followRemark;

    @ApiModelProperty(value = "是否同步到跟进记录；1：是，0或留空：否")
    private Integer isSyncToFollow;

    @ApiModelProperty(value = "跟进方式")
    private Integer type;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFollowRemark() {
        return followRemark;
    }

    public void setFollowRemark(String followRemark) {
        this.followRemark = followRemark;
    }

    public Integer getIsSyncToFollow() {
        return isSyncToFollow;
    }

    public void setIsSyncToFollow(Integer isSyncToFollow) {
        this.isSyncToFollow = isSyncToFollow;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
