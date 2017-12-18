package com.yundao.tenant.mapper.permission;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.permission.UserPermissionDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jan
 * @create 2017-08-04 PM9:19
 **/
public interface PermissionListMapper {
    
    /**
     * 获取用户的数据权限
     *
     * @param userId 用户id
     * @param codes  数据对象编码列表
     */
    List<UserPermissionDto> selectUserPermissionByCodes(@Param("userId") Long userId, @Param("codes") List<String> codes) throws
            BaseException;
}
