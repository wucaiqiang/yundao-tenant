package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseUpdateLog extends BaseModel implements Serializable {
    /**
	 * 修改模块
	 */
    private String model;

    /**
	 * 修改对象id
	 */
    private Long objectId;

    /**
	 * 修改项
	 */
    private String updateItem;

    /**
	 * 修改前内容
	 */
    private String updateBeforeContent;

    /**
	 * 修改后内容
	 */
    private String updateAfterContent;

    /**
	 * 修改id
	 */
    private Long updateId;

    /**
	 * 修改客户端
	 */
    private String client;

    /**
	 * 字段名
	 */
    private String clolumnName;

    private static final long serialVersionUID = 1L;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getUpdateItem() {
        return updateItem;
    }

    public void setUpdateItem(String updateItem) {
        this.updateItem = updateItem;
    }

    public String getUpdateBeforeContent() {
        return updateBeforeContent;
    }

    public void setUpdateBeforeContent(String updateBeforeContent) {
        this.updateBeforeContent = updateBeforeContent;
    }

    public String getUpdateAfterContent() {
        return updateAfterContent;
    }

    public void setUpdateAfterContent(String updateAfterContent) {
        this.updateAfterContent = updateAfterContent;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClolumnName() {
        return clolumnName;
    }

    public void setClolumnName(String clolumnName) {
        this.clolumnName = clolumnName;
    }
}