package com.yundao.tenant.service.user;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.user.role.UserRoleDto;
import com.yundao.tenant.dto.user.role.UserRoleInsertOrUpdateDto;
import com.yundao.tenant.dto.user.role.UserRolePageReqDto;
import com.yundao.tenant.dto.user.role.UserRolePageResDto;

public interface UserRoleService {

    /**
     * 添加用户的角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    public Integer insertUserRole(UserRoleInsertOrUpdateDto dto)throws BaseException;


    /**
     * 修改用户的角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    public Integer updateUserRole(UserRoleInsertOrUpdateDto dto)throws BaseException;

    /**
     * 获取用户角色分页数据
     *
     * @param dto 查询参数
     * @return 分页数据
     * @throws BaseException 异常信息
     */
    Result<PaginationSupport<UserRolePageResDto>> getUserRolePage(UserRolePageReqDto dto) throws BaseException;
    
    
    
	/**
	 * 查询用户角色信息
	 * @param userId
	 * @return
	 */
    public List<UserRoleDto> selectUserRoles(List<Long> userIds);
    
    /**
     * 通过用户id查询角色id集合
     * @param userId
     * @return
     */
    public List<Long> selectRoleIdsByUserId(Long userId);
    
    
    /**
     * 用户角色id查询在职用户id
     * @param userId
     * @return
     */
    public List<Long> selectUserIdsByRoleId(Long roleId);

    /**
     * 根据角色下的所有用户id
     *
     * @param roleId 角色id
     */
    List<Long> getUserIdByRole(Long roleId) throws BaseException;
}
