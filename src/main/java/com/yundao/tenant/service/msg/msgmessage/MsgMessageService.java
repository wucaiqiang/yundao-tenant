package com.yundao.tenant.service.msg.msgmessage;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.msg.msgmessage.MsgMessageCountResDto;
import com.yundao.tenant.dto.msg.msgmessage.MsgMessagePageResDto;
import com.yundao.tenant.model.base.msg.BaseMsgMessage;
import com.yundao.tenant.dto.msg.msgmessage.MsgMessageReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;

import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.RequestParam;


public interface MsgMessageService{


    public Result<Integer> add(MsgMessageReqDto reqDto) throws Exception;


    public Result<Integer> update(MsgMessageReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseMsgMessage> get(Long id) throws Exception;

    public Result<PaginationSupport<MsgMessagePageResDto>> getPage(MsgMessageReqDto msgMessageReqDto, AbstractBasePageDto pageDto) throws Exception;

    /**
     * 发送消息接口
     * @param code 对应模板表code
     * @param obj 实体dto或map，不允许基础数据类型
     * @return
     * @throws BaseException
     */
    Result<Long> processSendMessage(String code, Object obj) throws BaseException;

//    Result<Long> processSendMessage(String code, Object obj,boolean isNotSendUser) throws BaseException;

    Result<MsgMessageCountResDto> getUnreadCount() throws Exception;
    Result<Integer> getUnreadCountByType(Integer type,Date fromDate) throws Exception;
    Result<Integer> getUnreadCountByTypeAndTime(Integer type,Date beginDate,Date endDate) throws Exception;

    Result<Integer> processRead(String ids)throws BaseException;
    Result<Integer> processReadAll(Integer type)throws BaseException;

    Result<Long> processSendCustomerMessage(String code, Long customerId, Map<String, Object> params) throws BaseException;
}
