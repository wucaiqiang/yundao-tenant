package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCustomerFollowUpAttach extends BaseModel implements Serializable {
    /**
	 * 客户跟进记录Id
	 */
    private Long custoemrFollowUpId;

    /**
	 * 文件名称
	 */
    private String name;

    private String url;

    /**
	 * 文件格式
	 */
    private String format;

    /**
	 * 排序
	 */
    private Float sort;

    private static final long serialVersionUID = 1L;

    public Long getCustoemrFollowUpId() {
        return custoemrFollowUpId;
    }

    public void setCustoemrFollowUpId(Long custoemrFollowUpId) {
        this.custoemrFollowUpId = custoemrFollowUpId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Float getSort() {
        return sort;
    }

    public void setSort(Float sort) {
        this.sort = sort;
    }
}