package com.yundao.tenant.service.permission.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.dto.permission.UserPermissionDto;
import com.yundao.tenant.mapper.permission.PermissionMapper;
import com.yundao.tenant.service.permission.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户权限服务实现
 *
 * @author jan
 * @create 2017-08-20 PM2:57
 **/
@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    private static Log log = LogFactory.getLog(UserPermissionServiceImpl.class);

    private static final String CACHE_KEY = "T(com.yundao.core.cache.interceptor.BaseKeyGenerator).getKey(#root.targetClass,#tenantId)";

    @Autowired
    private PermissionMapper permissionMapper;

    @Cacheable(value = "userPermissionList", key = CACHE_KEY)
    @Override
    public List<UserPermissionDto> gets(Long tenantId) throws BaseException {
        log.info("从DB获取数据");
        return this.doGets(tenantId);
    }


    @CachePut(value = "userPermissionList", key = CACHE_KEY)
    @Override
    public List<UserPermissionDto> reload(Long tenantId) throws BaseException {
        return this.doGets(tenantId);
    }

    @CacheEvict(value = "userPermissionList", key = CACHE_KEY, beforeInvocation = true)
    @Override
    public void clear(Long tenantId) throws BaseException {
        log.info("UserPermissionServiceImpl clear complete!");
    }

    private List<UserPermissionDto> doGets(Long tenantId) throws BaseException {
        return permissionMapper.selectUserPermission(tenantId);
    }
}
