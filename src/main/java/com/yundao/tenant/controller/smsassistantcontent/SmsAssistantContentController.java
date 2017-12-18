package com.yundao.tenant.controller.smsassistantcontent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentAddReqDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentReqDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentResDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentUpdateDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantExeTimeUpdateDto;
import com.yundao.tenant.service.smsassistantcontent.SmsAssistantContentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/sms/assistant/content/")
@ResponseBody
@Api("短信助手发送的短信内容")
public class SmsAssistantContentController {

	@Autowired
	private SmsAssistantContentService smsAssistantContentService;

	@RequestMapping(value = "get_page", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询短信助手发送的短信内容")
	public Result<PaginationSupport<SmsAssistantContentResDto>> getPage(@ModelAttribute SmsAssistantContentReqDto dto,
			@ModelAttribute BasePageDto pageDto) throws Exception {
		return smsAssistantContentService.getPage(dto, pageDto);
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "新增短信助手发送的短信内容", notes = "根据SmsAssistantContent对象创建短信助手发送的短信内容")
	public Result<Long> add(@Validated @ModelAttribute SmsAssistantContentAddReqDto reqDto, BindingResult bindingResult)
			throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return smsAssistantContentService.add(reqDto);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ApiOperation(value = "编辑短信助手发送的短信内容信息")
	public Result<Long> update(@Validated @ModelAttribute SmsAssistantContentUpdateDto reqDto,
			BindingResult bindingResult) throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return smsAssistantContentService.update(reqDto);
	}

	@RequestMapping(value = "update_exe_time", method = RequestMethod.POST)
	@ApiOperation(value = "设置短信发送提醒时间")
	public Result<Integer> updateExeTime(
			@Validated @ModelAttribute SmsAssistantExeTimeUpdateDto reqDto,
			BindingResult bindingResult) throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return smsAssistantContentService.updateExeTime(reqDto);
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ApiOperation(value = "获取短信助手发送的短信内容详细信息")
	public Result<SmsAssistantContentResDto> get(@RequestParam Long id) throws Exception {
		return smsAssistantContentService.get(id);
	}

	@RequestMapping(value = "get_stay_alert", method = RequestMethod.GET)
	@ApiOperation(value = "获取待提醒短信")
	public Result<List<SmsAssistantContentResDto>> getStayAlert() throws Exception {
		return smsAssistantContentService.getStayAlert();
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ApiOperation(value = "删除短信助手发送的短信内容信息")
	public Result<Integer> delete(@RequestParam String ids) throws Exception {
		return smsAssistantContentService.delete(ids);
	}

}
