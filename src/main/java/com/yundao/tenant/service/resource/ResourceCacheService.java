package com.yundao.tenant.service.resource;

import com.yundao.core.exception.BaseException;

/**
 * 资源缓存服务接口
 *
 * @author jan
 * @create 2017-09-26 AM11:38
 **/
public interface ResourceCacheService {

    /**
     * 移除角色下所有用户资源缓存数据
     *
     * @param tenantId 租户id
     * @param roleId   用户id
     */
    void removeRoleCache(Long tenantId, Long roleId) throws BaseException;

    /**
     * 移除所有系统所有基本资源 缓存数据
     *
     * @param tenantId 租户id
     */
    void removeBaseResourceCache(Long tenantId) throws BaseException;

    /**
     * 移除用户对应的资源 缓存数据
     *
     * @param tenantId 租户id
     * @param userId   用户id
     */
    void removeUserResourceCache(Long tenantId, Long userId) throws BaseException;
}
