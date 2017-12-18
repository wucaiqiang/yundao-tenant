package com.yundao.tenant.controller.customercenter;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.customercenter.consult.ConsultFPReqDto;
import com.yundao.tenant.dto.customercenter.consult.ConsultProductReqDto;
import com.yundao.tenant.service.customercenter.ConsultService;
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
 * C端客户预约
 *
 * @author jan
 * @create 2017-09-07 AM11:28
 **/
@Controller
@ResponseBody
@RequestMapping("/consult")
@Api("C端客户预约")
public class ConsultController {

    @Autowired
    private ConsultService consultService;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ApiOperation("预约产品")
    public Result<Long> addForProduct(@Validated @ModelAttribute ConsultProductReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return consultService.addForProduct(dto);
    }

    @RequestMapping(value = "/fp", method = RequestMethod.POST)
    @ApiOperation("预约理财师")
    public Result<Long> addForFP(@Validated @ModelAttribute ConsultFPReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return consultService.addForFP(dto);
    }

}
