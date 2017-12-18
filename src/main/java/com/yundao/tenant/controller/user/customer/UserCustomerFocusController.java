package com.yundao.tenant.controller.user.customer;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.CustomerMultiIdReqDto;
import com.yundao.tenant.service.user.customer.UserCustomerFocusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 关注客户
 *
 * @author jan
 * @create 2017-08-10 AM9:03
 **/
@Controller
@RequestMapping("/user/customer")
@ResponseBody
@Api("客户关注")
public class UserCustomerFocusController {

    @Autowired
    private UserCustomerFocusService userCustomerFocusService;

    @RequestMapping(value = "/focus", method = RequestMethod.POST)
    @ApiOperation("批量关注")
    public Result<Boolean> focus(@Validated @ModelAttribute CustomerMultiIdReqDto dto, BindingResult bindingResult)
            throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return userCustomerFocusService.doFocus(dto);
    }

    @RequestMapping(value = "/v2/focus", method = RequestMethod.POST)
    @ApiOperation("批量关注v2版接口")
    public Result<Boolean> focusV2(@Validated @ModelAttribute CustomerMultiIdReqDto dto, BindingResult bindingResult)
            throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return userCustomerFocusService.doFocus(dto);
    }

    @RequestMapping(value = "/unfocus", method = RequestMethod.POST)
    @ApiOperation("取消关注")
    public Result<Boolean> reverse(@RequestParam Long customerId) throws BaseException {
        if (customerId == null)
            throw new BaseException(CodeConstant.CODE_1220045);
        return userCustomerFocusService.doUnFocus(customerId);
    }
}
