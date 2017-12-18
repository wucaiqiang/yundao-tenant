package com.yundao.tenant.service.user.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.Code1230000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.user.*;
import com.yundao.tenant.dto.user.role.RoleSimpleDto;
import com.yundao.tenant.dto.user.role.UserRoleDto;
import com.yundao.tenant.dto.user.role.UserRoleInsertOrUpdateDto;
import com.yundao.tenant.dto.user.role.department.UserDepartmentDto;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.enums.user.UserLockEnum;
import com.yundao.tenant.mapper.base.BaseRoleMapper;
import com.yundao.tenant.mapper.base.BaseUserAccountMapper;
import com.yundao.tenant.mapper.base.BaseUserDetailMapper;
import com.yundao.tenant.mapper.user.UserMapper;
import com.yundao.tenant.model.base.*;
import com.yundao.tenant.service.department.DepartmentService;
import com.yundao.tenant.service.permission.UserPermissionService;
import com.yundao.tenant.service.resource.ResourceCacheService;
import com.yundao.tenant.service.user.*;
import com.yundao.tenant.service.workflow.WorkFlowGroupUserService;
import com.yundao.tenant.util.HttpUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用户管理
 *
 * @author 欧阳利 2017年6月22日
 */
@Service
public class UserServiceImpl extends AbstractService implements UserService {

    private static Log log = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    BaseUserAccountMapper baseUserAccountMapper;

    @Autowired
    UserDepartmentService userDepartmentService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    UserStaffService userStaffService;

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    BaseRoleMapper baseRoleMapper;

    @Autowired
    private ResourceCacheService resourceCacheService;


    @Autowired
    private WorkFlowGroupUserService workFlowGroupUserService;
    @Autowired
    private BaseUserDetailMapper baseUserDetailMapper;

    @Override
    public Result<Long> updateBaseInfo(Map<String, String> params) throws BaseException {

        if (params == null || params.isEmpty()) {
            return Result.newFailureResult();
        }
        BaseUserAccount userAccount = baseUserAccountMapper.selectByPrimaryKey(this.getHeaderUserId());

        if (params.containsKey("email")) {
            if (StringUtils.isNotBlank(params.get("email"))) {
                if (params.get("email").length() > 40) {
                    throw new BaseException(Code1230000.CODE_1230007);
                }
                userAccount.setEmail(params.get("email"));
            }else{
            	userAccount.setEmail(null);
            }
            baseUserAccountMapper.updateByPrimaryKey(userAccount);
        }

        if (params.containsKey("address")) {
            if (StringUtils.isNotBlank(params.get("address"))) {
                if (params.get("address").length() > 20) {
                    throw new BaseException(Code1230000.CODE_1230008);
                }
            }
        }
        if (params.containsKey("cardIntroduce")) {
            if (StringUtils.isNotBlank(params.get("cardIntroduce"))) {
                if (params.get("cardIntroduce").length() > 30) {
                    throw new BaseException(Code1230000.CODE_1230009);
                }
            }
        }
        if (params.containsKey("cardHeaderBit")) {
            if (StringUtils.isNotBlank(params.get("cardHeaderBit"))) {
                if (params.get("cardHeaderBit").length() > 10) {
                    throw new BaseException(Code1230000.CODE_1230010);
                }
            }
        }

        BaseUserDetailExample example = new BaseUserDetailExample();
        example.createCriteria().andUserAccountIdEqualTo(this.getHeaderUserId());
        BaseUserDetail detail = baseUserDetailMapper.selectOne(example);
        if (detail == null) {
            detail = new BaseUserDetail();
            detail.setCardIntroduce(params.get("cardIntroduce"));
            detail.setCardHeaderBit(params.get("cardHeaderBit"));
            detail.setAddress(params.get("address"));
            detail.setAvatar(params.get("avatar"));
            detail.setUserAccountId(this.getHeaderUserId());
            detail.setTenantId(this.getHeaderTenantId());
            userDetailService.insertUserDetail(detail, this.getHeaderUserId());
        } else {
            if (params.containsKey("cardHeaderBit")) {
                detail.setCardHeaderBit(params.get("cardHeaderBit"));
            }
            if (params.containsKey("cardIntroduce")) {
                detail.setCardIntroduce(params.get("cardIntroduce"));
            }
            if (params.containsKey("address")) {
                detail.setAddress(params.get("address"));
            }
            if (params.containsKey("avatar")) {
                detail.setAvatar(params.get("avatar"));
            }
            userDetailService.updateUserDetailAllProperties(detail);
        }

        return Result.newSuccessResult(userAccount.getId());

    }

