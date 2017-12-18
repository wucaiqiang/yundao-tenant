package com.yundao.tenant.dto.sale.leads;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 销售线索分配回访请求数据dto
 *
 * @author jan
 * @create 2017-09-09 PM3:42
 **/
public class LeadsAllotReqDto {

    @ApiModelProperty(value = "客户id")
    @NotNull(message = "{" + CodeConstant.CODE_1220047 + "}")
    private Long customerId;

    @ApiModelProperty(value = "需要分配的线索id,多个逗号分隔")
    @NotEmpty(message = "{" + CodeConstant.CODE_1220089 + "}")
    private String leadsIds;

    @ApiModelProperty(value = "回访事由")
    private String matter;

    @ApiModelProperty(value = "分配回访人id")
    @NotNull(message = "{" + CodeConstant.CODE_1220098 + "}")
    private Long userId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getLeadsIds() {
        return leadsIds;
    }

    public void setLeadsIds(String leadsIds) {
        this.leadsIds = leadsIds;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
