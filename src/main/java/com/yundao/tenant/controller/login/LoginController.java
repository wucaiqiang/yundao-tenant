package com.yundao.tenant.controller.login;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.login.RetrievePasswordDto;
import com.yundao.tenant.dto.user.password.UserUpdatePasswordReqDto;
import com.yundao.tenant.enums.sms.template.CaptchaTempEnum;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理
 *
 * @author 欧阳利 2017年6月22日
 */
@RestController
@RequestMapping("/user")
@ResponseBody
@Api("登录相关")
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 修改用户密码
     *
     * @param userReqDto
     * @return
     */
    @RequestMapping(value = "/update_password", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    public Result<Integer> updateUserPassword(@ModelAttribute @Validated UserUpdatePasswordReqDto userReqDto,
                                              BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        // 查询用户的手机号码
        String mobile = userService.getCurrentUserMobile();
        if (mobile == null) {
            return Result.newFailureResult(1, "当前用户不存在,请登录！", null);
        }
        // 修改密码
        Map<String, Object> methodParams = new HashMap<String, Object>();
        methodParams.put("userName", mobile);
        methodParams.put("oldPassword", userReqDto.getOldPassword());
        methodParams.put("newPassword", userReqDto.getNewPassword());
        Result<Integer> result = HttpUtils.post(ScmUrlConstant.USER_UPDATE_PASSWORD, methodParams,
                new BaseTypeReference<Result<Integer>>() {
                });

        return result;
    }

}