    /**
     * 添加租户的超级管理员 addTenantSystemAdmin:
     *
     * @param reqDto
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    public Result<Long> addTenantSystemAdmin(TenantAdminAddReqDto reqDto) throws BaseException {
        // 查询超级管理员角色
        BaseRoleExample example = new BaseRoleExample();
        example.createCriteria().andIsSystemEqualTo(1);
        BaseRole role = baseRoleMapper.selectOne(example);
        if (role == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200133);
        }
        Long roleId = role.getId();

        List<Long> roleIds = new ArrayList<Long>();
        roleIds.add(roleId);

        UserAddReqDto userReqDto = new UserAddReqDto();
        userReqDto.setDepartmentId(0l);
        userReqDto.setMobile(reqDto.getMobile());
        userReqDto.setRealName(reqDto.getRealname());
        userReqDto.setRoleIds(roleIds);
        Long id = insertUser(userReqDto, reqDto.getUserId(), 1);
        return Result.newSuccessResult(id);
    }

    private Result<Long> addMobileUser(String mobile, String password) throws BaseException {
        // 公开库添加用户
        Map<String, Object> methodParams = new HashMap<String, Object>();
        methodParams.put("tenantId", this.getHeaderTenantId());
        methodParams.put("mobile", mobile);
        methodParams.put("password", password);
        return HttpUtils.post(ScmUrlConstant.ADD_USERACCOUNT_ADD, methodParams, new BaseTypeReference<Result<Long>>() {
        });
    }

    /**
     * 添加用户
     *
     * @param userReqDto
     * @return
     * @throws BaseException
     */
    public Long insertUser(UserAddReqDto userReqDto) throws Exception {
        log.info("添加用户信息：" + userReqDto);

        Result<Long> result = addMobileUser(userReqDto.getMobile(), userReqDto.getPassword());
        if (!result.getSuccess() || result.getResult() == null) {
            throw new BaseException(result.getCode(), result.getMessage());
        }

        return insertUser(userReqDto, result.getResult(), 0);

    }

    private Long insertUser(UserAddReqDto userReqDto, Long userId, Integer isSystem) throws BaseException {
        BaseUserAccount userAccount = null;
        try {
            Long createUserId = this.getHeaderUserId();
            Long tenantId = getHeaderTenantId();
            // 添加用户账户
            userAccount = UserAddReqDto.getBaseUserAccount(userReqDto);
            userAccount.setTenantId(tenantId);
            userAccount.setId(userId);
            userAccount.setIsSystem(isSystem);
            initAddUser(userAccount, createUserId);
            baseUserAccountMapper.insert(userAccount);

            // 添加用户详情
            BaseUserStaff userStaff = UserAddReqDto.getBaseUserStaff(userReqDto);
            userStaff.setUserAccountId(userAccount.getId());
            userStaff.setTenantId(tenantId);
            userStaffService.insertUserStaff(userStaff, createUserId);

            // 添加用户职员信息
            BaseUserDetail userDetail = UserAddReqDto.getBaseUserDetail(userReqDto);
            userDetail.setUserAccountId(userAccount.getId());
            userDetail.setTenantId(tenantId);
            userDetailService.insertUserDetail(userDetail, createUserId);

            // 添加用户所属部门
            BaseUserDepartment userDepartment = UserAddReqDto.getBaseUserDepartment(userReqDto);
            userDepartment.setUserAccountId(userAccount.getId());
            userDepartment.setTenantId(tenantId);
            userDepartmentService.insertUserDepartment(userDepartment, createUserId);

            // 添加用户的角色
            UserRoleInsertOrUpdateDto dto = new UserRoleInsertOrUpdateDto();
            dto.setCreateUserId(createUserId);
            dto.setRoleIds(userReqDto.getRoleIds());
            dto.setTenantId(tenantId);
            dto.setUserId(userAccount.getId());
            userRoleService.insertUserRole(dto);

            log.info("添加用户信息成功,用户id：" + userAccount.getId());

            // 更新用户角色的数据权限
            userPermissionService.clear(super.getHeaderTenantId());
        } catch (Exception e) {
            // 调用common服务，清楚关系/tenant/user/delete/user_tenant
            Map<String, Object> methodParams = new HashMap<String, Object>();
            methodParams.put("tenantId", this.getHeaderTenantId());
            methodParams.put("userId", userId);
            HttpUtils.post(ScmUrlConstant.DELETE_TENANT_USER_REF, methodParams, new BaseTypeReference<Result<Long>>() {
            });
            throw e;
        }
        return userAccount.getId();
    }

