package com.yundao.tenant.dto.product;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;

/**
 * 基金附件
 *
 * @author jan
 * @create 2017-11-25 14:23
 **/
public class FundAttachDto extends BaseModel implements Serializable {

    /**
     * 基金id
     */
    private Long fundId;

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

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }
}
