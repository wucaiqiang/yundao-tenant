package com.yundao.tenant.model.base.video;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseVideoCategory extends BaseModel implements Serializable {
    private String refParentId;

    private String refId;

    private String name;

    private static final long serialVersionUID = 1L;

    public String getRefParentId() {
        return refParentId;
    }

    public void setRefParentId(String refParentId) {
        this.refParentId = refParentId;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}