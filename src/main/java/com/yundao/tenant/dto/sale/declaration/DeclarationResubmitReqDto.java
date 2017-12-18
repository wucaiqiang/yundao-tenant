
package com.yundao.tenant.dto.sale.declaration;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

public class DeclarationResubmitReqDto implements Serializable{
    
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "报单id")
    @NotNull(message = "{" + CodeConstant.CODE_1220061 + "}")
    private Long id;

    @ApiModelProperty(value = "打款日期")
    @NotNull(message = "{" + GJLCodeConstant.CODE_1210060 + "}")
    private Date payDate;

    @ApiModelProperty(value = "认购金额")
    @NotNull(message = "{" + GJLCodeConstant.CODE_1210061 + "}")
    private Double dealAmount;

    @ApiModelProperty(value = "备注")
    @Length(max = 200, message = "{" + GJLCodeConstant.CODE_1210021 + "}", isBlank = true)
    private String remark;
    @ApiModelProperty(value = "动作,对应WorkflowActionEnum")
    private Integer action;

    public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public Date getPayDate (){
        return payDate;
    }

    public void setPayDate (Date payDate){
        this.payDate = payDate;
    }

    public String getRemark (){
        return remark;
    }

    public void setRemark (String remark){
        this.remark = remark;
    }

    public Double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(Double dealAmount) {
        this.dealAmount = dealAmount;
    }

	public Integer getAction() {
	
		return action;
	}

	public void setAction(Integer action) {
	
		this.action = action;
	}
    
}
