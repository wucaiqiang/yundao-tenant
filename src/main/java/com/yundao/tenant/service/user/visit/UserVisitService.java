package com.yundao.tenant.service.user.visit;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.customer.customer.CustomerDetailVisitPageReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerDetailVisitPageResDto;
import com.yundao.tenant.dto.operation.visit.UserVisitAddReqDto;
import com.yundao.tenant.dto.user.visit.UserVisitDetailForLeads;
import com.yundao.tenant.dto.user.visit.UserVisitDto;
import com.yundao.tenant.dto.user.visit.UserVisitPageReqDto;
import com.yundao.tenant.dto.user.visit.UserVisitPageResDto;

/**
 * 客户回访服务接口
 *
 * @author jan
 * @create 2017-08-11 AM10:21
 **/
public interface UserVisitService {

    /**
     * 回访
     */
    Result<Long> doVisit(UserVisitAddReqDto dto) throws BaseException;

    /**
     * 获取“客户详情”页的回访记录
     */
    Result<PaginationSupport<CustomerDetailVisitPageResDto>> getCustomerDetailVisitPage(CustomerDetailVisitPageReqDto dto, Integer permission) throws BaseException;

    /**
     * 获取分页数据
     */
    Result<PaginationSupport<UserVisitPageResDto>> getPage(UserVisitPageReqDto dto, Integer permission) throws BaseException;

    /**
     * 获取线索列表页的回访详情
     *
     * @param leadsId 线索id
     */
    Result<UserVisitDetailForLeads> getForLeads(Long leadsId) throws BaseException;
    Result<UserVisitDto> get(Long id) throws BaseException;
}
