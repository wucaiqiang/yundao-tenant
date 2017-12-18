package com.yundao.tenant.controller.cc.ccticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.service.ticket.AbstractTicketService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/cc/ticket/")
@ResponseBody
@Api("投资用户登录凭证")
public class CcTicketController{

    @Autowired
    private AbstractTicketService ccTicketService;

    @RequestMapping(value = "validate",method=RequestMethod.GET)
    @ApiOperation(value="验证登陆凭证")
    public Result<Boolean> doValidate(@RequestParam String ticket) throws Exception{
        return ccTicketService.doValidate(ticket);
    }

    @RequestMapping(value = "do_refresh",method=RequestMethod.GET)
    @ApiOperation(value="刷新ticket")
    public Result<String> doRefresh(@RequestParam String ticket) throws Exception{
        return ccTicketService.doRefresh(ticket);
    }
    
/*
    @RequestMapping(value = "update_expireTime",method=RequestMethod.GET)
    @ApiOperation(value="更新ticket时间")
    public Result<Integer> updateExpireTime(@RequestParam String ticket) throws Exception{
        return ccTicketService.updateExpireTime(ticket);
    }
*/
//    @RequestMapping(value="add", method=RequestMethod.POST)
//    @ApiOperation(value="新增投资用户登录凭证", notes="根据CcTicket对象创建投资用户登录凭证")
//    public Result<Integer> add(@Validated @ModelAttribute CcTicketReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return ccTicketService.add(reqDto);
//    }
//
//    @RequestMapping(value = "update", method=RequestMethod.POST)
//    @ApiOperation(value="编辑投资用户登录凭证信息")
//    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute CcTicketReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return ccTicketService.update(reqDto);
//    }
//
//    @RequestMapping(value = "get", method=RequestMethod.GET)
//    @ApiOperation(value="获取投资用户登录凭证详细信息")
//    public Result<BaseCcTicket> get(@RequestParam Long id) throws Exception{
//       return ccTicketService.get(id);
//    }
//
//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除投资用户登录凭证信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return ccTicketService.delete(id);
//    }

}
