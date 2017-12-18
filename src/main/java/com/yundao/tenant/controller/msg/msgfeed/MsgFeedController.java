package com.yundao.tenant.controller.msg.msgfeed;
import com.yundao.tenant.dto.BasePageDto;

import com.yundao.tenant.dto.msg.msgfeed.MsgFeedResDto;
import com.yundao.tenant.service.msg.msgfeed.MsgFeedService;
import com.yundao.tenant.model.base.msg.BaseMsgFeed;
import com.yundao.tenant.dto.msg.msgfeed.MsgFeedReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.validator.group.Update;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/msg/feed/")
@ResponseBody
@Api("动态")
public class MsgFeedController{

    @Autowired
    private MsgFeedService msgFeedService;

//    @RequestMapping(value = "get_page",method=RequestMethod.GET)
//    @ApiOperation(value="分页查询动态")
//    public Result<PaginationSupport<BaseMsgFeed>> getPage(@ModelAttribute MsgFeedReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
//		return msgFeedService.getPage(dto, pageDto);
//    }

    @RequestMapping(value = "get_customer_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询客户动态")
    public Result<PaginationSupport<MsgFeedResDto>> getCustomerPage(@RequestParam Long customerId,@RequestParam(required = false) Integer firstType, @ModelAttribute BasePageDto pageDto) throws Exception{
		return msgFeedService.getCustomerPage(customerId,firstType, pageDto);
    }

//    @RequestMapping(value="add", method=RequestMethod.POST)
//    @ApiOperation(value="新增动态", notes="根据MsgFeed对象创建动态")
//    public Result<Integer> add(@Validated @ModelAttribute MsgFeedReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return msgFeedService.add(reqDto);
//    }
//
//    @RequestMapping(value = "update", method=RequestMethod.POST)
//    @ApiOperation(value="编辑动态信息")
//    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute MsgFeedReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return msgFeedService.update(reqDto);
//    }
//
//    @RequestMapping(value = "get", method=RequestMethod.GET)
//    @ApiOperation(value="获取动态详细信息")
//    public Result<BaseMsgFeed> get(@RequestParam Long id) throws Exception{
//       return msgFeedService.get(id);
//    }
//
//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除动态信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return msgFeedService.delete(id);
//    }

}
