package com.yundao.tenant.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.utils.ThreadUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.login.LoginLogAddReqDto;
import com.yundao.tenant.service.loginlog.LoginLogService;
import com.yundao.tenant.util.HeaderUserThreadLocal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理
 *
 * @author 欧阳利 2017年6月22日
 */
@RestController
@RequestMapping("/login/log")
@ResponseBody
@Api("登录日志相关")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 新增登录日志
     *z @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增登录日志")
    public Result<Long> addLoginLog(@Validated @ModelAttribute LoginLogAddReqDto dto, BindingResult bindingResult)throws BaseException{
        BindingResultHandler.handleByException(bindingResult);
        HeaderUser user = (HeaderUser)ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
        ThreadUtils.execute(() -> {
        	HeaderUserThreadLocal.set(user);
            loginLogService.add(dto);
        });
         return Result.newSuccessResult(1L);
    }
}
