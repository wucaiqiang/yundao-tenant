package com.yundao.tenant.service.customer.distribution;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.CustomerMultiIdReqDto;
import com.yundao.tenant.dto.customer.distribution.CustomerAllotReqDto;
import com.yundao.tenant.dto.customer.distribution.CustomerAllotToCsReqDto;

/**
 * 调配客户服务实现
 *
 * @author jan
 * @create 2017-08-14 PM4:24
 **/
public interface CustomerDistributionService {


    /**
     * 分配客户给理财师
     */
    Result<PermissionResultDto> doAllotToFp(CustomerAllotReqDto dto) throws BaseException;

    /**
     * 回收客户
     */
    Result<PermissionResultDto> doRecycle(CustomerMultiIdReqDto dto) throws BaseException;

    /**
     * 分配客户给客服
     */
    Result<Boolean> doAllotToCs(CustomerAllotToCsReqDto dto) throws BaseException;

}
