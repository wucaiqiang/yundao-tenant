package com.yundao.tenant.service.permission;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.permission.UserPermissionDto;

import java.util.List;
import java.util.Map;

/**
 * 用户权限服务接口
 *
 * @author jan
 * @create 2017-08-20 PM2:57
 **/
public interface UserPermissionService {

    /**
     * 获取租户所有用户权限
     *
     * @param tenantId 租户id
     */
    List<UserPermissionDto> gets(Long tenantId) throws BaseException;

    /**
     * 从新加载数据
     *
     * @param tenantId 租户id
     */
    List<UserPermissionDto> reload(Long tenantId) throws BaseException;

    /**
     * 清空
     *
     * @param tenantId 租户id
     */
    void clear(Long tenantId) throws BaseException;

}