    /**
     * 添加用户
     *
     * @param userReqDto
     * @return
     * @throws BaseException
     */
    public Long updateUser(UserUpdateReqDto userReqDto) throws BaseException {
        log.info("修改用户信息：" + userReqDto);
        Long updateUserId = this.getHeaderUserId();
        Long tenantId = getHeaderTenantId();
        // 修改用户详情
        BaseUserDetail userDetail = new BaseUserDetail();
        userDetail.setUserAccountId(userReqDto.getId());
        userDetail.setRealName(userReqDto.getRealName());
        userDetailService.updateUserDetail(userDetail);

        // 修改用户所属部门
        BaseUserDepartment userDepartment = new BaseUserDepartment();
        userDepartment.setUserAccountId(userReqDto.getId());
        userDepartment.setDepartmentId(userReqDto.getDepartmentId());
        userDepartmentService.updateUserDeparment(userDepartment, updateUserId);


        // 检查是否是预置的管理员
        boolean isAdminSystem = this.checkUpdateSystemUserDeparmentOrRole(userReqDto.getId(),
                userReqDto.getDepartmentId(), userReqDto.getRoleIds());
        if (!isAdminSystem) {
            // 修改用户角色
            UserRoleInsertOrUpdateDto dto = new UserRoleInsertOrUpdateDto();
            dto.setUpdateUserId(updateUserId);
            dto.setRoleIds(userReqDto.getRoleIds());
            dto.setTenantId(tenantId);
            dto.setUserId(userReqDto.getId());
            userRoleService.updateUserRole(dto);
        }


        // 修改职员信息
        BaseUserStaff userStaff = new BaseUserStaff();
        userStaff.setUpdateUserId(updateUserId);
        userStaff.setUserAccountId(userReqDto.getId());
        userStaff.setJobNumber(userReqDto.getJobNumber());
        userStaff.setLeaderId(userReqDto.getLeaderId());
        userStaffService.updateUserStaff(userStaff);

        resourceCacheService.removeUserResourceCache(tenantId, userReqDto.getId());
        // 更新用户角色的数据权限
        userPermissionService.clear(tenantId);
        return userReqDto.getId();
    }

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     * @throws BaseException
     */
    public UserDetailResDto getUserDetail(Long userId) throws BaseException {
        UserDetailResDto dto = userMapper.getUserDetail(userId);
        if (dto != null) {
            // 设置部门信息
            List<Long> userIds = new ArrayList<Long>();
            userIds.add(dto.getId());
            List<UserDepartmentDto> userDepartmentDtos = userDepartmentService.selectUserDepartments(userIds);
            if (!BooleanUtils.isEmpty(userDepartmentDtos)) {
                for (UserDepartmentDto userDepartmentDto : userDepartmentDtos) {
                    if (userDepartmentDto.getUserId().equals(dto.getId())) {
                        dto.setDepartmentId(userDepartmentDto.getDepartmentId());
                        dto.setDepartmentName(userDepartmentDto.getDepartmentName());
                    }

                }
            }

            // 设置领导名称
            userIds.clear();
            if (dto.getLeaderId() != null) {
                userIds.add(dto.getLeaderId());
                List<BaseUserDetail> userDetails = userDetailService.getUserDetail(userIds);
                if (!BooleanUtils.isEmpty(userDetails)) {
                    dto.setLeaderName(userDetails.get(0).getRealName());
                }
            }

            // 设置角色id
            List<Long> userIdList = new ArrayList<>();
            userIdList.add(userId);
            List<UserRoleDto> userRoleDtos = userRoleService.selectUserRoles(userIdList);
            if (userRoleDtos != null && !userRoleDtos.isEmpty()) {
                List<Long> roleIds = new ArrayList<>();
                List<String> roleTexts = new ArrayList<>();
                for (UserRoleDto roleDto : userRoleDtos) {
                    roleIds.add(roleDto.getRoleId());
                    roleTexts.add(roleDto.getRoleName());
                }
                dto.setRoleIds(roleIds);
                dto.setRoleTexts(roleTexts);
            }
            // dto.setRoleIds(userRoleService.selectRoleIdsByUserId(userId));
        }

        return dto;
    }

