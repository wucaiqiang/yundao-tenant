package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseDataObjectInit extends BaseModel implements Serializable {
    /**
	 * 数据对象id
	 */
    private Long dataObjectId;

    /**
	 * 操作，0：读取，1：修改，2：删除
	 */
    private Integer operation;

    /**
	 * 权限值，0：无权限，10：我的，20：团队，30：部门，40：全部
	 */
    private Integer permission;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    /**
	 * 是否选中，0：否，1：是
	 */
    private Integer isCheck;

    private static final long serialVersionUID = 1L;

    public Long getDataObjectId() {
        return dataObjectId;
    }

    public void setDataObjectId(Long dataObjectId) {
        this.dataObjectId = dataObjectId;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }
}