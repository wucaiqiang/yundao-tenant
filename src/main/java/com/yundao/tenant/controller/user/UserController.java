package com.yundao.tenant.controller.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.RequestUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.Code1220000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.user.CheckMobileResDto;
import com.yundao.tenant.dto.user.TenantAdminAddReqDto;
import com.yundao.tenant.dto.user.UserAddReqDto;
import com.yundao.tenant.dto.user.UserDetailResDto;
import com.yundao.tenant.dto.user.UserDimissionListReqDto;
import com.yundao.tenant.dto.user.UserDimissionListResDto;
import com.yundao.tenant.dto.user.UserListReqDto;
import com.yundao.tenant.dto.user.UserListResDto;
import com.yundao.tenant.dto.user.UserOptionResDto;
import com.yundao.tenant.dto.user.UserOrgDetailDto;
import com.yundao.tenant.dto.user.UserSearchReqDto;
import com.yundao.tenant.dto.user.UserUpdateReqDto;
import com.yundao.tenant.dto.user.role.UserRolePageReqDto;
import com.yundao.tenant.dto.user.role.UserRolePageResDto;
import com.yundao.tenant.service.department.DepartmentService;
import com.yundao.tenant.service.role.RoleService;
import com.yundao.tenant.service.user.UserRoleService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.service.user.UserStaffService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理
 *
 * @author 欧阳利 2017年6月22日
 */
