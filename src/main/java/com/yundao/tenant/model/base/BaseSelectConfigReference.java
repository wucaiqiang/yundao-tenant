package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSelectConfigReference extends BaseModel implements Serializable {
    /**
	 * 引用表
	 */
    private String referenceTable;

    /**
	 * 引用表id
	 */
    private Long referenceTableId;

    /**
	 * 业务对象字段选项类配置id
	 */
    private Long selectConfigId;

    private static final long serialVersionUID = 1L;

    public String getReferenceTable() {
        return referenceTable;
    }

    public void setReferenceTable(String referenceTable) {
        this.referenceTable = referenceTable;
    }

    public Long getReferenceTableId() {
        return referenceTableId;
    }

    public void setReferenceTableId(Long referenceTableId) {
        this.referenceTableId = referenceTableId;
    }

    public Long getSelectConfigId() {
        return selectConfigId;
    }

    public void setSelectConfigId(Long selectConfigId) {
        this.selectConfigId = selectConfigId;
    }
}