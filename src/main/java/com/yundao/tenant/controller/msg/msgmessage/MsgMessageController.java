package com.yundao.tenant.controller.msg.msgmessage;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.MapUtils;
import com.yundao.core.utils.RequestUtils;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.msg.msgmessage.MsgMessageCountResDto;
import com.yundao.tenant.dto.msg.msgmessage.MsgMessagePageResDto;
import com.yundao.tenant.dto.msg.msgmessage.MsgMessageReqDto;
import com.yundao.tenant.enums.msg.MsgMessageFirstTypeEnum;
import com.yundao.tenant.model.base.msg.BaseMsgMessage;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.Map;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/msg/message/")
@ResponseBody
@Api("消息表")
public class MsgMessageController{

    @Autowired
    private MsgMessageService msgMessageService;

    @RequestMapping(value = "get_my_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询自己的消息")
    public Result<PaginationSupport<MsgMessagePageResDto>> getMyPage(@ModelAttribute MsgMessageReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return msgMessageService.getPage(dto, pageDto);
    }

    @RequestMapping(value = "get_unread_count",method=RequestMethod.GET)
    @ApiOperation(value="获取未读数")
    public Result<MsgMessageCountResDto> getUnreadCount() throws Exception{
		return msgMessageService.getUnreadCount();
    }
    @RequestMapping(value = "/get_todo_count",method=RequestMethod.GET)
    @ApiOperation(value="获取未读数")
    public Result<Integer> getCount(@RequestParam(required=false) Date beginDate,@RequestParam(required=false) Date endDate) throws Exception{
		return msgMessageService.getUnreadCountByTypeAndTime(MsgMessageFirstTypeEnum.MESSAGE_TYPE_1.getType(), beginDate,endDate);
    }
    @RequestMapping(value = "get_unread_count_by_type",method=RequestMethod.GET)
    @ApiOperation(value="获取未读数")
    public Result<Integer> getUnreadCountByType(@RequestParam(required=false) Integer type,@RequestParam(required=false) Date fromDate) throws Exception{
		return msgMessageService.getUnreadCountByType(type, fromDate);
    }
    @RequestMapping(value = "read",method=RequestMethod.GET)
    @ApiOperation(value="已读")
    public Result<Integer> read(@RequestParam String ids) throws Exception{
		return msgMessageService.processRead(ids);
    }
    @RequestMapping(value = "readAll",method=RequestMethod.GET)
    @ApiOperation(value="全部已读")
    public Result<Integer> readAll(@RequestParam(required=false) Integer type) throws Exception{
		return msgMessageService.processReadAll(type);
    }

//    @RequestMapping(value="add", method=RequestMethod.POST)
//    @ApiOperation(value="新增消息表", notes="根据MsgMessage对象创建消息表")
//    public Result<Integer> add(@Validated @ModelAttribute MsgMessageReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return msgMessageService.add(reqDto);
//    }
//
//    @RequestMapping(value = "update", method=RequestMethod.POST)
//    @ApiOperation(value="编辑消息表信息")
//    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute MsgMessageReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return msgMessageService.update(reqDto);
//    }
//
//    @RequestMapping(value = "get", method=RequestMethod.GET)
//    @ApiOperation(value="获取消息表详细信息")
//    public Result<BaseMsgMessage> get(@RequestParam Long id) throws Exception{
//       return msgMessageService.get(id);
//    }
//
//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除消息表信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return msgMessageService.delete(id);
//    }
//
    @RequestMapping(value = "send_message",method=RequestMethod.POST)
    @ApiOperation(value = "发送消息")
    public Result<Long> sendMessage(HttpServletRequest request, @RequestParam String code,@RequestParam Long customerId) throws BaseException {
        Map<String,Object> params = MapUtils.cast(RequestUtils.getParameterMap(request));
        return msgMessageService.processSendCustomerMessage(code,customerId,params);
    }

    @RequestMapping(value = "send_messagetest",method=RequestMethod.POST)
    @ApiOperation(value = "发送消息2")
    public Result<Long> sendMessageTest(HttpServletRequest request, @RequestParam String code,@RequestParam Long customerId) throws BaseException {
        Map<String,Object> params = MapUtils.cast(RequestUtils.getParameterMap(request));
        params.put("customerName","name");
        params.put("channel","C_H5");
        return msgMessageService.processSendCustomerMessage(code,customerId,params);
    }
//
//    @RequestMapping(value = "sendMessage2",method=RequestMethod.POST)
//    @ApiOperation(value = "发送消息2")
//    public Result<Long> sendMessage2(HttpServletRequest request,@RequestParam String code) throws BaseException{
//        Map<String,Object> params = MapUtils.cast(RequestUtils.getParameterMap(request));
//        return msgMessageService.processSendMessage(code,params);
//    }

}
