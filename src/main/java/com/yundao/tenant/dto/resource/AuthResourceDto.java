package com.yundao.tenant.dto.resource;

import com.yundao.tenant.dto.resource.api.AuthApiDto;

import java.io.Serializable;
import java.util.Map;

/**
 * 鉴权资源数据dto
 *
 * @author jan
 * @create 2017-11-07 19:06
 **/
public class AuthResourceDto implements Serializable {

    static final long serialVersionUID = -1L;

    private Map<String, AuthMenuDto> menuMap;

    private Map<String, AuthApiDto> apiMap;

    public Map<String, AuthMenuDto> getMenuMap() {
        return menuMap;
    }

    public void setMenuMap(Map<String, AuthMenuDto> menuMap) {
        this.menuMap = menuMap;
    }

    public Map<String, AuthApiDto> getApiMap() {
        return apiMap;
    }

    public void setApiMap(Map<String, AuthApiDto> apiMap) {
        this.apiMap = apiMap;
    }
}
