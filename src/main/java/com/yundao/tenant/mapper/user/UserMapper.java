package com.yundao.tenant.mapper.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.user.UserDetailResDto;
import com.yundao.tenant.dto.user.UserDimissionListReqDto;
import com.yundao.tenant.dto.user.UserDimissionListResDto;
import com.yundao.tenant.dto.user.UserListReqDto;
import com.yundao.tenant.dto.user.UserListResDto;
import com.yundao.tenant.dto.user.UserOptionResDto;
import com.yundao.tenant.dto.user.UserOrgDetailDto;
import com.yundao.tenant.dto.user.UserSimpleInfoDto;
import com.yundao.tenant.dto.user.role.UserRolePageResDto;

public interface UserMapper {

    /**
     * 查询用户列表
     *
     * @param reqDto
     * @return
     */
    List<UserListResDto> getUsers(UserListReqDto reqDto);

    /**
     * 查询用户总记录数
     *
     * @param reqDto
     * @return
     */
    int getUsersCount(UserListReqDto reqDto);

    /**
     * 获取角色关联用户分页数据
     *
     * @param params 查询参数
     * @return 分页数据
     */
    List<UserRolePageResDto> getUserRolePage(Map<String, Object> params) throws BaseException;

    /**
     * 获取角色关联用户总条数
     *
     * @param params 查询参数
     * @return 分页数据
     */
    Integer getUserRolePageCount(Map<String, Object> params) throws BaseException;

    /**
     * 查询用户详情
     *
     * @param UserId
     * @return
     */
    UserDetailResDto getUserDetail(@Param("userId") Long userId);

    /**
     * 分页查询离职或者在职用户
     *
     * @return
     */
    List<UserDimissionListResDto> getDimissionUsersPage(UserDimissionListReqDto reqDto);

    /**
     * 分页查询离职或者在职用户
     *
     * @return
     */
    int getDimissionUsersPageCount(UserDimissionListReqDto reqDto);

    /**
     * 获取在职用户下拉选择列表
     *
     * @param realName
     * @return
     */
    List<UserOptionResDto> getUsersByRealName(@Param("realName") String realName, @Param("count") Integer count);

    /**
     * 获取同一部门及下属部门所有用户
     *
     * @param departmentCode 部门编码
     */
    List<Long> selectSameDepUsers(@Param("departmentCode") String departmentCode);

    /**
     * 获取所有在职用户id集合
     *
     * @return
     */
    List<Long> getUserIds();

    void updateEnabled(@Param("ids") List<Long> ids, @Param("isEnabled") Integer isEnabled);

    /**
     * 获取部门下的用户id
     *
     * @param departmentName 部门名称
     */
    List<Long> selectLikeDepartmentName(@Param("departmentName") String departmentName) throws BaseException;
    /**
     * 获取没有归属部门的用户信息
     * getUserNotBelongToDepartment:
     * @author: wucq
     * @return
     * @throws BaseException
     * @description:
     */
    List<UserSimpleInfoDto> getUserNotBelongToDepartment() throws BaseException;

    UserOrgDetailDto selectUserDetailForOrg(@Param("userId") Long userId) throws BaseException;
}