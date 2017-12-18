package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseCustomerTransfer extends BaseModel implements Serializable {
    /**
	 * 客户ID
	 */
    private Long customerId;

    /**
	 * 移交后归属人名称
	 */
    private String afterUser;

    /**
	 * 移交后归属id
	 */
    private Long afterUserId;

    /**
	 * 移交前归属人名称
	 */
    private String beforeUser;

    /**
	 * 移交前归属id
	 */
    private Long beforeUserId;

    /**
	 * 移交时间
	 */
    private Date transferDate;

    /**
	 * 备注
	 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAfterUser() {
        return afterUser;
    }

    public void setAfterUser(String afterUser) {
        this.afterUser = afterUser;
    }

    public Long getAfterUserId() {
        return afterUserId;
    }

    public void setAfterUserId(Long afterUserId) {
        this.afterUserId = afterUserId;
    }

    public String getBeforeUser() {
        return beforeUser;
    }

    public void setBeforeUser(String beforeUser) {
        this.beforeUser = beforeUser;
    }

    public Long getBeforeUserId() {
        return beforeUserId;
    }

    public void setBeforeUserId(Long beforeUserId) {
        this.beforeUserId = beforeUserId;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}