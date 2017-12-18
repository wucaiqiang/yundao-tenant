package com.yundao.tenant.service.resource.user;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.resource.ResourceResDto;

/**
 * 用户菜单服务接口
 *
 * @author jan
 * @create 2017-11-08 14:46
 **/
public interface UserMenuService {

    /**
     * 获取用户菜单
     *
     * @param tenantId 租户id
     * @param userId   用户id
     */
    ResourceResDto get(Long tenantId, Long userId) throws BaseException;

    /**
     * 清除缓存数据
     *
     * @param tenantId 租户id
     * @param userId   用户id
     */
    void clear(Long tenantId, Long userId) throws BaseException;
}
