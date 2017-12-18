package com.yundao.tenant.service.cc.ccticket;

import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.cc.BaseCcTicket;
import com.yundao.tenant.dto.cc.ccticket.CcTicketReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;


public interface CcTicketService{


    public Result<Integer> add(CcTicketReqDto reqDto) throws Exception;


    public Result<Integer> update(CcTicketReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCcTicket> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCcTicket>> getPage(CcTicketReqDto ccTicketReqDto, AbstractBasePageDto pageDto) throws Exception;

}
