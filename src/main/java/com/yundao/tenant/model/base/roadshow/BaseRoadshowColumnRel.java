package com.yundao.tenant.model.base.roadshow;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseRoadshowColumnRel extends BaseModel implements Serializable {
    /**
	 * 路演ID
	 */
    private Long roadshowId;

    /**
	 * 栏目ID
	 */
    private Long columnId;

    private static final long serialVersionUID = 1L;

    public Long getRoadshowId() {
        return roadshowId;
    }

    public void setRoadshowId(Long roadshowId) {
        this.roadshowId = roadshowId;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }
}