package com.yundao.tenant.service.role.resource;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseRoleResource;

import java.util.List;

/**
 * 角色资源服务接口
 *
 * @author jan
 * @create 2017-06-23 PM4:32
 **/
public interface RoleResourceService {

    /**
     * 根据角色id获取 角色资源关系
     *
     * @param roleId 角色id
     * @return 角色资源关系
     * @throws BaseException 异常信息
     */
    List<BaseRoleResource> getByRoleId(Long roleId) throws BaseException;

    /**
     * 获取角色资源关系
     *
     * @param roleIds 角色id列表
     */
    List<BaseRoleResource> getByRoleIds(List<Long> roleIds) throws BaseException;


    /**
     * 插入
     *
     * @param models 角色资源
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    void insert(List<BaseRoleResource> models) throws BaseException;

    /**
     * 删除
     *
     * @param models 角色资源
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    void delete(List<BaseRoleResource> models) throws BaseException;
}
