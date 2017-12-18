package com.yundao.tenant.dto.resource;

import java.io.Serializable;

/**
 * 鉴权功能菜单数据dto
 *
 * @author jan
 * @create 2017-11-07 19:01
 **/
public class AuthMenuDto implements Serializable {

    static final long serialVersionUID = -1L;

    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * url
     */
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
