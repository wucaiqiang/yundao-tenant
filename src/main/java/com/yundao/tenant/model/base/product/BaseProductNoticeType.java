package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductNoticeType extends BaseModel implements Serializable {
    /**
	 * 类型名称
	 */
    private String name;

    /**
	 * 描述
	 */
    private String description;

    /**
	 * 产品公告CODE
	 */
    private String code;

    /**
	 * 1 允许删除，0不允许删除
	 */
    private Integer isPermitDelete;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIsPermitDelete() {
        return isPermitDelete;
    }

    public void setIsPermitDelete(Integer isPermitDelete) {
        this.isPermitDelete = isPermitDelete;
    }
}