    /**
     * 查询在职或者离职用户列表
     *
     * @param reqDto
     * @return
     */
    public Result<PaginationSupport<UserDimissionListResDto>> getDimissionUsers(UserDimissionListReqDto reqDto)
            throws BaseException {
        PaginationSupport<UserDimissionListResDto> result = reqDto.getPaginationSupport();

        // 设置部门id集合
        if (reqDto.getDepartmentId() != null && reqDto.getDepartmentId() != 0) {
            List<Long> departmentIds = departmentService.getAllChildsByDepartmentId(reqDto.getDepartmentId());
            departmentIds.add(reqDto.getDepartmentId());
            reqDto.setDepartmentIds(departmentIds);
        }

        int totalCount = userMapper.getDimissionUsersPageCount(reqDto);
        if (totalCount > 0) {
            // 重置排序
            resetGetDimissionUsersOrderBy(reqDto);
            List<UserDimissionListResDto> datas = userMapper.getDimissionUsersPage(reqDto);
            result.setDatas(datas);
            List<Long> userIds = new ArrayList<Long>();
            List<Long> leaderIds = new ArrayList<Long>();
            for (UserDimissionListResDto dto : datas) {
                userIds.add(dto.getId());
                if (dto.getLeaderId() != null) {
                    leaderIds.add(dto.getLeaderId());
                }
            }

            // 设置角色
            List<UserRoleDto> userRoleDtos = userRoleService.selectUserRoles(userIds);
            for (UserDimissionListResDto dto : datas) {
                if (!BooleanUtils.isEmpty(userRoleDtos)) {
                    List<RoleSimpleDto> roles = new ArrayList<RoleSimpleDto>();
                    for (UserRoleDto rserRoleDto : userRoleDtos) {
                        if (dto.getId().equals(rserRoleDto.getUserId())) {
                            RoleSimpleDto roleDto = new RoleSimpleDto();
                            BeanUtils.copyProperties(rserRoleDto, roleDto);
                            roles.add(roleDto);
                        }
                    }
                    dto.setRoles(roles);
                }

                dto.setRoleNames(getRoleNames(userRoleDtos, dto.getId()));
            }

            // 设置部门信息
            List<UserDepartmentDto> userDepartmentDtos = userDepartmentService.selectUserDepartments(userIds);
            if (!BooleanUtils.isEmpty(userDepartmentDtos)) {
                for (UserDimissionListResDto userDto : datas) {
                    for (UserDepartmentDto dto : userDepartmentDtos) {
                        if (dto.getUserId().equals(userDto.getId())) {
                            userDto.setDepartmentId(dto.getDepartmentId());
                            userDto.setDepartmentName(dto.getDepartmentName());
                        }
                    }
                }
            }

            // 设置领导名称信息
            List<BaseUserDetail> userDetails = userDetailService.getUserDetail(leaderIds);
            if (!BooleanUtils.isEmpty(userDetails)) {
                for (UserDimissionListResDto userDto : datas) {
                    for (BaseUserDetail dto : userDetails) {
                        if (userDto.getLeaderId() != null && userDto.getLeaderId().equals(dto.getUserAccountId())) {
                            userDto.setLeaderName(dto.getRealName());
                        }
                    }
                }
            }

        }
        result.setTotalCount(totalCount);
        return Result.newSuccessResult(result);
    }

