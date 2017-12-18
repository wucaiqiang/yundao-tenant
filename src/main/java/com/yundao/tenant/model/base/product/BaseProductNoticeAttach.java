package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseProductNoticeAttach extends BaseModel implements Serializable {
    /**
	 * 公告id
	 */
    private Long noticeId;

    /**
	 * 文件名称
	 */
    private String sourceName;

    /**
	 * url
	 */
    private String url;

    /**
	 * 排序
	 */
    private Double sort;

    /**
	 * 附件类型
	 */
    private String type;

    private static final long serialVersionUID = 1L;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSort() {
        return sort;
    }

    public void setSort(Double sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}