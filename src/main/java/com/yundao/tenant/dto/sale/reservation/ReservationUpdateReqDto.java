package com.yundao.tenant.dto.sale.reservation;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

/**
 * 添加预约请求dto
 *
 * @author jan
 * @create 2017-08-23 PM6:25
 **/
public class ReservationUpdateReqDto {

    @ApiModelProperty(value = "id")
    @NotNull(message = "{" + CodeConstant.CODE_1200102 + "}")
    private Long id;

    @ApiModelProperty(value = "预计打款日期")
    @NotNull(message = "{" + CodeConstant.CODE_1220050 + "}")
    private Date estimatePayDate;

    @ApiModelProperty(value = "预约金额")
    @NotNull(message = "{" + CodeConstant.CODE_1220051 + "}")
    private Double reservationAmount;

    @ApiModelProperty(value = "备注")
    @Length( max=200 ,message = "{" + CodeConstant.CODE_1220052 + "}" ,isBlank=true )
    private String remark;


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEstimatePayDate() {
        return estimatePayDate;
    }

    public void setEstimatePayDate(Date estimatePayDate) {
        this.estimatePayDate = estimatePayDate;
    }

    public Double getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(Double reservationAmount) {
        this.reservationAmount = reservationAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