    private List<String> getRoleNames(List<UserRoleDto> userRoleDtos, Long userId) {
        if (BooleanUtils.isEmpty(userRoleDtos)) {
            return null;
        }
        List<String> roleNames = new ArrayList<String>();
        for (UserRoleDto dto : userRoleDtos) {
            if (dto.getUserId().equals(userId)) {
                roleNames.add(dto.getRoleName());
            }
        }
        return roleNames;
    }

    /**
     * 查询用户列表
     *
     * @param reqDto
     * @return
     */
    public Result<PaginationSupport<UserListResDto>> getUsers(UserListReqDto reqDto) {
        PaginationSupport<UserListResDto> result = reqDto.getPaginationSupport();
        int totalCount = userMapper.getUsersCount(reqDto);
        if (totalCount > 0) {
            List<UserListResDto> datas = userMapper.getUsers(reqDto);
            result.setDatas(datas);
        }
        result.setTotalCount(totalCount);
        return Result.newSuccessResult(result);
    }

    /**
     * 初始化添加用户
     *
     * @param userAccount
     */
    private void initAddUser(BaseUserAccount userAccount, Long userId) {
        userAccount.setIsEnabled(EnabledEnum.ENABLED.getValue());
        userAccount.setIsLock(UserLockEnum.USER_NOT_LOCK.getValue());
        userAccount.setCreateDate(new Date());
        userAccount.setCreateUserId(userId);
        userAccount.setIsDelete(0);
    }

    /**
     * 判断手机号码是否已经存在
     *
     * @param mobile
     * @return
     */
    public CheckMobileResDto checkMobileExist(String mobile) throws BaseException {
        Map<String, Object> methodParams = new HashMap<String, Object>();
        methodParams.put("mobile", mobile);
        methodParams.put("tenantId", this.getHeaderTenantId());
        Result<CheckMobileResDto> result = HttpUtils.get(ScmUrlConstant.CHECK_MOBILE_EXIST, methodParams,
                new BaseTypeReference<Result<CheckMobileResDto>>() {
                });

        return result.getResult();
    }

    /**
     * 判断用户名是否已经存在
     *
     * @param username
     * @return
     */
    public boolean checkUsernameExist(String username) {
        BaseUserAccountExample example = new BaseUserAccountExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<BaseUserAccount> list = baseUserAccountMapper.selectByExample(example);
        return !BooleanUtils.isEmpty(list);
    }

    /**
     * 判断用户是否存在
     *
     * @param userId 用户id
     * @return
     */
    public boolean checkUserExist(Long userId) {
        if (userId == null) {
            return false;
        }
        BaseUserAccount baseUserAccount = baseUserAccountMapper.selectByPrimaryKey(userId);
        return baseUserAccount != null;
    }

    /**
     * 检查用户是否离职
     *
     * @param userId
     * @return
     * @throws BaseException
     */
    public boolean checkUserIsEnable(Long userId) throws BaseException {
        BaseUserAccount userAccount = baseUserAccountMapper.selectByPrimaryKey(userId);
        if (userAccount == null) {
            throw new BaseException(CodeConstant.CODE_1200018);
        }
        return EnabledEnum.ENABLED.getValue().equals(userAccount.getIsEnabled());
    }

