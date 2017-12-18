package com.yundao.tenant.service.role;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.common.IdNameDto;
import com.yundao.tenant.dto.role.RoleDetailResDto;
import com.yundao.tenant.dto.role.RoleReqDto;
import com.yundao.tenant.model.base.BaseRole;

import java.util.List;

/**
 * 角色服务接口
 *
 * @author jan
 * @create 2017-06-22 PM3:53
 **/
public interface RoleService {

    /**
     * 插入
     *
     * @param dto 请求dto
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    Result<Long> insert(RoleReqDto dto) throws BaseException;

    /**
     * 更新
     *
     * @param dto 请求dto
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    Result<Long> update(RoleReqDto dto) throws BaseException;

    /**
     * 根据id获取
     *
     * @param id 角色id
     */
    BaseRole get(Long id) throws BaseException;

    /**
     * 获取
     *
     * @param id 角色id
     * @return 响应dto
     * @throws BaseException 异常信息
     */
    Result<RoleDetailResDto> getById(Long id) throws BaseException;

    /**
     * 获取用户的角色
     *
     * @param userId 用户id
     * @return
     */
    List<IdNameDto> getByUserId(Long userId) throws BaseException;

    /**
     * 获取租户的所有角色
     *
     * @return 所有角色
     * @throws BaseException 异常信息
     */
    Result<List<RoleDetailResDto>> gets() throws BaseException;

    Result<List<Long>> getsByUserId() throws BaseException;

    /**
     * 删除
     *
     * @param id 角色id
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    Result<Boolean> delete(Long id) throws BaseException;

    /**
     * 检查是否存在，如果不存在直接返回
     *
     * @param id 角色id
     */
    void checkNotNullAndTerminal(Long id) throws BaseException;

    /**
     * 检查是否存在，如果不存在直接返回
     *
     * @param role 角色实体
     */
    void checkNotNullAndTerminal(BaseRole role) throws BaseException;

    /**
     * 检查角色是否存在
     */
    boolean checkRolesExist(List<Long> roleIds) throws BaseException;
}
