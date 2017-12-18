package com.yundao.tenant.controller.role;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.controller.BaseController;
import com.yundao.tenant.dto.role.RoleDetailResDto;
import com.yundao.tenant.dto.role.RoleReqDto;
import com.yundao.tenant.service.role.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色控制器
 *
 * @author jan
 * @create 2017-06-22 PM4:26
 **/
@Controller
@RequestMapping("/role")
@ResponseBody
@Api("角色权限管理")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 添加角色
     *
     * @param dto 请求dto
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加角色", notes = "参数id不需填写，返回角色id")
    public Result<Long> add(@Validated(Insert.class) @ModelAttribute RoleReqDto dto, BindingResult bindingResult) throws
            BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return roleService.insert(dto);
    }

    /**
     * 修改角色
     *
     * @param dto 请求dto
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改角色")
    public Result<Long> update(@Validated(Update.class) @ModelAttribute RoleReqDto dto, BindingResult bindingResult)
            throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return roleService.update(dto);
    }

    /**
     * 获取角色
     *
     * @param id 角色id
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "获取角色")
    public Result<RoleDetailResDto> get(@RequestParam Long id) throws BaseException {
        super.checkRoleIdNotNull(id);
        return roleService.getById(id);
    }

    /**
     * 获取租户的角色列表
     *
     * @return 角色列表
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation(value = "获取租户的角色列表")
    public Result<List<RoleDetailResDto>> gets() throws BaseException {
        return roleService.gets();
    }

    @RequestMapping(value = "/gets_by_user_id", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户的角色列表")
    public Result<List<Long>> getsByUserId() throws BaseException {
        return roleService.getsByUserId();
    }

    /**
     * 删除角色
     *
     * @param id 角色id
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除角色")
    public Result<Boolean> delete(@RequestParam Long id) throws BaseException {
        super.checkRoleIdNotNull(id);
        return roleService.delete(id);
    }

}
