package com.yundao.tenant.controller.user.fp;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.user.UserOptionResDto;
import com.yundao.tenant.service.user.fp.FpService;
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
 * 理财师控制器
 *
 * @author jan
 * @create 2017-08-15 PM3:48
 **/
@Controller
@RequestMapping("/user/fp")
@ResponseBody
@Api("理财师")
public class FpController {

    @Autowired
    private FpService fpService;

    @RequestMapping(value = "/get_by_name", method = RequestMethod.GET)
    @ApiOperation("根据姓名获取理财师信息")
    public Result<List<UserOptionResDto>> getsByName(@RequestParam String name) throws BaseException {
        return fpService.getsByName(name);
    }

}