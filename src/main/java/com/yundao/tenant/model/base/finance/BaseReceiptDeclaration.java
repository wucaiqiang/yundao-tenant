package com.yundao.tenant.model.base.finance;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseReceiptDeclaration extends BaseModel implements Serializable {
    /**
	 * 回款计划ID
	 */
    private Long receiptPlanId;

    /**
	 * 报单ID
	 */
    private Long declarationId;

    private static final long serialVersionUID = 1L;

    public Long getReceiptPlanId() {
        return receiptPlanId;
    }

    public void setReceiptPlanId(Long receiptPlanId) {
        this.receiptPlanId = receiptPlanId;
    }

    public Long getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Long declarationId) {
        this.declarationId = declarationId;
    }
}