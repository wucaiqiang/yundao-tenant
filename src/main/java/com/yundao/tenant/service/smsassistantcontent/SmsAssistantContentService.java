package com.yundao.tenant.service.smsassistantcontent;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentAddReqDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentReqDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentResDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentUpdateDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantExeTimeUpdateDto;

public interface SmsAssistantContentService {

	public Result<Long> add(SmsAssistantContentAddReqDto reqDto) throws Exception;

	public Result<Long> update(SmsAssistantContentUpdateDto reqDto) throws Exception;
	public Result<Integer> updateExeTime(SmsAssistantExeTimeUpdateDto reqDto) throws Exception;

	public Result<Integer> delete(String ids) throws Exception;

	public Result<SmsAssistantContentResDto> get(Long id) throws Exception;

	public Result<List<SmsAssistantContentResDto>> getStayAlert() throws Exception;

	public Result<PaginationSupport<SmsAssistantContentResDto>> getPage(
			SmsAssistantContentReqDto smsAssistantContentReqDto, AbstractBasePageDto pageDto) throws Exception;

}
