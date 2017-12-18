package com.yundao.tenant.mapper.resource.user;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.resource.AuthMenuDto;
import com.yundao.tenant.dto.resource.api.AuthApiDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jan
 * @create 2017-11-08 08:05
 **/
public interface UserAuthMapper {

    /**
     * 获取用户拥有的功能菜单
     *
     * @param userId 用户id
     */
    List<AuthMenuDto> selectUserMenus(@Param("userId") Long userId) throws BaseException;

    /**
     * 根据功能菜单，获取下面的api接口
     *
     * @param resourceIds 功能菜单集合
     */
    List<AuthApiDto> selectUserApis(@Param("resourceIds") List<Long> resourceIds) throws BaseException;
}
