package com.yundao.tenant.controller.resource;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.tenant.controller.BaseController;
import com.yundao.tenant.dto.resource.AuthResDto;
import com.yundao.tenant.dto.resource.MenuResDto;
import com.yundao.tenant.dto.resource.ResourceResDto;
import com.yundao.tenant.model.base.BaseResource;
import com.yundao.tenant.service.resource.ResourceService;
import com.yundao.tenant.service.resource.user.UserMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 权限资源控制器
 *
 * @author jan
 * @create 2017-06-23 PM5:29
 **/
@Controller
@RequestMapping("/resource")
@ResponseBody
@Api("权限资源")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserMenuService userMenuService;

    /**
     * 获取角色的资源
     *
     * @param roleId 角色id
     * @return 角色资源
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/get_by_role_id", method = RequestMethod.GET)
    @ApiOperation(value = "获取角色资源", notes = "管理员为该角色设置权限资源时使用")
    public Result<List<MenuResDto>> getByRoleId(@RequestParam Long roleId) throws BaseException {
        super.checkRoleIdNotNull(roleId);
        return resourceService.getsByRoleId(roleId);
    }

    /**
     * 设置角色的资源
     *
     * @param resourceIds 多个资源id,以逗号分隔
     * @param roleId      角色id
     * @return 操作结果
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "update_by_role_id", method = RequestMethod.POST)
    @ApiOperation(value = "设置角色资源", notes = "管理员为该角色设置权限资源")
    public Result<Integer> updateByRoleId(@RequestParam String resourceIds, @RequestParam Long roleId) throws
            BaseException {
        super.checkRoleIdNotNull(roleId);
        return resourceService.updateRoleResource(resourceIds, roleId);
    }

    /**
     * 获取当前用户的菜单资源
     *
     * @return 菜单资源
     * @throws BaseException 异常信息
     */
    @RequestMapping(value = "/get_menu", method = RequestMethod.GET)
    @ApiOperation(value = "获取当前用户的菜单资源", notes = "当前用户：userId在请求头设置即可")
    public Result<ResourceResDto> getMenu() throws BaseException {
        HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
        return Result.newSuccessResult(userMenuService.get(user.getTenantId(), user.getUserId()));
    }

    @RequestMapping(value = "/get_my", method = RequestMethod.GET)
    @ApiOperation(value = "获取当前用户的菜单资源", notes = "当前用户：userId在请求头设置即可")
    public Result<List<BaseResource>> getsByUserId() throws BaseException {
        return resourceService.getsByUserId();
    }

    @RequestMapping(value = "/get_user_urls", method = RequestMethod.GET)
    @ApiOperation(value = "获取当前用户的菜单资源地址")
    public Result<List<String>> getUserUrls(@RequestParam Long userId) throws BaseException {
        return resourceService.getUserUrls(userId);
    }

    @RequestMapping(value = "/get_current_user_auths", method = RequestMethod.GET)
    @ApiOperation(value = "获取当前用户的功能权限", notes = "当前用户：userId在请求头设置即可")
    public Result<List<AuthResDto>> getCurrentUserAuths() throws BaseException {
        return resourceService.getCurrentUserAuths();
    }

    /**
     * 获取所有资源
     */
    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有资源")
    public Result<List<MenuResDto>> gets() throws BaseException {
        return Result.newSuccessResult(resourceService.gets());
    }

}
