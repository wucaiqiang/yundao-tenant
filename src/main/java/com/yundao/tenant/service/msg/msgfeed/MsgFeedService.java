package com.yundao.tenant.service.msg.msgfeed;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.msg.msgfeed.MsgFeedResDto;
import com.yundao.tenant.model.base.msg.BaseMsgFeed;
import com.yundao.tenant.dto.msg.msgfeed.MsgFeedReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import io.swagger.models.auth.In;


public interface MsgFeedService{


    public Result<Integer> add(MsgFeedReqDto reqDto) throws Exception;


    public Result<Integer> update(MsgFeedReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseMsgFeed> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseMsgFeed>> getPage(MsgFeedReqDto msgFeedReqDto, AbstractBasePageDto pageDto) throws Exception;

    Result<PaginationSupport<MsgFeedResDto>> getCustomerPage(Long customerId, Integer firstType, BasePageDto pageDto) throws BaseException;
}
