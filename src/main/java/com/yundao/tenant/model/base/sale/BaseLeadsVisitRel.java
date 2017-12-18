package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseLeadsVisitRel extends BaseModel implements Serializable {
    /**
	 * 线索id
	 */
    private Long leadsId;

    /**
	 * 回访id
	 */
    private Long userVisitId;

    private static final long serialVersionUID = 1L;

    public Long getLeadsId() {
        return leadsId;
    }

    public void setLeadsId(Long leadsId) {
        this.leadsId = leadsId;
    }

    public Long getUserVisitId() {
        return userVisitId;
    }

    public void setUserVisitId(Long userVisitId) {
        this.userVisitId = userVisitId;
    }
}