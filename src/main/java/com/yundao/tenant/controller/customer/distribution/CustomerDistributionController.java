package com.yundao.tenant.controller.customer.distribution;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.CustomerMultiIdReqDto;
import com.yundao.tenant.dto.customer.distribution.CustomerAllotReqDto;
import com.yundao.tenant.dto.customer.distribution.CustomerAllotToCsReqDto;
import com.yundao.tenant.service.customer.distribution.CustomerDistributionService;
import com.yundao.tenant.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客户分配控制器
 *
 * @author jan
 * @create 2017-08-14 PM4:22
 **/
@Controller
@ResponseBody
@RequestMapping("/customer/distribution")
@Api("客户调配")
public class CustomerDistributionController {

    @Autowired
    private CustomerDistributionService customerDistributionService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/allot_to_fp", method = RequestMethod.POST)
    @ApiOperation("分配客户给理财师")
    public Result<PermissionResultDto> doAllotToFp(@Validated @ModelAttribute CustomerAllotReqDto dto, BindingResult bindingResult)
            throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return customerDistributionService.doAllotToFp(dto);
    }

    @RequestMapping(value = "/recycle", method = RequestMethod.POST)
    @ApiOperation("回收客户")
    public Result<PermissionResultDto> doRecycle(@Validated @ModelAttribute CustomerMultiIdReqDto dto, BindingResult bindingResult)
            throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return customerDistributionService.doRecycle(dto);
    }


    @RequestMapping(value = "/allot_to_cs", method = RequestMethod.POST)
    @ApiOperation("分配客户给客服")
    public Result<Boolean> doAllotToCs(@ModelAttribute @Validated CustomerAllotToCsReqDto dto, BindingResult bindingResult)
            throws BaseException {
        BindingResultHandler.handleByException(bindingResult);

        // 检查用户是否在职
        boolean userExist = userService.checkUserExist(dto.getCsId());
        if (!userExist) {
            return Result.newFailureResult(CodeConstant.CODE_1200018, "选择的客服不存在", null);
        }
        boolean isEnable = userService.checkUserIsEnable(dto.getCsId());
        if (!isEnable) {
            return Result.newFailureResult(CodeConstant.CODE_1200022, "选择的客服已被停用", null);
        }

        return customerDistributionService.doAllotToCs(dto);
    }

}
