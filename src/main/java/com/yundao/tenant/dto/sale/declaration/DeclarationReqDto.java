
package com.yundao.tenant.dto.sale.declaration;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DeclarationReqDto {
	@ApiModelProperty(value = "产品id")
    @NotNull(message = "{" + CodeConstant.CODE_1200041 + "}")
	private Long productId;
	
	@ApiModelProperty(value = "客户id")
	private Long customerId;
	
    @ApiModelProperty(value = "预约id")
    private Long reservationId;

    @ApiModelProperty(value = "打款日期")
    @NotNull(message = "{" + GJLCodeConstant.CODE_1210060 + "}")
    private Date payDate;

    @ApiModelProperty(value = "认购金额")
    @NotNull(message = "{" + GJLCodeConstant.CODE_1210061 + "}")
    private Double dealAmount;

    @ApiModelProperty(value = "备注")
    @Length(max = 200, message = "{" + GJLCodeConstant.CODE_1210021 + "}", isBlank = true)
    private String remark;

    public Long getProductId() {
	
		return productId;
	}

	public void setProductId(Long productId) {
	
		this.productId = productId;
	}

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}

	public Long getReservationId (){
        return reservationId;
    }

    public void setReservationId (Long reservationId){
        this.reservationId = reservationId;
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
}
