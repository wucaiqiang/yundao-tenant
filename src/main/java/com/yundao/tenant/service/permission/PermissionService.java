package com.yundao.tenant.service.permission;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.permission.UserPermissionDto;

/**
 * 权限校验基础服务接口
 *
 * @author jan
 * @create 2017-08-02 PM12:50
 **/
public interface PermissionService {

    /**
     * 获取用户对某个数据对象的操作权限
     *
     * @param dataObjectCode 数据对象编码
     * @param operation      操作类型
     * @param tenantId       租户id
     * @param userId         用户id
     */
    Integer get(String dataObjectCode, Integer operation, Long tenantId, Long userId) throws BaseException;


    /**
     * 获取用户对某个数据对象的操作权限
     *
     * @param dataObjectCode 数据对象编码
     * @param tenantId       租户id
     * @param userId         用户id
     */
    UserPermissionDto get(String dataObjectCode, Long tenantId, Long userId) throws BaseException;

    /**
     * 判断用户是否能对某个数据对象进行操作
     *
     * @param dataObjectCode 数据对象编码
     * @param operation      操作类型
     * @param ownerId        数据的拥有者id
     * @param tenantId       租户id
     * @param userId         用户id
     */
    Boolean check(String dataObjectCode, Integer operation, Long ownerId, Long tenantId, Long userId) throws
            BaseException;

}
