package com.yundao.tenant.dto.resource;

import java.io.Serializable;

/**
 * 功能权限资源
 *
 * @author jan
 * @create 2017-07-03 AM11:22
 **/
public class AuthResDto implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * 资源id
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 地址
     */
    private String url;

    /**
     * 地址
     */
    private String path;

    /**
     * 资源名称
     */
    private String name;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
}
