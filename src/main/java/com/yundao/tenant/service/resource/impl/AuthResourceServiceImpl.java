package com.yundao.tenant.service.resource.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.resource.AuthMenuDto;
import com.yundao.tenant.dto.resource.AuthResourceDto;
import com.yundao.tenant.dto.resource.api.AuthApiDto;
import com.yundao.tenant.model.base.BaseApiResource;
import com.yundao.tenant.model.base.BaseResource;
import com.yundao.tenant.service.resource.AuthResourceService;
import com.yundao.tenant.service.resource.ResourceService;
import com.yundao.tenant.service.resource.api.ApiResourceService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.url.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 鉴权资源服务实现
 *
 * @author jan
 * @create 2017-11-07 19:10
 **/
@Service
public class AuthResourceServiceImpl implements AuthResourceService {

    private static Log log = LogFactory.getLog(AuthResourceServiceImpl.class);

    private static final String CACHE_KEY = "T(com.yundao.core.cache.interceptor.BaseKeyGenerator).getKey(#root.targetClass,#tenantId)";

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ApiResourceService apiResourceService;

    @Override
    @Cacheable(value = "authResource", key = CACHE_KEY)
    public AuthResourceDto get(Long tenantId) throws BaseException {
        return doGet(tenantId);
    }

    @Override
    @CachePut(value = "authResource", key = CACHE_KEY)
    public AuthResourceDto reload(Long tenantId) throws BaseException {
        return doGet(tenantId);
    }

    @Override
    @CacheEvict(value = "authResource", key = CACHE_KEY, beforeInvocation = true)
    public void clear(Long tenantId) throws BaseException {
        log.info("authResource clear complete! tenantId=%s", tenantId);
    }


    /**
     * 从DB获取鉴权资源
     *
     * @param tenantId 租户id
     */
    private AuthResourceDto doGet(Long tenantId) throws BaseException {
        String logPrefix = "鉴权资源||从DB获取||";
        log.info("%s tenantId %s", logPrefix, tenantId);
        AuthResourceDto dto = new AuthResourceDto();
        dto.setMenuMap(doGetMenus());
        dto.setApiMap(doGetApis());
        log.info("%s 完成 dto %s", logPrefix, JsonUtils.objectToJson(dto));
        return dto;
    }

    /**
     * 获取api接口
     */
    private Map<String, AuthApiDto> doGetApis() throws BaseException {
        String logPrefix = "鉴权资源||从DB获取||api接口||";
        List<BaseApiResource> apis = apiResourceService.getAll();
        log.info("%s apis %s", logPrefix, JsonUtils.objectToJson(apis));
        List<AuthApiDto> authApis = LocalBeanUtils.copyPropertiesList(apis, AuthApiDto.class);
        authApis.forEach(m -> m.setUrl(UrlUtils.toLowerCase(m.getUrl())));
        return authApis.stream().collect(Collectors.toMap(AuthApiDto::getUrl, m -> m));
    }

    /**
     * 获取功能菜单
     */
    private Map<String, AuthMenuDto> doGetMenus() throws BaseException {
        String logPrefix = "鉴权资源||从DB获取||功能菜单||";
        List<BaseResource> menus = resourceService.getAll();
        log.info("%s menus %s", logPrefix, JsonUtils.objectToJson(menus));
        List<AuthMenuDto> authMenus = LocalBeanUtils.copyPropertiesList(menus, AuthMenuDto.class);
        authMenus.forEach(m -> m.setUrl(UrlUtils.toLowerCase(m.getUrl())));
        return authMenus.stream().collect(Collectors.toMap(AuthMenuDto::getUrl, m -> m));
    }
}
