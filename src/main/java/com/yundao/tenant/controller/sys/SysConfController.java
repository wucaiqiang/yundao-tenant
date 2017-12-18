package com.yundao.tenant.controller.sys;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.sys.sale.SaleConfOpenseaReqDto;
import com.yundao.tenant.dto.sys.sale.SaleConfResDto;
import com.yundao.tenant.service.sys.SysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统配置
 *
 * @author jan
 * @create 2017-11-03 13:52
 **/
@Controller
@ResponseBody
@RequestMapping("/sys/conf/")
@Api("系统配置")
public class SysConfController {

    @Autowired
    private SysConfigService sysConfigService;

    @RequestMapping(value = "/sale/get", method = RequestMethod.GET)
    @ApiOperation("获取销售管理配置")
    public Result<SaleConfResDto> getSaleConf() throws BaseException {
        return sysConfigService.getSaleConf();
    }

    @RequestMapping(value = "/sale/update", method = RequestMethod.POST)
    @ApiOperation("修改销售管理配置")
    public Result<Boolean> updateSaleConf(@ModelAttribute SaleConfOpenseaReqDto dto) throws BaseException {
        return sysConfigService.updateSaleConf(dto);
    }

}
