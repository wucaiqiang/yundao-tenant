package com.yundao.tenant.dto.resource;

import java.io.Serializable;
import java.util.List;

/**
 * 资源dto
 *
 * @author jan
 * @create 2017-07-03 AM11:23
 **/
public class ResourceResDto implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * 菜单
     */
    private List<MenuResDto> menu;

    /**
     * 功能
     */
    private List<AuthResDto> auth;

    public List<MenuResDto> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuResDto> menu) {
        this.menu = menu;
    }

    public List<AuthResDto> getAuth() {
        return auth;
    }

    public void setAuth(List<AuthResDto> auth) {
        this.auth = auth;
    }
}