    /**
     * 重置查询用户排序字段
     *
     * @param reqDto
     */
    private void resetGetDimissionUsersOrderBy(UserDimissionListReqDto reqDto) {
        String orderColumn = reqDto.getOrderColumn();
        String sort = reqDto.getSort();
        if (BooleanUtils.isBlank(orderColumn) || BooleanUtils.isBlank(sort)) {
            reqDto.setOrderColumn("ua.create_date");
            reqDto.setSort("desc");
            return;
        }
        if (orderColumn.equals("realName")) {
            reqDto.setOrderColumn("ud.real_name");
        } else if (orderColumn.equals("roleNames")) {
            reqDto.setOrderColumn("ro.name");
        } else if (orderColumn.equals("mobile")) {
            reqDto.setOrderColumn("ua.mobile");
        } else if (orderColumn.equals("jobNumber")) {
            reqDto.setOrderColumn("us.job_number");
        } else if (orderColumn.equals("departmentName")) {
            reqDto.setOrderColumn("de.name");
        } else if (orderColumn.equals("leaderName")) {
            reqDto.setOrderColumn("udetail.real_name");
        } else if (orderColumn.equals("enabledDate")) {
            reqDto.setOrderColumn("ua.enabled_date");
        }
    }

    /**
     * 查询在职用户
     *
     * @param realName
     * @return
     */
    public Result<List<UserOptionResDto>> getUsersByRealName(UserSearchReqDto reqDto) {
        String realName = "";
        if (BooleanUtils.isNotBlank(reqDto.getRealName())) {
            realName = reqDto.getRealName();
        }
        List<UserOptionResDto> list = userMapper.getUsersByRealName(realName.trim(), reqDto.getLimit());
        return Result.newSuccessResult(list);
    }

    /**
     * 获取当前用户的手机号码
     *
     * @return
     */
    public String getCurrentUserMobile() {
        BaseUserAccountExample example = new BaseUserAccountExample();
        example.createCriteria().andIdEqualTo(this.getHeaderUserId());
        BaseUserAccount user = baseUserAccountMapper.selectOne(example);
        if (user == null) {
            return null;
        }
        return user.getMobile();
    }

    @Override
    public List<Long> getSameDepUsers(Long userId) throws BaseException {
        BaseDepartment department = departmentService.getByUserId(userId);
        if (department == null)
            return new ArrayList<>(0);
        return userMapper.selectSameDepUsers(department.getCode());
    }

    /**
     * 获取同一部门及下属部门所有用户
     */
    public List<Long> getCurrentUserDepartmentUsers() throws BaseException {
        return this.getSameDepUsers(this.getHeaderUserId());
    }

    @Override
    public List<UserSimpleInfoDto> getUserNotBelongToDepartment() throws BaseException {
        return userMapper.getUserNotBelongToDepartment();
    }

    @Override
    public UserInfoDto getUserInfo(Long id) throws BaseException {
        BaseUserAccount user = baseUserAccountMapper.selectByPrimaryKey(id);
        if (user == null)
            return null;
        BaseUserStaff userStaff = userStaffService.getByUserId(id);
        log.info("userStaff:%s", JsonUtils.objectToJson(userStaff));
        if (userStaff == null)
            return null;
        UserInfoDto dto = new UserInfoDto();
        BeanUtils.copyProperties(user, dto);
        dto.setIsDimission(userStaff.getIsDimission());
        dto.setJobNumber(userStaff.getJobNumber());
        dto.setLeaderId(userStaff.getLeaderId());
        return dto;
    }

    @Override
    public void checkNotNullAndTerminal(Long id) throws BaseException {
        log.begin(id);
        BaseUserAccount user = baseUserAccountMapper.selectByPrimaryKey(id);
        if (user == null)
            throw new BaseException(CodeConstant.CODE_1200018);
    }

