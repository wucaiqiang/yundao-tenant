package com.yundao.tenant.mapper.permission;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.permission.UserPermissionDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jan
 * @create 2017-08-04 PM9:19
 **/
public interface PermissionMapper {

    /**
     * 获取用户的数据权限
     *
     * @param tenantId 租户id
     */
    List<UserPermissionDto> selectUserPermission(@Param("tenantId") Long tenantId) throws BaseException;

}
