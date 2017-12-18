package com.yundao.tenant.dto.sale.reservation;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 添加预约请求dto
 *
 * @author jan
 * @create 2017-08-23 PM6:25
 **/
public class ReservationAddReqDto implements Serializable {


    /**
     * serialVersionUID:
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品id")
    @NotNull(message = "{" + CodeConstant.CODE_1220049 + "}")
    private Long productId;

    @ApiModelProperty(value = "客户id")
    @NotNull(message = "{" + CodeConstant.CODE_1220045 + "}")
    private Long customerId;

    @ApiModelProperty(value = "预计打款日期")
    @NotNull(message = "{" + CodeConstant.CODE_1220050 + "}")
    private Date estimatePayDate;

    @ApiModelProperty(value = "预约金额")
    @NotNull(message = "{" + CodeConstant.CODE_1220051 + "}")
    private Double reservationAmount;

    @ApiModelProperty(value = "备注")
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
