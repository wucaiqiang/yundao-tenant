package com.yundao.tenant.controller.customer.back;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.back.CustomerBackApplyReqDto;
import com.yundao.tenant.service.customer.back.CustomerBackExamineService;
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
 * 客户回退
 *
 * @author jan
 * @create 2017-08-10 PM3:35
 **/
@Controller
@RequestMapping("/customer/v2/back")
@ResponseBody
@Api("客户回退V2版本")
public class CustomerBackV2Controller {

    @Autowired
    private CustomerBackExamineService customerBackExamineService;

    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ApiOperation(value = "放弃客户")
    public Result<PermissionResultDto> apply(@Validated @ModelAttribute CustomerBackApplyReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        //默认不执行
        if (null == dto.getExecute())
            dto.setExecute(false);
        return customerBackExamineService.doApplyV2(dto);
    }

}
