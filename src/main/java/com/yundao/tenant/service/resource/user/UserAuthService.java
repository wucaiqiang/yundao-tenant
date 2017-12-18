package com.yundao.tenant.service.resource.user;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.resource.AuthResourceDto;

/**
 * 用户鉴权服务
 *
 * @author jan
 * @create 2017-11-07 20:04
 **/
public interface UserAuthService {

    /**
     * 获取用户拥有的权限资源
     *
     * @param tenantId 租户id
     * @param userId   用户id
     */
    AuthResourceDto get(Long tenantId, Long userId) throws BaseException;

    /**
     * 重新加载数据
     *
     * @param tenantId 租户id
     * @param userId   用户id
     */
    AuthResourceDto reload(Long tenantId, Long userId) throws BaseException;

    /**
     * 清除缓存
     *
     * @param tenantId 租户id
     * @param userId   用户id
     */
    void clear(Long tenantId, Long userId) throws BaseException;

}
