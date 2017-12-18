package com.yundao.tenant.service.resource;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.resource.AuthResourceDto;

/**
 * 鉴权资源服务
 *
 * @author jan
 * @create 2017-11-07 18:54
 **/
public interface AuthResourceService {

    /**
     * 获取租户所有鉴权资源
     *
     * @param tenantId 租户id
     */
    AuthResourceDto get(Long tenantId) throws BaseException;

    /**
     * 从新加载数据
     *
     * @param tenantId 租户id
     */
    AuthResourceDto reload(Long tenantId) throws BaseException;

    /**
     * 清除缓存数据
     *
     * @param tenantId 租户id
     */
    void clear(Long tenantId) throws BaseException;

}
