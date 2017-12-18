package com.yundao.tenant.model.sale;

import com.yundao.tenant.model.base.sale.BaseDeclaration;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by gjl on 2017/8/24.
 */
public class DeclarationModel extends BaseDeclaration {
    
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	private String productName;

    private String customerName;

    private String statusName;

    private String createUserName;

    private Integer hasPayEvidence;
    
    @ApiModelProperty("是否能申请退款")
    private Boolean canApplyRefund;
    @ApiModelProperty("不能申请退款的提示信息")
    private String notCanApplyRefundTitle;

	public String getNotCanApplyRefundTitle() {
	
		return notCanApplyRefundTitle;
	}

	public void setNotCanApplyRefundTitle(String notCanApplyRefundTitle) {
	
		this.notCanApplyRefundTitle = notCanApplyRefundTitle;
	}

	public Boolean getCanApplyRefund() {
	
		return canApplyRefund;
	}

	public void setCanApplyRefund(Boolean canApplyRefund) {
	
		this.canApplyRefund = canApplyRefund;
	}

	public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Integer getHasPayEvidence() {
        return hasPayEvidence;
    }

    public void setHasPayEvidence(Integer hasPayEvidence) {
        this.hasPayEvidence = hasPayEvidence;
    }
}
