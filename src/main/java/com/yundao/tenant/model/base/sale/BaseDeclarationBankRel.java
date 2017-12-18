package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseDeclarationBankRel extends BaseModel implements Serializable {
    /**
	 * 报单id
	 */
    private Long declarationId;

    /**
	 * 银行卡id
	 */
    private Long bankId;

    private static final long serialVersionUID = 1L;

    public Long getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Long declarationId) {
        this.declarationId = declarationId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }
}