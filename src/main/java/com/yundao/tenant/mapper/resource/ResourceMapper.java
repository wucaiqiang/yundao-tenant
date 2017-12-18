package com.yundao.tenant.mapper.resource;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.resource.AuthResDto;
import com.yundao.tenant.dto.resource.UserResDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {

    /**
     * 获取用户资源权限信息
     *
     * @param userId
     * @return
     * @throws BaseException
     */
    List<AuthResDto> getUserAuths(@Param("userId") Long userId);

    /**
     * 查询某个用户拥有指定资源的情况
     *
     * @param userId
     * @param resourceCodes
     * @return
     */
    List<String> getResourceCodes(@Param("userId") Long userId, @Param("resourceCodes") List<String> resourceCodes);

    /**
     * 查询拥有制定资源的用户
     *
     * @param resCodes
     * @return
     */
    List<UserResDto> getUserResDtos(@Param("resourceCodes") List<String> resCodes);

    /**
     * 获取系统管理菜单
     */
    List<Long> selectSystemMgrResourceId();
}
