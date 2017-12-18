package com.yundao.tenant.service.resource.intercept.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.resource.AuthMenuDto;
import com.yundao.tenant.dto.resource.AuthResourceDto;
import com.yundao.tenant.dto.resource.AuthResultDto;
import com.yundao.tenant.dto.resource.api.AuthApiDto;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.resource.AuthResourceTypeEnum;
import com.yundao.tenant.enums.resource.AuthResultCodeEnum;
import com.yundao.tenant.service.resource.AuthResourceService;
import com.yundao.tenant.service.resource.intercept.ResourceInterceptService;
import com.yundao.tenant.service.resource.user.UserAuthService;
import com.yundao.tenant.util.url.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 鉴权资源拦截服务接口
 *
 * @author jan
 * @create 2017-11-07 20:31
 **/
@Service
public class ResourceInterceptServiceImpl extends AbstractService implements ResourceInterceptService {

    private static Log log = LogFactory.getLog(ResourceInterceptServiceImpl.class);

    @Autowired
    private AuthResourceService authResourceService;

    @Autowired
    private UserAuthService userAuthService;

    @Override
    public AuthResultDto doAuthenticate(String url) throws BaseException {
        String logPrefix = "资源拦截||鉴权||";
        Long tenantId = super.getHeaderTenantId();
        Long userId = super.getHeaderUserId();
        log.info("%s tenantId %s userId %s url %s", logPrefix, tenantId, userId, url);
        url = UrlUtils.toLowerCase(url);

        AuthResultDto result = new AuthResultDto();
        result.setRequestUrl(url);
        result.setUserId(userId);

        //all
        AuthResourceDto authResource = authResourceService.get(tenantId);

        //api
        Map<String, AuthApiDto> apiMap = authResource.getApiMap();
        AuthApiDto api = apiMap.get(url);
        if (api != null) {
            log.info("%s 访问api地址", logPrefix);
            return this.authenticateApi(result, api, url);
        }

        //menu
        Map<String, AuthMenuDto> menuMap = authResource.getMenuMap();
        AuthMenuDto menu = menuMap.get(url);
        if (menu != null) {
            log.info("%s 访问菜单页面", logPrefix);
            return this.authenticateMenu(result, menu, url);
        }
        //TODO 如果请求地址，在数据库不存在，表示不需要鉴权，返回true，临时方案，后面全部api地址加入到数据库后需要修改为false
        log.info("%s 请求地址不在需要鉴权范围内",logPrefix);

        return this.setAuthorization(result, AuthResultCodeEnum.NOT_IN_REOUSRCE.getCode());
    }

    private AuthResultDto authenticateMenu(AuthResultDto result, AuthMenuDto menu, String url) throws BaseException {
        String logPrefix = "资源拦截||鉴权菜单||";
        log.info("%s result %s AuthMenuDto %s url %s", logPrefix, JsonUtils.objectToJson(result), JsonUtils.objectToJson
                (menu), url);
        Long tenantId = super.getHeaderTenantId();
        Long userId = super.getHeaderUserId();

        result.setAuthResourceType(AuthResourceTypeEnum.MENU.getValue());

        //获取当前用户已授权的menu
        AuthResourceDto userAuthResource = userAuthService.get(tenantId, userId);
        log.info("%s userAuthResource %s", logPrefix, JsonUtils.objectToJson(userAuthResource));
        if (userAuthResource == null || BooleanUtils.isEmpty(userAuthResource.getMenuMap())) {
            return this.setAuthorization(result, AuthResultCodeEnum.DENIED.getCode());
        }

        Map<String, AuthMenuDto> apis = userAuthResource.getMenuMap();
        AuthMenuDto authMenu = apis.get(url);
        if (authMenu != null) {
            //拥有访问权限
            return this.setAuthorization(result, AuthResultCodeEnum.AUTHORIZATION.getCode());
        } else {
            //未拥有访问权限
            return this.setDenied(result, AuthResultCodeEnum.DENIED.getCode());
        }

    }

    private AuthResultDto authenticateApi(AuthResultDto result, AuthApiDto api, String url) throws BaseException {
        String logPrefix = "资源拦截||鉴权api||";
        log.info("%s result %s AuthApiDto %s url %s", logPrefix, JsonUtils.objectToJson(result), JsonUtils.objectToJson
                (api), url);
        Long tenantId = super.getHeaderTenantId();
        Long userId = super.getHeaderUserId();

        result.setAuthResourceType(AuthResourceTypeEnum.API.getValue());

        //whitelist
        if (YesOrNoEnum.YES.getValue().equals(api.getIsWhitelist())) {
            return this.setAuthorization(result, AuthResultCodeEnum.WHITELIST.getCode());
        }

        //获取当前用户已授权的api
        AuthResourceDto userAuthResource = userAuthService.get(tenantId, userId);
        log.info("%s userAuthResource %s", logPrefix, JsonUtils.objectToJson(userAuthResource));
        if (userAuthResource == null || BooleanUtils.isEmpty(userAuthResource.getApiMap())) {
            return this.setDenied(result, AuthResultCodeEnum.DENIED.getCode());
        }

        Map<String, AuthApiDto> apis = userAuthResource.getApiMap();
        AuthApiDto authApi = apis.get(url);
        if (authApi != null) {
            //拥有访问权限
            return this.setAuthorization(result, AuthResultCodeEnum.AUTHORIZATION.getCode());
        } else {
            //未拥有访问权限
            return this.setDenied(result, AuthResultCodeEnum.DENIED.getCode());
        }
    }

    /**
     * 设置为授权
     */
    private AuthResultDto setAuthorization(AuthResultDto result, String code) {
        result.setPermission(true);
        result.setCode(code);
        return result;
    }

    /**
     * 设置为拒绝访问
     */
    private AuthResultDto setDenied(AuthResultDto result, String code) {
        result.setPermission(false);
        result.setCode(code);
        return result;
    }
}
