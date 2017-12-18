package com.yundao.tenant.service.resource.user.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.dto.resource.ResourceResDto;
import com.yundao.tenant.service.resource.ResourceService;
import com.yundao.tenant.service.resource.user.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 用户菜单服务实现
 *
 * @author jan
 * @create 2017-11-08 14:49
 **/
@Service
public class UserMenuServiceImpl implements UserMenuService {

    private static Log log = LogFactory.getLog(UserMenuServiceImpl.class);

    private static final String CACHE_KEY = "T(com.yundao.core.cache.interceptor.BaseKeyGenerator).getKey(#root" +
            ".targetClass,#tenantId,#userId)";

    @Autowired
    private ResourceService resourceService;

    @Override
    @Cacheable(value = "userMenu", key = CACHE_KEY)
    public ResourceResDto get(Long tenantId, Long userId) throws BaseException {
        return this.doGet(tenantId,userId);
    }

    private ResourceResDto doGet(Long tenantId, Long userId) throws BaseException {
        String logPrefix = "用户菜单||从DB获取||";
        log.info("%s tenantId=%s userId=%s", logPrefix, tenantId, userId);
        return resourceService.getUserMenu(userId);
    }

    @Override
    @CacheEvict(value = "userMenu", key = CACHE_KEY, beforeInvocation = true)
    public void clear(Long tenantId, Long userId) throws BaseException {

    }
}
