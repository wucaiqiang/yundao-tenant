package com.yundao.tenant.dto.resource.api;

import java.io.Serializable;

/**
 * API资源dto
 *
 * @author jan
 * @create 2017-11-07 16:43
 **/
public class AuthApiDto implements Serializable {

    static final long serialVersionUID = -1L;

    /**
     * id
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 名字
     */
    private String name;

    /**
     * 链接
     */
    private String url;

    /**
     * 链接类型；1：PC，2：APP
     */
    private Integer urlType;

    /**
     * 是否白名单
     */
    private Integer isWhitelist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getUrlType() {
        return urlType;
    }

    public void setUrlType(Integer urlType) {
        this.urlType = urlType;
    }

    public Integer getIsWhitelist() {
        return isWhitelist;
    }

    public void setIsWhitelist(Integer isWhitelist) {
        this.isWhitelist = isWhitelist;
    }
}