    /**
     * 检查是否有预置的超级管理员
     *
     * @param userId
     * @return
     * @throws BaseException
     */
    public boolean checkUserIsSystem(Long userId) throws BaseException {
        BaseUserAccount user = baseUserAccountMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return false;
        }
        return user.getIsSystem() == 1;
    }

    /**
     * 检查是否有修改超级管理员的部门和角色
     *
     * @param userId
     * @return true：有, false:没有
     * @throws BaseException
     */
    public boolean checkUpdateSystemUserDeparmentOrRole(Long userId, Long departmentId, List<Long> roleIds)
            throws BaseException {
        boolean isSystem = checkUserIsSystem(userId);
        if (!isSystem) {
            return false;
        }
        if (departmentId != 0) {
            return true;
        }

        List<Long> list = userRoleService.selectRoleIdsByUserId(userId);
        if (!BooleanUtils.isEmpty(list)) {
            if (!BooleanUtils.isEmpty(roleIds)) {
                return true;
            }
            if (list.size() != roleIds.size()) {
                return true;
            }
            for (Long oldId : list) {
                if (!roleIds.contains(oldId)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 获取所有在职用户id集合
     *
     * @return
     */
    public List<Long> getUserIds() throws BaseException {
        return userMapper.getUserIds();
    }

    @Override
    public List<Long> getIdByRole(Long roleId) throws BaseException {
        return userRoleService.getUserIdByRole(roleId);
    }

    @Override
    public void setPermissionCondition(Map<String, Object> paramMap, Integer permission) throws BaseException {
        paramMap.put("permission", permission);
        if (DataObjectPermissionEnum.PERSONAL.getValue().equals(permission)) {
            paramMap.put("userId", super.getHeaderUserId());
        } else if (DataObjectPermissionEnum.DEPARTMENT.getValue().equals(permission)) {
            List<Long> userIds = this.getSameDepUsers(super.getHeaderUserId());
            paramMap.put("userIds", SymbolStrUtils.longToStr(userIds));
        }
    }

    @Override
    public Result<Integer> processEnabled(List<Long> ids, Integer isEnabled) throws BaseException {
        userMapper.updateEnabled(ids, isEnabled);
        if (isEnabled.equals(com.yundao.core.constant.CommonConstant.ZERO)) {
            workFlowGroupUserService.doDimission(ids);
        }
        return Result.newSuccessResult(1);
    }

    @Override
    public List<Long> getLikeDepartmentName(String departmentName) throws BaseException {
        return userMapper.selectLikeDepartmentName(departmentName);
    }

    @Override
    public Result<UserOrgDetailDto> getUserDetailForOrg(Long userId) throws BaseException {
        UserOrgDetailDto user = userMapper.selectUserDetailForOrg(userId);
        if (user == null)
            return Result.newSuccessResult(user);

        List<Long> roleIds = userRoleService.selectRoleIdsByUserId(user.getId());
        if (BooleanUtils.isEmpty(roleIds))
            return Result.newSuccessResult(user);
        BaseRoleExample roleExample = new BaseRoleExample();
        roleExample.createCriteria().andIdIn(roleIds);
        List<BaseRole> roles = baseRoleMapper.selectByExample(roleExample);
        if (BooleanUtils.isEmpty(roles))
            return Result.newSuccessResult(user);

        List<RoleSimpleDto> rsDtos = new ArrayList<>();
        for (BaseRole role : roles) {
            RoleSimpleDto rsDto = new RoleSimpleDto();
            rsDto.setRoleId(role.getId());
            rsDto.setRoleName(role.getName());
            rsDtos.add(rsDto);
        }
        user.setRoles(rsDtos);
        user.setRoleNames(LambdaMap.toSingleList(rsDtos, RoleSimpleDto::getRoleName));
        return Result.newSuccessResult(user);
    }

    @Override
    public Result<Boolean> checkCanAdd() throws BaseException {
        Map<String, Object> param = new HashMap<>();
        param.put("tenantId", super.getHeaderTenantId());
        Integer limitCount = HttpUtils
                .get(ScmUrlConstant.GET_LIMIT_EMPLOYEE_COUNT, param, new BaseTypeReference<Result<Integer>>() {
                }).getResult();

        BaseUserAccountExample example = new BaseUserAccountExample();
        example.createCriteria().andIsEnabledEqualTo(YesOrNoEnum.YES.getValue());
        int existCount = baseUserAccountMapper.countByExample(example);

        return Result.newSuccessResult(existCount < limitCount);

    }
}