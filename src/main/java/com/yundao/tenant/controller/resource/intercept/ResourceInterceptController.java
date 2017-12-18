package com.yundao.tenant.controller.resource.intercept;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.resource.AuthResultDto;
import com.yundao.tenant.service.resource.intercept.ResourceInterceptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 资源拦截器
 *
 * @author jan
 * @create 2017-11-07 14:08
 **/
@Controller
@RequestMapping("/resource/intercept")
@ResponseBody
@Api("资源拦截")
public class ResourceInterceptController {

    @Autowired
    private ResourceInterceptService resourceInterceptService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @ApiOperation("鉴权")
    public Result<AuthResultDto> authenticate(@RequestParam String url) throws BaseException {
        return Result.newSuccessResult(resourceInterceptService.doAuthenticate(url));
    }

}
