package com.yundao.tenant.service.resource;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.resource.AuthResDto;
import com.yundao.tenant.dto.resource.MenuResDto;
import com.yundao.tenant.dto.resource.ResourceResDto;
import com.yundao.tenant.dto.resource.UserResDto;
import com.yundao.tenant.model.base.BaseResource;

import java.util.List;

/**
 * 权限资源服务接口
 *
 * @author jan
 * @create 2017-06-23 PM4:14
 **/
public interface ResourceService {

    /**
     * 查询拥有该资源的在职用户
     * getUserIds:
     *
     * @param resourceCode
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    List<Long> getUserIds(String resourceCode) throws BaseException;


    /**
     * 根据角色id获取权限资源
     *
     * @param roleId 角色id
     * @return 权限资源列表
     * @throws BaseException 异常信息
     */
    Result<List<MenuResDto>> getsByRoleId(Long roleId) throws BaseException;

    /**
     * 更新角色资源
     *
     * @param resourcesIds 已勾选的资源ids
     * @param roleId       角色id
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    Result<Integer> updateRoleResource(String resourcesIds, Long roleId) throws BaseException;

    /**
     * 获取当前用户的菜单资源
     *
     * @return 菜单资源
     * @throws BaseException 异常信息
     */
    ResourceResDto getUserMenu(Long userId) throws BaseException;


    Result<List<BaseResource>> getsByUserId() throws BaseException;

    /**
     * 获取用户的资源
     *
     * @param userId 用户id
     * @return 权限资源url列表
     */
    List<BaseResource> getUserResources(Long userId) throws BaseException;

    /**
     * 获取所有资源
     */
    List<MenuResDto> gets() throws BaseException;

    /**
     * 获取用户的菜单资源地址
     *
     * @param userId 用户id
     */
    Result<List<String>> getUserUrls(Long userId) throws BaseException;

    /**
     * 获取当前用户的功能权限
     *
     * @return
     * @throws BaseException
     */
    Result<List<AuthResDto>> getCurrentUserAuths() throws BaseException;

    /**
     * 获取拥有某个资源的用户列表
     *
     * @param code 资源CODE
     */
    List<UserResDto> getUserByCode(String code) throws BaseException;

    /**
     * 获取所有资源
     */
    List<BaseResource> getAll() throws BaseException;

}
