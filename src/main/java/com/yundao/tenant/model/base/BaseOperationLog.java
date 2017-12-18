package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseOperationLog extends BaseModel implements Serializable {
    /**
	 * 操作者用户账号id
	 */
    private Long userAccountId;

    /**
	 * 操作类型（0：新建，1：编辑，2：删除，3：锁定，4：解锁）
	 */
    private Integer operateType;

    /**
	 * 对象类型
	 */
    private Integer objectType;

    /**
	 * 对象名字
	 */
    private String objectName;

    /**
	 * 对象主键
	 */
    private Long objectId;

    /**
	 * ip
	 */
    private String ip;

    /**
	 * 操作描述
	 */
    private String description;

    /**
	 * 系统编码
	 */
    private String systemCode;

    private static final long serialVersionUID = 1L;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public Integer getObjectType() {
        return objectType;
    }

    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}