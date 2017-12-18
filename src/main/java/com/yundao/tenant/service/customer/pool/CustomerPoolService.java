package com.yundao.tenant.service.customer.pool;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.customer.pool.CustomerPoolPageReqDto;
import com.yundao.tenant.dto.customer.pool.CustomerPoolPageResDto;

/**
 * 客户池服务接口
 *
 * @author jan
 * @create 2017-08-14 AM8:54
 **/
public interface CustomerPoolService {

    /**
     * 获取分页数据
     */
    Result<PaginationSupport<CustomerPoolPageResDto>> getPage(CustomerPoolPageReqDto dto,Integer permission) throws BaseException;


}