@RestController
@RequestMapping("/user")
@ResponseBody
@Api("用户管理")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserStaffService userStaffService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    RoleService roleService;

    
	@RequestMapping(value = "/app/update_base_info", method = RequestMethod.POST)
	@ApiOperation(value = "修改用户基本信息", notes = "修改用户基本信息")
	public Result<Long> updateInfoForApp(HttpServletRequest request) throws Exception {
		Map<String, String> params = RequestUtils.getParameterMap(request);
		return userService.updateBaseInfo(params);
 	}
    /**
     * 添加租户超级管理员 addTenantSystemUser:
     *
     * @return
     * @throws Exception
     * @author: 欧阳利
     * @description:
     */
    @ApiOperation(value = "添加租户超级管理员", notes = "添加租户超级管理员")
    @RequestMapping(value = "/add/system/admin", method = RequestMethod.POST)
    public Result<Long> addTenantSystemAdmin(@Validated @ModelAttribute TenantAdminAddReqDto reqDto,
                                             BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);

        return userService.addTenantSystemAdmin(reqDto);
    }

    /**
     * 添加用户信息
     *
     * @param userReqDto
     * @return
     */
    @ApiOperation(value = "添加用户", notes = "添加用户信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Long> addUser(@Validated @ModelAttribute UserAddReqDto userReqDto, BindingResult bindingResult)
            throws Exception {
        BindingResultHandler.handleByException(bindingResult);

        // 检查部门是否存在
        Boolean departmentExist = departmentService.checkDepartmentExist(userReqDto.getDepartmentId());
        if (!departmentExist) {
            return Result.newFailureResult(CodeConstant.CODE_1200004);
        }

        // 检查角色是否正确
        if (BooleanUtils.isEmpty(userReqDto.getRoleIds())) {
            return Result.newFailureResult(CodeConstant.CODE_1200036);
        }
        Boolean rolesExist = roleService.checkRolesExist(userReqDto.getRoleIds());
        if (!rolesExist) {
            return Result.newFailureResult(CodeConstant.CODE_1200003);
        }

        Boolean canAdd = userService.checkCanAdd().getResult();
        if (!canAdd)
            throw new BaseException(Code1220000.CODE_1220152);

        // 检查领导是否存在
        if (userReqDto.getLeaderId() != null) {
            Boolean leaderExist = userService.checkUserExist(userReqDto.getLeaderId());
            if (!leaderExist) {
                return Result.newFailureResult(CodeConstant.CODE_1200037);
            }
        }

        // 检查工号是否存在
        if (!BooleanUtils.isBlank(userReqDto.getJobNumber())) {
            boolean jobNumberExist = userStaffService.checkJobNumberExist(userReqDto.getJobNumber());
            if (jobNumberExist) {
                return Result.newFailureResult(CodeConstant.CODE_1200021);
            }
        }

        Long userId = userService.insertUser(userReqDto);
        return Result.newSuccessResult(userId);
    }

    /**
     * 修改用户信息
     *
     * @param UsereqDto
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    public Result<Long> modifyUser(@Validated @ModelAttribute UserUpdateReqDto useReqDto, BindingResult bindingResult)
            throws Exception {
        BindingResultHandler.handleByException(bindingResult);

        // 检查部门是否存在
        Boolean departmentExist = departmentService.checkDepartmentExist(useReqDto.getDepartmentId());
        if (!departmentExist) {
            return Result.newFailureResult(CodeConstant.CODE_1200004);
        }

        // 检查角色是否正确
        if (BooleanUtils.isEmpty(useReqDto.getRoleIds())) {
            return Result.newFailureResult(CodeConstant.CODE_1200036);
        }
        Boolean rolesExist = roleService.checkRolesExist(useReqDto.getRoleIds());
        if (!rolesExist) {
            return Result.newFailureResult(CodeConstant.CODE_1200003);
        }

        // 检查领导是否存在
        if (useReqDto.getLeaderId() != null) {
            Boolean leaderExist = userService.checkUserExist(useReqDto.getLeaderId());
            if (!leaderExist) {
                return Result.newFailureResult(CodeConstant.CODE_1200037);
            }
        }

        // 检查工号是否存在
        if (!BooleanUtils.isBlank(useReqDto.getJobNumber())) {
            boolean jobNumberExist = userStaffService.checkJobNumberExist(useReqDto.getId(), useReqDto.getJobNumber());
            if (jobNumberExist) {
                return Result.newFailureResult(CodeConstant.CODE_1200021);
            }
        }

        // 检查用户是否能正常使用
        boolean isEnable = userService.checkUserIsEnable(useReqDto.getId());
        if (!isEnable) {
            return Result.newFailureResult(CodeConstant.CODE_1200022, "已被停用用户不能编辑!", null);
        }
        Long userId = userService.updateUser(useReqDto);
        return Result.newSuccessResult(userId);
    }

    /**
     * 查询用户详细信息
     *
     * @param UserId
     * @return
     */
    @RequestMapping(value = "/get_by_id", method = RequestMethod.GET)
    @ApiOperation(value = "通过用户id查询用户详情", notes = "通过用户id查询用户详情")
    public Result<UserDetailResDto> getUserDetail(@RequestParam Long id) throws BaseException {
        if (id == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200038);
        }
        UserDetailResDto dto = userService.getUserDetail(id);
        if (dto == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200018);
        }
        return Result.newSuccessResult(dto);
    }

    /**
     * 查询离职用户列表
     *
     * @param reqDto
     * @return
     */
    @RequestMapping(value = "/get_cease_users", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询停用用户列表", notes = "分页查询停用户列表")
    public Result<PaginationSupport<UserDimissionListResDto>> getCeaseUsers(
            @ModelAttribute UserDimissionListReqDto reqDto) throws BaseException {
        reqDto.setIsEnabled(CommonConstant.ZERO);
        reqDto.setOrderColumn("enabledDate");
        reqDto.setSort("desc");
        Result<PaginationSupport<UserDimissionListResDto>> result = userService.getDimissionUsers(reqDto);
        return result;
    }

    /**
     * 查询在职用户列表
     *
     * @param reqDto
     * @return
     */
    @RequestMapping(value = "/get_enabled_users", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询在职用户列表", notes = "分页查询在职用户列表")
    public Result<PaginationSupport<UserDimissionListResDto>> getEnabledUsers(
            @ModelAttribute UserDimissionListReqDto reqDto) throws BaseException {
        reqDto.setIsEnabled(CommonConstant.ONE);
        return userService.getDimissionUsers(reqDto);
    }

    /**
     * 查询用户列表
     *
     * @param reqDto
     * @return
     */
    // @RequestMapping(value = "/get_users", method = RequestMethod.GET)
    // @ApiOperation(value = "分页查询用户列表", notes = "分页查询用户列表")
    public Result<PaginationSupport<UserListResDto>> getUsers(@ModelAttribute UserListReqDto reqDto) {
        return userService.getUsers(reqDto);
    }

    @ApiOperation(value = "用户启用", notes = "用户启用")
    @RequestMapping(value = "/enabled", method = RequestMethod.POST)

    public Result<Integer> enabled(@RequestParam List<Long> ids) throws BaseException {
        if (BooleanUtils.isEmpty(ids)) {
            return Result.newFailureResult(CodeConstant.CODE_1200000);
        }
        for (Long id : ids) {
            // 检查用户是否存在
            boolean isExist = userService.checkUserExist(id);
            if (!isExist) {
                return Result.newFailureResult(CodeConstant.CODE_1200018);
            }
        }

        Boolean canAdd = this.checkCanAdd().getResult();
        if (!canAdd)
            throw new BaseException(Code1220000.CODE_1220154);

        return userService.processEnabled(ids, CommonConstant.ONE);
    }

    /**
     * 用户离职
     *
     * @param userId
     * @return
     */
    @ApiOperation(value = "用户停用", notes = "用户停用")
    @RequestMapping(value = "/cease", method = RequestMethod.POST)
    public Result<Integer> cease(@RequestParam List<Long> ids) throws BaseException {
        if (BooleanUtils.isEmpty(ids)) {
            return Result.newFailureResult(CodeConstant.CODE_1200000);
        }
        for (Long id : ids) {
            // 检查用户是否存在
            boolean isExist = userService.checkUserExist(id);
            if (!isExist) {
                return Result.newFailureResult(CodeConstant.CODE_1200018);
            }
            // 检查用户是否在职
            // boolean isDimission = userStaffService.checkDimission(id);
            // if (isDimission) {
            // return Result.newFailureResult(CodeConstant.CODE_1200022,
            // "用户已经离职", null);
            // }

            // 检查是否是预置的管理员
            boolean isSystem = userService.checkUserIsSystem(id);
            if (isSystem) {
                return Result.newFailureResult(CodeConstant.CODE_1200046);
            }
        }
        return userService.processEnabled(ids, CommonConstant.ZERO);
    }

    /**
     * 获取角色关联的用户分页数据
     *
     * @param dto           查询参数
     * @param bindingResult 验证返回
     * @return 查询结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/get_by_role", method = RequestMethod.GET)
    public Result<PaginationSupport<UserRolePageResDto>> getUserRolePage(
            @Validated @ModelAttribute UserRolePageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return userRoleService.getUserRolePage(dto);
    }

    /**
     * 检查手机号码是否已经存在
     *
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/check_mobile_exist", method = RequestMethod.GET)
    @ApiOperation(value = "检查手机号码是否已经使用", notes = "检查手机号码是否已经使用")
    public Result<CheckMobileResDto> checkMobileExist(@RequestParam String mobile) throws BaseException {
        // 检查手机号码是否存在
        if (BooleanUtils.isBlank(mobile)) {
            return Result.newFailureResult(CodeConstant.CODE_1220023);
        }
        CheckMobileResDto checkMobileResDto = userService.checkMobileExist(mobile);
        return Result.newSuccessResult(checkMobileResDto);

    }


    /**
     * 检查工号是否已经存在
     *
     * @param jobNumber
     * @return
     */
    @ApiOperation(value = "检查工号是否存在", notes = "检查工号是否存在")
    @RequestMapping(value = "/check_job_number_exist", method = RequestMethod.GET)

    public Result<Boolean> checkJobNumberExist(@RequestParam String jobNumber) {
        // 检查工号是否已经存在
        if (BooleanUtils.isBlank(jobNumber)) {
            return Result.newFailureResult(CodeConstant.CODE_1200050);
        }
        boolean usernameExist = userStaffService.checkJobNumberExist(jobNumber);
        return Result.newSuccessResult(usernameExist);
    }

    /**
     * 获取角色下的所有用户id
     *
     * @param roleId
     */
    @RequestMapping(value = "/get_id_by_role", method = RequestMethod.GET)
    @ApiOperation(value = "获取角色下的所有用户id")
    public Result<List<Long>> getIdsByRole(@RequestParam Long roleId) throws BaseException {
        return Result.newSuccessResult(userService.getIdByRole(roleId));
    }

    /**
     * 通过真实姓名查找在职用户
     *
     * @param realName
     * @return
     */
    @ApiOperation(value = "通过真实姓名查找在职用户下拉选项", notes = "通过真实姓名查找在职用户下拉选项")
    @RequestMapping(value = "/get_users_by_realName", method = RequestMethod.GET)
    public Result<List<UserOptionResDto>> getUsersByRealName(@ModelAttribute UserSearchReqDto reqDto) {
        return userService.getUsersByRealName(reqDto);
    }

    @ApiOperation(value = "获取同一部门及下属部门所有用户", notes = "获取同一部门及下属部门所有用户")
    @RequestMapping(value = "/get_current_user_department_user", method = RequestMethod.GET)
    public Result<List<Long>> getSameDepUsers() throws BaseException {
        return Result.newSuccessResult(userService.getCurrentUserDepartmentUsers());
    }


    /**
     * 检查用户名是否已经存在
     */
    @RequestMapping(value = "/check_username_exist", method = RequestMethod.GET)
    @ApiOperation(value = "检查登录用户名是否已经使用", notes = "检查登录用户名码是否已经使用")
    public Result<Boolean> checkUsernameExist(@RequestParam String username) {
        // 检查登录名称是否存在
        if (BooleanUtils.isBlank(username)) {
            return Result.newFailureResult(CodeConstant.CODE_1200051);
        }
        boolean usernameExist = userService.checkUsernameExist(username);
        return Result.newSuccessResult(usernameExist);
    }


    @ApiOperation(value = "检查是否能够添加员工")
    @RequestMapping(value = "/check_can_add", method = RequestMethod.GET)
    public Result<Boolean> checkCanAdd() throws BaseException {
        return userService.checkCanAdd();
    }

    @ApiOperation(value = "组织架构用户详情")
    @RequestMapping(value = "/get_for_org", method = RequestMethod.GET)
    public Result<UserOrgDetailDto> getForOrg(@RequestParam Long id) throws BaseException {
        return userService.getUserDetailForOrg(id);
    }
}
