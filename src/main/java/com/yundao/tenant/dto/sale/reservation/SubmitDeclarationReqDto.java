

package com.yundao.tenant.dto.sale.reservation;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月13日 下午5:33:27 
 * @author   欧阳利
 * @version   
 */
public class SubmitDeclarationReqDto {
    @ApiModelProperty(value = "预约id")
    @NotNull(message = "{" + CodeConstant.CODE_1200102 + "}")
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

