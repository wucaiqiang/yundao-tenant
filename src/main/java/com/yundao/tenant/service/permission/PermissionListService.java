package com.yundao.tenant.service.permission;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.permission.PermissionListReqDto;
import com.yundao.tenant.dto.permission.PermissionListResDto;
import com.yundao.tenant.dto.permission.UserPermissionDto;

import java.util.List;

/**
 * 权限校验基础服务接口
 *
 * @author jan
 * @create 2017-08-05 PM11:45
 **/
public interface PermissionListService {

    /**
     * 多条数据校验是否具有对某个数据对象的操作权限
     *
     * @param dataObjectCode 数据对象编码
     * @param operation      操作类型
     * @param ownerIds       多条数据对应的拥有者id
     * @param tenantId       租户id
     * @param userId         当前操作人id
     */
    List<PermissionListResDto> checkList(String dataObjectCode, Integer operation, List<Long> ownerIds, Long tenantId,
                                         Long userId)
            throws
            BaseException;

    /**
     * 多条数据校验是否具有对某个数据对象的操作权限
     *
     * @param operation 操作类型
     * @param dtos      请求数据
     * @param tenantId  租户id
     * @param userId    当前操作人id
     */
    List<PermissionListResDto> checkList(Integer operation, List<PermissionListReqDto> dtos, Long tenantId, Long userId)
            throws
            BaseException;

    /**
     * 获取多个数据对象权限
     *
     * @param dataObjectCodes 数据对象编码
     * @param tenantId        租户id
     * @param userId          当前操作人id
     */
    List<UserPermissionDto> getUserPermissionByCodes(List<String> dataObjectCodes, Long tenantId, Long userId) throws
            BaseException;
}
