package com.yundao.tenant.service.user;

import java.util.List;
import java.util.Map;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.user.CheckMobileResDto;
import com.yundao.tenant.dto.user.TenantAdminAddReqDto;
import com.yundao.tenant.dto.user.UserAddReqDto;
import com.yundao.tenant.dto.user.UserDetailResDto;
import com.yundao.tenant.dto.user.UserDimissionListReqDto;
import com.yundao.tenant.dto.user.UserDimissionListResDto;
import com.yundao.tenant.dto.user.UserInfoDto;
import com.yundao.tenant.dto.user.UserListReqDto;
import com.yundao.tenant.dto.user.UserListResDto;
import com.yundao.tenant.dto.user.UserOptionResDto;
import com.yundao.tenant.dto.user.UserOrgDetailDto;
import com.yundao.tenant.dto.user.UserSearchReqDto;
import com.yundao.tenant.dto.user.UserSimpleInfoDto;
import com.yundao.tenant.dto.user.UserUpdateReqDto;

/**
 * 用户管理
 *
 * @author 欧阳利
 *         2017年6月22日
 */
public interface UserService {
	
	public Result<Long> updateBaseInfo(Map<String, String> params) throws BaseException ;
    /**
     * 添加租户的超级管理员
     * addTenantSystemAdmin:
     *
     * @param reqDto
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    public Result<Long> addTenantSystemAdmin(TenantAdminAddReqDto reqDto) throws BaseException;


    /**
     * 添加用户
     *
     * @param userReqDto
     * @return
     * @throws BaseException
     */
    public Long insertUser(UserAddReqDto userReqDto) throws Exception;


    /**
     * 添加用户
     *
     * @param userReqDto
     * @return
     * @throws BaseException
     */
    public Long updateUser(UserUpdateReqDto userReqDto) throws BaseException;


    /**
     * 查询用户详情
     *
     * @param UserId
     * @return
     * @throws BaseException
     */
    public UserDetailResDto getUserDetail(Long UserId) throws BaseException;


    /**
     * 查询离职或者用户列表
     *
     * @param reqDto
     * @return
     */
    public Result<PaginationSupport<UserDimissionListResDto>> getDimissionUsers(UserDimissionListReqDto reqDto) throws BaseException;


    /**
     * 查询用户列表
     *
     * @param reqDto
     * @return
     */
    public Result<PaginationSupport<UserListResDto>> getUsers(UserListReqDto reqDto);


    /**
     * 判断手机号码是否已经存在
     *
     * @param mobile
     * @return
     */
    public CheckMobileResDto checkMobileExist(String mobile) throws BaseException;


    /**
     * 判断用户名是否已经存在
     *
     * @param username
     * @return
     */
    public boolean checkUsernameExist(String username);


    /**
     * 判断用户是否存在
     *
     * @param userId 用户id
     * @return
     */
    public boolean checkUserExist(Long userId);

    /**
     * 查询在职用户
     *
     * @param realName
     * @return
     */
    Result<List<UserOptionResDto>> getUsersByRealName(UserSearchReqDto reqDto);

    /**
     * 获取当前用户的手机号码
     *
     * @return
     */
    String getCurrentUserMobile();

    /**
     * 获取同一部门及下属部门所有用户
     */
    List<Long> getSameDepUsers(Long userId) throws BaseException;

    /**
     * 获取同一部门及下属部门所有用户
     */
    List<Long> getCurrentUserDepartmentUsers() throws BaseException;
    /**
     * 获取没有归属部门的用户信息
     * getUsersNotBelongToDepartment:
     * @author: wucq
     * @return
     * @throws BaseException
     * @description:
     */
    List<UserSimpleInfoDto> getUserNotBelongToDepartment() throws BaseException;

    /**
     * 获取用户信息
     *
     * @param id 用户id
     */
    UserInfoDto getUserInfo(Long id) throws BaseException;

    /**
     * 检查是否存在，如果不存在，直接返回
     *
     * @param id 用户id
     */
    void checkNotNullAndTerminal(Long id) throws BaseException;

    /**
     * 检查是否有预置的超级管理员
     *
     * @param userId
     * @return
     * @throws BaseException
     */
    boolean checkUserIsSystem(Long userId) throws BaseException;

    /**
     * 检查是否有修改超级管理员的部门和角色
     *
     * @param userId
     * @return true：有, false:没有
     * @throws BaseException
     */
    boolean checkUpdateSystemUserDeparmentOrRole(Long userId, Long departmentId, List<Long> roleIds) throws BaseException;

    /**
     * 检查用户是否能正常使用
     *
     * @param userId
     * @return 是否离职
     * @throws BaseException
     */
    boolean checkUserIsEnable(Long userId) throws BaseException;

    /**
     * 获取所有在职用户id集合
     *
     * @return
     */
    public List<Long> getUserIds() throws BaseException;

    /**
     * 根据角色下的所有用户id
     *
     * @param roleId 角色id
     */
    List<Long> getIdByRole(Long roleId) throws BaseException;

    /**
     * 设置访问数据的权限条件
     *
     * @param paramMap   参数
     * @param permission 权限值
     */
    void setPermissionCondition(Map<String, Object> paramMap, Integer permission) throws BaseException;

    /**
     * 启用或停用用户
     *
     * @param ids
     * @return
     */
    Result<Integer> processEnabled(List<Long> ids, Integer isEnabled) throws BaseException;

    /**
     * 通过模糊查询获取部门下的用户id
     *
     * @param departmentName 部门名称
     */
    List<Long> getLikeDepartmentName(String departmentName) throws BaseException;

    /**
     * 组织架构 用户详情
     *
     * @param userId 客户id
     */
    Result<UserOrgDetailDto> getUserDetailForOrg(Long userId) throws BaseException;

    /**
     * 检查是否能够添加员工
     */
    Result<Boolean> checkCanAdd() throws BaseException;
}