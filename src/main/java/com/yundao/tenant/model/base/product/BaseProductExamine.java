package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseProductExamine extends BaseModel implements Serializable {
    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 流程发起人id
	 */
    private Long applyUserId;

    /**
	 * 发行状态
	 */
    private Integer issuedStatus;

    /**
	 * 请求审核的 状态
	 */
    private Integer reqIssuedStatus;

    /**
	 * 审核人
	 */
    private Long approveId;

    /**
	 * 审核时间
	 */
    private Date approveDate;

    /**
	 * 原因
	 */
    private String reason;

    /**
	 * 审核状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已撤销
	 */
    private Integer status;

    /**
	 * 业务类型
	 */
    private String businessType;

    private static final long serialVersionUID = 1L;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Integer getIssuedStatus() {
        return issuedStatus;
    }

    public void setIssuedStatus(Integer issuedStatus) {
        this.issuedStatus = issuedStatus;
    }

    public Integer getReqIssuedStatus() {
        return reqIssuedStatus;
    }

    public void setReqIssuedStatus(Integer reqIssuedStatus) {
        this.reqIssuedStatus = reqIssuedStatus;
    }

    public Long getApproveId() {
        return approveId;
    }

    public void setApproveId(Long approveId) {
        this.approveId = approveId;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}